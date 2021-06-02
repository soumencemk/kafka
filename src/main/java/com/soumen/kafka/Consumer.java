package com.soumen.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author Soumen Karmakar
 * @Date 26/04/2021
 */
@Service
@Slf4j
public class Consumer {

    @KafkaListener(topics = "users", groupId = "soumen_test")
    public void consume(String message) throws IOException {
        log.info("Consumed message : {}", message);
    }
}
