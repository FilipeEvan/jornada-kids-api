package com.unimar.jornada_kids;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class JornadaKidsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JornadaKidsApplication.class, args);
	}

}
