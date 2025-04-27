package com.urfu.project.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class SmsService implements MessageService {
    @Override
    public String getMessage() {
        return "SMS message";
    }

    @PostConstruct
    public void init() {
        log.info("SmsService bean is created!");
    }

    @PreDestroy
    public void destroy() {
        log.info("SmsService bean is being destroyed!");
    }
}
