package cn.ladd.grpcx.consumer;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;

import cn.ladd.grpcx.register.common.HostInfo;
import cn.ladd.grpcx.register.common.util.HostInfoFormatter;

/**
 * Loadbalance strategy implement class
 * Random,RoundRobin stategy are supported.
 * @author ladd
 * @date 2017-11-29
 */
public class LoadBalance {
	
	static Logger logger=Logger.getLogger(LoadBalance.class);
	
	public static final String LOADBALANCE_RANDOM="RANDOM";
	public static final String LOADBALANCE_ROUNDRONBIN="ROUNDROBIN";
	
	public static String LOADBALANCE_STRATEGY=LOADBALANCE_RANDOM;
	
	static ConcurrentHashMap<String, ArrayList<HostInfo>> LOCALSERVER_HOSTINFOS=
			new ConcurrentHashMap<String, ArrayList<HostInfo>>();
	
	static ConcurrentHashMap<String, AtomicInteger> ROUNDROBIN_INDEX=
			new ConcurrentHashMap<String, AtomicInteger>();
	
	public static void refreshHostInfos(String serviceName,ArrayList<HostInfo> hostInfos)
	{
		LOCALSERVER_HOSTINFOS.put(serviceName, hostInfos);
		ROUNDROBIN_INDEX.put(serviceName, new AtomicInteger(0));
	}
	
	
	
	public static HostInfo getHostInfo(String serviceName)
	{
		if(LOCALSERVER_HOSTINFOS.get(serviceName)==null)
		{
			ConsumerProxy consumerProxy=new ConsumerProxy("127.0.0.1", 8090);
			ArrayList<HostInfo> serviceHostInfos=new ArrayList<HostInfo>();
			for(Object object:consumerProxy.lookup(serviceName))
			{
				HostInfo hostInfo=(HostInfo) object;
				serviceHostInfos.add(hostInfo);
				logger.info(serviceName+" service hostinfo:"+HostInfoFormatter.getFormatString(hostInfo));
			}
			refreshHostInfos(serviceName, serviceHostInfos);
			consumerProxy.subscribe(serviceName, "127.0.0.1", "8091");
		}
		
		if(LOADBALANCE_ROUNDRONBIN.equals(LOADBALANCE_STRATEGY))
		{
			return roundRobinSelect(serviceName);
		}
		else {
			return randomSelect(serviceName);
		}
		
	}
	
	public static HostInfo randomSelect(String serviceName)
	{
		ArrayList<HostInfo> hostInfos=LOCALSERVER_HOSTINFOS.get(serviceName);
		if(hostInfos!=null&&hostInfos.size()>0)
		{
			int index=(int) Math.random()*hostInfos.size();
			return hostInfos.get(index);
		}
		return null;
	}
	
	public static HostInfo roundRobinSelect(String serviceName)
	{
		ArrayList<HostInfo> hostInfos=LOCALSERVER_HOSTINFOS.get(serviceName);
		if(hostInfos!=null&&hostInfos.size()>0)
		{
			AtomicInteger atomicIndex=ROUNDROBIN_INDEX.get(serviceName);
			if(atomicIndex.get()==hostInfos.size())
			{
				atomicIndex.set(0);
			}
			int index=atomicIndex.getAndAdd(1);
			return hostInfos.get(index);
		}
		return null;
	}
	
	
}
