package cn.ladd.grpcx.consumer;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import cn.ladd.grpcx.register.common.HostInfo;
import cn.ladd.grpcx.register.common.util.HostInfoFormatter;
import cn.ladd.grpcx.register.service.ConsumerRefreshService;
import cn.ladd.grpcx.register.service.HeartbeatService;
import cn.ladd.grpcx.register.service.RegisterService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 * Consumer main class
 * @author ladd
 * @date
 */
public class Consumer {
	static Logger logger=Logger.getLogger(Consumer.class);
	static HostInfo selectServiceHost(ArrayList<HostInfo> serviceHostInfos)
	{
		if(serviceHostInfos.size()>0)
		{
			return serviceHostInfos.get(0);
		}
		return null;
	}
	public static void main(String[] args) {
		
		
		ConsumerProxy consumerProxy=new ConsumerProxy("127.0.0.1", 8090);
		ArrayList<HostInfo> serviceHostInfos=new ArrayList<HostInfo>();
		for(Object object:consumerProxy.lookup("order"))
		{
			HostInfo hostInfo=(HostInfo) object;
			serviceHostInfos.add(hostInfo);
			logger.info("Order service hostinfo:"+HostInfoFormatter.getFormatString(hostInfo));
		}
		consumerProxy.subscribe("order", "127.0.0.1", "8091");
		
		HostInfo selectedHostInfo=selectServiceHost(serviceHostInfos);
		AddProxy addProxy=new AddProxy(selectedHostInfo.getIp(), Integer.valueOf(selectedHostInfo.getPort()));
		logger.info("Result from remote of 1+3="+addProxy.add(1, 3));
		
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
