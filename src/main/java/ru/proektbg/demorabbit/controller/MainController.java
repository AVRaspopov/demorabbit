package ru.proektbg.demorabbit.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Raspopov Anton
 */
@RestController
public class MainController {

    @Autowired
    AmqpTemplate template;

    @GetMapping("/biba")
    public String testQueue(){
        template.convertAndSend("testik", "Hello, Biba!");
        return "Сообщение отправлено!";
    }

}
