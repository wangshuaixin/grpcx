package cn.ladd.grpcx.consumer;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import cn.ladd.grpcx.register.common.HostInfo;
import io.grpc.ManagedChannel;

public class ChannelFactory {
	private static ConcurrentHashMap<HostInfo, ManagedChannel> serviceChannels=new ConcurrentHashMap<HostInfo, ManagedChannel>();
	
	
	public static ManagedChannel getChannel(String serviceName)
	{
		HostInfo hostInfo=LoadBalance.getHostInfo(serviceName);
		if(serviceChannels.get(hostInfo)!=null)
		{
			return serviceChannels.get(hostInfo);
		}
		else 
		{
			return null;
		}
		
	}
}
