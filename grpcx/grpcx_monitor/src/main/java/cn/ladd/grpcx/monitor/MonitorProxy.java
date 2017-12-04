package cn.ladd.grpcx.monitor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.catalina.util.ServerInfo;

import cn.ladd.grpcx.register.common.Empty;
import cn.ladd.grpcx.register.common.GetConsumerRequest;
import cn.ladd.grpcx.register.common.HostInfo;
import cn.ladd.grpcx.register.common.LookupRequest;
import cn.ladd.grpcx.register.common.RegisterGrpc;
import cn.ladd.grpcx.register.common.SubscribeRequest;
import cn.ladd.grpcx.register.common.util.HostInfoFormatter;
import cn.ladd.grpcx.register.common.RegisterGrpc.RegisterBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class MonitorProxy {
	ManagedChannel channel;
	RegisterBlockingStub registerBlockingStub;
	public MonitorProxy(String ip,int port) {
		// TODO Auto-generated constructor stub
		channel=ManagedChannelBuilder.forAddress(ip, port)
					.usePlaintext(true)
					.build();
		registerBlockingStub=RegisterGrpc.newBlockingStub(channel);
	}
	
	public ArrayList<String> getAllServiceNames()
	{
		Empty request=Empty.newBuilder().build();
		List serviceNames=registerBlockingStub.getAllServiceNames(request).getServiceNamesList();
		ArrayList<String> result=new ArrayList<String>();
		for(Object object:serviceNames)
		{
			String serviceName=(String) object;
			result.add(serviceName);
		}
		return result;
	}
	
	public ArrayList<String> lookup(String serviceName)
	{
		List hostInfos=new ArrayList<HostInfo>();
		LookupRequest lookupRequest=LookupRequest.newBuilder()
										.setServiceName(serviceName)
										.build();
		hostInfos= registerBlockingStub.lookup(lookupRequest).getHostInfosList();
		ArrayList<String> result=new ArrayList<String>();
		for(Object object:hostInfos)
		{
			result.add(HostInfoFormatter.getFormatString(((HostInfo) object)));
		}
		return result;
	}
	
	public ArrayList<String> getConsumerHostInfos(String serviceName)
	{
		GetConsumerRequest request=GetConsumerRequest.newBuilder()
									.setServiceName(serviceName)
									.build();
		ArrayList<String> result=new ArrayList<String>();
		for(Object object:registerBlockingStub.getConsumerHostInfos(request).getHostInfosList())
		{
			result.add(HostInfoFormatter.getFormatString((HostInfo) object));
		}
		return result;
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
