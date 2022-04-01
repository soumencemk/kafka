package com.soumen.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Soumen Karmakar
 * @Date 26/04/2021
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class Producer {

    private static final String TOPIC = "test_soumen";
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        log.debug("Producing message : {}", message);
        this.kafkaTemplate.send(TOPIC, message);
    }

}
