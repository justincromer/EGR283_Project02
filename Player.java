//Project02: Uncle Wiggly Game
//Created by: Justin Cromer
//Date: 1-29-21
//
//A review of the Java Programming language. This program models a children's board
//	game based on drawing cards and moving squares. 

package edu.mtc.egr283.project02;

public class Player {

	private String name, color;
	
	private int gameScore, currentSquare, lostTurnCount;
	
	
	public Player(String newName, String newColor) {
		this.setName(newName);
		this.setColor(newColor);
		this.setGameScore(0);
		this.setCurrentSquare(0);
		this.setLostTurnCount(0);
	}//end of constructor
	
	public String getName() {
		return this.name;
	}//end of method getName
	
	private void setName(String newName) {
		this.name = newName;
	}//end of method setName
	
	public String getColor() {
		return this.color;
	}//end of method getColor
	
	private void setColor(String newColor) {
		this.color = newColor;
	}//end of method setColor
	
	public int getGameScore() {
		return this.gameScore;
	}//end of method getGameScore
	
	public void setGameScore(int newGameScore) {
		this.gameScore = newGameScore;
	}//end of method setGameScore
	
	public int getCurrentSquare() {
		return this.currentSquare;
	}//end of method getCurrentSquare
	
	public void setCurrentSquare(int newSquare) {
		this.currentSquare = newSquare;
	}//end of method setCurrentSquare
	
	public int getLostTurnCount() {
		return this.lostTurnCount;
	}//end of method getLostTurnCount
	
	public void setLostTurnCount(int numberOfLostTurns) {
		this.lostTurnCount = numberOfLostTurns;
	}//end of method setLostTurnCount
	
}//end of class player
