package br.com.cesarschool.messagingservice.producer;

import br.com.cesarschool.messagingservice.Menu;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProducerApplication {

    static final String topicExchangeName = "topic-exchange";
    static final String routingKey = Menu.routingKey;

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }

}
