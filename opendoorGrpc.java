package grpc.test.office;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * The open door service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: AutoDoors.proto")
public final class opendoorGrpc {

  private opendoorGrpc() {}

  public static final String SERVICE_NAME = "office.opendoor";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.test.office.InputRequest,
      grpc.test.office.OutputReply> getMotionDetectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MotionDetect",
      requestType = grpc.test.office.InputRequest.class,
      responseType = grpc.test.office.OutputReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.test.office.InputRequest,
      grpc.test.office.OutputReply> getMotionDetectMethod() {
    io.grpc.MethodDescriptor<grpc.test.office.InputRequest, grpc.test.office.OutputReply> getMotionDetectMethod;
    if ((getMotionDetectMethod = opendoorGrpc.getMotionDetectMethod) == null) {
      synchronized (opendoorGrpc.class) {
        if ((getMotionDetectMethod = opendoorGrpc.getMotionDetectMethod) == null) {
          opendoorGrpc.getMotionDetectMethod = getMotionDetectMethod = 
              io.grpc.MethodDescriptor.<grpc.test.office.InputRequest, grpc.test.office.OutputReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "office.opendoor", "MotionDetect"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.test.office.InputRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.test.office.OutputReply.getDefaultInstance()))
                  .setSchemaDescriptor(new opendoorMethodDescriptorSupplier("MotionDetect"))
                  .build();
          }
        }
     }
     return getMotionDetectMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static opendoorStub newStub(io.grpc.Channel channel) {
    return new opendoorStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static opendoorBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new opendoorBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static opendoorFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new opendoorFutureStub(channel);
  }

  /**
   * <pre>
   * The open door service definition.
   * </pre>
   */
  public static abstract class opendoorImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Provides automatic request to open door
     * </pre>
     */
    public void motionDetect(grpc.test.office.InputRequest request,
        io.grpc.stub.StreamObserver<grpc.test.office.OutputReply> responseObserver) {
      asyncUnimplementedUnaryCall(getMotionDetectMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getMotionDetectMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.test.office.InputRequest,
                grpc.test.office.OutputReply>(
                  this, METHODID_MOTION_DETECT)))
          .build();
    }
  }

  /**
   * <pre>
   * The open door service definition.
   * </pre>
   */
  public static final class opendoorStub extends io.grpc.stub.AbstractStub<opendoorStub> {
    private opendoorStub(io.grpc.Channel channel) {
      super(channel);
    }

    private opendoorStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected opendoorStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new opendoorStub(channel, callOptions);
    }

    /**
     * <pre>
     * Provides automatic request to open door
     * </pre>
     */
    public void motionDetect(grpc.test.office.InputRequest request,
        io.grpc.stub.StreamObserver<grpc.test.office.OutputReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getMotionDetectMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The open door service definition.
   * </pre>
   */
  public static final class opendoorBlockingStub extends io.grpc.stub.AbstractStub<opendoorBlockingStub> {
    private opendoorBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private opendoorBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected opendoorBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new opendoorBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Provides automatic request to open door
     * </pre>
     */
    public grpc.test.office.OutputReply motionDetect(grpc.test.office.InputRequest request) {
      return blockingUnaryCall(
          getChannel(), getMotionDetectMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The open door service definition.
   * </pre>
   */
  public static final class opendoorFutureStub extends io.grpc.stub.AbstractStub<opendoorFutureStub> {
    private opendoorFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private opendoorFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected opendoorFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new opendoorFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Provides automatic request to open door
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.test.office.OutputReply> motionDetect(
        grpc.test.office.InputRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getMotionDetectMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_MOTION_DETECT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final opendoorImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(opendoorImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MOTION_DETECT:
          serviceImpl.motionDetect((grpc.test.office.InputRequest) request,
              (io.grpc.stub.StreamObserver<grpc.test.office.OutputReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class opendoorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    opendoorBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.test.office.OfficeServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("opendoor");
    }
  }

  private static final class opendoorFileDescriptorSupplier
      extends opendoorBaseDescriptorSupplier {
    opendoorFileDescriptorSupplier() {}
  }

  private static final class opendoorMethodDescriptorSupplier
      extends opendoorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    opendoorMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (opendoorGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new opendoorFileDescriptorSupplier())
              .addMethod(getMotionDetectMethod())
              .build();
        }
      }
    }
    return result;
  }
}
