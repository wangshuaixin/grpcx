// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: register.proto

package cn.ladd.grpcx.register.common;

public final class RegisterOuterClass {
  private RegisterOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cn_ladd_grpcx_register_common_HostInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cn_ladd_grpcx_register_common_HostInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cn_ladd_grpcx_register_common_BeatRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cn_ladd_grpcx_register_common_BeatRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cn_ladd_grpcx_register_common_ServiceRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cn_ladd_grpcx_register_common_ServiceRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cn_ladd_grpcx_register_common_SubscribeRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cn_ladd_grpcx_register_common_SubscribeRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cn_ladd_grpcx_register_common_LookupRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cn_ladd_grpcx_register_common_LookupRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cn_ladd_grpcx_register_common_GetDataRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cn_ladd_grpcx_register_common_GetDataRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cn_ladd_grpcx_register_common_RefreshRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cn_ladd_grpcx_register_common_RefreshRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cn_ladd_grpcx_register_common_Empty_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cn_ladd_grpcx_register_common_Empty_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cn_ladd_grpcx_register_common_LookupResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cn_ladd_grpcx_register_common_LookupResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cn_ladd_grpcx_register_common_GetAllServiceNamesResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cn_ladd_grpcx_register_common_GetAllServiceNamesResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cn_ladd_grpcx_register_common_GetDataResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cn_ladd_grpcx_register_common_GetDataResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016register.proto\022\035cn.ladd.grpcx.register" +
      ".common\"$\n\010HostInfo\022\n\n\002ip\030\001 \001(\t\022\014\n\004port\030" +
      "\002 \001(\t\"]\n\013BeatRequest\022\023\n\013serviceName\030\001 \001(" +
      "\t\0229\n\010hostInfo\030\002 \001(\0132\'.cn.ladd.grpcx.regi" +
      "ster.common.HostInfo\"`\n\016ServiceRequest\022\023" +
      "\n\013serviceName\030\001 \001(\t\0229\n\010hostInfo\030\002 \001(\0132\'." +
      "cn.ladd.grpcx.register.common.HostInfo\"b" +
      "\n\020SubscribeRequest\022\023\n\013serviceName\030\001 \001(\t\022" +
      "9\n\010hostInfo\030\002 \001(\0132\'.cn.ladd.grpcx.regist" +
      "er.common.HostInfo\"$\n\rLookupRequest\022\023\n\013s",
      "erviceName\030\001 \001(\t\"`\n\016GetDataRequest\022\023\n\013se" +
      "rviceName\030\001 \001(\t\0229\n\010hostInfo\030\002 \001(\0132\'.cn.l" +
      "add.grpcx.register.common.HostInfo\"a\n\016Re" +
      "freshRequest\022\023\n\013serviceName\030\001 \001(\t\022:\n\thos" +
      "tInfos\030\002 \003(\0132\'.cn.ladd.grpcx.register.co" +
      "mmon.HostInfo\"\007\n\005Empty\"L\n\016LookupResponse" +
      "\022:\n\thostInfos\030\001 \003(\0132\'.cn.ladd.grpcx.regi" +
      "ster.common.HostInfo\"2\n\032GetAllServiceNam" +
      "esResponse\022\024\n\014serviceNames\030\001 \003(\t\"#\n\017GetD" +
      "ataResponse\022\020\n\010nodeData\030\001 \001(\t2g\n\tHeartBe",
      "at\022Z\n\004beat\022*.cn.ladd.grpcx.register.comm" +
      "on.BeatRequest\032$.cn.ladd.grpcx.register." +
      "common.Empty\"\0002\367\005\n\010Register\022c\n\naddServic" +
      "e\022-.cn.ladd.grpcx.register.common.Servic" +
      "eRequest\032$.cn.ladd.grpcx.register.common" +
      ".Empty\"\000\022f\n\rremoveService\022-.cn.ladd.grpc" +
      "x.register.common.ServiceRequest\032$.cn.la" +
      "dd.grpcx.register.common.Empty\"\000\022d\n\tsubs" +
      "cribe\022/.cn.ladd.grpcx.register.common.Su" +
      "bscribeRequest\032$.cn.ladd.grpcx.register.",
      "common.Empty\"\000\022f\n\013unsubscribe\022/.cn.ladd." +
      "grpcx.register.common.SubscribeRequest\032$" +
      ".cn.ladd.grpcx.register.common.Empty\"\000\022g" +
      "\n\006lookup\022,.cn.ladd.grpcx.register.common" +
      ".LookupRequest\032-.cn.ladd.grpcx.register." +
      "common.LookupResponse\"\000\022w\n\022getAllService" +
      "Names\022$.cn.ladd.grpcx.register.common.Em" +
      "pty\0329.cn.ladd.grpcx.register.common.GetA" +
      "llServiceNamesResponse\"\000\022n\n\013getNodeData\022" +
      "-.cn.ladd.grpcx.register.common.GetDataR",
      "equest\032..cn.ladd.grpcx.register.common.G" +
      "etDataResponse\"\0002w\n\023RefreshServiceInfos\022" +
      "`\n\007refresh\022-.cn.ladd.grpcx.register.comm" +
      "on.RefreshRequest\032$.cn.ladd.grpcx.regist" +
      "er.common.Empty\"\000B\002P\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_cn_ladd_grpcx_register_common_HostInfo_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_cn_ladd_grpcx_register_common_HostInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cn_ladd_grpcx_register_common_HostInfo_descriptor,
        new java.lang.String[] { "Ip", "Port", });
    internal_static_cn_ladd_grpcx_register_common_BeatRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_cn_ladd_grpcx_register_common_BeatRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cn_ladd_grpcx_register_common_BeatRequest_descriptor,
        new java.lang.String[] { "ServiceName", "HostInfo", });
    internal_static_cn_ladd_grpcx_register_common_ServiceRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_cn_ladd_grpcx_register_common_ServiceRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cn_ladd_grpcx_register_common_ServiceRequest_descriptor,
        new java.lang.String[] { "ServiceName", "HostInfo", });
    internal_static_cn_ladd_grpcx_register_common_SubscribeRequest_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_cn_ladd_grpcx_register_common_SubscribeRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cn_ladd_grpcx_register_common_SubscribeRequest_descriptor,
        new java.lang.String[] { "ServiceName", "HostInfo", });
    internal_static_cn_ladd_grpcx_register_common_LookupRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_cn_ladd_grpcx_register_common_LookupRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cn_ladd_grpcx_register_common_LookupRequest_descriptor,
        new java.lang.String[] { "ServiceName", });
    internal_static_cn_ladd_grpcx_register_common_GetDataRequest_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_cn_ladd_grpcx_register_common_GetDataRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cn_ladd_grpcx_register_common_GetDataRequest_descriptor,
        new java.lang.String[] { "ServiceName", "HostInfo", });
    internal_static_cn_ladd_grpcx_register_common_RefreshRequest_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_cn_ladd_grpcx_register_common_RefreshRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cn_ladd_grpcx_register_common_RefreshRequest_descriptor,
        new java.lang.String[] { "ServiceName", "HostInfos", });
    internal_static_cn_ladd_grpcx_register_common_Empty_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_cn_ladd_grpcx_register_common_Empty_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cn_ladd_grpcx_register_common_Empty_descriptor,
        new java.lang.String[] { });
    internal_static_cn_ladd_grpcx_register_common_LookupResponse_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_cn_ladd_grpcx_register_common_LookupResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cn_ladd_grpcx_register_common_LookupResponse_descriptor,
        new java.lang.String[] { "HostInfos", });
    internal_static_cn_ladd_grpcx_register_common_GetAllServiceNamesResponse_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_cn_ladd_grpcx_register_common_GetAllServiceNamesResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cn_ladd_grpcx_register_common_GetAllServiceNamesResponse_descriptor,
        new java.lang.String[] { "ServiceNames", });
    internal_static_cn_ladd_grpcx_register_common_GetDataResponse_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_cn_ladd_grpcx_register_common_GetDataResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cn_ladd_grpcx_register_common_GetDataResponse_descriptor,
        new java.lang.String[] { "NodeData", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
