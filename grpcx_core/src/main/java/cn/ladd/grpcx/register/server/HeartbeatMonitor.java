package cn.ladd.grpcx.register.server;

import org.apache.log4j.Logger;

import cn.ladd.grpcx.config.Config;
import cn.ladd.grpcx.register.Register;
import cn.ladd.grpcx.register.common.HostInfo;
import cn.ladd.grpcx.register.common.util.HostInfoFormatter;

/**
 * Monitor thread class for check servers state
 * @author ladd
 * @date 20171125
 */
public class HeartbeatMonitor extends Thread{
	
	static Logger logger=Logger.getLogger(HeartbeatMonitor.class);
	int heartbeatOverdue;
	int heartbeatNodeCheckInterval;
	
	public HeartbeatMonitor() {
		// TODO Auto-generated constructor stub
		this.heartbeatOverdue=Config.getHeartbeatOverdueSecond();
		this.heartbeatNodeCheckInterval=Config.getHeartbeatNodecheckInterval();
	}

	public void heartbeatCheck()
	{
		logger.info("heartbeat check begins");
		for(String serviceName:Register.getAllServiceNames())
		{
			for(HostInfo providerHostInfo:Register.lookup(serviceName))
			{
				nodeCheck(false, serviceName, providerHostInfo);
			}
			for(HostInfo consumerHostInfo:Register.getConsumerHostInfos(serviceName))
			{
				nodeCheck(true, serviceName, consumerHostInfo);
			}
		}
		logger.info("heartbeat check ends");
	}
	
	private void nodeCheck(boolean isConsumer,String serviceName,HostInfo hostInfo)
	{
		String nodeData=Register.getNodeData(isConsumer,serviceName, hostInfo);
		Long lastUpdateTime;
		try {
			lastUpdateTime=Long.valueOf(nodeData);
		} catch (NumberFormatException e) {
			logger.info(e.getMessage());
			return;
		}
		
		if((System.currentTimeMillis()-lastUpdateTime)>heartbeatOverdue*1000)
		{
			logger.info("ServiceName:"+serviceName
					+";ServerInfo:"+HostInfoFormatter.getFormatString(hostInfo)
					+";Nodedata:"+nodeData
					+";State:dead"
					);
			logger.info("Remove ServiceName:"+serviceName
					+";ServerInfo:"+HostInfoFormatter.getFormatString(hostInfo)
					);
			Register.removeService(serviceName, hostInfo);
		}
		else 
		{
			logger.info("ServiceName:"+serviceName
					+";ServerInfo:"+HostInfoFormatter.getFormatString(hostInfo)
					+";Nodedata:"+nodeData
					+";State:live"
					);
		}
	}
	
	public void run() {
		// TODO Auto-generated method stub
		logger.info("HeartbeatMonitor started!");
		while(true)
		{
			try {
				Thread.sleep(heartbeatNodeCheckInterval*1000);
				heartbeatCheck();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
