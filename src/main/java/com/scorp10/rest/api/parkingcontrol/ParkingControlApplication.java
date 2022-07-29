package com.scorp10.rest.api.parkingcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ParkingControlApplication {

	@GetMapping("/message")
	public String getMessage(){
		return "<h1>It's working!</h1><p>Spring Boot Stub App is OK!</p>";
	}

	public static void main(String[] args) {
		SpringApplication.run(ParkingControlApplication.class, args);
	}

}
