package com.moviesource.moviesource;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import com.moviesource.moviesource.model.PingRequest;
import com.moviesource.moviesource.model.PingResponse;


@Slf4j
@GRpcService
public class GrpcController extends com.moviesource.moviesource.model.CoreServiceGrpc.CoreServiceImplBase {
    @Autowired
    private PingService pingService;

    @Override
    public void ping(PingRequest request, StreamObserver<PingResponse> responseObserver) {
        responseObserver.onNext(pingService.ping(request));
        responseObserver.onCompleted();
    }
}