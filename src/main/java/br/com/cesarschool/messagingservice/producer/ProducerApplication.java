package br.com.cesarschool.messagingservice.producer;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProducerApplication {

    static final String topicExchangeName = "topic-exchange";
    static final String routingKey = "route-1";

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }

}
