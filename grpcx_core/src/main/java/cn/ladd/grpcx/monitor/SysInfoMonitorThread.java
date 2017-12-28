package cn.ladd.grpcx.monitor;

import java.io.IOException;
import java.util.ArrayList;

import cn.ladd.grpcx.config.Config;
import cn.ladd.grpcx.provider.ProviderHeartbeatThread;
import cn.ladd.grpcx.provider.ProviderProxy;
import cn.ladd.grpcx.register.common.HostInfo;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class SysInfoMonitorThread extends Thread{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		HostInfo localHostInfo=HostInfo.newBuilder()
				.setIp(Config.getLocalIP())
				.setPort(String.valueOf(Config.getLocalPortMonitor()))
				.build();
		ProviderProxy heartbeatClientProxy=new ProviderProxy(Config.getRegisterIP(), Config.getRegisterPort());
		ArrayList<String> serviceNames=new ArrayList<String>();
		serviceNames.add("monitor");
		heartbeatClientProxy.addService("monitor", Config.getLocalIP(), String.valueOf(Config.getLocalPortMonitor()));
		new ProviderHeartbeatThread(heartbeatClientProxy,serviceNames,localHostInfo).start();
		
		Server server=ServerBuilder.forPort(Config.getLocalPortMonitor())
					.addService(new MonitorService())
					.build();
		try {
			server.start();
			server.awaitTermination();
		} catch (IOException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
