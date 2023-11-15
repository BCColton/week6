/*
 * @author Brian Colton
 */
package week6;

public class Card {
	
	// Data for the class
	private int value; // NOTE: Aces are high in this implementation so values go from 2 - 14
	private int suit; // 0 - Clubs; 1 - Diamonds; 2 - Hearts; 3 - Spades 
	private String name; // this.value of this.suit
	
	// Constructor for Card class, uses setter methods uses decideName() 
	// function to determine the value passed into setName()
	public Card(int v, int s) {
		setValue(v);
		setSuit(s);
		setName(decideName());
	}
	
	// Getters and setters
	public int getValue() {
		return this.value;
	}
	
	private void setValue(int value) {
		this.value = value;
	}
	
	public int getSuit() {
		return suit;
	}
	
	private void setSuit(int suit) {
		this.suit = suit;
	}
	
	public String getName() {
		return name;
	}
	
	private void setName(String name) {
		this.name = name;
	}
	// Getters and setters end
	
	// Describe method prints the name of the instance using the this keyword.
	public void describe() {
		System.out.println(this.name);
	}
	
	// Method used to construct the string value that will be stored in the name variable of the instance.
	// Uses the values assigned in the constructor to determine values.
	private String decideName() {
		String result = "";
		
		// Sets the value of result to the raw card value if the value isn't a face card.
		if (this.value < 11) {
			result += this.value;
		} else {
			// This determines what face card the value of the card represents.
			switch(this.value) { 
			
				case 11: result += "Jack";
				break;
				
				case 12: result += "Queen";
				break;
				
				case 13: result += "King";
				break;
				
				case 14: result += "Ace";
				break;
				
				default:
				break;
				
			}
		}
		
		result += " of ";
		
		// Switch statement to determine the suit of the card and concatenates value to result.
		// integer - String mapping below
		// 0 - Clubs; 1 - Diamonds; 2 - Hearts; 3 - Spades 
		switch(this.suit) {
		
			case 0: result += "Clubs";
			break;
			
			case 1: result += "Diamonds";
			break;
			
			case 2: result += "Hearts";
			break;
			
			case 3: result += "Spades";
			break;
			
			default:
			break;
		
		}
		
		return result;
	}
	
	
}