package cn.ladd.grpcx.consumer;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import cn.ladd.grpcx.register.common.HostInfo;
import cn.ladd.grpcx.register.common.util.HostInfoFormatter;
import cn.ladd.grpcx.register.demo.add.AddProxy;
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
	
	public static void main(String[] args) throws InterruptedException {
		
		HostInfo selectedHostInfo=LoadBalance.getHostInfo("cal");
		AddProxy addProxy=new AddProxy(selectedHostInfo.getIp(), Integer.valueOf(selectedHostInfo.getPort()));
		logger.info("Result from remote of 1+3="+addProxy.add(1, 3));
		
		ConsumerRefreshThread consumerRefreshThread=new ConsumerRefreshThread();
		consumerRefreshThread.start();
		
		ArrayList<String> serviceNames=new ArrayList<String>();
		serviceNames.add("cal");
		ConsumerHeartbeatThread consumerHeartbeatThread=new ConsumerHeartbeatThread(serviceNames);
		consumerHeartbeatThread.start();
		
		Thread.sleep(10000*1000);
	}
}
