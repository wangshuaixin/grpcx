// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: register.proto

package cn.ladd.grpcx.register.common;

public interface BeatRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:cn.ladd.grpcx.register.common.BeatRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string serviceName = 1;</code>
   */
  java.lang.String getServiceName();
  /**
   * <code>string serviceName = 1;</code>
   */
  com.google.protobuf.ByteString
      getServiceNameBytes();

  /**
   * <code>.cn.ladd.grpcx.register.common.HostInfo hostInfo = 2;</code>
   */
  boolean hasHostInfo();
  /**
   * <code>.cn.ladd.grpcx.register.common.HostInfo hostInfo = 2;</code>
   */
  cn.ladd.grpcx.register.common.HostInfo getHostInfo();
  /**
   * <code>.cn.ladd.grpcx.register.common.HostInfo hostInfo = 2;</code>
   */
  cn.ladd.grpcx.register.common.HostInfoOrBuilder getHostInfoOrBuilder();
}
