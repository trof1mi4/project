package com.urfu.project.contriller;

import com.urfu.project.service.MessageService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Log4j2
@Controller
public class SetterInjectionController {
    private MessageService messageService;

    @Autowired
    public void setMessageService(@Qualifier("smsService") MessageService messageService) {
        this.messageService = messageService;
        log.info("Setter injection: " + messageService.getMessage());
    }
}
