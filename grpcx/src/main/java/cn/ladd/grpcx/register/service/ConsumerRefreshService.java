package cn.ladd.grpcx.register.service;

import java.util.List;

import cn.ladd.grpcx.register.common.Empty;
import cn.ladd.grpcx.register.common.HostInfo;
import cn.ladd.grpcx.register.common.RefreshRequest;
import cn.ladd.grpcx.register.common.RefreshServiceInfosGrpc.RefreshServiceInfosImplBase;
import cn.ladd.grpcx.register.common.util.HostInfoFormatter;
import io.grpc.stub.StreamObserver;

public class ConsumerRefreshService extends RefreshServiceInfosImplBase{
	
	@Override
	public void refresh(RefreshRequest request, StreamObserver<Empty> responseObserver) {
		// TODO Auto-generated method stub
		String serviceName=request.getServiceName();
		List serviceHostInfos=request.getHostInfosList();
		System.out.println("Refresh host infos:"+serviceName+" Begin");
		for(Object object:serviceHostInfos)
		{
			HostInfo hostInfo=(HostInfo) object;
			System.out.println(HostInfoFormatter.getFormatString(hostInfo));
		}
		System.out.println("Refresh host infos:"+serviceName+" End");
		Empty result=Empty.newBuilder().build();
		responseObserver.onNext(result);
		responseObserver.onCompleted();
	}

}
