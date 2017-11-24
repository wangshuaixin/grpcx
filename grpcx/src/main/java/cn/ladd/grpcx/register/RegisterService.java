package cn.ladd.grpcx.register;

import java.util.ArrayList;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.ZKPaths;
import org.apache.zookeeper.KeeperException;

import cn.ladd.grpcx.register.heartbeat.common.ServerInfo;
import cn.ladd.grpcx.register.heartbeat.common.ServerInfoFormatter;

/**
 * 
 * Register center service
 * support lookup,addSevice(register),removeService,subscribe,unsubscribe functions
 * @author ladd
 * @20171124
 *
 */
public class RegisterService {
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
	
	public static void addService(String serviceName,ServerInfo serverInfo)
	{
		String serverInfoString=ServerInfoFormatter.getFormatString(serverInfo);
		String serviceDirPath="/"+serviceName+"/services";
		String serviceNodePath="/"+serviceName+"/services/"+serverInfoString;
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
	
	public static void removeService(String serviceName,ServerInfo serverInfo)
	{
		String serverInfoString=ServerInfoFormatter.getFormatString(serverInfo);
		String serviceNodePath="/"+serviceName+"/services/"+serverInfoString;
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
	
	
	
	
	
	public static void subscribe(String serviceName,ServerInfo clientHostInfo)
	{
		String clientHostInfoString=ServerInfoFormatter.getFormatString(clientHostInfo);
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
	
	public static void unsubscribe(String serviceName,ServerInfo clientHostInfo)
	{
		String clientHostInfoString=ServerInfoFormatter.getFormatString(clientHostInfo);
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
	
	
	
	private static ArrayList<ServerInfo> getClientUrlInfos(String serviceName)
	{
		ArrayList<ServerInfo> clinetUrlInfos=new ArrayList<ServerInfo>();
		String clientDirPath="/"+serviceName+"/clients";
		try {
			if(client.checkExists().forPath(clientDirPath)==null)
			{
				return clinetUrlInfos;
			}
			for(String childNode:ZKPaths.getSortedChildren(client.getZookeeperClient().getZooKeeper(), "/registor"+clientDirPath))
				clinetUrlInfos.add(ServerInfoFormatter.fromFormatString(childNode));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clinetUrlInfos;
	}
	
	public static ArrayList<ServerInfo> lookup(String serviceName)
	{
		ArrayList<ServerInfo> serviceInfos=new ArrayList<ServerInfo>();
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
				serviceInfos.add(ServerInfoFormatter.fromFormatString(childNode));
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
	
	public static String getNodeData(String serviceName,ServerInfo serverInfo)
	{
		String result="";
		String serviceNodePath="/"+serviceName+"/services/"+ServerInfoFormatter.getFormatString(serverInfo);
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
		ArrayList<ServerInfo> clientsUrlInfos=getClientUrlInfos(serviceName);
		for(ServerInfo clientInfo:clientsUrlInfos)
		{
			System.out.println("Refresh "+clientInfo.toString());
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
		for(String serviceName:getAllServiceNames())
		{
			for(ServerInfo serverInfo:lookup(serviceName))
			{
				String nodeData=getNodeData(serviceName, serverInfo);
				System.out.println("ServiceName:"+serviceName
						+";ServerInfo:"+ServerInfoFormatter.getFormatString(serverInfo)
						+";Nodedata:"+nodeData
						);
			}
		}
	}

}
