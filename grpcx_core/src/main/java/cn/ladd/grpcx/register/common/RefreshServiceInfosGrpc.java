package cn.ladd.grpcx.register.common;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.7.0)",
    comments = "Source: register.proto")
public final class RefreshServiceInfosGrpc {

  private RefreshServiceInfosGrpc() {}

  public static final String SERVICE_NAME = "cn.ladd.grpcx.register.common.RefreshServiceInfos";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<cn.ladd.grpcx.register.common.RefreshRequest,
      cn.ladd.grpcx.register.common.Empty> METHOD_REFRESH =
      io.grpc.MethodDescriptor.<cn.ladd.grpcx.register.common.RefreshRequest, cn.ladd.grpcx.register.common.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "cn.ladd.grpcx.register.common.RefreshServiceInfos", "refresh"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              cn.ladd.grpcx.register.common.RefreshRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              cn.ladd.grpcx.register.common.Empty.getDefaultInstance()))
          .setSchemaDescriptor(new RefreshServiceInfosMethodDescriptorSupplier("refresh"))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RefreshServiceInfosStub newStub(io.grpc.Channel channel) {
    return new RefreshServiceInfosStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RefreshServiceInfosBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RefreshServiceInfosBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RefreshServiceInfosFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RefreshServiceInfosFutureStub(channel);
  }

  /**
   */
  public static abstract class RefreshServiceInfosImplBase implements io.grpc.BindableService {

    /**
     */
    public void refresh(cn.ladd.grpcx.register.common.RefreshRequest request,
        io.grpc.stub.StreamObserver<cn.ladd.grpcx.register.common.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_REFRESH, responseObserver);
    }

    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_REFRESH,
            asyncUnaryCall(
              new MethodHandlers<
                cn.ladd.grpcx.register.common.RefreshRequest,
                cn.ladd.grpcx.register.common.Empty>(
                  this, METHODID_REFRESH)))
          .build();
    }
  }

  /**
   */
  public static final class RefreshServiceInfosStub extends io.grpc.stub.AbstractStub<RefreshServiceInfosStub> {
    private RefreshServiceInfosStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RefreshServiceInfosStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RefreshServiceInfosStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RefreshServiceInfosStub(channel, callOptions);
    }

    /**
     */
    public void refresh(cn.ladd.grpcx.register.common.RefreshRequest request,
        io.grpc.stub.StreamObserver<cn.ladd.grpcx.register.common.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_REFRESH, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RefreshServiceInfosBlockingStub extends io.grpc.stub.AbstractStub<RefreshServiceInfosBlockingStub> {
    private RefreshServiceInfosBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RefreshServiceInfosBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RefreshServiceInfosBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RefreshServiceInfosBlockingStub(channel, callOptions);
    }

    /**
     */
    public cn.ladd.grpcx.register.common.Empty refresh(cn.ladd.grpcx.register.common.RefreshRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_REFRESH, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RefreshServiceInfosFutureStub extends io.grpc.stub.AbstractStub<RefreshServiceInfosFutureStub> {
    private RefreshServiceInfosFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RefreshServiceInfosFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RefreshServiceInfosFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RefreshServiceInfosFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.ladd.grpcx.register.common.Empty> refresh(
        cn.ladd.grpcx.register.common.RefreshRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_REFRESH, getCallOptions()), request);
    }
  }

  private static final int METHODID_REFRESH = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RefreshServiceInfosImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RefreshServiceInfosImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }


    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REFRESH:
          serviceImpl.refresh((cn.ladd.grpcx.register.common.RefreshRequest) request,
              (io.grpc.stub.StreamObserver<cn.ladd.grpcx.register.common.Empty>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }


    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RefreshServiceInfosBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RefreshServiceInfosBaseDescriptorSupplier() {}


    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cn.ladd.grpcx.register.common.RegisterOuterClass.getDescriptor();
    }


    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RefreshServiceInfos");
    }
  }

  private static final class RefreshServiceInfosFileDescriptorSupplier
      extends RefreshServiceInfosBaseDescriptorSupplier {
    RefreshServiceInfosFileDescriptorSupplier() {}
  }

  private static final class RefreshServiceInfosMethodDescriptorSupplier
      extends RefreshServiceInfosBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RefreshServiceInfosMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }


    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (RefreshServiceInfosGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RefreshServiceInfosFileDescriptorSupplier())
              .addMethod(METHOD_REFRESH)
              .build();
        }
      }
    }
    return result;
  }
}
