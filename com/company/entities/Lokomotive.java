package com.company.entities;

public class Lokomotive {
    private int id;
    private String name;

    public Lokomotive() {}

    public Lokomotive(String name) {
        setName(name);
    }

    public Lokomotive(int id, String name) {
        setId(id);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "lokomotive id: " + getId() + ", name: " + getName();
    }
}
