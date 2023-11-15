/*
 * @author Brian Colton
 */
package week6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

	// ArrayList<> implementation of our list of cards used for familiarity
	List<Card> cards = new ArrayList<>();
	
	// 52 cards initialized in constructor
	// i value represents card value, j value represents card suit
	public Deck() {
		for (int i = 2; i <= 14; i++) {
			for (int j = 0; j <=3; j++) {
				cards.add(new Card(i,j));
			}
		}
	}
	
	// Implementation of a Fisher-Yates shuffle algorithm
	public void shuffle() {
		Random rand = new Random();
		for(int i = this.cards.size() - 1; i > 0; i--) {
			int j = rand.nextInt(0, i);
			Card temp = cards.get(i);
			cards.set(i, cards.get(j));
			cards.set(j, temp);
		}
	}
	
	// draw method simply returns the value returned by the ArrayList remove method
	public Card draw() {
		return cards.remove(0);
	}
	
}