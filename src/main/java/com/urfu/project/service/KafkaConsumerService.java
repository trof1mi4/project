package com.urfu.project.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class KafkaConsumerService {
    @KafkaListener(topics = "test-topic", groupId = "my-group")
    public void listen(String message) {
        log.info("Получено сообщение: {}", message);
    }
}
