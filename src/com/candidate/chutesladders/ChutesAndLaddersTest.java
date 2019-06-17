package com.candidate.chutesladders;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the ChutesAndLadders Test class used for testing the business logic of the game.
 *
 * @author Shiva Prasad Gaddameedi
 * @version 1.0
 * @since 05/14/2019
 */

public class ChutesAndLaddersTest {

    /**
     * This is the main method which simulates the ChutesAndLadders for 3 plays.
     * You can also make it run for N players by adding additional players to listOfPlayers list.
     *
     * @param args
     */
    public static void main(String args[]){

        //You can add N number of players here
        List<ChutesAndLadders> listOfPlayers = new ArrayList<ChutesAndLadders>();
        listOfPlayers.add(new ChutesAndLadders("Shiva"));
        listOfPlayers.add(new ChutesAndLadders("Eric"));
        listOfPlayers.add(new ChutesAndLadders("Paul"));

        int gameTurn = 0;
        int spinnerValue = 0;

        //Finding out who plays first based of each player spinner value.
        for(int i=0;i<listOfPlayers.size();i++){
            int currentPlayerSpinnerValue = listOfPlayers.get(i).spinTheSpinner();
            if(currentPlayerSpinnerValue > spinnerValue){
                gameTurn = i;
            }
        }


        int numOfPlayers = listOfPlayers.size();

        //Play until someone win
        while(true){
            listOfPlayers.get(gameTurn).play();
            if(listOfPlayers.get(gameTurn).isWin()){
                System.out.println("\nThe Winner is "+listOfPlayers.get(gameTurn).getPlayerName());
                break;
            }
            gameTurn++;
            if(gameTurn == numOfPlayers){
                gameTurn = 0;
            }
        }
    }
}
