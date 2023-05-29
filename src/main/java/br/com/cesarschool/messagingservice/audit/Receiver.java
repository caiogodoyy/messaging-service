package br.com.cesarschool.messagingservice.audit;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class Receiver {

    public void receiveMessage(String message) {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
        String formattedDateTime = dateTime.format(formatter);
        System.out.println("[" + formattedDateTime + "] " + message);
    }
}
