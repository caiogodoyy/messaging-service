package br.com.cesarschool.messagingservice;

import br.com.cesarschool.messagingservice.audit.AuditApplication;
import br.com.cesarschool.messagingservice.consumer.ConsumerApplication;
import br.com.cesarschool.messagingservice.producer.ProducerApplication;
import org.springframework.boot.SpringApplication;

import java.util.Scanner;

public class Menu {
	private static String queueName;
	private static String routingKey;

	public static String getQueueName() {
		return queueName;
	}

	public static void setQueueName(String queueName) {
		Menu.queueName = queueName;
	}

	public static String getRoutingKey() {
		return routingKey;
	}

	public static void setRoutingKey(String routingKey) {
		Menu.routingKey = routingKey;
	}

	public static void route(Scanner scanner) {
		System.out.println("(1) Status de Compra\n(2) Status de Envio\n(3) Status de Recebimento");
		int op = scanner.nextInt();
		switch (op) {
			case 1 -> setRoutingKey("Status de Compra");
			case 2 -> setRoutingKey("Status de Envio");
			case 3 -> setRoutingKey("Status de Recebimento");
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
				setQueueName(scanner.nextLine());
				route(scanner);

				SpringApplication.run(ConsumerApplication.class, args);
			}
			case 3 -> {
				route(scanner);

				SpringApplication.run(ProducerApplication.class, args);
			}
			case 4 -> System.out.println("Encerrando o programa.");
			default -> System.out.println("Opção inválida.");
		}
	}
}
