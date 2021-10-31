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
    public Clinic(File file) {
        this.patientFile = file;
        //double health = this.getHealth();
    }


    //methods

    String nextday(File f) throws FileNotFoundException{
        return null;
    }

    String nextday(String fileName) throws FileNotFoundException {
        return null;
    }

    boolean addToFile(String patientInfo){
        return false;
    }

    String addTime(String timeIn, int treatmentTime){
        return null;
    }

}

