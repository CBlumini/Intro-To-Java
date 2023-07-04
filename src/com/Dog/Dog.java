package com.Dog;

import com.Pet.Pet;

public class Dog extends Pet {

    //Instance Variables
    private double droolRate;
    public final double DEFAULT_DROOL_RATE = 5.0;

    //constructors
    public Dog(String name, double health, int painLevel, double droolRate) {
        super(name, health, painLevel);
        this.droolRate = droolRate;
    }

    public Dog(String name, double health, int painLevel) {
        super(name, health, painLevel);
        this.droolRate = DEFAULT_DROOL_RATE;
    }

    //methods

    @Override
    public int treat() {
        this.heal();
        if (this.droolRate < 3.5) {
            return (int) (this.getPainLevel() * 2 / this.getHealth());
        } else if (this.droolRate <= 7.5) {
            return (int) (this.getPainLevel()/this.getHealth());
        } else{
            return (int) (this.getPainLevel()/this.getHealth()*2);
        }
    }

    @Override
    public void speak() {
        super.speak();
        int pain = this.getPainLevel();
        //these won't print quite right
        StringBuilder output = new StringBuilder("bark");
        if (1 < pain) {
            output.append(" bark".repeat(pain));
        }
        if (pain > 5) {
            System.out.println(output.toString().toUpperCase());
        } else {
            System.out.println(output.toString());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Dog) {
            Dog dog = (Dog) o;
            return super.equals(o) && this.droolRate == dog.getDroolRate();
        } else {
            return false;
        }
    }

    public double getDroolRate() {
        return droolRate;
    }

}

