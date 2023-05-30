package br.com.cesarschool.messagingservice;

import br.com.cesarschool.messagingservice.audit.AuditApplication;
import br.com.cesarschool.messagingservice.consumer.ConsumerApplication;
import br.com.cesarschool.messagingservice.producer.ProducerApplication;
import org.springframework.boot.SpringApplication;

import java.util.Scanner;

public class Menu {
	public static String queueName;
	public static String routingKey;

	public static void inputRoutingKey(Scanner scanner) {
		System.out.println("(1) Status de Compra\n(2) Status de Envio\n(3) Status de Recebimento");
		int op = scanner.nextInt();
		switch (op) {
			case 1 -> routingKey = "Status de Compra";
			case 2 -> routingKey = "Status de Envio";
			case 3 -> routingKey = "Status de Recebimento";
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("MENU\n(1) Audit\n(2) Consumer\n(3) Producer\n(4) Sair");
		int op = scanner.nextInt();

		switch (op) {
			case 1 -> SpringApplication.run(AuditApplication.class, args);
			case 2 -> {
				scanner.nextLine();
				System.out.println("Queue: ");
				queueName = scanner.nextLine();
				inputRoutingKey(scanner);
				SpringApplication.run(ConsumerApplication.class, args);
			}
			case 3 -> {
				inputRoutingKey(scanner);
				SpringApplication.run(ProducerApplication.class, args);
			}
			case 4 -> System.out.println("Encerrando o programa.");
			default -> System.out.println("Opção inválida.");
		}
	}
}
