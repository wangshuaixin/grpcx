package cn.ladd.grpcx.register.demo.add;

import io.grpc.stub.StreamObserver;
import cn.ladd.grpcx.register.demo.add.AddGrpc.AddImplBase;

public class AddService extends AddImplBase{
	@Override
	public void add(RequestInfo request,
			StreamObserver<ResponseInfo> responseObserver) {
		// TODO Auto-generated method stub
		int a=request.getA();
		int b=request.getB();
		ResponseInfo result=ResponseInfo.newBuilder()
							.setC(a+b)
							.build();
		responseObserver.onNext(result);
		responseObserver.onCompleted();
	}
}
