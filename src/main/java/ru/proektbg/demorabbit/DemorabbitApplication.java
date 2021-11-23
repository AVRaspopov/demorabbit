package ru.proektbg.demorabbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import ru.proektbg.demorabbit.config.RabbitConfig;

@SpringBootApplication
@Import(RabbitConfig.class)
public class DemorabbitApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemorabbitApplication.class, args);
    }

}
