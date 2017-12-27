package cn.ladd.grpcx.consumer;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

import cn.ladd.grpcx.config.Config;
import cn.ladd.grpcx.register.service.ConsumerRefreshService;

/**
 * Receive notification from register center. Update local  service host infos 
 * when received notification from register center
 * @author ladd
 * @date 20171129
 */
public class ConsumerRefreshThread extends Thread{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Server server=ServerBuilder
				.forPort(Config.getLocalPort())
				.addService(new ConsumerRefreshService())
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
