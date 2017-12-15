package cn.ladd.grpcx.provider;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import cn.ladd.grpcx.register.common.BeatRequest;
import cn.ladd.grpcx.register.common.HeartBeatGrpc;
import cn.ladd.grpcx.register.common.HeartBeatGrpc.HeartBeatBlockingStub;
import cn.ladd.grpcx.register.common.HostInfo;
import cn.ladd.grpcx.register.common.RegisterGrpc;
import cn.ladd.grpcx.register.common.RegisterGrpc.RegisterBlockingStub;
import cn.ladd.grpcx.register.common.ServiceRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * Proxy for register and heartbeat
 * @author ladd
 * @date 20171125
 */
public class ProviderProxy {
	ManagedChannel channel;
	HeartBeatBlockingStub heartBeatBlockingStub;
	RegisterBlockingStub registerBlockingStub;
	public ProviderProxy(String ip,int port) {
		// TODO Auto-generated constructor stub
		channel=ManagedChannelBuilder.forAddress(ip, port)
					.usePlaintext(true)
					.build();
		heartBeatBlockingStub=HeartBeatGrpc.newBlockingStub(channel);
		registerBlockingStub=RegisterGrpc.newBlockingStub(channel);
	}
	
	
	
	public void beat(ArrayList<String> serviceNames,HostInfo hostInfo)
	{
		BeatRequest beatRequest=BeatRequest.newBuilder()
									.setIsConsumer(false)
									.addAllServiceNames(serviceNames)
									.setHostInfo(hostInfo)
									.build();
		heartBeatBlockingStub.beat(beatRequest);
	}
	
	public void addService(String serviceName,String ip,String port)
	{
		HostInfo hostInfo=HostInfo.newBuilder()
								.setIp(ip)
								.setPort(port)
								.build();
		ServiceRequest serviceRequest=ServiceRequest.newBuilder()
									.setServiceName(serviceName)
									.setHostInfo(hostInfo)
									.build();
		registerBlockingStub.addService(serviceRequest);
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
