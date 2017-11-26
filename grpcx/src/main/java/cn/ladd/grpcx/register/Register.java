package cn.ladd.grpcx.register;

import java.util.ArrayList;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.ZKPaths;
import org.apache.zookeeper.KeeperException;

import cn.ladd.grpcx.register.common.HostInfo;
import cn.ladd.grpcx.register.common.util.HostInfoFormatter;
import cn.ladd.grpcx.register.server.ConsumerRefershProxy;

/**
 * 
 * Register center service
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
	    		.connectString("localhost:2181")
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
			notifyAllClients(serviceName);
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
				notifyAllClients(serviceName);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	public static void subscribe(String serviceName,HostInfo clientHostInfo)
	{
		String clientHostInfoString=HostInfoFormatter.getFormatString(clientHostInfo);
		String clientRootPath="/"+serviceName+"/clients";
		String clientNodePath=clientRootPath+"/"+clientHostInfoString;
		try {
			if(client.checkExists().forPath(clientRootPath)==null)
			{
				client.create()
				.creatingParentsIfNeeded()
				.forPath(clientRootPath);
			}
			if(client.checkExists().forPath(clientNodePath)==null)
			{
				client.create()
					.creatingParentsIfNeeded()
					.forPath(clientNodePath, clientHostInfoString.getBytes());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void unsubscribe(String serviceName,HostInfo clientHostInfo)
	{
		String clientHostInfoString=HostInfoFormatter.getFormatString(clientHostInfo);
		String clientNodePath="/"+serviceName+"/clients/"+clientHostInfoString;
		try {
			if(client.checkExists().forPath(clientNodePath)!=null)
			{
				client.delete().forPath(clientNodePath);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	private static ArrayList<HostInfo> getClientHostInfos(String serviceName)
	{
		ArrayList<HostInfo> clinetHostInfos=new ArrayList<HostInfo>();
		String clientDirPath="/"+serviceName+"/clients";
		try {
			if(client.checkExists().forPath(clientDirPath)==null)
			{
				return clinetHostInfos;
			}
			for(String childNode:ZKPaths.getSortedChildren(client.getZookeeperClient().getZooKeeper(), "/registor"+clientDirPath))
				clinetHostInfos.add(HostInfoFormatter.fromFormatString(childNode));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clinetHostInfos;
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
				serviceInfos.add(HostInfoFormatter.fromFormatString(childNode));
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
				serviceNameList.add(childNode);
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
	
	public static String getNodeData(String serviceName,HostInfo serverInfo)
	{
		String result="";
		String serviceNodePath="/"+serviceName+"/services/"+HostInfoFormatter.getFormatString(serverInfo);
		try {
			result=new String(client.getData().forPath(serviceNodePath));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	private static void notifyAllClients(String serviceName)
	{
		ArrayList<HostInfo> clientsHostInfos=getClientHostInfos(serviceName);
		ArrayList<HostInfo> serviceHostInfos=lookup(serviceName);
		for(HostInfo clientInfo:clientsHostInfos)
		{
			ConsumerRefershProxy consumerRefershProxy=new ConsumerRefershProxy(clientInfo.getIp(), Integer.valueOf(clientInfo.getPort()));
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
		for(String serviceName:getAllServiceNames())
		{
			for(HostInfo serverInfo:lookup(serviceName))
			{
				String nodeData=getNodeData(serviceName, serverInfo);
				System.out.println("ServiceName:"+serviceName
						+";ServerInfo:"+HostInfoFormatter.getFormatString(serverInfo)
						+";Nodedata:"+nodeData
						);
			}
		}
	}

}
