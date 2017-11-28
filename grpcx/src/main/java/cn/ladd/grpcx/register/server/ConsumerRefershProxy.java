package cn.ladd.grpcx.register.server;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import cn.ladd.grpcx.register.common.HostInfo;
import cn.ladd.grpcx.register.common.RefreshRequest;
import cn.ladd.grpcx.register.common.RefreshServiceInfosGrpc;
import cn.ladd.grpcx.register.common.RefreshServiceInfosGrpc.RefreshServiceInfosBlockingStub;
import cn.ladd.grpcx.register.common.RegisterGrpc;
import cn.ladd.grpcx.register.common.SubscribeRequest;
import cn.ladd.grpcx.register.common.RegisterGrpc.RegisterBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * Proxy for ConsumerRefreshService
 * @author ladd
 * @date 20171125
 */
public class ConsumerRefershProxy {
	ManagedChannel channel;
	RefreshServiceInfosBlockingStub refreshServiceInfosBlockingStub;
	public ConsumerRefershProxy(String ip,int port) {
		// TODO Auto-generated constructor stub
		channel=ManagedChannelBuilder.forAddress(ip, port)
					.usePlaintext(true)
					.build();
		refreshServiceInfosBlockingStub=RefreshServiceInfosGrpc.newBlockingStub(channel);
	}
	
	public void refresh(String serviceName,ArrayList<HostInfo> serviceHostInfos)
	{
		RefreshRequest refreshRequest=RefreshRequest.newBuilder()
										.setServiceName(serviceName)
										.addAllHostInfos(serviceHostInfos)
										.build();
		refreshServiceInfosBlockingStub.refresh(refreshRequest);
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
