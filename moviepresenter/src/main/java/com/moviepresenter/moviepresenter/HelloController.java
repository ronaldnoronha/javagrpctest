package com.moviepresenter.moviepresenter;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.logging.Logger;

import com.moviepresenter.moviepresenter.model.PingRequest;
import com.moviepresenter.moviepresenter.model.PingRequest;
import com.moviepresenter.moviepresenter.model.CoreServiceGrpc;



@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() throws IOException {

        Date date = new Date();

        String url = "localhost:6789/api/ping";

        ManagedChannel channel = ManagedChannelBuilder.forTarget(url)
                .usePlaintext()
                .build();

        HelloClient client = new HelloClient(channel);
        String message = client.ping(date.getTime());

        return "Greetings from Spring Boot! I am the movie presenter! "+ message;
    }

//    public static String getText(String url) throws IOException {
//        URL website = new URL(url);
//        URLConnection connection = website.openConnection();
//        BufferedReader in = new BufferedReader(
//                new InputStreamReader(
//                        connection.getInputStream()));
//
//        StringBuilder response = new StringBuilder();
//        String inputLine;
//
//        while ((inputLine = in.readLine()) != null) {
//            response.append(inputLine);
//        }
//
//        in.close();
//
//        return response.toString();
//    }

}