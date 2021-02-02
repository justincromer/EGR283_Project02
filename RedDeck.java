//Project02: Uncle Wiggly Game
//Created by: Justin Cromer
//Date: 1-29-21
//
//A review of the Java Programming language. This program models a children's board
//	game based on drawing cards and moving squares. 

package edu.mtc.egr283.project02;

public class RedDeck extends Deck{

	public static final int TOTAL_CARDS = 9;
	
	public static final String DECK_NAME = "Red";
	
	
	public RedDeck() {
		
		super(RedDeck.DECK_NAME,RedDeck.TOTAL_CARDS);
		
		for(RedCard c : RedCard.values()) {
			
			this.setCard(c.getNumber(), c.getContents(), c.getAction());
			
		}//end of for loop
		
	}//end of constructor
	
}//end of class RedDeck
