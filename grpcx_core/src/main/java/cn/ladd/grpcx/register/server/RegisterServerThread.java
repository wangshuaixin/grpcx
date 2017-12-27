package cn.ladd.grpcx.register.server;

import java.io.IOException;

import cn.ladd.grpcx.config.Config;
import cn.ladd.grpcx.register.service.HeartbeatService;
import cn.ladd.grpcx.register.service.RegisterService;
import cn.ladd.grpcx.sensor.BaseThread;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class RegisterServerThread extends BaseThread{
	
	public RegisterServerThread() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		HeartbeatMonitor heartbeatMonitor=new HeartbeatMonitor();
		heartbeatMonitor.start();
		
		Server server=ServerBuilder
				.forPort(Config.getRegisterPort())
				.addService(new HeartbeatService())
				.addService(new RegisterService())
				.build();
		try {
			server.start();
			server.awaitTermination();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
