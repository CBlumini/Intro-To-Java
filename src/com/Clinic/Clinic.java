package com.Clinic;


import com.Cat.Cat;
import com.Dog.Dog;
import com.InvalidPetException.InvalidPetException;
import com.Pet.Pet;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;


//https://stackoverflow.com/questions/37758566/when-to-use-a-string-with-filename-or-file-as-argument-to-constructor

public class Clinic{

    //***********************instance variables*****************
    File patientFile;
    int day;
    Scanner fileScan = null;
    private Object InvalidPetException;

    //*************************constructors*********************
    public Clinic(File file) {
        this.patientFile = file;
        //double health = this.getHealth();
    }

    public Clinic (String filename) {
        this(new File(filename));
    }


    //**********************methods********************
    public String nextDay(File f) throws FileNotFoundException{
        //setup the variables
        String[] tokens = null;
        String[] petNames = new String[100];
        Object[] petTypes = new Object[100];
        int[] uniqueAtt = new int[100];
        int[] times = new int[100];
        int index = 0;
        //setup a try block to make sure the read is handled
        try {
            fileScan = new Scanner(f);
            String line = null;
            //loop through the file to read the data
            while (fileScan.hasNextLine()) {
                line = fileScan.nextLine();
                tokens = line.split(",");
                petNames[index] = tokens[0];
                petTypes[index] = tokens[1];
                uniqueAtt[index] = Integer.parseInt(tokens[2]);
                times[index] = Integer.parseInt(tokens[3]);
                index++;
            }
            //do some stuff with the data
            //may need to make this loop
            int j = 0;
            System.out.println("Consultation for " + petNames[j] + " the " + petTypes[j] + " at " + times[j] +".\nWhat is the health of " + petNames[j] + "?\n");
            if (petTypes[j] instanceof Cat | petTypes[j] instanceof Dog) {
                throw (Throwable) InvalidPetException;
            }
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        finally {
            return null;
        }
    }


    /**
     * Takes in a string with the file name and reads the files
     * @param fileName
     * @return
     * @throws FileNotFoundException
     */
    public String nextDay(String fileName) throws FileNotFoundException {
        //setup the variables
        File fileIn = new File(fileName);
        String[] tokens = null;
        String[] petNames = new String[100];
        Object[] petTypes = new Object[100];
        int[] uniqueAtt = new int[100];
        int[] times = new int[100];
        int index = 0;

        //setup a try block to make sure the read is handled
        try {
            fileScan = new Scanner(fileIn);
            String line = null;
            //loop through the file to read the data
            while (fileScan.hasNextLine()) {
                line = fileScan.nextLine();
                tokens = line.split(",");
                petNames[index] = tokens[0];
                //may need to read this as strings
                petTypes[index] = tokens[1];
                uniqueAtt[index] = Integer.parseInt(tokens[2]);
                times[index] = Integer.parseInt(tokens[3]);
                index++;
            }

            //do some stuff with the data
            //may need to make this loop
            int j = 0;
            System.out.println("Consultation for " + petNames[j] + " the " + petTypes[j] + " at " + times[j] +".\nWhat is the health of " + petNames[j] + "?\n");
            if (petTypes[j] instanceof Cat | petTypes[j] instanceof Dog) {
                throw (Throwable) InvalidPetException;
            }

        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        finally {
            return null;
        }
    }

    public boolean addToFile(String patientInfo){
        return false;
    }

    String addTime(String timeIn, int treatmentTime){
        return null;
    }

}

