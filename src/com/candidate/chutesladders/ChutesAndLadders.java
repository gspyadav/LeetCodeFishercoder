package com.candidate.chutesladders;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 * This is the implementation of classic children's game "Chutes And Ladders".
 * All the details of Chutes and Ladders are taken from the given requirements documents.
 *
 * @author Shiva Prasad Gaddameedi
 * @version 1.0
 * @since 05/14/2019
 */
public class ChutesAndLadders {

    final static int WINNINGPOIINT = 100;
    static int playCount = 1;
    final static Map<Integer,Integer> CHUTE = new HashMap<Integer,Integer>();
    final static Map<Integer,Integer> LADDER = new HashMap<Integer,Integer>();
    {
        //Define all chutes here in format <TOP_OF_CHUTE, BOTTOM_OF_CHUTE>
        CHUTE.put(16,6);
        CHUTE.put(47,26);
        CHUTE.put(49,11);
        CHUTE.put(56,53);
        CHUTE.put(62,19);
        CHUTE.put(64,60);
        CHUTE.put(93,73);
        CHUTE.put(95,75);
        CHUTE.put(98,78);

        //Define all ladders here in the format <BOTTOM_OF_LADDER, TOP_OF_LADDER>
        LADDER.put(1,38);
        LADDER.put(4,14);
        LADDER.put(9,31);
        LADDER.put(21,42);
        LADDER.put(28,84);
        LADDER.put(36,43);
        LADDER.put(51,67);
        LADDER.put(71,91);
        LADDER.put(80,100);
    }

    private int currentPosition;
    private String playerName;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    ChutesAndLadders(String name){
        this.currentPosition = 0;
        this.playerName = name;
    }

    /**
     * This method is called when when each players get their turn to play
     */
    public void play(){
        calculateNewPosition(spinTheSpinner());
    }

    /**
     * The Spinner will return random value between [1,6] inclusive.
     *
     * @return random integer [1,6]
     */
    public int spinTheSpinner(){
        return (new Random()).nextInt(6)+1;
    }

    /**
     * Calculated the new position of current player based on his/her spinner value
     * if there is any CHUTE or LADDER it calculates the position value accordingly
     *
     * @param spinnerValue
     */
    private void calculateNewPosition(int spinnerValue){
        int newPosition = currentPosition +spinnerValue;
        System.out.print("\n"+playCount++ +": "+playerName+": "+currentPosition+" --> ");
        //If the new position is > WINPOINT 100 then don't change change the current position
        if(newPosition > WINNINGPOIINT){
            System.out.print(currentPosition);
            return;
        }

        //If there is chute / ladder at new position change the new position accordingly
        if(CHUTE.containsKey(newPosition)){
            System.out.print(newPosition+" --CHUTE--> ");
            newPosition = CHUTE.get(newPosition);
        }
        if(LADDER.containsKey(newPosition)){
            System.out.print(newPosition+" --LADDER--> ");
            newPosition = LADDER.get(newPosition);
        }

        //Assign new position to current position
        System.out.print(newPosition);
        currentPosition = newPosition;
    }

    /**
     * Returns true if the current player reached the Winning point position, else return false.
     *
     * @return true/false
     */
    public boolean isWin(){
        return WINNINGPOIINT == currentPosition;
    }

    //TODO: Create a method for returning the [x,y] co-ordinates based on current position value of current player.
    //This method will be useful for creating the UI

    //TODO: Create getter methods for Ladders and Chutes Maps. This methods will be used to display methods for Ladders in UI.


}
