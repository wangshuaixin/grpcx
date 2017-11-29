package cn.ladd.grpcx.provider;

import java.io.IOException;

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
		ProviderProxy heartbeatClientProxy=new ProviderProxy("127.0.0.1", 8090);
		heartbeatClientProxy.addService("order", "127.0.0.1", "8094");
		new ProviderHeartbeatThread(heartbeatClientProxy).start();
		
		Server server=ServerBuilder.forPort(8094)
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
