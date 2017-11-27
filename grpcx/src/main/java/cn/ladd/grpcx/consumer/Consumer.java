package cn.ladd.grpcx.consumer;

import java.io.IOException;

import org.apache.log4j.Logger;

import cn.ladd.grpcx.register.common.HostInfo;
import cn.ladd.grpcx.register.common.util.HostInfoFormatter;
import cn.ladd.grpcx.register.service.ConsumerRefreshService;
import cn.ladd.grpcx.register.service.HeartbeatService;
import cn.ladd.grpcx.register.service.RegisterService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class Consumer {
	static Logger logger=Logger.getLogger(Consumer.class);
	public static void main(String[] args) {
		
		
		ConsumerProxy consumerProxy=new ConsumerProxy("127.0.0.1", 8090);
		for(Object object:consumerProxy.lookup("order"))
		{
			HostInfo hostInfo=(HostInfo) object;
			logger.info("Order service hostinfo:"+HostInfoFormatter.getFormatString(hostInfo));
		}
		consumerProxy.subscribe("order", "127.0.0.1", "8091");
		
		
		Server server=ServerBuilder
				.forPort(8091)
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
