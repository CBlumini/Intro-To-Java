package com.Pet;

import java.util.Objects;

public abstract class Pet {

    //Variables
    private String name;
    private double health;
    private int painLevel;

    //Constsructor

    public Pet(String name, double health, int painLevel) {
        this.name = name;
        this.health = health;
        if (health > 10) {
            this.health = 10;
        }
        else if (health < 1) {
            this.health = 1;
        }
        else {
            this.health = painLevel;
        }

        if (painLevel > 10) {
            this.painLevel = 10;
        }
        else if (painLevel < 1) {
            this.painLevel = 1;
        }
        else {
            this.painLevel = painLevel;
        }

    }

    //Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public int getPainLevel() {
        return painLevel;
    }

    public void setPainLevel(int painLevel) {
        this.painLevel = painLevel;
    }

    //treat method
    public abstract int treat();

    //speak method
    public void speak() {
        String output = "Hello! My name is " + this.name;
        if (painLevel > 5) {
            System.out.println(output.toUpperCase());
        } else {
            System.out.println(output);
        }
    }

    //heal
    protected void heal() {
        health = 1.0;
        painLevel = 1;
    }

    //equals
    @Override
    public boolean equals(Object o) {
        if (o instanceof Pet) {
            Pet pet = (Pet) o;
            return this.name.equals(pet.name) ;
        }
        return false;
    }



}
