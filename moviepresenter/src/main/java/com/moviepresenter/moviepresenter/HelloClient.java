package com.moviepresenter.moviepresenter;

import com.moviepresenter.moviepresenter.model.CoreServiceGrpc;
import com.moviepresenter.moviepresenter.model.PingRequest;
import com.moviepresenter.moviepresenter.model.PingResponse;
import io.grpc.Channel;

import io.grpc.StatusRuntimeException;

import java.util.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HelloClient {

    private static final Logger logger = Logger.getLogger(HelloController.class.getName());

    private final CoreServiceGrpc.CoreServiceBlockingStub blockingStub;

    public HelloClient(Channel channel) {
        blockingStub = CoreServiceGrpc.newBlockingStub(channel);
    }

    public Collection<PingResponse> ping(long time) {

        PingRequest request = PingRequest.newBuilder().setTimestamp(time).build();
        Iterator<PingResponse> resp;
        Collection<PingResponse> responses = new ArrayList<PingResponse>();

        try {
            resp = blockingStub.ping(request);
            for (Iterator<PingResponse> it = resp; it.hasNext(); ) {
                responses.add(it.next());
            }
        } catch (StatusRuntimeException ex) {
            logger.log(Level.WARNING, "RPC failed: {0}", ex.getStatus());
        }

        return responses;
    }

}