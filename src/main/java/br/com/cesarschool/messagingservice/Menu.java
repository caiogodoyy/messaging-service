package br.com.cesarschool.messagingservice;

import br.com.cesarschool.messagingservice.audit.AuditApplication;
import br.com.cesarschool.messagingservice.consumer.ConsumerApplication;
import br.com.cesarschool.messagingservice.producer.ProducerApplication;
import org.springframework.boot.SpringApplication;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Menu {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("MENU\n(1) Audit\n(2) Consumer\n(3) Producer\n(4) Sair");
		int op = scanner.nextInt();

		/*
		String queueName = null;
		String routingKey = null;

		if (op == 2) {
			System.out.println("Queue: ");
			scanner.nextLine();
			queueName = scanner.nextLine();

			System.out.println("Route: ");
			routingKey = scanner.nextLine();
		}
		if (op == 3) {
			System.out.println("Route: ");
			scanner.nextLine();
			routingKey = scanner.nextLine();
		}

		CountDownLatch latch = new CountDownLatch(1);
		*/

		switch (op) {
			case 1:
				SpringApplication.run(AuditApplication.class, args);
				break;
			case 2:
				//String[] consArgs = { "--queueName=" + queueName, "--routingKey=" + routingKey };
				SpringApplication.run(ConsumerApplication.class, args);
				break;
			case 3:
				//String[] prodArgs = { "--routingKey=" + routingKey };
				SpringApplication.run(ProducerApplication.class, args);
				break;
			case 4:
				System.out.println("Encerrando o programa.");
			default:
				System.out.println("Opção inválida.");
		}
	}
}
