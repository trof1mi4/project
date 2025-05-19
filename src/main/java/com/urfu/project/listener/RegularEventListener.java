package com.urfu.project.listener;

import com.urfu.project.event.CustomEvent;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class RegularEventListener {

    @EventListener
    public void handleCustomEvent(CustomEvent event) {
        log.info("RegularEventListener получил событие: {}", event.getMessage());
    }
}
