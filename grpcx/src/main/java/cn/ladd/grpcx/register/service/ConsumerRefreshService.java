package cn.ladd.grpcx.register.service;

import java.util.List;

import org.apache.log4j.Logger;

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
		List serviceHostInfos=request.getHostInfosList();
		logger.info("Refresh host infos:"+serviceName+" Begin");
		for(Object object:serviceHostInfos)
		{
			HostInfo hostInfo=(HostInfo) object;
			logger.info(HostInfoFormatter.getFormatString(hostInfo));
		}
		logger.info("Refresh host infos:"+serviceName+" End");
		Empty result=Empty.newBuilder().build();
		responseObserver.onNext(result);
		responseObserver.onCompleted();
	}

}
