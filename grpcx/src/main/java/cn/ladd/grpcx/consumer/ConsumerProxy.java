package cn.ladd.grpcx.consumer;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import cn.ladd.grpcx.register.common.BeatRequest;
import cn.ladd.grpcx.register.common.HeartBeatGrpc;
import cn.ladd.grpcx.register.common.HostInfo;
import cn.ladd.grpcx.register.common.LookupRequest;
import cn.ladd.grpcx.register.common.RegisterGrpc;
import cn.ladd.grpcx.register.common.HeartBeatGrpc.HeartBeatBlockingStub;
import cn.ladd.grpcx.register.common.RegisterGrpc.RegisterBlockingStub;
import cn.ladd.grpcx.register.common.SubscribeRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * Proxy for register service
 * @author ladd
 * @date 20171125
 */
public class ConsumerProxy {
	ManagedChannel channel;
	RegisterBlockingStub registerBlockingStub;
	public ConsumerProxy(String ip,int port) {
		// TODO Auto-generated constructor stub
		channel=ManagedChannelBuilder.forAddress(ip, port)
					.usePlaintext(true)
					.build();
		registerBlockingStub=RegisterGrpc.newBlockingStub(channel);
	}
	
	public List lookup(String serviceName)
	{
		List hostInfos=new ArrayList<HostInfo>();
		LookupRequest lookupRequest=LookupRequest.newBuilder()
										.setServiceName(serviceName)
										.build();
		hostInfos= registerBlockingStub.lookup(lookupRequest).getHostInfosList();
		return hostInfos;
	}
	
	public void subscribe(String serviceName,String ip,String port)
	{
		HostInfo clientHostInfo=HostInfo.newBuilder()
									.setIp(ip)
									.setPort(port)
									.build();
		SubscribeRequest subscribeRequest=SubscribeRequest.newBuilder()
											.setServiceName(serviceName)
											.setHostInfo(clientHostInfo)
											.build();
		registerBlockingStub.subscribe(subscribeRequest);
	}
	
	public void unsubscribe(String serviceName,String ip,String port)
	{
		HostInfo clientHostInfo=HostInfo.newBuilder()
									.setIp(ip)
									.setPort(port)
									.build();
		SubscribeRequest unsubscribeRequest=SubscribeRequest.newBuilder()
											.setServiceName(serviceName)
											.setHostInfo(clientHostInfo)
											.build();
		registerBlockingStub.unsubscribe(unsubscribeRequest);
	}
	
	public void shutdown() 
	{
		try {
			channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
