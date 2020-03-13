package com.moviesource.moviesource;

import java.util.Arrays;

		import org.springframework.boot.CommandLineRunner;
		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
		import org.springframework.context.ApplicationContext;
		import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MoviesourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesourceApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Starting app on port localhost:8080");

		};
	}

}
