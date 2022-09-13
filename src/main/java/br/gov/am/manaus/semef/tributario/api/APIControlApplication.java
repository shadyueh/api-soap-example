package br.gov.am.manaus.semef.tributario.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class APIControlApplication {

    public static void main(String[] args) {
        SpringApplication.run(APIControlApplication.class, args);
    }

    @GetMapping("/")
    public String index() {
        return "<h1>API Control</h1>";
    }

    @GetMapping("/message")
    public String getMessage() {
        return "<h1>It's working!</h1><p>Spring Boot Stub App is OK!</p>";
    }
}
