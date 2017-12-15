package cn.ladd.grpcx.consumer;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import cn.ladd.grpcx.register.common.HostInfo;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ChannelFactory {
	private static ConcurrentHashMap<HostInfo, ManagedChannel> serviceChannels=new ConcurrentHashMap<HostInfo, ManagedChannel>();
	private static Lock singlonLocker=new ReentrantLock();
	
	public static ManagedChannel getChannel(String serviceName)
	{
		HostInfo hostInfo=LoadBalance.getHostInfo(serviceName);
		if(serviceChannels.get(hostInfo)!=null)
		{
			return serviceChannels.get(hostInfo);
		}
		else 
		{
			singlonLocker.lock();
			ManagedChannel channel=ManagedChannelBuilder.forAddress(hostInfo.getIp(), Integer.valueOf(hostInfo.getPort()))
					.usePlaintext(true)
					.build();
			serviceChannels.put(hostInfo, channel);
			singlonLocker.unlock();
			return channel;
		}
		
	}
}
