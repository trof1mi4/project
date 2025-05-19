package com.urfu.project.service;

import com.urfu.project.event.CustomEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Service
@RequiredArgsConstructor
public class EventPublisherService {

    private final ApplicationEventPublisher eventPublisher;

    public void publishRegularEvent() {
        log.info("Публикация обычного события");
        eventPublisher.publishEvent(new CustomEvent(this, "Обычное событие"));
    }

    public void publishAsyncEvent() {
        log.info("Публикация асинхронного события");
        eventPublisher.publishEvent(new CustomEvent(this, "Асинхронное событие"));
    }


    @Transactional
    public void publishTransactionalEvent(boolean success) {
        log.info("Публикация транзакционного события");
        eventPublisher.publishEvent(new CustomEvent(this, "Транзакционное событие"));

        if (!success)
            throw new RuntimeException("Исключение для отката транзакции");
    }
}

