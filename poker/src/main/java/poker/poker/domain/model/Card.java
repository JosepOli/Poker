package poker.poker.domain.model;

public class Card {

	private int suit;

	private int number;

	final int CLUBS = 1;
	final int DIAMONDS = 2;
	final int HEARTS = 3;
	final int SPADES = 4;

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

}
