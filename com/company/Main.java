package com.company;

import com.company.data.interfaces.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.repositories.LokoRepo;
import com.company.repositories.interfaces.ILokoRepository;
import com.company.repositories.trainRepo;
import com.company.repositories.interfaces.ITrainRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IDB db = new PostgresDB();
        ITrainRepository repoTrain = new trainRepo(db);
        ILokoRepository repoLokomotive = new LokoRepo(db);
        MyTrainApplication appTrain = new MyTrainApplication(repoTrain, repoLokomotive);
        MyLokomotiveApplication appLokomotive = new MyLokomotiveApplication(repoTrain, repoLokomotive);
        System.out.println("Hello");
        System.out.println("1. Locomotive");
        System.out.println("2. Train");
        System.out.print("Enter option (1-2): ");
        int option = scanner.nextInt();
        if (option == 1) {
            appLokomotive.start();
        } else if (option == 2) {
            appTrain.start();
        }
    }
}
