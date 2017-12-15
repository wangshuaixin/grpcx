package cn.ladd.grpcx.register;

import java.util.ArrayList;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.ZKPaths;
import org.apache.log4j.Logger;
import org.apache.zookeeper.KeeperException;

import cn.ladd.grpcx.config.Config;
import cn.ladd.grpcx.register.common.HostInfo;
import cn.ladd.grpcx.register.common.util.HostInfoFormatter;
import cn.ladd.grpcx.register.server.ConsumerRefershProxy;

/**
 * 
 * Register center service implement class
 * support lookup,addSevice(register),removeService,subscribe,unsubscribe functions
 * @author ladd
 * @20171124
 *
 */
public class Register {
	static CuratorFramework client;
	static
	{
		RetryPolicy retryPolicy=new ExponentialBackoffRetry(1000, 3);
		client=CuratorFrameworkFactory
	    		.builder()
	    		.connectString(Config.getZookeeperHost())
	    		.sessionTimeoutMs(5000)
	    		.namespace("registor")
	    		.retryPolicy(retryPolicy)
	    		.build();
		client.start();
	}
	
	public static void addService(String serviceName,HostInfo hostInfo)
	{
		String hostInfoString=HostInfoFormatter.getFormatString(hostInfo);
		String serviceDirPath="/"+serviceName+"/services";
		String serviceNodePath="/"+serviceName+"/services/"+hostInfoString;
		try {
			if(client.checkExists().forPath(serviceDirPath)==null)
			{
				client.create()
				.creatingParentsIfNeeded()
				.forPath(serviceDirPath);
			}
			if(client.checkExists().forPath(serviceNodePath)==null)
			{
				client.create()
					.creatingParentsIfNeeded()
					.forPath(serviceNodePath, String.valueOf(System.currentTimeMillis()).getBytes());
			}
			notifyAllConsumers(serviceName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void removeService(String serviceName,HostInfo hostInfo)
	{
		String hostInfoString=HostInfoFormatter.getFormatString(hostInfo);
		String serviceNodePath="/"+serviceName+"/services/"+hostInfoString;
		try {
			if(client.checkExists().forPath(serviceNodePath)!=null)
			{
				client.delete().forPath(serviceNodePath);
				notifyAllConsumers(serviceName);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	public static void subscribe(String serviceName,HostInfo consumerHostInfo)
	{
		String clientHostInfoString=HostInfoFormatter.getFormatString(consumerHostInfo);
		String consumerRootPath="/"+serviceName+"/consumers";
		String consumerNodePath=consumerRootPath+"/"+clientHostInfoString;
		try {
			if(client.checkExists().forPath(consumerRootPath)==null)
			{
				client.create()
				.creatingParentsIfNeeded()
				.forPath(consumerRootPath);
			}
			if(client.checkExists().forPath(consumerNodePath)==null)
			{
				client.create()
					.creatingParentsIfNeeded()
					.forPath(consumerNodePath, clientHostInfoString.getBytes());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void unsubscribe(String serviceName,HostInfo clientHostInfo)
	{
		String consumerHostInfoString=HostInfoFormatter.getFormatString(clientHostInfo);
		String consumerNodePath="/"+serviceName+"/consumers/"+consumerHostInfoString;
		try {
			if(client.checkExists().forPath(consumerNodePath)!=null)
			{
				client.delete().forPath(consumerNodePath);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getNodePath(boolean isConsumer,String serviceName,HostInfo serverInfo)
	{
		String hostInfoString=HostInfoFormatter.getFormatString(serverInfo);
		String nodePath;
		if(isConsumer)
		{
			nodePath="/"+serviceName+"/consumers/"+hostInfoString;
		}
		else {
			nodePath="/"+serviceName+"/services/"+hostInfoString;
		}
		return nodePath;
	}
	
	
	public static ArrayList<HostInfo> getConsumerHostInfos(String serviceName)
	{
		ArrayList<HostInfo> consumerHostInfos=new ArrayList<HostInfo>();
		String consumerDirPath="/"+serviceName+"/consumers";
		try {
			if(client.checkExists().forPath(consumerDirPath)==null)
			{
				return consumerHostInfos;
			}
			for(String childNode:ZKPaths.getSortedChildren(client.getZookeeperClient().getZooKeeper(), "/registor"+consumerDirPath))
			{
				consumerHostInfos.add(HostInfoFormatter.fromFormatString(childNode));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return consumerHostInfos;
	}
	
	public static ArrayList<HostInfo> lookup(String serviceName)
	{
		ArrayList<HostInfo> serviceInfos=new ArrayList<HostInfo>();
		String serviceDirPath="/"+serviceName+"/services";
		try {
			if(client.checkExists().forPath(serviceDirPath)==null)
			{
				return serviceInfos;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			for(String childNode:ZKPaths.getSortedChildren(client.getZookeeperClient().getZooKeeper(), "/registor"+serviceDirPath))
			{
				serviceInfos.add(HostInfoFormatter.fromFormatString(childNode));
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeeperException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return serviceInfos;
	}
	
	public static ArrayList<String> getAllServiceNames()
	{
		ArrayList<String> serviceNameList=new ArrayList<String>();
		
		try {
			for(String childNode:ZKPaths.getSortedChildren(client.getZookeeperClient().getZooKeeper(), "/registor"))
			{
				serviceNameList.add(childNode);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeeperException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return serviceNameList;
	}
	
	public static String getNodeData(boolean isConsumer,String serviceName,HostInfo serverInfo)
	{
		String result="";
		String nodePath=getNodePath(isConsumer, serviceName, serverInfo);
		try {
			result=new String(client.getData().forPath(nodePath));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	private static void notifyAllConsumers(String serviceName)
	{
		ArrayList<HostInfo> cosumerHostInfos=getConsumerHostInfos(serviceName);
		ArrayList<HostInfo> serviceHostInfos=lookup(serviceName);
		for(HostInfo consumerInfo:cosumerHostInfos)
		{
			ConsumerRefershProxy consumerRefershProxy=new ConsumerRefershProxy(consumerInfo.getIp(), Integer.valueOf(consumerInfo.getPort()));
			consumerRefershProxy.refresh(serviceName,serviceHostInfos);
			consumerRefershProxy.shutdown();
		}
	}
	
	public static void main(String[] args) {
//		ServerInfo ieClientUrlInfo=new ServerInfo("102.168.0.0:80");
//		ServerInfo chromeClientUrlInfo=new ServerInfo("101.168.0.0:80");
//		ServerInfo addServiceUrlInfo=new ServerInfo("192.168.0.0:80");
//		ServerInfo payServiceUrlInfo=new ServerInfo("192.198.0.0:80");
//		subscribe("add", ieClientUrlInfo);
//		subscribe("pay", chromeClientUrlInfo);
//		addService("add", addServiceUrlInfo);
//		addService("pay", payServiceUrlInfo);
//		for(ServerInfo addUrlInfo:lookup("add"))
//		{
//			System.out.println("add service url info"+addUrlInfo.toString());
//		}
//		for(ServerInfo addClientUrlInfo:getClientUrlInfos("add"))
//		{
//			System.out.println("add client url info"+addClientUrlInfo.toString());
//		}
//		removeService("pay", HostInfo.newBuilder().setIp("192.198.0.0").setPort("80").build());;
		Logger logger=Logger.getLogger(Register.class);
		logger.info("Register started!");
		for(String serviceName:getAllServiceNames())
		{
			for(HostInfo serverInfo:lookup(serviceName))
			{
				String nodeData=getNodeData(false,serviceName, serverInfo);
				logger.info("ServiceName:"+serviceName
						+";ServerInfo:"+HostInfoFormatter.getFormatString(serverInfo)
						+";Nodedata:"+nodeData
						);
			}
		}
	}

}
