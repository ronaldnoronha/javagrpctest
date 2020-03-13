package com.moviepresenter.moviepresenter;

import java.util.Arrays;

		import org.springframework.boot.CommandLineRunner;
		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
		import org.springframework.context.ApplicationContext;
		import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MoviepresenterApplication {

	public static void main(String[] args) {
//		SpringApplication app = new SpringApplication(MoviepresenterApplication.class);
//		{
			SpringApplication.run(MoviepresenterApplication.class, args);
//		app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
//		Collections.
	//		app.run(args);


	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Starting presenter app on port localhost:8081");

		};
	}

}
