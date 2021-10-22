package com.Clinic;

import com.Cat.Cat;
import com.Dog.Dog;
import com.Pet.Pet;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Clinic {

    //instance variables
    File patientFile;
    int day;

    //constructors
    public Clinic (File file) {
        this.patientFile = file;
        //double health = this.getHealth();
    }

    Clinic (String fileName) {

    }


    //Dog steve = new Dog("Steve", 1.2, 2);


}

