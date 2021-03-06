// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: register.proto

package cn.ladd.grpcx.register.common;

/**
 * Protobuf type {@code cn.ladd.grpcx.register.common.ServiceRequest}
 */
public  final class ServiceRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:cn.ladd.grpcx.register.common.ServiceRequest)
    ServiceRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ServiceRequest.newBuilder() to construct.
  private ServiceRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ServiceRequest() {
    serviceName_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ServiceRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            serviceName_ = s;
            break;
          }
          case 18: {
            cn.ladd.grpcx.register.common.HostInfo.Builder subBuilder = null;
            if (hostInfo_ != null) {
              subBuilder = hostInfo_.toBuilder();
            }
            hostInfo_ = input.readMessage(cn.ladd.grpcx.register.common.HostInfo.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(hostInfo_);
              hostInfo_ = subBuilder.buildPartial();
            }

            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return cn.ladd.grpcx.register.common.RegisterOuterClass.internal_static_cn_ladd_grpcx_register_common_ServiceRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return cn.ladd.grpcx.register.common.RegisterOuterClass.internal_static_cn_ladd_grpcx_register_common_ServiceRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            cn.ladd.grpcx.register.common.ServiceRequest.class, cn.ladd.grpcx.register.common.ServiceRequest.Builder.class);
  }

  public static final int SERVICENAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object serviceName_;
  /**
   * <code>string serviceName = 1;</code>
   */
  public java.lang.String getServiceName() {
    java.lang.Object ref = serviceName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      serviceName_ = s;
      return s;
    }
  }
  /**
   * <code>string serviceName = 1;</code>
   */
  public com.google.protobuf.ByteString
      getServiceNameBytes() {
    java.lang.Object ref = serviceName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      serviceName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int HOSTINFO_FIELD_NUMBER = 2;
  private cn.ladd.grpcx.register.common.HostInfo hostInfo_;
  /**
   * <code>.cn.ladd.grpcx.register.common.HostInfo hostInfo = 2;</code>
   */
  public boolean hasHostInfo() {
    return hostInfo_ != null;
  }
  /**
   * <code>.cn.ladd.grpcx.register.common.HostInfo hostInfo = 2;</code>
   */
  public cn.ladd.grpcx.register.common.HostInfo getHostInfo() {
    return hostInfo_ == null ? cn.ladd.grpcx.register.common.HostInfo.getDefaultInstance() : hostInfo_;
  }
  /**
   * <code>.cn.ladd.grpcx.register.common.HostInfo hostInfo = 2;</code>
   */
  public cn.ladd.grpcx.register.common.HostInfoOrBuilder getHostInfoOrBuilder() {
    return getHostInfo();
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getServiceNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, serviceName_);
    }
    if (hostInfo_ != null) {
      output.writeMessage(2, getHostInfo());
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getServiceNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, serviceName_);
    }
    if (hostInfo_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getHostInfo());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof cn.ladd.grpcx.register.common.ServiceRequest)) {
      return super.equals(obj);
    }
    cn.ladd.grpcx.register.common.ServiceRequest other = (cn.ladd.grpcx.register.common.ServiceRequest) obj;

    boolean result = true;
    result = result && getServiceName()
        .equals(other.getServiceName());
    result = result && (hasHostInfo() == other.hasHostInfo());
    if (hasHostInfo()) {
      result = result && getHostInfo()
          .equals(other.getHostInfo());
    }
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + SERVICENAME_FIELD_NUMBER;
    hash = (53 * hash) + getServiceName().hashCode();
    if (hasHostInfo()) {
      hash = (37 * hash) + HOSTINFO_FIELD_NUMBER;
      hash = (53 * hash) + getHostInfo().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static cn.ladd.grpcx.register.common.ServiceRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.ladd.grpcx.register.common.ServiceRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.ladd.grpcx.register.common.ServiceRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.ladd.grpcx.register.common.ServiceRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.ladd.grpcx.register.common.ServiceRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.ladd.grpcx.register.common.ServiceRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.ladd.grpcx.register.common.ServiceRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.ladd.grpcx.register.common.ServiceRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.ladd.grpcx.register.common.ServiceRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static cn.ladd.grpcx.register.common.ServiceRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.ladd.grpcx.register.common.ServiceRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.ladd.grpcx.register.common.ServiceRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(cn.ladd.grpcx.register.common.ServiceRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code cn.ladd.grpcx.register.common.ServiceRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:cn.ladd.grpcx.register.common.ServiceRequest)
      cn.ladd.grpcx.register.common.ServiceRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cn.ladd.grpcx.register.common.RegisterOuterClass.internal_static_cn_ladd_grpcx_register_common_ServiceRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cn.ladd.grpcx.register.common.RegisterOuterClass.internal_static_cn_ladd_grpcx_register_common_ServiceRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cn.ladd.grpcx.register.common.ServiceRequest.class, cn.ladd.grpcx.register.common.ServiceRequest.Builder.class);
    }

    // Construct using cn.ladd.grpcx.register.common.ServiceRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      serviceName_ = "";

      if (hostInfoBuilder_ == null) {
        hostInfo_ = null;
      } else {
        hostInfo_ = null;
        hostInfoBuilder_ = null;
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return cn.ladd.grpcx.register.common.RegisterOuterClass.internal_static_cn_ladd_grpcx_register_common_ServiceRequest_descriptor;
    }

    public cn.ladd.grpcx.register.common.ServiceRequest getDefaultInstanceForType() {
      return cn.ladd.grpcx.register.common.ServiceRequest.getDefaultInstance();
    }

    public cn.ladd.grpcx.register.common.ServiceRequest build() {
      cn.ladd.grpcx.register.common.ServiceRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public cn.ladd.grpcx.register.common.ServiceRequest buildPartial() {
      cn.ladd.grpcx.register.common.ServiceRequest result = new cn.ladd.grpcx.register.common.ServiceRequest(this);
      result.serviceName_ = serviceName_;
      if (hostInfoBuilder_ == null) {
        result.hostInfo_ = hostInfo_;
      } else {
        result.hostInfo_ = hostInfoBuilder_.build();
      }
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof cn.ladd.grpcx.register.common.ServiceRequest) {
        return mergeFrom((cn.ladd.grpcx.register.common.ServiceRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(cn.ladd.grpcx.register.common.ServiceRequest other) {
      if (other == cn.ladd.grpcx.register.common.ServiceRequest.getDefaultInstance()) return this;
      if (!other.getServiceName().isEmpty()) {
        serviceName_ = other.serviceName_;
        onChanged();
      }
      if (other.hasHostInfo()) {
        mergeHostInfo(other.getHostInfo());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      cn.ladd.grpcx.register.common.ServiceRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (cn.ladd.grpcx.register.common.ServiceRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object serviceName_ = "";
    /**
     * <code>string serviceName = 1;</code>
     */
    public java.lang.String getServiceName() {
      java.lang.Object ref = serviceName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        serviceName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string serviceName = 1;</code>
     */
    public com.google.protobuf.ByteString
        getServiceNameBytes() {
      java.lang.Object ref = serviceName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        serviceName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string serviceName = 1;</code>
     */
    public Builder setServiceName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      serviceName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string serviceName = 1;</code>
     */
    public Builder clearServiceName() {
      
      serviceName_ = getDefaultInstance().getServiceName();
      onChanged();
      return this;
    }
    /**
     * <code>string serviceName = 1;</code>
     */
    public Builder setServiceNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      serviceName_ = value;
      onChanged();
      return this;
    }

    private cn.ladd.grpcx.register.common.HostInfo hostInfo_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        cn.ladd.grpcx.register.common.HostInfo, cn.ladd.grpcx.register.common.HostInfo.Builder, cn.ladd.grpcx.register.common.HostInfoOrBuilder> hostInfoBuilder_;
    /**
     * <code>.cn.ladd.grpcx.register.common.HostInfo hostInfo = 2;</code>
     */
    public boolean hasHostInfo() {
      return hostInfoBuilder_ != null || hostInfo_ != null;
    }
    /**
     * <code>.cn.ladd.grpcx.register.common.HostInfo hostInfo = 2;</code>
     */
    public cn.ladd.grpcx.register.common.HostInfo getHostInfo() {
      if (hostInfoBuilder_ == null) {
        return hostInfo_ == null ? cn.ladd.grpcx.register.common.HostInfo.getDefaultInstance() : hostInfo_;
      } else {
        return hostInfoBuilder_.getMessage();
      }
    }
    /**
     * <code>.cn.ladd.grpcx.register.common.HostInfo hostInfo = 2;</code>
     */
    public Builder setHostInfo(cn.ladd.grpcx.register.common.HostInfo value) {
      if (hostInfoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        hostInfo_ = value;
        onChanged();
      } else {
        hostInfoBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.cn.ladd.grpcx.register.common.HostInfo hostInfo = 2;</code>
     */
    public Builder setHostInfo(
        cn.ladd.grpcx.register.common.HostInfo.Builder builderForValue) {
      if (hostInfoBuilder_ == null) {
        hostInfo_ = builderForValue.build();
        onChanged();
      } else {
        hostInfoBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.cn.ladd.grpcx.register.common.HostInfo hostInfo = 2;</code>
     */
    public Builder mergeHostInfo(cn.ladd.grpcx.register.common.HostInfo value) {
      if (hostInfoBuilder_ == null) {
        if (hostInfo_ != null) {
          hostInfo_ =
            cn.ladd.grpcx.register.common.HostInfo.newBuilder(hostInfo_).mergeFrom(value).buildPartial();
        } else {
          hostInfo_ = value;
        }
        onChanged();
      } else {
        hostInfoBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.cn.ladd.grpcx.register.common.HostInfo hostInfo = 2;</code>
     */
    public Builder clearHostInfo() {
      if (hostInfoBuilder_ == null) {
        hostInfo_ = null;
        onChanged();
      } else {
        hostInfo_ = null;
        hostInfoBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.cn.ladd.grpcx.register.common.HostInfo hostInfo = 2;</code>
     */
    public cn.ladd.grpcx.register.common.HostInfo.Builder getHostInfoBuilder() {
      
      onChanged();
      return getHostInfoFieldBuilder().getBuilder();
    }
    /**
     * <code>.cn.ladd.grpcx.register.common.HostInfo hostInfo = 2;</code>
     */
    public cn.ladd.grpcx.register.common.HostInfoOrBuilder getHostInfoOrBuilder() {
      if (hostInfoBuilder_ != null) {
        return hostInfoBuilder_.getMessageOrBuilder();
      } else {
        return hostInfo_ == null ?
            cn.ladd.grpcx.register.common.HostInfo.getDefaultInstance() : hostInfo_;
      }
    }
    /**
     * <code>.cn.ladd.grpcx.register.common.HostInfo hostInfo = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        cn.ladd.grpcx.register.common.HostInfo, cn.ladd.grpcx.register.common.HostInfo.Builder, cn.ladd.grpcx.register.common.HostInfoOrBuilder> 
        getHostInfoFieldBuilder() {
      if (hostInfoBuilder_ == null) {
        hostInfoBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            cn.ladd.grpcx.register.common.HostInfo, cn.ladd.grpcx.register.common.HostInfo.Builder, cn.ladd.grpcx.register.common.HostInfoOrBuilder>(
                getHostInfo(),
                getParentForChildren(),
                isClean());
        hostInfo_ = null;
      }
      return hostInfoBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:cn.ladd.grpcx.register.common.ServiceRequest)
  }

  // @@protoc_insertion_point(class_scope:cn.ladd.grpcx.register.common.ServiceRequest)
  private static final cn.ladd.grpcx.register.common.ServiceRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new cn.ladd.grpcx.register.common.ServiceRequest();
  }

  public static cn.ladd.grpcx.register.common.ServiceRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ServiceRequest>
      PARSER = new com.google.protobuf.AbstractParser<ServiceRequest>() {
    public ServiceRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new ServiceRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ServiceRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ServiceRequest> getParserForType() {
    return PARSER;
  }

  public cn.ladd.grpcx.register.common.ServiceRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

