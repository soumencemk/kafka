package com.soumen.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author Soumen Karmakar
 * @Date 26/04/2021
 */
@Service
@Slf4j
public class Consumer {

    @KafkaListener(topics = "test_soumen", groupId = "cg_soumen_local",concurrency = "2")
    public void consume(String message) throws InterruptedException {
        log.info("Consumed : {}", message);
        Thread.sleep(1500);
    }
}
