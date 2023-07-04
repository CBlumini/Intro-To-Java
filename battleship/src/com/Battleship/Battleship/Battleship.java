package com.Battleship.Battleship;

import java.util.*;
//import java.util.Arrays;
class Battleship {
    public static void main(String[] args) {
        System.out.println("Welcome to Battleship!");
        Scanner input = new Scanner(System.in);


        //declar vars
        int coordX;
        int coordY;
        //int coordX2=0;
        //int coordY2=0;

        //int test;
        int[] arrP1X = {5, 5, 5, 5, 5};
        int[] arrP1Y = {5, 5, 5, 5, 5};
        int[] arrP2X = {5, 5, 5, 5, 5};
        int[] arrP2Y = {5, 5, 5, 5, 5};
        char[][] shipArr1 = {{'-','-','-','-','-'},
                {'-','-','-','-','-'},
                {'-','-','-','-','-'},
                {'-','-','-','-','-'},
                {'-','-','-','-','-'},};
        char[][] shipArr2 = {{'-','-','-','-','-'},
                {'-','-','-','-','-'},
                {'-','-','-','-','-'},
                {'-','-','-','-','-'},
                {'-','-','-','-','-'},};
        char[][] shotArr1 = {{'-','-','-','-','-'},
                {'-','-','-','-','-'},
                {'-','-','-','-','-'},
                {'-','-','-','-','-'},
                {'-','-','-','-','-'},};
        char[][] shotArr2 = {{'-','-','-','-','-'},
                {'-','-','-','-','-'},
                {'-','-','-','-','-'},
                {'-','-','-','-','-'},
                {'-','-','-','-','-'},};


        //prompt for value
        System.out.println("PLAYER 1, ENTER YOUR SHIPS’ COORDINATES.");


        int xCounter = 0;
        int yCounter = 0;
        int shipCounter =1;




        while (yCounter<5){

            System.out.println("Enter ship " + shipCounter + " location:");

            if(input.hasNextInt() && input.hasNextInt()) {
                coordX = input.nextInt()-1;
                coordY = input.nextInt()-1;

//this only partially works. If the number is in the array of fails, it's not smart enought to take into account location
                //should create a method to populate a 5x2 array with all the ships
                //then create another method to check calling each row of the 5x2 array and checking the two values agains the respective values that were just entered
                if (reuseCheck(arrP1X, coordX) && reuseCheck(arrP1Y, coordY)){
                    System.out.println("You already have a ship there. Choose different coordinates.");
                    input.nextLine();
                    //continue;
                } else{
                    arrP1X[xCounter] = coordX;
                    arrP1Y[yCounter] = coordY;
                    xCounter++;
                    yCounter++;
                    shipCounter++;
                }
                ////System.out.print(yCounter);
            } else{
                System.out.println("Invalid coordinates. Choose different coordinates.");
                input.nextLine();
                //continue;
            }
        }


//print 100 lines
        for(int i=0; i<100; i++)
            System.out.println();

        //prompt for value
        System.out.println("PLAYER 2, ENTER YOUR SHIPS’ COORDINATES.");



        xCounter = 0;
        yCounter = 0;
        coordX=0;
        coordY=0;
        shipCounter =1;

        while (yCounter<5){

            System.out.println("Enter ship " + shipCounter + " location:");

            if(input.hasNextInt() && input.hasNextInt()) {
                coordX = input.nextInt()-1;
                coordY = input.nextInt()-1;

                if (reuseCheck(arrP2X, coordX) && reuseCheck(arrP2Y, coordY)){
                    System.out.println("You already have a ship there. Choose different coordinates.");
                    input.nextLine();
                    continue;
                } else{
                    arrP2X[xCounter] = coordX;
                    arrP2Y[yCounter] = coordY;
                    xCounter++;
                    yCounter++;
                    shipCounter++;
                }
                ////System.out.print(yCounter);
            }
            else{
                System.out.print("Invalid coordinates. Choose different coordinates.");
                break;
            }
        }


//cobine the arrays

        int[][] arrP1 = {arrP1X, arrP1Y};
        int[][] arrP2 = {arrP2X, arrP2Y};

        System.out.println(Arrays.deepToString(arrP1));

        assignPlayer(shipArr1, arrP1);
        assignPlayer(shipArr2, arrP2);

        printBattleShip(shipArr1);
        printBattleShip(shipArr2);


    } //<<<<<<<<<********************* end of main method

    // Use this method to print game boards to the console.
    private static void printBattleShip(char[][] player) {
        System.out.print("  ");
        for (int row = -1; row < 5; row++) {
            if (row > -1) {
                System.out.print(row + " ");
            }
            for (int column = 0; column < 5; column++) {
                if (row == -1) {
                    System.out.print(column + " ");
                } else {
                    System.out.print(player[row][column] + " ");
                }
            }
            System.out.println("");

        }
    }

    //use this method to assign to the main boards
    private static void assignPlayer(char[][] shipsGrid, int[][] locations){
        //use location arrary to assign the targets to the ship grid array
        shipsGrid[locations[0][0]][locations[1][0]]='@';
        shipsGrid[locations[0][1]][locations[1][1]]='@';
        shipsGrid[locations[0][2]][locations[1][2]]='@';
        shipsGrid[locations[0][3]][locations[1][3]]='@';
        shipsGrid[locations[0][4]][locations[1][4]]='@';
    }

    //use this method to check if a spot was reused during entry
    private static boolean reuseCheck(int[] arr, int toCheckValue){
        // check if the specified element
        // is present in the array or not
        // using Linear Search method
        boolean test = false;
        for (int element : arr) {
            if (element == toCheckValue) {
                test = true;
                break;
            }
        }
        return test;
    }

    //create a method to see if shots were placed in the same place twice


} //<<<<<<********************end of main class


//public static void fillArrUser(int[] arrX[], int[] arrY[], int[][] arr1) {

//}









//maybe create an update array method?
//do the math and print
//test = coordX1+coordY1;
//System.out.print("Answer: " + test);

//    System.out.print("made it");
/*
  for (int row = 0; row < arrP1.length; row++) {
        int colCounter = 0;
        int rowCounter = 0;
    for (int col = 0; col < arrP1[0].length; col++) {

     arrP1[row][col] = arrP1X[rowCounter];
     arrP1[row][col] = arrP1Y[rowCounter];


    }
          rowCounter++;
          System.out.println(rowCounter);
  }
*/

//System.out.print(arrP1);
//System.out.println(Arrays.deepToString(arrP1));
//System.out.println(Arrays.deepToString(arrP2));
//System.out.println(Arrays.toString(arrP1Y));



//return arr1;

/*

public class Main {
  public static void main(String[] args) {
    int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };
    for (int i = 0; i < myNumbers.length; ++i) {
      for(int j = 0; j < myNumbers[i].length; ++j) {
        System.out.println(myNumbers[i][j]);
      }
    }
  }
}*/

//int[] activeBoard1;
//String[][] activeBoard1;

//Arrays.fill(activeBoard1, 2);