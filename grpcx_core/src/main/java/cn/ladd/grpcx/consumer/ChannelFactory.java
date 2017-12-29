package cn.ladd.grpcx.consumer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import cn.ladd.grpcx.register.common.HostInfo;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ChannelFactory {
	private static ConcurrentHashMap<HostInfo, ManagedChannel> serviceChannels=new ConcurrentHashMap<HostInfo, ManagedChannel>();
	
	public static ManagedChannel getChannel(String serviceName)
	{
		HostInfo hostInfo=LoadBalance.getHostInfo(serviceName);
		if(hostInfo==null)
			return null;
		synchronized (ChannelFactory.class) {
			if(serviceChannels.get(hostInfo)!=null)
			{
				return serviceChannels.get(hostInfo);
			}
			else 
			{
				ManagedChannel channel=ManagedChannelBuilder.forAddress(hostInfo.getIp(), Integer.valueOf(hostInfo.getPort()))
						.usePlaintext(true)
						.build();
				serviceChannels.put(hostInfo, channel);
				return channel;
			}
		}
		
	}
	
	public static void shutDownChannel(HostInfo hostInfo)
	{
		ManagedChannel channel=serviceChannels.get(hostInfo);
		try {
			if(channel!=null&&!channel.isShutdown())
			{
				channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			serviceChannels.remove(hostInfo);
		}
	}
}
