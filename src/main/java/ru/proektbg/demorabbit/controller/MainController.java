package ru.proektbg.demorabbit.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Raspopov Anton
 */
@RestController
public class MainController {

    @Autowired
    RabbitTemplate template;

    @GetMapping("/biba")
    public String testQueue(){
        template.setExchange("amq.fanout");
        template.convertAndSend("", "Hello, Biba!");
        return "Сообщение отправлено!";
    }

}
