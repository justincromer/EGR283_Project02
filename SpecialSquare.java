//Project02: Uncle Wiggly Game
//Created by: Justin Cromer
//Date: 1-29-21
//
//A review of the Java Programming language. This program models a children's board
//	game based on drawing cards and moving squares. 

package edu.mtc.egr283.project02;

public enum SpecialSquare {

	NINE(9, -1, "Skillery Skallery Alligator, Lose 1 turn."), 
	SEVENTEEN(17, 100, "Cluck Cluck Chicken House, go to space 100."), 
	TWENTYTHREE(23, 13, "Rabbit Hole, go back to space 13."), 
	TWENTYEIGHT(28, 50, "Bow Wow Dog House, go to space 50."),
	THIRTYNINE(39, -1, "Woods, Lose 1 turn."),
	FIFTYTWO(52, 13, "Rabbit Hole, go back to space 13."),
	SIXTYFOUR(64, 100, "Cluck Cluck Chicken House, go to space 100."),
	SIXTYSEVEN(67, -2, "The Bad Pipsisewah - Lose 2 turns."),
	SEVENTYSIX(76, 60, "Wibble Wobble Duck Pond, go to space 60."),
	SEVENTYNINE(79, -2, "Fox Den, Lose 2 turns"),
	NINETYFOUR(94, 35, "5 & 10 Cent Store, go to space 35"),
	ONEOHONE(101, -2, "Trap, Lose 2 turns."),
	ONETEN(110, -1, "Skeezicks, Lose 1 turn."),
	ONEONEFIVE(115, -1, "Woods, Lose 1 turn."),
	ONETWOONE(121, 75, "Bushytail Squirrel Tree, go to space 75"),
	ONETHREEONE(131, -2, "Trap, Lose 2 turns."),
	ONETHREEEIGHT(138, 35, "5 & 10 Cent Store, go to space 35"),
	ONEFOURONE(141, -2, "Fox Den, Lose 2 turns.");
	
	private int squareNumber, actionNumber;
	
	private String story;
	
	
	private SpecialSquare(int newSquareNumber, int newActionNumber, String newStory) {
		this.squareNumber = newSquareNumber;
		this.actionNumber = newActionNumber;
		this.story = newStory;
	}//end of constructor
	
	public int getSquareNumber() {
		return this.squareNumber;
	}//end of method getSquareNumber
	
	public int getActionNumber() {
		return this.actionNumber;
	}//end of method getActionNumber
	
	public String getStory() {
		return this.story;
	}//end of method getStory
	
}//end of enum SpecialSquares
