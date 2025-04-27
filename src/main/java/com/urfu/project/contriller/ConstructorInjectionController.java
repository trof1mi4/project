package com.urfu.project.contriller;

import com.urfu.project.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;

@Log4j2
@Controller
public class ConstructorInjectionController {
    private final MessageService messageService;

    @Autowired
    public ConstructorInjectionController(@Qualifier("emailService") MessageService messageService) {
        this.messageService = messageService;
        log.info("Constructor injection: " + messageService.getMessage());
    }
}
