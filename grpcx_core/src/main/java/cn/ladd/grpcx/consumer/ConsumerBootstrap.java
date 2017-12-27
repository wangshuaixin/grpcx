package cn.ladd.grpcx.consumer;

import cn.ladd.grpcx.config.Config;
import cn.ladd.grpcx.sensor.SysInfoSensorThread;

public class ConsumerBootstrap {
	
	/**
	 * Start heartbeat(keep alive with register center),
	 * sysinfsensor(send service info to monitor service) 
	 * and consumer refresh(listen to provide change event from register center)
	 * threads 
	 */
	public static void init()
	{
		ConsumerRefreshThread consumerRefreshThread=new ConsumerRefreshThread();
		consumerRefreshThread.start();
		
		//TODO need to interact with channelfactory, send heartbeat when subscribe is finished
		ConsumerHeartbeatThread consumerHeartbeatThread=new ConsumerHeartbeatThread(Config.getRefServiceNameList());
		consumerHeartbeatThread.start();
		
		SysInfoSensorThread sysInfoSensorThread=new SysInfoSensorThread();
		sysInfoSensorThread.start();
	}

}
