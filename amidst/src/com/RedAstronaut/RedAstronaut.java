package com.RedAstronaut;
import com.BlueAstronaut.BlueAstronaut;
import com.Impostor.Impostor;
import com.Player.Player;

import java.util.Arrays;
//import java.lang.*;

/*Notes
https://www.javatpoint.com/downcasting-with-instanceof-operator
https://www.javatpoint.com/this-keyword
https://www.tutorialspoint.com/java/lang/class_isassignablefrom.htm
https://stackoverflow.com/questions/7749052/private-methods-over-public-methods
https://stackoverflow.com/questions/2559527/non-static-variable-cannot-be-referenced-from-a-static-context
https://stackoverflow.com/questions/40480/is-java-pass-by-reference-or-pass-by-value
https://stackoverflow.com/questions/37323933/how-do-i-share-methods-with-instance-variables-in-a-superclass
https://stackoverflow.com/questions/10165887/how-to-check-if-an-object-implements-an-interface
https://stackoverflow.com/questions/33598691/how-to-use-tostring-and-getter-and-setter-methods
 */

public class RedAstronaut extends Player implements Impostor
{

    // instance variable
    private String skill;
    public static final int DEFAULT_SUS_LEVEL = 15;
    public static final String DEFAULT_SKILL = "experienced";

    //Main Constructor
    public RedAstronaut(String name, int susLevel, String skill){
        super(name, susLevel);
        this.skill = skill;
    }

    //default constructor
    public RedAstronaut(String name){
        super(name, DEFAULT_SUS_LEVEL);
        this.skill = DEFAULT_SKILL;
    }

    //*****************Methods***************

    //String test;

    /**need to check the player is frozen and keep them from even calling this? How? Bad problem statemet?
     * Using an if statement seems to prevent compile since method is not decalred
    */
    //need to sort the players array and then select the highest suslevel
    //need to validate that it is not the person calling the meeting
    //set the voted off play to frozen using the frozen setter
    @Override
    public void emergencyMeeting () {
        if (!isFrozen()){
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

    /**Freezes the player fed into the method if they meet the correct criteria
     * 1: check if player fed in is frozen
     * 2: check if player fed in is an imposter by seeing it is implements the imposter interface
     * 3: check if the instance calling the method is less sus then the player being fed in
     * 3a: freeze if this instance is less then the suslevel fed in. Can we use compare to? How to have compareTo act on this instce
     * https://www.javatpoint.com/this-keyword
     * 3
     * @param p the player to potentially be frozen
     */
    @Override
    public void freeze(Player p) {
        if (!p.isFrozen()) {
            if (p instanceof Impostor) {
            } else {
                //Player[] tempArr = getPlayers();
                int redAstroSus = getSusLevel();
                int tempSusDelta = this.compareTo(p); //does this work?
                if (tempSusDelta <0) {
                    p.setFrozen(true);
                } else {
                    setSusLevel(redAstroSus*2);
                }
            }
        }
        gameOver();
    }

    @Override
    public void sabotage(Player p) {
        //int impSus = getSusLevel();
        if (!p.isFrozen() || !this.isFrozen()) {
            if (p instanceof Impostor) {
            } else if (this.getSusLevel() < 20) {
                p.setSusLevel((int) (p.getSusLevel() * 1.5));
            } else {
                p.setSusLevel((int) (p.getSusLevel() * 1.25));
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Player) {
            RedAstronaut player = (RedAstronaut) o;
            return this.getName().equals(player.getName()) && this.isFrozen() == player.isFrozen()
                    && this.getSusLevel() == player.getSusLevel() && skill.equals(player.getSkill());
        }
        return false;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        String frozenString = isFrozen() ? "frozen" : "not frozen";
        if (getSusLevel() <= 15) {
            return "My name is " + getName() + ", and I have a suslevel of " + getSusLevel() + ". I am currently " +
                    frozenString + ". I am a " + skill + " player!";
        } else {
            String output = "My name is " + getName() + ", and I have a suslevel of " + getSusLevel() + ". I am currently " +
                    frozenString + ". I am a " + skill + " player!";
            return output.toUpperCase();
        }
    }

/*
"My name is [name], and I have a suslevel of [susLevel]. I am currently (frozen / not frozen). I am an [skill] player!”
 */

}
