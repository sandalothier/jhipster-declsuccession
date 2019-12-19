package com.fisc.declsuccession.web.rest;

import com.fisc.declsuccession.service.DeclsuccessionKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/declsuccession-kafka")
public class DeclsuccessionKafkaResource {

    private final Logger log = LoggerFactory.getLogger(DeclsuccessionKafkaResource.class);

    private DeclsuccessionKafkaProducer kafkaProducer;

    public DeclsuccessionKafkaResource(DeclsuccessionKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
