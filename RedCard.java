//Project02: Uncle Wiggly Game
//Created by: Justin Cromer
//Date: 1-29-21
//
//A review of the Java Programming language. This program models a children's board
//	game based on drawing cards and moving squares. 

package edu.mtc.egr283.project02;

public enum RedCard {

	One (1, "We really hope you won't feel blue. But Uncle Wiggily must go back two.", -2),
	Two (2, "Uncle Wiggily must jump back three. It's not the best place for him to be.", -3),
	Three (3, "Uncle Wiggily must hop back four. Hope this won't happen any more.", -4),
	Four (4, "Uncle Wiggily must go back five. Nobody knows when he will arrive.", -5),
	Five (5, "Hurry! Hurry! Don't be late! Move Uncle Wiggily ahead by eight.", 8),
	Six (6, "Uncle Wiggily hops ahead by nine. He thinks this game is really fine.", 9),
	Seven (7, "Hope you get this card again! Uncle Wiggily goes ahead by ten.", 10),
	Eight (8, "A card this good is not often seen. Move Uncle Wiggily ahead by thirteen!", 13),
	Nine (9, "Uncle Wiggily hops ahead by fifteen. You're one of the best he's ever seen!", 15);

	private int number, action;
	
	private String contents;
	
	
	private RedCard(int newNumber, String newContents, int newAction) {
		this.number = newNumber;
		this.contents = newContents;
		this.action = newAction;
	}//end of constructor
	
	public int getNumber() {
		return this.number;
	}//end of method getNumber
	
	public String getContents() {
		return this.contents;
	}//end of method getContents
	
	public int getAction() {
		return this.action;
	}//end of method getAction
	
}//end of enum RedCards
