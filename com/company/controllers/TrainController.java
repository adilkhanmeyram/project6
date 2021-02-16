package com.company.controllers;

import java.util.List;

import com.company.entities.Lokomotive;
import com.company.entities.Train;
import com.company.repositories.interfaces.ILokoRepository;
import com.company.repositories.interfaces.ITrainRepository;

public class TrainController {
    private final ITrainRepository repo;
    private final ILokoRepository locoRepo;
    public TrainController(ITrainRepository repo, ILokoRepository locoRepo) {

        this.repo = repo;
        this.locoRepo = locoRepo;
    }

    public String createTrain(String name, int capacity, int loko_id) {
        Train train = new Train(name, capacity, loko_id);

        boolean created = repo.createTrain(train);

        return (created ? "Train was created!" : "Train creation was failed!");
    }

    public String getTrain(int id) {
        Train train = repo.getTrain(id);

        return (train == null ? "Train was not found!" : train.toString());
    }

    public String getAllTrains() {
        List<Train> trains = repo.getAllTrains();

        return trains.toString();
    }

    public String createLokomotive(String name) {
        Lokomotive Lokomotive = new Lokomotive(name);

        boolean created = locoRepo.createLokomotive(Lokomotive);

        return (created ? "Lokomotive was created!" : "Lokomotive creation was failed!");
    }

    public Lokomotive getLokomotive(int id) {
        Lokomotive lokomotive = locoRepo.getLokomotive(id);
        return lokomotive;

    }

    public String getAllLokomotives() {
        List<Lokomotive> Lokomotives = locoRepo.getAllLokomotives();

        return Lokomotives.toString();
    }
}
