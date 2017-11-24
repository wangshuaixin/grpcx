package cn.ladd.grpcx.register.heartbeat.service;

import io.grpc.stub.StreamObserver;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

import cn.ladd.grpcx.register.heartbeat.common.BeatRequest;
import cn.ladd.grpcx.register.heartbeat.common.Empty;
import cn.ladd.grpcx.register.heartbeat.common.ServerInfoFormatter;
import cn.ladd.grpcx.register.heartbeat.common.HeartBeatGrpc.HeartBeatImplBase;
import cn.ladd.grpcx.register.heartbeat.common.ServerInfo;

/**
 * 
 * @author ladd
 * @date 20171124
 */
public class HeartbeatService extends HeartBeatImplBase{
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
	
	public static void beat(String serviceName,ServerInfo serverInfo)
	{
		String url=ServerInfoFormatter.getFormatString(serverInfo);
		String serviceNodePath="/"+serviceName+"/services/"+url;
		String updateTimeStamp=String.valueOf(System.currentTimeMillis());
		try {
			if(client.checkExists().forPath(serviceNodePath)!=null)
			{
				client.setData()
					.forPath(serviceNodePath, updateTimeStamp.getBytes());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void beat(BeatRequest request, StreamObserver<Empty> responseObserver) {
		// TODO Auto-generated method stub
		String serviceName=request.getServiceName();
		ServerInfo serverInfo=request.getServerInfo();
		beat(serviceName, serverInfo);
		Empty result=Empty.newBuilder().build();
		responseObserver.onNext(result);
		responseObserver.onCompleted();
	}
	
	
	
	private static long getUpdateTimeStamp(String serviceName,ServerInfo serverInfo)
	{
		String url=serverInfo.toString();
		String serviceNodePath="/"+serviceName+"/services/"+url;
		try {
			if(client.checkExists().forPath(serviceNodePath)!=null)
			{
				String data=new String(client.getData().forPath(serviceNodePath));
				if(data!=null)
					return Long.valueOf(data);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public static void main(String[] args) {
		ServerInfo addServiceUrlInfo=ServerInfoFormatter.fromFormatString("192.168.0.0:80");
		beat("add", addServiceUrlInfo);
		System.out.println(getUpdateTimeStamp("add", addServiceUrlInfo));
	}
	
}
