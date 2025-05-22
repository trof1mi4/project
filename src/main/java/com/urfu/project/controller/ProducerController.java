package com.urfu.project.controller;

import com.urfu.project.dto.Message;
import com.urfu.project.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/producer")
@RequiredArgsConstructor
public class ProducerController {
    private final KafkaProducerService producerService;

    @PostMapping("/send")
    public String sendMessage(@RequestBody Message message) {
        producerService.sendMessage(message, "test-topic");
        return "Сообщение отправлено";
    }
}
