package cn.ladd.grpcx;

import java.io.IOException;

import cn.ladd.grpcx.config.Config;
import cn.ladd.grpcx.provider.ProviderBootstrap;
import cn.ladd.grpcx.register.demo.add.AddService;
import cn.ladd.grpcx.sensor.BaseThread;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class ProviderDemoThread extends BaseThread{
	
	public ProviderDemoThread() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
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
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
