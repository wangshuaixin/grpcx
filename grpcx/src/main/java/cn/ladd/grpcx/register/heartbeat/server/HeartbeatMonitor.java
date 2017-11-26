package cn.ladd.grpcx.register.heartbeat.server;

import cn.ladd.grpcx.register.RegisterService;
import cn.ladd.grpcx.register.common.HostInfo;
import cn.ladd.grpcx.register.common.util.HostInfoFormatter;

public class HeartbeatMonitor implements Runnable{

	public void heartbeatCheck()
	{
		for(String serviceName:RegisterService.getAllServiceNames())
		{
			for(HostInfo serverInfo:RegisterService.lookup(serviceName))
			{
				String nodeData=RegisterService.getNodeData(serviceName, serverInfo);
				Long lastUpdateTime=Long.valueOf(nodeData);
				if((System.currentTimeMillis()-lastUpdateTime)>30*60*1000)
				{
					RegisterService.removeService(serviceName, serverInfo);
				}
				else 
				{
					System.out.println("ServiceName:"+serviceName
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
		System.out.println("HeartbeatMonitor started!");
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
