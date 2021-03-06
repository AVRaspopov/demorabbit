package ru.proektbg.demorabbit.listeners;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Raspopov Anton
 */
@Component
public class RabbitMqListener {

    @RabbitListener(queues = "testFanout1")
    public void helloWorld(Message message){
        System.out.println(new String (message.getBody())+" Listener 1");
    }

    @RabbitListener(queues = "testFanout2")
    public void helloWorld2(Message message){
        System.out.println(new String (message.getBody())+" Listener 2");
    }

}
