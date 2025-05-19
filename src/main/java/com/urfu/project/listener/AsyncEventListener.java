package com.urfu.project.listener;

import com.urfu.project.event.CustomEvent;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class AsyncEventListener {

    @Async
    @EventListener
    public void handleCustomEventAsync(CustomEvent event) {
        log.info("AsyncEventListener получил событие: {}", event.getMessage());
    }
}
