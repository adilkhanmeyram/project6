package com.company.repositories.interfaces;

import com.company.entities.Lokomotive;
import com.company.entities.Train;

import java.util.List;

public interface ILokoRepository {
    boolean createLokomotive(Lokomotive lokomotive);
    Lokomotive getLokomotive(int id);
    List<Lokomotive> getAllLokomotives();
}
