package com.urfu.project.controller;

import com.urfu.project.service.EventPublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventPublisherService eventPublisherService;

    @GetMapping("/regular")
    public String publishRegularEvent() {
        eventPublisherService.publishRegularEvent();
        return "Обычное событие опубликовано";
    }

    @GetMapping("/async")
    public String publishAsyncEvent() {
        eventPublisherService.publishAsyncEvent();
        return "Асинхронное событие опубликовано";
    }

    @GetMapping("/transactional")
    public String publishTransactionalEvent(@RequestParam(defaultValue = "true") boolean success) {
        eventPublisherService.publishTransactionalEvent(success);
        return "Транзакционное событие опубликовано";
    }
}
