package cn.ladd.grpcx.register.service;

import io.grpc.stub.StreamObserver;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.log4j.Logger;

import cn.ladd.grpcx.config.Config;
import cn.ladd.grpcx.register.Register;
import cn.ladd.grpcx.register.common.BeatRequest;
import cn.ladd.grpcx.register.common.Empty;
import cn.ladd.grpcx.register.common.HeartBeatGrpc.HeartBeatImplBase;
import cn.ladd.grpcx.register.common.HostInfo;
import cn.ladd.grpcx.register.common.util.HostInfoFormatter;

/**
 * Heartbeat service to receive beat from server nodes.
 * Timestamp info for server node will be updated when receive beat.
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
	    		.connectString(Config.getZookeeperHost())
	    		.sessionTimeoutMs(5000)
	    		.namespace("registor")
	    		.retryPolicy(retryPolicy)
	    		.build();
		client.start();
	}
	
	
	
	
	@Override
	public void beat(BeatRequest request, StreamObserver<Empty> responseObserver) {
		// TODO Auto-generated method stub
		HostInfo serverInfo=request.getHostInfo();
		boolean isConsumer=request.getIsConsumer();
		for(Object object:request.getServiceNamesList())
		{
			String serviceName=(String) object;
			beat(isConsumer,serviceName, serverInfo);
		}
		Empty result=Empty.newBuilder().build();
		responseObserver.onNext(result);
		responseObserver.onCompleted();
	}
	
	public static void beat(boolean isConsumer,String serviceName,HostInfo serverInfo)
	{
		logger.info("Receive beat from "+serviceName+","+HostInfoFormatter.getFormatString(serverInfo));
		String nodePath=Register.getNodePath(isConsumer, serviceName, serverInfo);
		String updateTimeStamp=String.valueOf(System.currentTimeMillis());
		try {
			if(client.checkExists().forPath(nodePath)!=null)
			{
				client.setData()
					.forPath(nodePath, updateTimeStamp.getBytes());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
