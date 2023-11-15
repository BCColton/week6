/*
 * @author Brian Colton
 */
package week6;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	// Data for the class
	List<Card> hand = new ArrayList<>(); // ArrayList representation of a hand of cards
	int score; // Used to track the score a player has accumulated
	String name; // String used as a "name" for the player instance other than the variable name of the instance
	
	// Constructor
	public Player (String name) {
		this.name = name;
		score = 0;
	}
	
	// Describe method prints the instances name, score, and iterates through the 
	// players hand and calls describe on each card.
	public void describe() {
		System.out.println(this.name + " has " + this.score + " point(s).");
		System.out.println(this.name + "'s hand is:");
		for(Card c: this.hand) { 
			c.describe();
		}
	}
	
	// Flip method returns the value returned bv the ArrayList method remove called on the hand of the player
	public Card flip() {
		return this.hand.remove(0);
	}
	
	// Draw adds the card value returned by the draw method called on a given deck to the player instances hand
	public void draw(Deck d) {
		this.hand.add(d.draw());
	}
	
	// Called when player scores a point to increase the players score.
	public void incrementScore() {
		this.score++;
	}
	
	
	
	
}
