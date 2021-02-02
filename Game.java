//Project02: Uncle Wiggly Game
//Created by: Justin Cromer
//Date: 1-29-21
//
//A review of the Java Programming language. This program models a children's board
//	game based on drawing cards and moving squares. 

package edu.mtc.egr283.project02;

import java.util.Scanner;

public class Game {
	
	private Card currentCard;
	
	private Player[] players;
	
	private int numberOfPlayers;
	
	private boolean isNoWinner;
	
	public static final int WINNING_SQUARE = 151;
	public static final int STARTING_SQUARE = 0;
	
	
	public Game(Scanner kb) {
		
		//set up the game
		System.out.println("Uncle Wiggly Game");
		System.out.println();
		System.out.println("How many players? [1-4]");
		
		this.numberOfPlayers = kb.nextInt();
		
		this.players = new Player[numberOfPlayers];
		
		//get player names, assign colored bunny
		for(int i = 1; i <= this.numberOfPlayers; ++i) {
			
			System.out.println("What is player " + i + "'s name?");
			
			this.players[i-1] = new Player(kb.next().toUpperCase(), 
					this.assignColor(i));
		}//end of for loop
		
	
		System.out.println();
		
	}//end of constructor
	
	
	public void playTheGame() {
		
		//shuffle the decks for each game
		YellowDeck yellowDeck = new YellowDeck();
		
		RedDeck redDeck = new RedDeck();
		
		//reset starting positions & lost turn penalties
		for(Player p : this.players) {
			p.setCurrentSquare(Game.STARTING_SQUARE);
			p.setLostTurnCount(0);
		}//end of for loop
		
		//loop the game until someone wins
		do {
			
			//flag to control do-while loop
			this.isNoWinner = true;
			
			//each player draws a card
			for(int i = 0; i < this.players.length; ++i) {
				System.out.println();
				System.out.println();
				
				//check to see if player has any penalty
				if(this.players[i].getLostTurnCount() > 0) {
					
					System.out.println("Skipped " + this.players[i].getName() + "'s turn.");
					
					//reduce lost turn count by 1
					this.players[i].setLostTurnCount(this.players[i].getLostTurnCount() - 1);
					
					//display lost turn count
					System.out.println(this.players[i].getLostTurnCount() + " lost turns"
							+ " remaining.");
					
					//go to next player
					continue;
				}//end of if lost turn
				
				
				System.out.println(this.players[i].getName() + " draws a "
						+ "card from the yellow deck.");
				
				
				//build a new yellow deck if all yellow cards have been used
				if(yellowDeck.getCardsRemaining() == 0) {
					yellowDeck = new YellowDeck();
				}//end of if
				
				//draw a yellow card and show it
				this.currentCard = yellowDeck.drawCard();
		
				System.out.println("The card reads: \n");
				System.out.println("\t" + this.currentCard.getRhyme());
				
				//all yellow cards except the one at index 0 require the player to move
				//	forward
				if(this.currentCard.getAction() > 0) {
					
					this.players[i].setCurrentSquare(this.players[i].getCurrentSquare()
							+ this.currentCard.getAction());
					
					System.out.println("\t\t" + this.players[i].getName() + " moves the "
							+ this.players[i].getColor() + " bunny to square "
							+ this.players[i].getCurrentSquare());
					
				//yellow at index 0 asks you to draw a red card
				}else {
					//build a new red deck if all red cards have been used
					if(redDeck.getCardsRemaining() == 0) {
						redDeck = new RedDeck();
					}//end of if
					
					//draw a red card and show it
					this.currentCard = redDeck.drawCard();
					
					System.out.println();
					System.out.println(this.players[i].getName() + " draws a card from"
							+ " the red deck.");
					System.out.println("The card reads: \n");
					System.out.println("\t" + currentCard.getRhyme());
					
					//some red cards require backwards movement, so first check to see
					//	if player can even move backwards
					if((this.players[i].getCurrentSquare() + this.currentCard.getAction()) > 0) {
						
						//the players new square is the total of the old square plus the action
						this.players[i].setCurrentSquare(this.players[i].getCurrentSquare() 
								+ this.currentCard.getAction());
						
						//display the movement
						System.out.println("\t\t" + this.players[i].getName() + " moves the " 
								+ this.players[i].getColor() + " bunny to square " 
								+ this.players[i].getCurrentSquare());
						
					}else {
						
						//if players action would result in a negative square, don't move
						System.out.println(this.players[i].getColor() + " bunny remains on "
								+ "square " + this.players[i].getCurrentSquare());
						
					}//end of INNER if-else
					
				}//end of OUTER if-else
				
				
				//after drawing cards, check to see if landed on special square
				this.checkForSpecialSquare(this.players[i]);
				
				//check to see if player won the game and score appropriately 
				if(this.players[i].getCurrentSquare() >= Game.WINNING_SQUARE) {
					
					this.isNoWinner = false;
					
					this.players[i].setGameScore(this.players[i].getGameScore() + 1);
					
					System.out.println("\n\n \t\t" + this.players[i].getName() + " wins this "
							+ "game. \n\n");
					
					//display game score
					this.showScore();
					break;
					
				}//end of if
				
			}//end of for loop
	
		}while(isNoWinner);
		
	}//end of method playTheGame

	
	//method to assign players pieces 
	private String assignColor(int numberOfPlayers) {
		String rv = null;
		
		switch(numberOfPlayers) {
			case 1:
				rv = "Blue";
				break;
			case 2: 
				rv = "Red";
				break;
			case 3:
				rv = "Yellow";
				break;
			default:
				rv = "Green";
		}//end of switch
		
		return rv;
	}//end of method assignColor
	
	
	private void checkForSpecialSquare(Player p) {
		
		//check to see if currentSquare is special
		for(SpecialSquare s : SpecialSquare.values()) {
			
			if(p.getCurrentSquare() == s.getSquareNumber()) {
				
				System.out.println();
				System.out.print("\t\t******  ");
				System.out.print(s.getStory());
				System.out.println("  ******\n");
				
				if(s.getActionNumber()>0) {
					
					//if action > 0, it is the new square number
					p.setCurrentSquare(s.getActionNumber());
					
				}else {
					
					//if action < 0, then it is a lost turn count
					p.setLostTurnCount(Math.abs(s.getActionNumber()));
					
				}//end of if-else do action
				break;
				
			}//end if landed on a special square
			
		}//end of for loop
		
	}//end of method checkForSpecialSquares
	
	
	//score board method for total games
	private void showScore() {
		
		for(int i = 0; i < 100; ++i) {
			System.out.print("^~");
		}//end of for loop
		
		System.out.println();
		
		for(Player p : this.players) {
			
			System.out.println("\t" + p.getName() + " and the " + p.getColor() 
			+ " bunny have a score of " + p.getGameScore());
			
		}//end of for loop
		
		System.out.println();
		
	}//end of method showScore
	
	//overloaded version, method for non-tournament play
	public boolean isTournamentStillGoing() {
		return this.isTournamentStillGoing(1);
	}//end of no-args version method isTournamentStillGoing
	
	
	//flag for tournament loop in main method
	public boolean isTournamentStillGoing(int tournamentSize) {
		
		boolean rv = true;
		
		for(Player p : players) {
			
			if(p.getGameScore() == tournamentSize) {
				
				rv = false;
				
				System.out.println(p.getName() + " and the " + p.getColor() + " bunny...");
				
				System.out.println("\t\t\t WIN THE TOURNAMENT!!!");
				
				break;
				
			}//end of if
			
		}//end of for loop
		
		return rv;
		
	}//end of method isTournamentStillGoing
	
}//end of class Game
