package cn.ladd.grpcx.register.service;

import io.grpc.stub.StreamObserver;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.log4j.Logger;

import cn.ladd.grpcx.register.common.BeatRequest;
import cn.ladd.grpcx.register.common.Empty;
import cn.ladd.grpcx.register.common.HeartBeatGrpc.HeartBeatImplBase;
import cn.ladd.grpcx.register.common.HostInfo;
import cn.ladd.grpcx.register.common.util.HostInfoFormatter;

/**
 * 
 * @author ladd
 * @date 20171124
 */
public class HeartbeatService extends HeartBeatImplBase{
	static Logger logger=Logger.getLogger(HeartbeatService.class);
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
	
	public static void beat(String serviceName,HostInfo serverInfo)
	{
		logger.info("Receive beat from "+serviceName+","+HostInfoFormatter.getFormatString(serverInfo));
		String hostInfoString=HostInfoFormatter.getFormatString(serverInfo);
		String serviceNodePath="/"+serviceName+"/services/"+hostInfoString;
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
		HostInfo serverInfo=request.getHostInfo();
		beat(serviceName, serverInfo);
		Empty result=Empty.newBuilder().build();
		responseObserver.onNext(result);
		responseObserver.onCompleted();
	}
	
	
	
	private static long getUpdateTimeStamp(String serviceName,HostInfo serverInfo)
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
		HostInfo addServiceUrlInfo=HostInfoFormatter.fromFormatString("192.168.0.0:80");
		beat("add", addServiceUrlInfo);
		System.out.println(getUpdateTimeStamp("add", addServiceUrlInfo));
	}
	
}
