package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class Instruction {
    public void getInstruction() {
        StringBuilder s = new StringBuilder("");
        s.append("1. Add a person to the database\n");
        s.append("2. Read a person's information in the database\n");
        s.append("3. Update a person's information in the database\n");
        s.append("4. Delete a person's information in the database\n");
        s.append("5. Print table of people\n");
        s.append("6. Exit the program\n");
        s.append("Select an option: ");
        System.out.print(s);
    }
}
