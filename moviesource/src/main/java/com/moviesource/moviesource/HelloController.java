package com.moviesource.moviesource;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        MovieApiService movieApiService = new MovieApiService();

        return movieApiService.getMovies().toString();
    }

}