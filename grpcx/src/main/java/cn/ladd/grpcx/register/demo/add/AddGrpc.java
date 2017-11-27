package cn.ladd.grpcx.register.demo.add;

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
    comments = "Source: add.proto")
public final class AddGrpc {

  private AddGrpc() {}

  public static final String SERVICE_NAME = "cn.ladd.grpcx.register.demo.add.Add";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<cn.ladd.grpcx.register.demo.add.RequestInfo,
      cn.ladd.grpcx.register.demo.add.ResponseInfo> METHOD_ADD =
      io.grpc.MethodDescriptor.<cn.ladd.grpcx.register.demo.add.RequestInfo, cn.ladd.grpcx.register.demo.add.ResponseInfo>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "cn.ladd.grpcx.register.demo.add.Add", "add"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              cn.ladd.grpcx.register.demo.add.RequestInfo.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              cn.ladd.grpcx.register.demo.add.ResponseInfo.getDefaultInstance()))
          .setSchemaDescriptor(new AddMethodDescriptorSupplier("add"))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AddStub newStub(io.grpc.Channel channel) {
    return new AddStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AddBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AddBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AddFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AddFutureStub(channel);
  }

  /**
   */
  public static abstract class AddImplBase implements io.grpc.BindableService {

    /**
     */
    public void add(cn.ladd.grpcx.register.demo.add.RequestInfo request,
        io.grpc.stub.StreamObserver<cn.ladd.grpcx.register.demo.add.ResponseInfo> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ADD, responseObserver);
    }

    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_ADD,
            asyncUnaryCall(
              new MethodHandlers<
                cn.ladd.grpcx.register.demo.add.RequestInfo,
                cn.ladd.grpcx.register.demo.add.ResponseInfo>(
                  this, METHODID_ADD)))
          .build();
    }
  }

  /**
   */
  public static final class AddStub extends io.grpc.stub.AbstractStub<AddStub> {
    private AddStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AddStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AddStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AddStub(channel, callOptions);
    }

    /**
     */
    public void add(cn.ladd.grpcx.register.demo.add.RequestInfo request,
        io.grpc.stub.StreamObserver<cn.ladd.grpcx.register.demo.add.ResponseInfo> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ADD, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AddBlockingStub extends io.grpc.stub.AbstractStub<AddBlockingStub> {
    private AddBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AddBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AddBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AddBlockingStub(channel, callOptions);
    }

    /**
     */
    public cn.ladd.grpcx.register.demo.add.ResponseInfo add(cn.ladd.grpcx.register.demo.add.RequestInfo request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ADD, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AddFutureStub extends io.grpc.stub.AbstractStub<AddFutureStub> {
    private AddFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AddFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AddFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AddFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.ladd.grpcx.register.demo.add.ResponseInfo> add(
        cn.ladd.grpcx.register.demo.add.RequestInfo request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ADD, getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AddImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AddImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }


    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD:
          serviceImpl.add((cn.ladd.grpcx.register.demo.add.RequestInfo) request,
              (io.grpc.stub.StreamObserver<cn.ladd.grpcx.register.demo.add.ResponseInfo>) responseObserver);
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

  private static abstract class AddBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AddBaseDescriptorSupplier() {}


    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cn.ladd.grpcx.register.demo.add.AddOuterClass.getDescriptor();
    }


    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Add");
    }
  }

  private static final class AddFileDescriptorSupplier
      extends AddBaseDescriptorSupplier {
    AddFileDescriptorSupplier() {}
  }

  private static final class AddMethodDescriptorSupplier
      extends AddBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AddMethodDescriptorSupplier(String methodName) {
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
      synchronized (AddGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AddFileDescriptorSupplier())
              .addMethod(METHOD_ADD)
              .build();
        }
      }
    }
    return result;
  }
}
