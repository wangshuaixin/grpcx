package cn.ladd.grpcx.register.server;

import org.apache.log4j.Logger;

import cn.ladd.grpcx.register.Register;
import cn.ladd.grpcx.register.common.HostInfo;
import cn.ladd.grpcx.register.common.util.HostInfoFormatter;

/**
 * Monitor thread class for check servers state
 * @author ladd
 * @date 20171125
 */
public class HeartbeatMonitor implements Runnable{
	
	static Logger logger=Logger.getLogger(HeartbeatMonitor.class);

	public void heartbeatCheck()
	{
		for(String serviceName:Register.getAllServiceNames())
		{
			for(HostInfo serverInfo:Register.lookup(serviceName))
			{
				String nodeData=Register.getNodeData(serviceName, serverInfo);
				Long lastUpdateTime;
				try {
					lastUpdateTime=Long.valueOf(nodeData);
				} catch (NumberFormatException e) {
					// TODO: handle exception
					logger.info(e.getMessage());
					return;
				}
				
				if((System.currentTimeMillis()-lastUpdateTime)>30*60*1000)
				{
					logger.info("ServiceName:"+serviceName
							+";ServerInfo:"+HostInfoFormatter.getFormatString(serverInfo)
							+";Nodedata:"+nodeData
							+";State:dead"
							);
					logger.info("Remove ServiceName:"+serviceName
							+";ServerInfo:"+HostInfoFormatter.getFormatString(serverInfo)
							);
					Register.removeService(serviceName, serverInfo);
				}
				else 
				{
					logger.info("ServiceName:"+serviceName
							+";ServerInfo:"+HostInfoFormatter.getFormatString(serverInfo)
							+";Nodedata:"+nodeData
							+";State:live"
							);
				}
			}
		}
	}
	
	public void run() {
		// TODO Auto-generated method stub
		logger.info("HeartbeatMonitor started!");
		while(true)
		{
			try {
				Thread.sleep(10*1000);
				heartbeatCheck();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
