package com.moviepresenter.moviepresenter;

import com.moviepresenter.moviepresenter.model.CoreServiceGrpc;
import com.moviepresenter.moviepresenter.model.PingRequest;
import com.moviepresenter.moviepresenter.model.PingResponse;
import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HelloClient {

    private static final Logger logger = Logger.getLogger(HelloController.class.getName());

    private final CoreServiceGrpc.CoreServiceBlockingStub blockingStub;

    /** Construct client for accessing HelloWorld server using the existing channel. */
    public HelloClient(Channel channel) {
        // 'channel' here is a Channel, not a ManagedChannel, so it is not this code's responsibility to
        // shut it down.

        // Passing Channels to code makes code easier to test and makes it easier to reuse Channels.
        blockingStub = CoreServiceGrpc.newBlockingStub(channel);
    }

    /** Say hello to server. */
    public String ping(long time) {

        PingRequest request = PingRequest.newBuilder().setTimestamp(time).build();
        PingResponse response = blockingStub.ping(request);
//        try {
//            response = blockingStub.ping(request);
//        } catch (StatusRuntimeException e) {
//            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
//            return;
//        }
//        logger.info("Greeting: " + response.getMessage());
        return response.getMessage();
    }

    /**
     * Greet server. If provided, the first element of {@code args} is the name to use in the
     * greeting. The second argument is the target server.
     */
//    public static void main(String[] args) throws Exception {
//
//        Date date = new Date();
//        long time = date.getTime();
//        // Access a service running on the local machine on port 50051
//        String target = "localhost:6789/api/ping";
//        // Allow passing in the user and target strings as command line arguments
//        if (args.length > 0) {
//            if ("--help".equals(args[0])) {
//                System.err.println("Usage: [time [target]]");
//                System.err.println("");
//                System.err.println("  name    The name you wish to be greeted by. Defaults to " + time);
//                System.err.println("  target  The server to connect to. Defaults to " + target);
//                System.exit(1);
//            }
//            time = Long.parseLong(args[0]);
//        }
//        if (args.length > 1) {
//            target = args[1];
//        }
//
//        // Create a communication channel to the server, known as a Channel. Channels are thread-safe
//        // and reusable. It is common to create channels at the beginning of your application and reuse
//        // them until the application shuts down.
//        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
//                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
//                // needing certificates.
//                .usePlaintext()
//                .build();
//        try {
//            HelloClient client = new HelloClient(channel);
//            client.ping(time);
//        } finally {
//            // ManagedChannels use resources like threads and TCP connections. To prevent leaking these
//            // resources the channel should be shut down when it will no longer be used. If it may be used
//            // again leave it running.
//            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
//        }
//    }
}