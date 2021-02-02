//Project02: Uncle Wiggly Game
//Created by: Justin Cromer
//Date: 1-29-21
//
//A review of the Java Programming language. This program models a children's board
//	game based on drawing cards and moving squares. 

package edu.mtc.egr283.project02;

public enum YellowCard {

	One (1, "Take a red card if you please. Hope you win this game with ease."),
	Two (2, "Uncle Wiggily moves ahead by one. He takes a walk and has some fun."),
	Three (3, "Uncle Wiggily hops forward by two. He moves right now and then he's through."),
	Four (4, "How near the finish will you be? When Uncle Wiggily hops ahead by three."),
	Five (5, "Uncle Wiggily hops along by four. Now he likes you even more."),
	Six (6, "He'd rather walk than take a drive. Uncle Wiggily jumps ahead by five."),
	Seven (7, "Move Uncle Wiggily forward by six. The clever rabbit knows all the tricks."),
	Eight (8, "Uncle Wiggily takes seven hops. He moves right now and then he stops."),
	Nine (9, "Hurry! Hurry! Don't be late! Move Uncle Wiggily ahead by eight."),
	Ten (10, "Uncle Wiggily hops ahead by nine. He thinks this game is really fine."),
	Eleven (11, "Hope you get this card again! Uncle Wiggily goes ahead by ten.");
	
	private int number;
	
	private String contents;
	
	
	private YellowCard(int newNumber, String newContents) {
		this.number = newNumber;
		this.contents = newContents;
	}//end of constructor
	
	public int getNumber() {
		return this.number;
	}//end of method getNumber
	
	public String getContents() {
		return this.contents;
	}//end of method getContents
	
	public int getAction() {
		return this.number - 1;
	}//end of method getAction
	
}//end of enum YellowCards
