package cn.ladd.grpcx.demo.consumer;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import cn.ladd.grpcx.config.Config;
import cn.ladd.grpcx.consumer.ChannelFactory;
import cn.ladd.grpcx.consumer.ConsumerBootstrap;
import cn.ladd.grpcx.consumer.ConsumerHeartbeatThread;
import cn.ladd.grpcx.consumer.ConsumerRefreshThread;
import cn.ladd.grpcx.register.common.HostInfo;
import cn.ladd.grpcx.register.common.util.HostInfoFormatter;
import cn.ladd.grpcx.register.demo.add.AddGrpc.AddBlockingStub;
import cn.ladd.grpcx.register.demo.add.AddGrpc;
import cn.ladd.grpcx.register.demo.add.AddProxy;
import cn.ladd.grpcx.register.demo.add.RequestInfo;
import cn.ladd.grpcx.register.service.ConsumerRefreshService;
import cn.ladd.grpcx.register.service.HeartbeatService;
import cn.ladd.grpcx.register.service.RegisterService;
import cn.ladd.grpcx.sensor.SysInfoSensorThread;
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
	
		ConsumerBootstrap.init();
		
		
		AddBlockingStub addBlockingStub=AddGrpc.newBlockingStub(ChannelFactory.getChannel("cal"));
		RequestInfo requestInfo=RequestInfo.newBuilder()
				.setA(1)
				.setB(3)
				.build();
		int result=addBlockingStub.add(requestInfo).getC();
		logger.info("Result from remote of 1+3="+result);
		
		
		
	}
}
