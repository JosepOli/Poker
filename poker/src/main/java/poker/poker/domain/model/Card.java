package poker.poker.domain.model;

public class Card {

	private int suit;

	public final static int CLUBS = 1;
	public final static int DIAMONDS = 2;
	public final static int HEARTS = 3;
	public final static int SPADES = 4;

	private int number;

	//Constructor including validation that throws an IllegalArgumentException if values are not on range
	public Card(int suit, int number) {
		if (suit < CLUBS || suit > SPADES) {
			throw new IllegalArgumentException("Invalid suit value");
		}
		if (number < 2 || number > 14) {
			throw new IllegalArgumentException("Number must be between 2 and 14");
		}

		this.suit = suit;
		this.number = number;
	}

	public int getSuit() {
		return suit;
	}

	public int getNumber() {
		return number;
	}

}
