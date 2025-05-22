package com.urfu.project.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
@Endpoint(id = "custom")
@Log4j2
public class CustomActuator {

    @ReadOperation
    public String triggerCustomEndpoint() {
        var message = "Актуатор: " + LocalDateTime.now();
        log.info(message);
        return message;
    }
}
