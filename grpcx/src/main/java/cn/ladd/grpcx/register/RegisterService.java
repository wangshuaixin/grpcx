package cn.ladd.grpcx.register;

import java.util.ArrayList;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.ZKPaths;
import org.apache.zookeeper.KeeperException;

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
	
	public static void addService(String serviceName,UrlInfo urlInfo)
	{
		String url=urlInfo.toString();
		String serviceDirPath="/"+serviceName+"/services";
		String serviceNodePath="/"+serviceName+"/services/"+url;
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
					.forPath(serviceNodePath, url.getBytes());
				
			}
			notifyAllClients(serviceName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static ArrayList<UrlInfo> lookup(String serviceName)
	{
		ArrayList<UrlInfo> serviceInfos=new ArrayList<UrlInfo>();
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
				serviceInfos.add(new UrlInfo(childNode));
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
	
	
	
	public static void subscribe(String serviceName,UrlInfo clientUrlInfo)
	{
		String url=clientUrlInfo.toString();
		String clientRootPath="/"+serviceName+"/clients";
		String clientNodePath=clientRootPath+"/"+url;
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
					.forPath(clientNodePath, url.getBytes());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void unsubscribe(String serviceName,UrlInfo clientUrlInfo)
	{
		String url=clientUrlInfo.toString();
		String clientNodePath="/"+serviceName+"/clients/"+url;
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
	
	public static void removeService(String serviceName,UrlInfo urlInfo)
	{
		String url=urlInfo.toString();
		String serviceNodePath="/"+serviceName+"/services/"+url;
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
	
	private static ArrayList<UrlInfo> getClientUrlInfos(String serviceName)
	{
		ArrayList<UrlInfo> clinetUrlInfos=new ArrayList<UrlInfo>();
		String clientDirPath="/"+serviceName+"/clients";
		try {
			if(client.checkExists().forPath(clientDirPath)==null)
			{
				return clinetUrlInfos;
			}
			for(String childNode:ZKPaths.getSortedChildren(client.getZookeeperClient().getZooKeeper(), "/registor"+clientDirPath))
				clinetUrlInfos.add(new UrlInfo(childNode));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clinetUrlInfos;
	}
	
	
	private static void notifyAllClients(String serviceName)
	{
		ArrayList<UrlInfo> clientsUrlInfos=getClientUrlInfos(serviceName);
		for(UrlInfo clientInfo:clientsUrlInfos)
		{
			System.out.println("Refresh "+clientInfo.toString());
		}
	}
	
	public static void main(String[] args) {
		UrlInfo ieClientUrlInfo=new UrlInfo("102.168.0.0:80");
		UrlInfo chromeClientUrlInfo=new UrlInfo("101.168.0.0:80");
		UrlInfo addServiceUrlInfo=new UrlInfo("192.168.0.0:80");
		UrlInfo payServiceUrlInfo=new UrlInfo("192.198.0.0:80");
		subscribe("add", ieClientUrlInfo);
		subscribe("pay", chromeClientUrlInfo);
		addService("add", addServiceUrlInfo);
		addService("pay", payServiceUrlInfo);
		for(UrlInfo addUrlInfo:lookup("add"))
		{
			System.out.println("add service url info"+addUrlInfo.toString());
		}
		for(UrlInfo addClientUrlInfo:getClientUrlInfos("add"))
		{
			System.out.println("add client url info"+addClientUrlInfo.toString());
		}
	}

}
