package com.company.controllers;

import java.util.List;

import com.company.entities.Lokomotive;
import com.company.repositories.interfaces.ILokoRepository;


public class LokomotiveController {
    private final ILokoRepository repo;

    public LokomotiveController(ILokoRepository repo) {
        this.repo = repo;
    }

    public String createLokomotive(String name) {
        Lokomotive Lokomotive = new Lokomotive(name);

        boolean created = repo.createLokomotive(Lokomotive);

        return (created ? "Lokomotive was created!" : "Lokomotive creation was failed!");
    }

    public String getLokomotive(int id) {
        Lokomotive Lokomotive = repo.getLokomotive(id);

        return (Lokomotive == null ? "Lokomotive was not found!" : Lokomotive.toString());
    }

    public String getAllLokomotives() {
        List<Lokomotive> Lokomotives = repo.getAllLokomotives();

        return Lokomotives.toString();
    }
}
