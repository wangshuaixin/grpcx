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
public final class RegisterGrpc {

  private RegisterGrpc() {}

  public static final String SERVICE_NAME = "cn.ladd.grpcx.register.common.Register";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<cn.ladd.grpcx.register.common.ServiceRequest,
      cn.ladd.grpcx.register.common.Empty> METHOD_ADD_SERVICE =
      io.grpc.MethodDescriptor.<cn.ladd.grpcx.register.common.ServiceRequest, cn.ladd.grpcx.register.common.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "cn.ladd.grpcx.register.common.Register", "addService"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              cn.ladd.grpcx.register.common.ServiceRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              cn.ladd.grpcx.register.common.Empty.getDefaultInstance()))
          .setSchemaDescriptor(new RegisterMethodDescriptorSupplier("addService"))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<cn.ladd.grpcx.register.common.ServiceRequest,
      cn.ladd.grpcx.register.common.Empty> METHOD_REMOVE_SERVICE =
      io.grpc.MethodDescriptor.<cn.ladd.grpcx.register.common.ServiceRequest, cn.ladd.grpcx.register.common.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "cn.ladd.grpcx.register.common.Register", "removeService"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              cn.ladd.grpcx.register.common.ServiceRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              cn.ladd.grpcx.register.common.Empty.getDefaultInstance()))
          .setSchemaDescriptor(new RegisterMethodDescriptorSupplier("removeService"))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<cn.ladd.grpcx.register.common.SubscribeRequest,
      cn.ladd.grpcx.register.common.Empty> METHOD_SUBSCRIBE =
      io.grpc.MethodDescriptor.<cn.ladd.grpcx.register.common.SubscribeRequest, cn.ladd.grpcx.register.common.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "cn.ladd.grpcx.register.common.Register", "subscribe"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              cn.ladd.grpcx.register.common.SubscribeRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              cn.ladd.grpcx.register.common.Empty.getDefaultInstance()))
          .setSchemaDescriptor(new RegisterMethodDescriptorSupplier("subscribe"))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<cn.ladd.grpcx.register.common.SubscribeRequest,
      cn.ladd.grpcx.register.common.Empty> METHOD_UNSUBSCRIBE =
      io.grpc.MethodDescriptor.<cn.ladd.grpcx.register.common.SubscribeRequest, cn.ladd.grpcx.register.common.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "cn.ladd.grpcx.register.common.Register", "unsubscribe"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              cn.ladd.grpcx.register.common.SubscribeRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              cn.ladd.grpcx.register.common.Empty.getDefaultInstance()))
          .setSchemaDescriptor(new RegisterMethodDescriptorSupplier("unsubscribe"))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<cn.ladd.grpcx.register.common.LookupRequest,
      cn.ladd.grpcx.register.common.LookupResponse> METHOD_LOOKUP =
      io.grpc.MethodDescriptor.<cn.ladd.grpcx.register.common.LookupRequest, cn.ladd.grpcx.register.common.LookupResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "cn.ladd.grpcx.register.common.Register", "lookup"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              cn.ladd.grpcx.register.common.LookupRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              cn.ladd.grpcx.register.common.LookupResponse.getDefaultInstance()))
          .setSchemaDescriptor(new RegisterMethodDescriptorSupplier("lookup"))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<cn.ladd.grpcx.register.common.Empty,
      cn.ladd.grpcx.register.common.GetAllServiceNamesResponse> METHOD_GET_ALL_SERVICE_NAMES =
      io.grpc.MethodDescriptor.<cn.ladd.grpcx.register.common.Empty, cn.ladd.grpcx.register.common.GetAllServiceNamesResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "cn.ladd.grpcx.register.common.Register", "getAllServiceNames"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              cn.ladd.grpcx.register.common.Empty.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              cn.ladd.grpcx.register.common.GetAllServiceNamesResponse.getDefaultInstance()))
          .setSchemaDescriptor(new RegisterMethodDescriptorSupplier("getAllServiceNames"))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<cn.ladd.grpcx.register.common.GetConsumerRequest,
      cn.ladd.grpcx.register.common.GetConsumerResponse> METHOD_GET_CONSUMER_HOST_INFOS =
      io.grpc.MethodDescriptor.<cn.ladd.grpcx.register.common.GetConsumerRequest, cn.ladd.grpcx.register.common.GetConsumerResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "cn.ladd.grpcx.register.common.Register", "getConsumerHostInfos"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              cn.ladd.grpcx.register.common.GetConsumerRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              cn.ladd.grpcx.register.common.GetConsumerResponse.getDefaultInstance()))
          .setSchemaDescriptor(new RegisterMethodDescriptorSupplier("getConsumerHostInfos"))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<cn.ladd.grpcx.register.common.GetDataRequest,
      cn.ladd.grpcx.register.common.GetDataResponse> METHOD_GET_NODE_DATA =
      io.grpc.MethodDescriptor.<cn.ladd.grpcx.register.common.GetDataRequest, cn.ladd.grpcx.register.common.GetDataResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "cn.ladd.grpcx.register.common.Register", "getNodeData"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              cn.ladd.grpcx.register.common.GetDataRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              cn.ladd.grpcx.register.common.GetDataResponse.getDefaultInstance()))
          .setSchemaDescriptor(new RegisterMethodDescriptorSupplier("getNodeData"))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RegisterStub newStub(io.grpc.Channel channel) {
    return new RegisterStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RegisterBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RegisterBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RegisterFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RegisterFutureStub(channel);
  }

  /**
   */
  public static abstract class RegisterImplBase implements io.grpc.BindableService {

    /**
     */
    public void addService(cn.ladd.grpcx.register.common.ServiceRequest request,
        io.grpc.stub.StreamObserver<cn.ladd.grpcx.register.common.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ADD_SERVICE, responseObserver);
    }

    /**
     */
    public void removeService(cn.ladd.grpcx.register.common.ServiceRequest request,
        io.grpc.stub.StreamObserver<cn.ladd.grpcx.register.common.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_REMOVE_SERVICE, responseObserver);
    }

    /**
     */
    public void subscribe(cn.ladd.grpcx.register.common.SubscribeRequest request,
        io.grpc.stub.StreamObserver<cn.ladd.grpcx.register.common.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SUBSCRIBE, responseObserver);
    }

    /**
     */
    public void unsubscribe(cn.ladd.grpcx.register.common.SubscribeRequest request,
        io.grpc.stub.StreamObserver<cn.ladd.grpcx.register.common.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_UNSUBSCRIBE, responseObserver);
    }

    /**
     */
    public void lookup(cn.ladd.grpcx.register.common.LookupRequest request,
        io.grpc.stub.StreamObserver<cn.ladd.grpcx.register.common.LookupResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LOOKUP, responseObserver);
    }

    /**
     */
    public void getAllServiceNames(cn.ladd.grpcx.register.common.Empty request,
        io.grpc.stub.StreamObserver<cn.ladd.grpcx.register.common.GetAllServiceNamesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_ALL_SERVICE_NAMES, responseObserver);
    }

    /**
     */
    public void getConsumerHostInfos(cn.ladd.grpcx.register.common.GetConsumerRequest request,
        io.grpc.stub.StreamObserver<cn.ladd.grpcx.register.common.GetConsumerResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_CONSUMER_HOST_INFOS, responseObserver);
    }

    /**
     */
    public void getNodeData(cn.ladd.grpcx.register.common.GetDataRequest request,
        io.grpc.stub.StreamObserver<cn.ladd.grpcx.register.common.GetDataResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_NODE_DATA, responseObserver);
    }

    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_ADD_SERVICE,
            asyncUnaryCall(
              new MethodHandlers<
                cn.ladd.grpcx.register.common.ServiceRequest,
                cn.ladd.grpcx.register.common.Empty>(
                  this, METHODID_ADD_SERVICE)))
          .addMethod(
            METHOD_REMOVE_SERVICE,
            asyncUnaryCall(
              new MethodHandlers<
                cn.ladd.grpcx.register.common.ServiceRequest,
                cn.ladd.grpcx.register.common.Empty>(
                  this, METHODID_REMOVE_SERVICE)))
          .addMethod(
            METHOD_SUBSCRIBE,
            asyncUnaryCall(
              new MethodHandlers<
                cn.ladd.grpcx.register.common.SubscribeRequest,
                cn.ladd.grpcx.register.common.Empty>(
                  this, METHODID_SUBSCRIBE)))
          .addMethod(
            METHOD_UNSUBSCRIBE,
            asyncUnaryCall(
              new MethodHandlers<
                cn.ladd.grpcx.register.common.SubscribeRequest,
                cn.ladd.grpcx.register.common.Empty>(
                  this, METHODID_UNSUBSCRIBE)))
          .addMethod(
            METHOD_LOOKUP,
            asyncUnaryCall(
              new MethodHandlers<
                cn.ladd.grpcx.register.common.LookupRequest,
                cn.ladd.grpcx.register.common.LookupResponse>(
                  this, METHODID_LOOKUP)))
          .addMethod(
            METHOD_GET_ALL_SERVICE_NAMES,
            asyncUnaryCall(
              new MethodHandlers<
                cn.ladd.grpcx.register.common.Empty,
                cn.ladd.grpcx.register.common.GetAllServiceNamesResponse>(
                  this, METHODID_GET_ALL_SERVICE_NAMES)))
          .addMethod(
            METHOD_GET_CONSUMER_HOST_INFOS,
            asyncUnaryCall(
              new MethodHandlers<
                cn.ladd.grpcx.register.common.GetConsumerRequest,
                cn.ladd.grpcx.register.common.GetConsumerResponse>(
                  this, METHODID_GET_CONSUMER_HOST_INFOS)))
          .addMethod(
            METHOD_GET_NODE_DATA,
            asyncUnaryCall(
              new MethodHandlers<
                cn.ladd.grpcx.register.common.GetDataRequest,
                cn.ladd.grpcx.register.common.GetDataResponse>(
                  this, METHODID_GET_NODE_DATA)))
          .build();
    }
  }

  /**
   */
  public static final class RegisterStub extends io.grpc.stub.AbstractStub<RegisterStub> {
    private RegisterStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RegisterStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegisterStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RegisterStub(channel, callOptions);
    }

    /**
     */
    public void addService(cn.ladd.grpcx.register.common.ServiceRequest request,
        io.grpc.stub.StreamObserver<cn.ladd.grpcx.register.common.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ADD_SERVICE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removeService(cn.ladd.grpcx.register.common.ServiceRequest request,
        io.grpc.stub.StreamObserver<cn.ladd.grpcx.register.common.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_REMOVE_SERVICE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void subscribe(cn.ladd.grpcx.register.common.SubscribeRequest request,
        io.grpc.stub.StreamObserver<cn.ladd.grpcx.register.common.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SUBSCRIBE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void unsubscribe(cn.ladd.grpcx.register.common.SubscribeRequest request,
        io.grpc.stub.StreamObserver<cn.ladd.grpcx.register.common.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UNSUBSCRIBE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void lookup(cn.ladd.grpcx.register.common.LookupRequest request,
        io.grpc.stub.StreamObserver<cn.ladd.grpcx.register.common.LookupResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LOOKUP, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllServiceNames(cn.ladd.grpcx.register.common.Empty request,
        io.grpc.stub.StreamObserver<cn.ladd.grpcx.register.common.GetAllServiceNamesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_ALL_SERVICE_NAMES, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getConsumerHostInfos(cn.ladd.grpcx.register.common.GetConsumerRequest request,
        io.grpc.stub.StreamObserver<cn.ladd.grpcx.register.common.GetConsumerResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_CONSUMER_HOST_INFOS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getNodeData(cn.ladd.grpcx.register.common.GetDataRequest request,
        io.grpc.stub.StreamObserver<cn.ladd.grpcx.register.common.GetDataResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_NODE_DATA, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RegisterBlockingStub extends io.grpc.stub.AbstractStub<RegisterBlockingStub> {
    private RegisterBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RegisterBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegisterBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RegisterBlockingStub(channel, callOptions);
    }

    /**
     */
    public cn.ladd.grpcx.register.common.Empty addService(cn.ladd.grpcx.register.common.ServiceRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ADD_SERVICE, getCallOptions(), request);
    }

    /**
     */
    public cn.ladd.grpcx.register.common.Empty removeService(cn.ladd.grpcx.register.common.ServiceRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_REMOVE_SERVICE, getCallOptions(), request);
    }

    /**
     */
    public cn.ladd.grpcx.register.common.Empty subscribe(cn.ladd.grpcx.register.common.SubscribeRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SUBSCRIBE, getCallOptions(), request);
    }

    /**
     */
    public cn.ladd.grpcx.register.common.Empty unsubscribe(cn.ladd.grpcx.register.common.SubscribeRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_UNSUBSCRIBE, getCallOptions(), request);
    }

    /**
     */
    public cn.ladd.grpcx.register.common.LookupResponse lookup(cn.ladd.grpcx.register.common.LookupRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LOOKUP, getCallOptions(), request);
    }

    /**
     */
    public cn.ladd.grpcx.register.common.GetAllServiceNamesResponse getAllServiceNames(cn.ladd.grpcx.register.common.Empty request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_ALL_SERVICE_NAMES, getCallOptions(), request);
    }

    /**
     */
    public cn.ladd.grpcx.register.common.GetConsumerResponse getConsumerHostInfos(cn.ladd.grpcx.register.common.GetConsumerRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_CONSUMER_HOST_INFOS, getCallOptions(), request);
    }

    /**
     */
    public cn.ladd.grpcx.register.common.GetDataResponse getNodeData(cn.ladd.grpcx.register.common.GetDataRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_NODE_DATA, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RegisterFutureStub extends io.grpc.stub.AbstractStub<RegisterFutureStub> {
    private RegisterFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RegisterFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegisterFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RegisterFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.ladd.grpcx.register.common.Empty> addService(
        cn.ladd.grpcx.register.common.ServiceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ADD_SERVICE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.ladd.grpcx.register.common.Empty> removeService(
        cn.ladd.grpcx.register.common.ServiceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_REMOVE_SERVICE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.ladd.grpcx.register.common.Empty> subscribe(
        cn.ladd.grpcx.register.common.SubscribeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SUBSCRIBE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.ladd.grpcx.register.common.Empty> unsubscribe(
        cn.ladd.grpcx.register.common.SubscribeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UNSUBSCRIBE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.ladd.grpcx.register.common.LookupResponse> lookup(
        cn.ladd.grpcx.register.common.LookupRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LOOKUP, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.ladd.grpcx.register.common.GetAllServiceNamesResponse> getAllServiceNames(
        cn.ladd.grpcx.register.common.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_ALL_SERVICE_NAMES, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.ladd.grpcx.register.common.GetConsumerResponse> getConsumerHostInfos(
        cn.ladd.grpcx.register.common.GetConsumerRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_CONSUMER_HOST_INFOS, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.ladd.grpcx.register.common.GetDataResponse> getNodeData(
        cn.ladd.grpcx.register.common.GetDataRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_NODE_DATA, getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_SERVICE = 0;
  private static final int METHODID_REMOVE_SERVICE = 1;
  private static final int METHODID_SUBSCRIBE = 2;
  private static final int METHODID_UNSUBSCRIBE = 3;
  private static final int METHODID_LOOKUP = 4;
  private static final int METHODID_GET_ALL_SERVICE_NAMES = 5;
  private static final int METHODID_GET_CONSUMER_HOST_INFOS = 6;
  private static final int METHODID_GET_NODE_DATA = 7;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RegisterImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RegisterImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }


    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_SERVICE:
          serviceImpl.addService((cn.ladd.grpcx.register.common.ServiceRequest) request,
              (io.grpc.stub.StreamObserver<cn.ladd.grpcx.register.common.Empty>) responseObserver);
          break;
        case METHODID_REMOVE_SERVICE:
          serviceImpl.removeService((cn.ladd.grpcx.register.common.ServiceRequest) request,
              (io.grpc.stub.StreamObserver<cn.ladd.grpcx.register.common.Empty>) responseObserver);
          break;
        case METHODID_SUBSCRIBE:
          serviceImpl.subscribe((cn.ladd.grpcx.register.common.SubscribeRequest) request,
              (io.grpc.stub.StreamObserver<cn.ladd.grpcx.register.common.Empty>) responseObserver);
          break;
        case METHODID_UNSUBSCRIBE:
          serviceImpl.unsubscribe((cn.ladd.grpcx.register.common.SubscribeRequest) request,
              (io.grpc.stub.StreamObserver<cn.ladd.grpcx.register.common.Empty>) responseObserver);
          break;
        case METHODID_LOOKUP:
          serviceImpl.lookup((cn.ladd.grpcx.register.common.LookupRequest) request,
              (io.grpc.stub.StreamObserver<cn.ladd.grpcx.register.common.LookupResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_SERVICE_NAMES:
          serviceImpl.getAllServiceNames((cn.ladd.grpcx.register.common.Empty) request,
              (io.grpc.stub.StreamObserver<cn.ladd.grpcx.register.common.GetAllServiceNamesResponse>) responseObserver);
          break;
        case METHODID_GET_CONSUMER_HOST_INFOS:
          serviceImpl.getConsumerHostInfos((cn.ladd.grpcx.register.common.GetConsumerRequest) request,
              (io.grpc.stub.StreamObserver<cn.ladd.grpcx.register.common.GetConsumerResponse>) responseObserver);
          break;
        case METHODID_GET_NODE_DATA:
          serviceImpl.getNodeData((cn.ladd.grpcx.register.common.GetDataRequest) request,
              (io.grpc.stub.StreamObserver<cn.ladd.grpcx.register.common.GetDataResponse>) responseObserver);
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

  private static abstract class RegisterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RegisterBaseDescriptorSupplier() {}


    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cn.ladd.grpcx.register.common.RegisterOuterClass.getDescriptor();
    }


    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Register");
    }
  }

  private static final class RegisterFileDescriptorSupplier
      extends RegisterBaseDescriptorSupplier {
    RegisterFileDescriptorSupplier() {}
  }

  private static final class RegisterMethodDescriptorSupplier
      extends RegisterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RegisterMethodDescriptorSupplier(String methodName) {
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
      synchronized (RegisterGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RegisterFileDescriptorSupplier())
              .addMethod(METHOD_ADD_SERVICE)
              .addMethod(METHOD_REMOVE_SERVICE)
              .addMethod(METHOD_SUBSCRIBE)
              .addMethod(METHOD_UNSUBSCRIBE)
              .addMethod(METHOD_LOOKUP)
              .addMethod(METHOD_GET_ALL_SERVICE_NAMES)
              .addMethod(METHOD_GET_CONSUMER_HOST_INFOS)
              .addMethod(METHOD_GET_NODE_DATA)
              .build();
        }
      }
    }
    return result;
  }
}
