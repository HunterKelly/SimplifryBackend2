package com.Simplifry;

import com.Simplifry.configurations.CorsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@ComponentScan
public class SimplifryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimplifryApplication.class, args);
	}



	@Bean
	public CorsConfig corsConfig() {
		return new CorsConfig();
	}
}









