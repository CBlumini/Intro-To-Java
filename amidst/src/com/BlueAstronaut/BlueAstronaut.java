package com.BlueAstronaut;

import com.Crewmate.Crewmate;
import com.Player.Player;
import com.RedAstronaut.RedAstronaut;

import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate {

    private int numTasks;
    private int taskSpeed;
    public static final int DEFAULT_SUS_LEVEL = 15;
    public static final int DEFAULT_NUM_TASKS = 6;
    public static final int DEFAULT_TASK_SPEED = 10;

    /**
     * Main Constructor
     */
    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
        super(name, susLevel);
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }

    /**
     * Defaultier constructor
     */
    public BlueAstronaut(String name) {
        super(name, DEFAULT_SUS_LEVEL);
        this.numTasks = DEFAULT_NUM_TASKS;
        this.taskSpeed = DEFAULT_TASK_SPEED;
    }

    @Override
    public void emergencyMeeting() {
        if (!isFrozen()) {
            Player[] tempArr = getPlayers();
            Arrays.sort(tempArr);
            Player tempPlayer1 = tempArr[tempArr.length - 1];
            Player tempPlayer2 = tempArr[tempArr.length - 2];
            //need to set this up so it steps down if the imposter is the most sus, fine for now...
            if (tempPlayer1.compareTo(tempPlayer2) != 0) {
                /* since the array holds instances of the player class I should be able to use the getter and setter
                for each instance that I pull out of the array to retrieve data about that particular instance and change
                value for that particular instance even though I have placed the player in a temp arr. I am acting on the
                instance variable, not what is in the arr itself
                 */
                tempArr[tempArr.length - 1].setFrozen(true);
            }
        }
        gameOver();
    }


    @Override
    public void completeTask() {
        if (!isFrozen()) {
            if (taskSpeed > 20) {
                if (numTasks > 0) {
                    numTasks = -2;
                }
            } else {
                numTasks--;
            }
            if (numTasks <= 0) {
                numTasks = 0;
                System.out.println("I have completed all my tasks");
            }

        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Player) {
            BlueAstronaut player = (BlueAstronaut) o;
            return this.getName().equals(player.getName()) && this.isFrozen() == player.isFrozen() && this.getSusLevel() == player.getSusLevel()
                    && numTasks == player.getNumTasks() && taskSpeed == player.getTaskSpeed();
        }
        return false;
    }

    public int getNumTasks() {
        return numTasks;
    }

    public void setNumTasks(int numTasks) {
        this.numTasks = numTasks;
    }

    public int getTaskSpeed() {
        return taskSpeed;
    }

    public void setTaskSpeed(int taskSpeed) {
        this.taskSpeed = taskSpeed;
    }

    @Override
    public String toString() {
        String frozenString = isFrozen() ? "frozen" : "not frozen";
        if (getSusLevel() <= 15) {
            return "My name is " + getName() + ", and I have a suslevel of " + getSusLevel() + ". I am currently " +
                    frozenString + ". I have " + numTasks + " leftover.";
        } else {
            String output = "My name is " + getName() + ", and I have a suslevel of " + getSusLevel() + ". I am currently " +
                    frozenString + ". I have " + numTasks + " leftover.";
            return output.toUpperCase();
        }


    }
}


