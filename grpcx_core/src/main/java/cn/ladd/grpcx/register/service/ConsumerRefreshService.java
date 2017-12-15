package cn.ladd.grpcx.register.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import cn.ladd.grpcx.consumer.LoadBalance;
import cn.ladd.grpcx.register.common.Empty;
import cn.ladd.grpcx.register.common.HostInfo;
import cn.ladd.grpcx.register.common.RefreshRequest;
import cn.ladd.grpcx.register.common.RefreshServiceInfosGrpc.RefreshServiceInfosImplBase;
import cn.ladd.grpcx.register.common.util.HostInfoFormatter;
import io.grpc.stub.StreamObserver;

/**
 * Consumer refresh class to receive notification from register center.
 * Local host infos will be updated when received new server host infos
 * @author ladd
 * @date 20171125
 */
public class ConsumerRefreshService extends RefreshServiceInfosImplBase{
	static Logger logger=Logger.getLogger(ConsumerRefreshService.class);
	
	
	@Override
	public void refresh(RefreshRequest request, StreamObserver<Empty> responseObserver) {
		// TODO Auto-generated method stub
		String serviceName=request.getServiceName();
		ArrayList<HostInfo> hostInfos=new ArrayList<HostInfo>();
		logger.info("Refresh host infos:"+serviceName+" Begin");
		for(Object object:request.getHostInfosList())
		{
			HostInfo hostInfo=(HostInfo) object;
			hostInfos.add(hostInfo);
			logger.info(HostInfoFormatter.getFormatString(hostInfo));
		}
		LoadBalance.refreshHostInfos(serviceName, hostInfos);
		logger.info("Refresh host infos:"+serviceName+" End");
		Empty result=Empty.newBuilder().build();
		responseObserver.onNext(result);
		responseObserver.onCompleted();
	}

}
