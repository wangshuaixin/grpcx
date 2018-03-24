package cn.ladd.grpcx.consumer;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;


import cn.ladd.grpcx.register.common.HostInfo;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.apache.log4j.Logger;

/**
 * Use concurrentHashMap to manage chanel, per service per chanel
 */
public class ChannelFactory {

	private static Logger logger=Logger.getLogger(ChannelFactory.class);

	private static ConcurrentHashMap<HostInfo, ManagedChannel> serviceChannels=new ConcurrentHashMap<HostInfo, ManagedChannel>();

	/**
	 * Get channel for serive, if not exist, create a new channel and return
	 * @param serviceName
	 * @return
	 */
	public static ManagedChannel getChannel(String serviceName)
	{
		HostInfo hostInfo=LoadBalance.getHostInfo(serviceName);

		if(hostInfo==null)
			return null;

		synchronized (ChannelFactory.class) {
			ManagedChannel serviceChannel=serviceChannels.get(hostInfo);
			if(serviceChannel!=null)
			{
				return serviceChannel;
			}
			else 
			{
				//if not exist, create a new channel for serive name
				ManagedChannel channel=ManagedChannelBuilder.forAddress(hostInfo.getIp(), Integer.valueOf(hostInfo.getPort()))
						.usePlaintext(true)
						.build();
				serviceChannels.put(hostInfo, channel);
				return channel;
			}
		}
		
	}

	/**
	 * Shutdown chanel with hostInfo
	 * @param hostInfo
	 */
	public static void shutDownChannel(HostInfo hostInfo)
	{
		ManagedChannel channel=serviceChannels.get(hostInfo);
		try {
			if(channel!=null&&!channel.isShutdown())
			{
				channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
			}
		} catch (InterruptedException e) {
			logger.error("Shutdown channel exception:",e);
		}
		finally {
			serviceChannels.remove(hostInfo);
		}
	}
}
