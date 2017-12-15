package cn.ladd.grpcx.register.service;

import java.util.ArrayList;

import cn.ladd.grpcx.register.Register;
import cn.ladd.grpcx.register.common.Empty;
import cn.ladd.grpcx.register.common.GetAllServiceNamesResponse;
import cn.ladd.grpcx.register.common.GetConsumerRequest;
import cn.ladd.grpcx.register.common.GetConsumerResponse;
import cn.ladd.grpcx.register.common.GetDataRequest;
import cn.ladd.grpcx.register.common.GetDataResponse;
import cn.ladd.grpcx.register.common.HostInfo;
import cn.ladd.grpcx.register.common.LookupRequest;
import cn.ladd.grpcx.register.common.LookupResponse;
import cn.ladd.grpcx.register.common.ServiceRequest;
import cn.ladd.grpcx.register.common.SubscribeRequest;
import cn.ladd.grpcx.register.common.RegisterGrpc.RegisterImplBase;
import io.grpc.stub.StreamObserver;


/**
 * Register center service supports addService,removeService,lookup,
 * subscribe,unsubscribe,getAllServiceNames and getNodeData
 * @author ladd
 * @date 20171125
 */
public class RegisterService extends RegisterImplBase{
	
	@Override
	public void addService(ServiceRequest request, StreamObserver<Empty> responseObserver) {
		// TODO Auto-generated method stub
		String serviceName=request.getServiceName();
		HostInfo hostInfo=request.getHostInfo();
		Register.addService(serviceName, hostInfo);
		Empty result=Empty.newBuilder().build();
		responseObserver.onNext(result);
		responseObserver.onCompleted();
	}
	
	@Override
	public void removeService(ServiceRequest request, StreamObserver<Empty> responseObserver) {
		// TODO Auto-generated method stub
		String serviceName=request.getServiceName();
		HostInfo hostInfo=request.getHostInfo();
		Register.removeService(serviceName, hostInfo);
		Empty result=Empty.newBuilder().build();
		responseObserver.onNext(result);
		responseObserver.onCompleted();
	}
	
	@Override
	public void subscribe(SubscribeRequest request, StreamObserver<Empty> responseObserver) {
		// TODO Auto-generated method stub
		String serviceName=request.getServiceName();
		HostInfo hostInfo=request.getHostInfo();
		Register.subscribe(serviceName, hostInfo);
		Empty result=Empty.newBuilder().build();
		responseObserver.onNext(result);
		responseObserver.onCompleted();
	}
	
	@Override
	public void unsubscribe(SubscribeRequest request, StreamObserver<Empty> responseObserver) {
		// TODO Auto-generated method stub
		String serviceName=request.getServiceName();
		HostInfo hostInfo=request.getHostInfo();
		Register.unsubscribe(serviceName, hostInfo);
		Empty result=Empty.newBuilder().build();
		responseObserver.onNext(result);
		responseObserver.onCompleted();
	}
	
	@Override
	public void lookup(LookupRequest request, StreamObserver<LookupResponse> responseObserver) {
		// TODO Auto-generated method stub
		String serviceName=request.getServiceName();
		ArrayList<HostInfo> hostInfos=Register.lookup(serviceName);
		LookupResponse result=LookupResponse.newBuilder()
								.addAllHostInfos(hostInfos)
								.build();
		responseObserver.onNext(result);
		responseObserver.onCompleted();
	}
	
	@Override
	public void getAllServiceNames(Empty request, StreamObserver<GetAllServiceNamesResponse> responseObserver) {
		// TODO Auto-generated method stub
		ArrayList<String> serviceNames=Register.getAllServiceNames();
		GetAllServiceNamesResponse result=GetAllServiceNamesResponse.newBuilder()
								.addAllServiceNames(serviceNames)
								.build();
		responseObserver.onNext(result);
		responseObserver.onCompleted();
	}
	
	@Override
	public void getNodeData(GetDataRequest request, StreamObserver<GetDataResponse> responseObserver) {
		// TODO Auto-generated method stub
		boolean isConsumer=request.getIsCunsumer();
		String serviceName=request.getServiceName();
		HostInfo hostInfo=request.getHostInfo();
		String nodeData=Register.getNodeData(isConsumer,serviceName, hostInfo);
		GetDataResponse result=GetDataResponse.newBuilder()
								.setNodeData(nodeData)
								.build();
		responseObserver.onNext(result);
		responseObserver.onCompleted();
	}
	
	@Override
	public void getConsumerHostInfos(GetConsumerRequest request, StreamObserver<GetConsumerResponse> responseObserver) {
		// TODO Auto-generated method stub
		String serviceName=request.getServiceName();
		ArrayList<HostInfo> consumerHostInfos=Register.getConsumerHostInfos(serviceName);
		GetConsumerResponse result=GetConsumerResponse.newBuilder()
									.addAllHostInfos(consumerHostInfos)
									.build();
		responseObserver.onNext(result);
		responseObserver.onCompleted();
	}
	

}
