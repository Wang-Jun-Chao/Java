// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: hello-world-service.proto

package wjc.dubbo.s001.helloworld.api;

public final class HelloWorldService {
  private HelloWorldService() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_wjc_dubbo_s001_helloworld_api_HelloRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_wjc_dubbo_s001_helloworld_api_HelloRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_wjc_dubbo_s001_helloworld_api_HelloResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_wjc_dubbo_s001_helloworld_api_HelloResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\031hello-world-service.proto\022\035wjc.dubbo.s" +
      "001.helloworld.api\"\034\n\014HelloRequest\022\014\n\004na" +
      "me\030\001 \001(\t\" \n\rHelloResponse\022\017\n\007message\030\001 \001" +
      "(\t2v\n\013DemoService\022g\n\010SayHello\022+.wjc.dubb" +
      "o.s001.helloworld.api.HelloRequest\032,.wjc" +
      ".dubbo.s001.helloworld.api.HelloResponse" +
      "\"\000B4\n\035wjc.dubbo.s001.helloworld.apiB\021Hel" +
      "loWorldServiceP\001b\006proto3"
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
    internal_static_wjc_dubbo_s001_helloworld_api_HelloRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_wjc_dubbo_s001_helloworld_api_HelloRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_wjc_dubbo_s001_helloworld_api_HelloRequest_descriptor,
        new java.lang.String[] { "Name", });
    internal_static_wjc_dubbo_s001_helloworld_api_HelloResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_wjc_dubbo_s001_helloworld_api_HelloResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_wjc_dubbo_s001_helloworld_api_HelloResponse_descriptor,
        new java.lang.String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
