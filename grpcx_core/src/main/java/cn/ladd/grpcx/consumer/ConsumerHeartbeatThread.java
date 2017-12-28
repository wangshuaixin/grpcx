package cn.ladd.grpcx.consumer;

import java.util.ArrayList;

import cn.ladd.grpcx.config.Config;
import cn.ladd.grpcx.register.common.HostInfo;

/**
 * Provider heartbeat class to send heatbeat to register center
 * @author ladd
 * @date 20171125
 */
public class ConsumerHeartbeatThread extends Thread{
	
	ConsumerProxy consumerProxy;
	ArrayList<String> serviceNames;
	HostInfo localHostInfo;
	int heartbeatInterval;
	boolean stopped;
	
	public ConsumerHeartbeatThread(ArrayList<String> serviceNames) {
		// TODO Auto-generated constructor stub
		this.consumerProxy=new ConsumerProxy(Config.getRegisterIP(), Config.getRegisterPort());
		this.serviceNames=serviceNames;
		this.localHostInfo=HostInfo.newBuilder()
							.setIp(Config.getLocalIP())
							.setPort(String.valueOf(Config.getLocalPortConsumer()))
							.build();
		this.heartbeatInterval=Config.getHeartbeatInterval();
		this.stopped=false;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!stopped) {
			try {
				Thread.sleep(heartbeatInterval*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			consumerProxy.beat(serviceNames, localHostInfo);
		}
	}
}
