package com.soumen.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Soumen Karmakar
 * @Date 26/04/2021
 */
@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class KafkaController {
    private final Producer producer;

    @PostMapping(value = "/publish")
    public void sendMessage(@RequestParam("message") String message) {
        producer.sendMessage(message);
    }

}
