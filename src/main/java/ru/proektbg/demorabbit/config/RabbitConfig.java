package ru.proektbg.demorabbit.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * @author Raspopov Anton
 */
public class RabbitConfig {

    @Value("${spring.rabbitmq.username}")
    private String rabbitUsername;

    @Value("${spring.rabbitmq.password}")
    private String rabbitPassword;

    @Bean
    public ConnectionFactory connectionFactory(){
        CachingConnectionFactory factory = new CachingConnectionFactory("134.0.115.190");
        factory.setPassword(rabbitPassword);
        factory.setUsername(rabbitUsername);
        return factory;
    }

    @Bean
    public AmqpAdmin amqpAdmin(ConnectionFactory connectionFactory){
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        return new RabbitTemplate(connectionFactory);
    }

    @Bean(name = "testFanout2")
    public Queue myQueue(){
        return new Queue("testFanout1");
    }

    @Bean(name = "testFanout1")
    public Queue myQueue1(){
        return new Queue("testFanout1");
    }

    @Bean
    public FanoutExchange fanoutExchangeA(){
        return new FanoutExchange("amq.fanout");
    }

    @Bean
    public Binding binding1(@Value(value = "testFanout1") Queue queue, FanoutExchange exchange){
        return BindingBuilder.bind(queue).to(exchange);
    }

    @Bean
    public Binding binding2(@Value(value = "testFanout2") Queue queue, FanoutExchange exchange){
        return BindingBuilder.bind(queue).to(exchange);
    }


}
