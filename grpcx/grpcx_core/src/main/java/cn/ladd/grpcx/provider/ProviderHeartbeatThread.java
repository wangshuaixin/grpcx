package cn.ladd.grpcx.provider;

import java.util.ArrayList;

import cn.ladd.grpcx.register.common.HostInfo;

/**
 * Provider heartbeat class to send heatbeat to register center
 * @author ladd
 * @date 20171125
 */
public class ProviderHeartbeatThread extends Thread{
	
	ProviderProxy providerProxy;
	ArrayList<String> serviceNames;
	HostInfo hostInfo;
	
	public ProviderHeartbeatThread(ProviderProxy providerProxy,ArrayList<String> serviceNames,HostInfo hostInfo) {
		// TODO Auto-generated constructor stub
		this.providerProxy=providerProxy;
		this.serviceNames=serviceNames;
		this.hostInfo=hostInfo;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i!=500;++i) {
			try {
				Thread.sleep(2*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			providerProxy.beat(serviceNames, hostInfo);
		}
	}
}
