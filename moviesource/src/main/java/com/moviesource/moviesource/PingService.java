package com.moviesource.moviesource;

import com.google.gson.Gson;
import com.moviesource.moviesource.model.PingRequest;
import com.moviesource.moviesource.model.PingResponse;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;


/**
 * Created by thinhda.
 * Date: 2019-08-18
 */

@Service
@Slf4j
public class PingService {
    public Collection<PingResponse> ping(PingRequest request) {
        log.info("Received Ping message {}", new Gson().toJson(request));

        MovieApiService movieApiService = new MovieApiService();
        JSONArray jsonArray = movieApiService.getMovies();
        Collection<PingResponse> pingResponses = new ArrayList<PingResponse>();

        jsonArray.forEach(item->{
            JSONObject json = (JSONObject) item;
            pingResponses.add(PingResponse.newBuilder()
                    .setTimestamp(request.getTimestamp())
                    .setCountry(json.getString("Country"))
                    .setTotalConfirmed(json.getInt("TotalConfirmed"))
                    .build());
            });

        return pingResponses;
    }
}