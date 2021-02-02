//Project02: Uncle Wiggly Game
//Created by: Justin Cromer
//Date: 1-29-21
//
//A review of the Java Programming language. This program models a children's board
//	game based on drawing cards and moving squares. 

package edu.mtc.egr283.project02;

public class YellowDeck extends Deck {
	
	public static final int TOTAL_CARDS = 11;
	
	public static final String DECK_NAME = "Yellow";
	
	
	public YellowDeck() {
		
		super(YellowDeck.DECK_NAME, YellowDeck.TOTAL_CARDS);
		
		for(YellowCard c : YellowCard.values()) {
			
			this.setCard(c.getNumber(), c.getContents(), c.getAction());
			
		}//end of for loop
		
	}//end of  constructor

}//end of class YellowDeck
