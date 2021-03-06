// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: add.proto

package cn.ladd.grpcx.register.demo.add;

/**
 * Protobuf type {@code cn.ladd.grpcx.register.demo.add.RequestInfo}
 */
public  final class RequestInfo extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:cn.ladd.grpcx.register.demo.add.RequestInfo)
    RequestInfoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use RequestInfo.newBuilder() to construct.
  private RequestInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RequestInfo() {
    a_ = 0;
    b_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private RequestInfo(
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
          case 8: {

            a_ = input.readInt32();
            break;
          }
          case 16: {

            b_ = input.readInt32();
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
    return cn.ladd.grpcx.register.demo.add.AddOuterClass.internal_static_cn_ladd_grpcx_register_demo_add_RequestInfo_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return cn.ladd.grpcx.register.demo.add.AddOuterClass.internal_static_cn_ladd_grpcx_register_demo_add_RequestInfo_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            cn.ladd.grpcx.register.demo.add.RequestInfo.class, cn.ladd.grpcx.register.demo.add.RequestInfo.Builder.class);
  }

  public static final int A_FIELD_NUMBER = 1;
  private int a_;
  /**
   * <code>int32 a = 1;</code>
   */
  public int getA() {
    return a_;
  }

  public static final int B_FIELD_NUMBER = 2;
  private int b_;
  /**
   * <code>int32 b = 2;</code>
   */
  public int getB() {
    return b_;
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
    if (a_ != 0) {
      output.writeInt32(1, a_);
    }
    if (b_ != 0) {
      output.writeInt32(2, b_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (a_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, a_);
    }
    if (b_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, b_);
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
    if (!(obj instanceof cn.ladd.grpcx.register.demo.add.RequestInfo)) {
      return super.equals(obj);
    }
    cn.ladd.grpcx.register.demo.add.RequestInfo other = (cn.ladd.grpcx.register.demo.add.RequestInfo) obj;

    boolean result = true;
    result = result && (getA()
        == other.getA());
    result = result && (getB()
        == other.getB());
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
    hash = (37 * hash) + A_FIELD_NUMBER;
    hash = (53 * hash) + getA();
    hash = (37 * hash) + B_FIELD_NUMBER;
    hash = (53 * hash) + getB();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static cn.ladd.grpcx.register.demo.add.RequestInfo parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.ladd.grpcx.register.demo.add.RequestInfo parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.ladd.grpcx.register.demo.add.RequestInfo parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.ladd.grpcx.register.demo.add.RequestInfo parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.ladd.grpcx.register.demo.add.RequestInfo parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.ladd.grpcx.register.demo.add.RequestInfo parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.ladd.grpcx.register.demo.add.RequestInfo parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.ladd.grpcx.register.demo.add.RequestInfo parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.ladd.grpcx.register.demo.add.RequestInfo parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static cn.ladd.grpcx.register.demo.add.RequestInfo parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.ladd.grpcx.register.demo.add.RequestInfo parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.ladd.grpcx.register.demo.add.RequestInfo parseFrom(
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
  public static Builder newBuilder(cn.ladd.grpcx.register.demo.add.RequestInfo prototype) {
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
   * Protobuf type {@code cn.ladd.grpcx.register.demo.add.RequestInfo}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:cn.ladd.grpcx.register.demo.add.RequestInfo)
      cn.ladd.grpcx.register.demo.add.RequestInfoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cn.ladd.grpcx.register.demo.add.AddOuterClass.internal_static_cn_ladd_grpcx_register_demo_add_RequestInfo_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cn.ladd.grpcx.register.demo.add.AddOuterClass.internal_static_cn_ladd_grpcx_register_demo_add_RequestInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cn.ladd.grpcx.register.demo.add.RequestInfo.class, cn.ladd.grpcx.register.demo.add.RequestInfo.Builder.class);
    }

    // Construct using cn.ladd.grpcx.register.demo.add.RequestInfo.newBuilder()
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
      a_ = 0;

      b_ = 0;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return cn.ladd.grpcx.register.demo.add.AddOuterClass.internal_static_cn_ladd_grpcx_register_demo_add_RequestInfo_descriptor;
    }

    public cn.ladd.grpcx.register.demo.add.RequestInfo getDefaultInstanceForType() {
      return cn.ladd.grpcx.register.demo.add.RequestInfo.getDefaultInstance();
    }

    public cn.ladd.grpcx.register.demo.add.RequestInfo build() {
      cn.ladd.grpcx.register.demo.add.RequestInfo result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public cn.ladd.grpcx.register.demo.add.RequestInfo buildPartial() {
      cn.ladd.grpcx.register.demo.add.RequestInfo result = new cn.ladd.grpcx.register.demo.add.RequestInfo(this);
      result.a_ = a_;
      result.b_ = b_;
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
      if (other instanceof cn.ladd.grpcx.register.demo.add.RequestInfo) {
        return mergeFrom((cn.ladd.grpcx.register.demo.add.RequestInfo)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(cn.ladd.grpcx.register.demo.add.RequestInfo other) {
      if (other == cn.ladd.grpcx.register.demo.add.RequestInfo.getDefaultInstance()) return this;
      if (other.getA() != 0) {
        setA(other.getA());
      }
      if (other.getB() != 0) {
        setB(other.getB());
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
      cn.ladd.grpcx.register.demo.add.RequestInfo parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (cn.ladd.grpcx.register.demo.add.RequestInfo) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int a_ ;
    /**
     * <code>int32 a = 1;</code>
     */
    public int getA() {
      return a_;
    }
    /**
     * <code>int32 a = 1;</code>
     */
    public Builder setA(int value) {
      
      a_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 a = 1;</code>
     */
    public Builder clearA() {
      
      a_ = 0;
      onChanged();
      return this;
    }

    private int b_ ;
    /**
     * <code>int32 b = 2;</code>
     */
    public int getB() {
      return b_;
    }
    /**
     * <code>int32 b = 2;</code>
     */
    public Builder setB(int value) {
      
      b_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 b = 2;</code>
     */
    public Builder clearB() {
      
      b_ = 0;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:cn.ladd.grpcx.register.demo.add.RequestInfo)
  }

  // @@protoc_insertion_point(class_scope:cn.ladd.grpcx.register.demo.add.RequestInfo)
  private static final cn.ladd.grpcx.register.demo.add.RequestInfo DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new cn.ladd.grpcx.register.demo.add.RequestInfo();
  }

  public static cn.ladd.grpcx.register.demo.add.RequestInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RequestInfo>
      PARSER = new com.google.protobuf.AbstractParser<RequestInfo>() {
    public RequestInfo parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new RequestInfo(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RequestInfo> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RequestInfo> getParserForType() {
    return PARSER;
  }

  public cn.ladd.grpcx.register.demo.add.RequestInfo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

