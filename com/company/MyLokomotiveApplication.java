package com.company;

import com.company.controllers.LokomotiveController;
import com.company.controllers.TrainController;
import com.company.entities.Lokomotive;
import com.company.repositories.interfaces.ILokoRepository;
import com.company.repositories.interfaces.ITrainRepository;

import java.util.Scanner;

public class MyLokomotiveApplication {
    private final TrainController controller;
    private final Scanner scanner;

    public MyLokomotiveApplication(ITrainRepository trainRepository, ILokoRepository LokoRepository) {
        controller = new TrainController(trainRepository, LokoRepository);
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all Locomotives");
            System.out.println("2. Get Locomotive by id");
            System.out.println("3. Create Locomotive");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-3): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllLokomotivesMenu();
                } else if (option == 2) {
                    getLokomotiveByIdMenu();
                } else if (option == 3) {
                    createLokomotiveMenu();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next(); // to ignore incorrect input
            }

            System.out.println("*************************");
        }
    }

    public void getAllLokomotivesMenu() {
        String response = controller.getAllLokomotives();
        System.out.println(response);
    }

    public void getLokomotiveByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        Lokomotive lokomotive = controller.getLokomotive(id);
        System.out.println((lokomotive == null ? "Lokomotive was not found!" : lokomotive.toString()));
    }

    public void createLokomotiveMenu() {
        System.out.println("Please enter name");
        String name = scanner.next();

        String response = controller.createLokomotive(name);
        System.out.println(response);
    }
}
