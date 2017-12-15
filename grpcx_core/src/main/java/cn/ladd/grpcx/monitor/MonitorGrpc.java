package cn.ladd.grpcx.monitor;

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
    comments = "Source: monitor.proto")
public final class MonitorGrpc {

  private MonitorGrpc() {}

  public static final String SERVICE_NAME = "cn.ladd.grpcx.monitor.Monitor";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<cn.ladd.grpcx.monitor.ServiceInfo,
      cn.ladd.grpcx.monitor.Empty> METHOD_SEND_SYS_INFO =
      io.grpc.MethodDescriptor.<cn.ladd.grpcx.monitor.ServiceInfo, cn.ladd.grpcx.monitor.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "cn.ladd.grpcx.monitor.Monitor", "sendSysInfo"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              cn.ladd.grpcx.monitor.ServiceInfo.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              cn.ladd.grpcx.monitor.Empty.getDefaultInstance()))
          .setSchemaDescriptor(new MonitorMethodDescriptorSupplier("sendSysInfo"))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MonitorStub newStub(io.grpc.Channel channel) {
    return new MonitorStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MonitorBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new MonitorBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MonitorFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new MonitorFutureStub(channel);
  }

  /**
   */
  public static abstract class MonitorImplBase implements io.grpc.BindableService {

    /**
     */
    public void sendSysInfo(cn.ladd.grpcx.monitor.ServiceInfo request,
        io.grpc.stub.StreamObserver<cn.ladd.grpcx.monitor.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEND_SYS_INFO, responseObserver);
    }

    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_SEND_SYS_INFO,
            asyncUnaryCall(
              new MethodHandlers<
                cn.ladd.grpcx.monitor.ServiceInfo,
                cn.ladd.grpcx.monitor.Empty>(
                  this, METHODID_SEND_SYS_INFO)))
          .build();
    }
  }

  /**
   */
  public static final class MonitorStub extends io.grpc.stub.AbstractStub<MonitorStub> {
    private MonitorStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MonitorStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MonitorStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MonitorStub(channel, callOptions);
    }

    /**
     */
    public void sendSysInfo(cn.ladd.grpcx.monitor.ServiceInfo request,
        io.grpc.stub.StreamObserver<cn.ladd.grpcx.monitor.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEND_SYS_INFO, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MonitorBlockingStub extends io.grpc.stub.AbstractStub<MonitorBlockingStub> {
    private MonitorBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MonitorBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MonitorBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MonitorBlockingStub(channel, callOptions);
    }

    /**
     */
    public cn.ladd.grpcx.monitor.Empty sendSysInfo(cn.ladd.grpcx.monitor.ServiceInfo request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SEND_SYS_INFO, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MonitorFutureStub extends io.grpc.stub.AbstractStub<MonitorFutureStub> {
    private MonitorFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MonitorFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MonitorFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MonitorFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.ladd.grpcx.monitor.Empty> sendSysInfo(
        cn.ladd.grpcx.monitor.ServiceInfo request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEND_SYS_INFO, getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_SYS_INFO = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MonitorImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MonitorImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

   
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_SYS_INFO:
          serviceImpl.sendSysInfo((cn.ladd.grpcx.monitor.ServiceInfo) request,
              (io.grpc.stub.StreamObserver<cn.ladd.grpcx.monitor.Empty>) responseObserver);
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

  private static abstract class MonitorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MonitorBaseDescriptorSupplier() {}


    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cn.ladd.grpcx.monitor.MonitorOuterClass.getDescriptor();
    }


    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Monitor");
    }
  }

  private static final class MonitorFileDescriptorSupplier
      extends MonitorBaseDescriptorSupplier {
    MonitorFileDescriptorSupplier() {}
  }

  private static final class MonitorMethodDescriptorSupplier
      extends MonitorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MonitorMethodDescriptorSupplier(String methodName) {
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
      synchronized (MonitorGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MonitorFileDescriptorSupplier())
              .addMethod(METHOD_SEND_SYS_INFO)
              .build();
        }
      }
    }
    return result;
  }
}
