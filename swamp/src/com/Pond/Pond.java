package com.Pond;

import com.Frog.Frog;
import com.Fly.Fly;

public class Pond {
    public static void main(String[] args){
        //operations
        Frog.setSpecies("1331 Frogs");

        //Frogs
        Frog Peepo = new Frog("Peepo");
        Frog Pepe = new Frog("Pepe",10, 15);
        Frog Peepaw = new Frog("Peepaw", 4.6, 5);
        Frog Clyde = new Frog("Clyde", 7.3, 10);

        //Flys
        Fly Fly1 = new Fly(1, 3);
        Fly Fly2 = new Fly(6);
        Fly Fly3 = new Fly(2, 4);

        System.out.println(Peepo.toString());
        Peepo.eat(Fly2);
        System.out.println(Fly2.toString());

        Peepo.grow(8);
        Peepo.eat(Fly2);
        System.out.println(Fly2.toString());
        System.out.println(Peepo.toString());

        System.out.println(Clyde.toString());

        Peepaw.grow(4);
        System.out.println(Peepaw.toString());
        System.out.println(Pepe.toString());

        //tests
        //Fly1.grow(19);
        //System.out.println(Fly1.toString());
        //System.out.println(Peepo.getSpecies());


    }
}
