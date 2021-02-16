package com.company;

import com.company.controllers.TrainController;
import com.company.repositories.interfaces.ILokoRepository;
import com.company.repositories.interfaces.ITrainRepository;

import java.util.Scanner;

public class MyTrainApplication {
    private final TrainController controller;
    private final Scanner scanner;

    public MyTrainApplication(ITrainRepository TrainRepository, ILokoRepository lokoRepository) {
        controller = new TrainController(TrainRepository, lokoRepository);
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all Trains");
            System.out.println("2. Get Train by id");
            System.out.println("3. Create Train");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-3): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllTrainsMenu();
                } else if (option == 2) {
                    getTrainByIdMenu();
                } else if (option == 3) {
                    createTrainMenu();
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

    public void getAllTrainsMenu() {
        String response = controller.getAllTrains();
        System.out.println(response);
    }

    public void getTrainByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller.getTrain(id);
        System.out.println(response);
    }

    public void createTrainMenu() {
        System.out.println("Please enter loko_id");
        Integer loko_id = Integer.parseInt(scanner.next());
        try{
            var id = controller.getLokomotive(loko_id).getId();
        }
        catch (Exception ex){
            return;
        }

        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter capacity");
        Integer capacity = Integer.parseInt(scanner.next());


        String response = controller.createTrain(name, capacity, loko_id);
        System.out.println(response);
    }
}