package com.example.demo;

import com.example.demo.service.Instruction;
import com.example.demo.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class PeopleMainApplication {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PeopleMainApplication.class, args);
		PeopleService peopleService = context.getBean(PeopleService.class);
		int option;
		do {
			Instruction instruction = context.getBean(Instruction.class);
			instruction.getInstruction();
			option = sc.nextInt();
			switch (option) {
				case 1:
					peopleService.insertPerson();
					break;
				case 2:
					peopleService.getPerson();
					break;
				case 3:
					peopleService.updatePerson();
					break;
				case 4:
					peopleService.deletePerson();
					break;
				case 5:
					peopleService.printSchema();
					break;
				case 6:
					System.out.println("exit");
					System.exit(0);
			}
		} while (option != 6);

	}

}
