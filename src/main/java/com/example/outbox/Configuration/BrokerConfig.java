package com.example.outbox.Configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class BrokerConfig {
    public static final String QUEUE_NAME1 = "queue1";

    @Bean
    public Queue queue1() {
        return new Queue(QUEUE_NAME1, true);
    }
}
