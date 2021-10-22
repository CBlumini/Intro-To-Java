package com.Cat;

import com.Dog.Dog;
import com.Pet.Pet;

public class Cat extends Pet {

    //Instance Variable
    private int miceCaught;
    public final int DEFAULT_MICE_CAUGHT = 0;

    public Cat(String name, double health, int painLevel, int miceCaught) {
        super(name, health, painLevel);
        this.miceCaught = miceCaught;
    }

    public Cat(String name, double health, int painLevel) {
        super(name, health, painLevel);
        this.miceCaught = DEFAULT_MICE_CAUGHT;
    }



    @Override
    public int treat() {
        this.heal();
        if (miceCaught < 4) {
            return (int) (this.getPainLevel() * 2 / this.getHealth());
        } else if (miceCaught <= 7) {
            return (int) (this.getPainLevel()/this.getHealth());
        } else{
            return (int) (this.getPainLevel()/this.getHealth()*2);
        }
    }

    @Override
    public void speak() {
        super.speak();
        if (this.getPainLevel() <= 5) {
            for (int i = 0; i < miceCaught; i++) {
                System.out.println("meow");
            }
        } else {
            for (int i = 0; i < miceCaught; i++) {
                System.out.println("MEOW");
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Cat) {
            Cat cat = (Cat) o;
            return super.equals(o) && miceCaught == cat.getMiceCaught();
        } else {
            return false;
        }
    }

    public int getMiceCaught() {
        return miceCaught;
    }

    public void setMiceCaught(int miceCaught) {
        this.miceCaught = miceCaught;
    }
}
