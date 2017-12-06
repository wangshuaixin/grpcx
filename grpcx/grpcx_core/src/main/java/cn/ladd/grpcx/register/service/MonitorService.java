package cn.ladd.grpcx.register.service;

import org.apache.log4j.Logger;

import cn.ladd.grpcx.monitor.Empty;
import cn.ladd.grpcx.monitor.ServiceInfo;
import cn.ladd.grpcx.monitor.MonitorGrpc.MonitorImplBase;
import io.grpc.stub.StreamObserver;

public class MonitorService extends MonitorImplBase{
	private static Logger logger=Logger.getLogger(MonitorService.class);
	@Override
	public void sendSysInfo(ServiceInfo request, StreamObserver<Empty> responseObserver) {
		// TODO Auto-generated method stub
		logger.info(request.getAllFields());
		Empty result=Empty.newBuilder().build();
		responseObserver.onNext(result);
		responseObserver.onCompleted();
	}
}
