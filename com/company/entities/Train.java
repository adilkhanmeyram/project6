package com.company.entities;

public class Train {
    private int id;
    private String name;
    private int capacity;
    private int lokoID;

    public Train() {}

    public Train(String name, int capacity, int lokoID) {
        setName(name);
        setCapacity(capacity);
        setLokoID(lokoID);
    }

    public Train(int id, String name, int capacity, int lokoID) {
        setLokoID(lokoID);
        setName(name);
        setCapacity(capacity);
        setId(id);
    }

    public int getCapacity() {
        return capacity;
    }

    public int getId() {
        return id;
    }

    public int getLokoID() {
        return lokoID;
    }

    public String getName() {
        return name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLokoID(int lokoID) {
        this.lokoID = lokoID;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "train id: " + getId() + ", name: " + getName() + ", capacity: " + getCapacity() +
                ", lokomotive_id" + lokoID;
    }
}
