package com.moviesource.moviesource;
import com.google.gson.Gson;
import com.moviesource.moviesource.model.PingRequest;
import com.moviesource.moviesource.model.PingResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.moviesource.moviesource.MovieApiService;

/**
 * Created by thinhda.
 * Date: 2019-08-18
 */

@Service
@Slf4j
public class PingService {
    public PingResponse ping(PingRequest request) {
        log.info("Received Ping message {}", new Gson().toJson(request));

        MovieApiService movieApiService = new MovieApiService();
        return PingResponse.newBuilder()
                .setTimestamp(request.getTimestamp())
                .setMessage(movieApiService.getMovies().toString())
                .build();
    }
}