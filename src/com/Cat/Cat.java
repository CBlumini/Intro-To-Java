package com.Cat;

import com.Pet.Pet;

public class Cat extends Pet {
    public Cat(String name, double health, int painLevel) {
        super(name, health, painLevel);
    }

    @Override
    public int treat() {
        return 0;
    }
}
