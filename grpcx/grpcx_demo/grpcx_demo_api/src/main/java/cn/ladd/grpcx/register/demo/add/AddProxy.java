package cn.ladd.grpcx.register.demo.add;

import java.util.concurrent.TimeUnit;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import cn.ladd.grpcx.register.common.RegisterGrpc;
import cn.ladd.grpcx.register.common.RegisterGrpc.RegisterBlockingStub;
import cn.ladd.grpcx.register.demo.add.AddGrpc;
import cn.ladd.grpcx.register.demo.add.AddGrpc.AddBlockingStub;
import cn.ladd.grpcx.register.demo.add.RequestInfo;

/**
 * Proxy class for add service
 * @author ladd
 * @date 2
 */
public class AddProxy {
	
	ManagedChannel channel;
	AddBlockingStub addBlockingStub;
	public AddProxy(String ip,int port) {
		// TODO Auto-generated constructor stub
		channel=ManagedChannelBuilder.forAddress(ip, port)
					.usePlaintext(true)
					.build();
		addBlockingStub=AddGrpc.newBlockingStub(channel);
	}
	
	public int add(int a,int b)
	{
		RequestInfo requestInfo=RequestInfo.newBuilder()
								.setA(a)
								.setB(b)
								.build();
		return addBlockingStub.add(requestInfo).getC();
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
