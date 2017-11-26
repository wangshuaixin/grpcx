package cn.ladd.grpcx.register.heartbeat.client;

import java.util.concurrent.TimeUnit;

import cn.ladd.grpcx.register.common.BeatRequest;
import cn.ladd.grpcx.register.common.HeartBeatGrpc;
import cn.ladd.grpcx.register.common.HeartBeatGrpc.HeartBeatBlockingStub;
import cn.ladd.grpcx.register.common.HostInfo;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class HeartbeatClientProxy {
	ManagedChannel channel;
	HeartBeatBlockingStub heartBeatBlockingStub;
	public HeartbeatClientProxy(String ip,int port) {
		// TODO Auto-generated constructor stub
		channel=ManagedChannelBuilder.forAddress(ip, port)
					.usePlaintext(true)
					.build();
		heartBeatBlockingStub=HeartBeatGrpc.newBlockingStub(channel);
	}
	
	public void beat(String serviceName,String ip,String port)
	{
		HostInfo hostInfo=HostInfo.newBuilder()
								.setIp(ip)
								.setPort(port)
								.build();
		BeatRequest beatRequest=BeatRequest.newBuilder()
									.setServiceName(serviceName)
									.setHostInfo(hostInfo)
									.build();
		heartBeatBlockingStub.beat(beatRequest);
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
