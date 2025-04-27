package com.urfu.project.contriller;

import com.urfu.project.service.MessageService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Log4j2
@Controller
public class FieldInjectionController {
    @Autowired
    @Qualifier("smsService")
    private MessageService messageService;

    public void printMessage() {
        log.info("Field injection: " + messageService.getMessage());
    }
}
