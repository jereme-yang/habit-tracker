package com.jereme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication // all spring boot applications will have this
@RestController // rest api ENDpoint, each method will return a response body directly
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping
    public String helloWorld() {
        return "Hello World";
    }

}
