package com.urfu.project.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class EmailService implements MessageService {

    @Override
    public String getMessage() {
        return "EmailMessage";
    }

    @PostConstruct
    public void init() {
        log.info("EmailService bean is created!");
    }

    @PreDestroy
    public void destroy() {
        log.info("EmailService bean is being destroyed!");
    }
}
