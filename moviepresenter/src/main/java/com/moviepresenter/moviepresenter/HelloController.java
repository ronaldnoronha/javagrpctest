package com.moviepresenter.moviepresenter;

import com.moviepresenter.moviepresenter.model.PingResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.HashMap;
import java.util.Date;
import java.util.Collection;



@RestController
public class HelloController {

    @RequestMapping(path="/", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity index() {

        Map<String, Object> map = new HashMap<String, Object>();

        Date date = new Date();

        String url = "localhost:6789/api/ping";

        ManagedChannel channel = ManagedChannelBuilder.forTarget(url)
                .usePlaintext()
                .build();

        HelloClient client = new HelloClient(channel);
        Collection<PingResponse> responses = client.ping(date.getTime());

        responses.forEach(item-> {
                    map.put(item.getCountry(), item.getTotalConfirmed());
                });

        return ResponseEntity.ok(map);
    }

}