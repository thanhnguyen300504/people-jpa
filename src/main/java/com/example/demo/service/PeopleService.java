package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class PeopleService {
    private Scanner sc = new Scanner(System.in);

    private PeopleRepository peopleRepository;

    public PeopleService(@Autowired PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public void getPerson() {
        System.out.println("\n--------------------------");

        System.out.print("Enter ID: ");
        Long id = sc.nextLong();
        Person person = peopleRepository.findById(id).orElse(null);
        if (person == null) {
            System.out.println("no records found");
            return;
        }
        System.out.printf("%-10d %-20s\n", person.getId(), person.getFirstName());
        System.out.println("--------------------------\n");
    }

    public void printSchema() {
        if (peopleRepository == null) {
            System.out.println("\nNo records found\n");
            return;
        }
        System.out.println();
        System.out.printf("%-10s %-20s\n", "id", "first_name");
        System.out.println("---------------------");
        Iterable<Person> people = peopleRepository.findAll();
        for (Person person : people) {
            System.out.printf("%-10d %-20s\n", person.getId(), person.getFirstName());
        }
        System.out.println();
    }

    public void updatePerson() {
        System.out.println("\n--------------------------");
        System.out.println("Enter old ID");
        Long oldId = Long.parseLong(sc.nextLine());
        Person person = peopleRepository.findById(oldId).orElse(null);
        if (person == null) {
            System.out.println("No id found");
            return;
        }

        System.out.print("Enter new ID: ");
        Long newId = Long.parseLong(sc.nextLine());
        if (newId == oldId) {
            System.out.println("ID already existed, try again");
            return;
        }

        System.out.print("Enter new first name: ");
        String newFirstName = sc.nextLine();

        peopleRepository.updatePeopleById(newId, newFirstName, oldId);
        System.out.println("--------------------------\n");
    }


    public void insertPerson() {
        System.out.println("\n--------------------------");
        System.out.print("Enter ID: ");
        Long id = Long.parseLong(sc.nextLine());
        System.out.print("Enter first name: ");
        String firstName = sc.nextLine();
        Person person = peopleRepository.findById(id).orElse(null);
        if (person != null) {
            System.out.println("ID alread existed, try again!");
            return;
        }
        peopleRepository.save(new Person(id, firstName));
        System.out.println("--------------------------\n");
    }

    public void deletePerson() {
        System.out.println("\n--------------------------");
        System.out.print("Enter an ID to remove its record: ");
        Long id = Long.parseLong(sc.nextLine());
        Person person = peopleRepository.findById(id).orElse(null);
        if (person != null) {
            peopleRepository.deleteById(id);
            return;
        }
        System.out.println("records not found");
        System.out.println("--------------------------\n");
    }

}
