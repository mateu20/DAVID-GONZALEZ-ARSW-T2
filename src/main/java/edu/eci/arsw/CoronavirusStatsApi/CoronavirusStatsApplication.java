package edu.eci.arsw.CoronavirusStatsApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.eci.arsw.CoronavirusStats"})
public class CoronavirusStatsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronavirusStatsApplication.class, args);
	}

}
