package com.example.listviewnangcao;

public class Animal {
    private String Name;
    private String Description;
    private int position;

    public Animal(String name, String description, int position) {
        Name = name;
        Description = description;
        this.position = position;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
