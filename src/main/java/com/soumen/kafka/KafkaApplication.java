package com.soumen.kafka;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;

@SpringBootApplication
public class KafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }

    @Bean
    ApplicationRunner runner(Producer producer) {
        return args -> {
            while (true) {
                producer.sendMessage("Hello @" + Instant.now());
                Thread.sleep(1000);
            }
        };
    }
}
