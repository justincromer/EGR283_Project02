//Project02: Uncle Wiggly Game
//Created by: Justin Cromer
//Date: 1-29-21
//
//A review of the Java Programming language. This program models a children's board
//	game based on drawing cards and moving squares. 

package edu.mtc.egr283.project02;

public class Card {

	private int number, action;
	
	private String rhyme;
	
	
	public Card(int newNumber, String newRhyme, int newAction) {
		this.setNumber(newNumber);
		this.setRhyme(newRhyme);
		this.setAction(newAction);
	}//end of constructor
	
	public int getNumber() {
		return this.number;
	}//end of method getNumber
	
	private void setNumber(int newNumber) {
		this.number = newNumber;
	}//end of method setNumber
	
	public int getAction() {
		return this.action;
	}//end of method getAction
	
	private void setAction(int newAction) {
		this.action = newAction;
	}//end of method setAction
	
	public String getRhyme() {
		return this.rhyme;
	}//end of method getRhyme
	
	private void setRhyme(String newRhyme) {
		this.rhyme = newRhyme;
	}//end of method setRhyme	
	
}//end of class Card
