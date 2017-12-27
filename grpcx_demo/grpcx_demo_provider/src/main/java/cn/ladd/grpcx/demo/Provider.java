package cn.ladd.grpcx.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import cn.ladd.grpcx.config.Config;
import cn.ladd.grpcx.provider.ProviderBootstrap;
import cn.ladd.grpcx.provider.ProviderHeartbeatThread;
import cn.ladd.grpcx.provider.ProviderProxy;
import cn.ladd.grpcx.provider.ProviderServiceRegitster;
import cn.ladd.grpcx.register.common.HostInfo;
import cn.ladd.grpcx.register.demo.add.AddService;
import cn.ladd.grpcx.sensor.SysInfoSensorThread;
import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 * Provider main class
 * @author ladd
 * @date 20171125
 */
public class Provider {
	public static void main(String[] args) throws InterruptedException {
		
		Server server=ServerBuilder.forPort(Config.getLocalPort())
						.addService(new AddService())
						.build();
		try {
			server.start();
			
			ProviderBootstrap.init();
			
			server.awaitTermination();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
