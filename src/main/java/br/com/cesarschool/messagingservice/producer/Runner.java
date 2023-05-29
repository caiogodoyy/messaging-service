package br.com.cesarschool.messagingservice.producer;

import java.util.Scanner;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final ConfigurableApplicationContext context;

    public Runner(RabbitTemplate rabbitTemplate,
                  ConfigurableApplicationContext context) {
        this.rabbitTemplate = rabbitTemplate;
        this.context = context;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Digite a mensagem: ");
            String input;
            input = scanner.nextLine();
            input = ProducerApplication.routingKey + ": " + input;

            if(input.equalsIgnoreCase("sair"))
                break;

            rabbitTemplate.convertAndSend(ProducerApplication.topicExchangeName, ProducerApplication.routingKey, input);
        }
        context.close();
    }
}
