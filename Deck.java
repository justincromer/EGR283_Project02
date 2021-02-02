//Project02: Uncle Wiggly Game
//Created by: Justin Cromer
//Date: 1-29-21
//
//A review of the Java Programming language. This program models a children's board
//	game based on drawing cards and moving squares. 

package edu.mtc.egr283.project02;

import java.util.Random;

public class Deck {

	private int totalCards, numberOfCardsRemaining;
	
	private String name;
	
	private Random randomizer;
	
	private Card[] cards;
	
	
	public Deck(String newName, int newTotalNumberOfCards) {
		this.setName(newName);
		this.setTotalCards(newTotalNumberOfCards);
		this.setCardsRemaining();
		this.randomizer = new Random();
		this.cards = new Card[this.getTotalCards()];
	}//end of constructor
	
	public String getName() {
		return this.name;
	}//end of method getName
	
	private void setName(String newName) {
		this.name = newName;
	}//end of method setName
	
	public int getTotalCards() {
		return this.totalCards;
	}//end of method getTotalCards
	
	private void setTotalCards(int newTotalNumberOfCards) {
		this.totalCards = newTotalNumberOfCards;
	}//end of method setTotalCards
	
	public int getCardsRemaining() {
		return this.numberOfCardsRemaining;
	}//end of method getCardsRemaining
	
	private void setCardsRemaining() {
		this.numberOfCardsRemaining = this.getTotalCards();
	}//end of method setCardsRemaining

	
	protected void setCard(int cardNumber, String cardContents, int cardAction) {
		this.cards[cardNumber - 1] = new Card(cardNumber, cardContents, cardAction);
	}//end of method setCardAt
	
	public Card drawCard() {
		
		//algorithm to randomly select a card, store it as a temporary card, then null 
		//	the selected card out so it cannot be used again without creating a new deck
		Card rv = null;
		
		int index = -1;
		
		do {
			index = this.randomizer.nextInt(this.totalCards);
			rv = this.cards[index];
		} while(rv == null);

		--this.numberOfCardsRemaining;
		
		this.cards[index] = null;
		
		return rv;
	}//end of method drawCard
	
	
}//end of class Deck
