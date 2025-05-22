package com.urfu.project.service;

import com.urfu.project.dto.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class KafkaProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(Message message, String topic) {
        var jsonMessage = convertToJson(message);
        kafkaTemplate.send(topic, jsonMessage);
        log.info("Отправленное сообщение: {}", jsonMessage);
    }

    private String convertToJson(Message message) {
        return String.format("{\"text\":\"%s\",\"sender\":\"%s\"}", message.getText(), message.getSender());
    }
}
