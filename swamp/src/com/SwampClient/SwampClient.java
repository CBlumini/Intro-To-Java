package com.SwampClient;

import com.Fly.Fly;
import com.Frog.Frog;

public class SwampClient {
    public static void main(String[] args){
        Fly ka1 = new Fly(2, 4);
        Fly ka2 = new Fly(3);
        Fly ka3 = new Fly();
        System.out.println("fly 1 mass is " + ka1.getMass());
        System.out.println("fly 2 mass is " + ka2.getMass());
        System.out.println("fly 2 mass is " + ka3.getMass());

        System.out.println(ka1.toString());



        ka1.setSpeed(25);
        System.out.println("fly 1 speed is " + ka1.getSpeed());

        Frog froggy = new Frog("Meatwad", 6, 3.3122);
        Frog froggy2 = new Frog("Shake", 2.0, 3.221);
        Frog froggy3 = new Frog("Frylock");

        System.out.println(froggy.toString());
        System.out.println(froggy2.toString());
        System.out.println(froggy3.toString());

        System.out.println(froggy3.DEFAULT_AGE);
    }
}
