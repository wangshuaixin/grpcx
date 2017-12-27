package cn.ladd.grpcx.provider;

import cn.ladd.grpcx.sensor.SysInfoSensorThread;

public class ProviderBootstrap {
	/**
	 * Registry services defined in config file to register center and
	 * start heartbeat(keep alive with register center),
	 * sysinfsensor(send service info to monitor service) threads 
	 */
	public static void init()
	{
		ProviderServiceRegitster.defaultServiceRegistry();
		new ProviderHeartbeatThread().start();	
		new SysInfoSensorThread().start();
	}
}
