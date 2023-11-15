/*
 * @author Brian Colton
 */

//Imports are handled in their respective classes.

package week6;

public class App {

	// Clean main method that runs the warGame method is to make modification easier in the future.
	public static void main(String[] args) {
	
		warGame(); // Method call runs code for our War simulation
			
	}
	
	// Holds our main game-play loop, instantiated objects and variables, and prints out to the console
	// any information that might be useful to someone running the simulation.
	public static void warGame() {
		
		//Object variables declared and instantiated
		Deck theDeck = new Deck();
		Player PlayerOne = new Player("PlayerOne"); // Player names have been chosen for
		Player PlayerTwo = new Player("PlayerTwo"); // the sake of simplicity
		
		// Deck shuffled twice to ensure a somewhat well shuffled deck.
		theDeck.shuffle();
		theDeck.shuffle();		
		
		// Used a while loop to deal cards until the deck is empty.
		while (!theDeck.cards.isEmpty()) {
			PlayerOne.draw(theDeck);
			PlayerTwo.draw(theDeck);
		}
		
		// Round tracker added for QoL and bug tracking.
		int round = 0;
		
		// While loop is used to allow for easier future modification.
		while (!PlayerOne.hand.isEmpty() && !PlayerTwo.hand.isEmpty()) {
			System.out.println("Round: " + ++round);
			System.out.print("Player One plays the ");
			PlayerOne.hand.get(0).describe();
			System.out.print("Player Two plays the ");
			PlayerTwo.hand.get(0).describe();
			int difference = PlayerOne.flip().getValue() - PlayerTwo.flip().getValue();
			
			// Logic used to determine 
			if (difference > 0) { 
				//PlayerOne has high card
				PlayerOne.incrementScore();
				System.out.println("Player One has scored a point.");
			} else if (difference < 0) {
				//PlayerTwo has high card
				PlayerTwo.incrementScore();
				System.out.println("Player Two has scored a point.");
			} else {
				System.out.println("Tie! No points awarded.");
			}
			
			System.out.println(); // Lone println statement used as a spacer.
		}
		
		// Logic that determines the winner by comparing the values of the players.
		if (PlayerOne.score > PlayerTwo.score) {
			System.out.println("Player One wins with a score of: " + PlayerOne.score + " points");
		} else if (PlayerOne.score < PlayerTwo.score) {
			System.out.println("Player Two wins with a score of: " + PlayerTwo.score + " points");
		} else {
			System.out.println("Draw!");
		}
	
	}

}	