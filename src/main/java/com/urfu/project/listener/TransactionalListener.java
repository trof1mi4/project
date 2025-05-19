package com.urfu.project.listener;

import com.urfu.project.event.CustomEvent;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Log4j2
@Component
public class TransactionalListener {

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleAfterCommit(CustomEvent event) {
        log.info("TransactionalEventListener получил событие: {}", event.getMessage());
    }
}
