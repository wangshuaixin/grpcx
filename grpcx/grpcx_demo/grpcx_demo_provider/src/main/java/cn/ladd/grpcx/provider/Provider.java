package cn.ladd.grpcx.provider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import cn.ladd.grpcx.config.Config;
import cn.ladd.grpcx.register.common.HostInfo;
import cn.ladd.grpcx.register.demo.add.AddService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 * Provider main class
 * @author ladd
 * @date 20171125
 */
public class Provider {
	public static void main(String[] args) throws InterruptedException {
		HostInfo localHostInfo=HostInfo.newBuilder()
							.setIp(Config.getLocalIP())
							.setPort(String.valueOf(Config.getLocalPort()))
							.build();
		ProviderProxy heartbeatClientProxy=new ProviderProxy(Config.getRegisterIP(), Config.getRegisterPort());
		ArrayList<String> serviceNames=new ArrayList<String>();
		serviceNames.add("cal");
		heartbeatClientProxy.addService("cal", Config.getLocalIP(), String.valueOf(Config.getLocalPort()));
		new ProviderHeartbeatThread(heartbeatClientProxy,serviceNames,localHostInfo).start();
		
		Server server=ServerBuilder.forPort(Config.getLocalPort())
						.addService(new AddService())
						.build();
		try {
			server.start();
			server.awaitTermination();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
