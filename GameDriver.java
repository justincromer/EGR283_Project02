//Project02: Uncle Wiggly Game
//Created by: Justin Cromer
//Date: 1-29-21
//
//A review of the Java Programming language. This program models a children's board
//	game based on drawing cards and moving squares. 


package edu.mtc.egr283.project02;

import java.util.Scanner;

public class GameDriver {
	
	private static final int STANDARD_TOURNAMENT = 10;
	
	public static void main(String[] args) {
		
		
		//open scanner object
		Scanner kb = new Scanner(System.in);;
		
		//create the game
		Game uncleWiggly = new Game(kb);

		//play the game until someone wins a 10 game tournament
		do {
			
			uncleWiggly.playTheGame();
			
		//check for winner - USE NO-ARGS VERSION OF THIS METHOD TO PLAY A SINGLE GAME
		}while(uncleWiggly.isTournamentStillGoing(STANDARD_TOURNAMENT));
		
		
		//close scanner object
		kb.close();
		
	}//end of method main
	
}//end of class GameDriver
