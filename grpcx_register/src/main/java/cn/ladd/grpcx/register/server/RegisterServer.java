package cn.ladd.grpcx.register.server;

import java.io.IOException;

import cn.ladd.grpcx.config.Config;
import cn.ladd.grpcx.register.service.HeartbeatService;
import cn.ladd.grpcx.register.service.RegisterService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 * Register center server class
 * Register center supports addService,removeService,lookup,
 * subscribe,unsubscribe,getAllServiceNames and getNodeData services.
 * When server starts, heartbeat monitor will be started at the same time.
 * @author ladd
 * @date 20171125
 */
public class RegisterServer {
	public static void main(String[] args) {
		HeartbeatMonitor heartbeatMonitor=new HeartbeatMonitor();
		Thread monitorThread=new Thread(heartbeatMonitor);
		monitorThread.start();
		
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
