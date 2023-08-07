package poker.poker.domain.model;

public class Card {

	private int suit;

	public final static int CLUBS = 1;
	public final static int DIAMONDS = 2;
	public final static int HEARTS = 3;
	public final static int SPADES = 4;

	private int number;

	// Constructor including validation that throws an IllegalArgumentException if
	// values are not on range
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

	public String getSuitAsString() {
		switch (this.suit) {
		case CLUBS:
			return "CLUBS";
		case DIAMONDS:
			return "DIAMONDS";
		case HEARTS:
			return "HEARTS";
		case SPADES:
			return "SPADES";
		default:
			return "UNKNOWN";
		}
	}

	public String getNumberAsString() {
		switch (this.number) {
		case 2:
			return "2";
		case 3:
			return "3";
		case 4:
			return "4";
		case 5:
			return "5";
		case 6:
			return "6";
		case 7:
			return "7";
		case 8:
			return "8";
		case 9:
			return "9";
		case 10:
			return "10";
		case 11:
			return "Jack";
		case 12:
			return "Queen";
		case 13:
			return "King";
		case 14:
			return "Ace";
		default:
			return "Unknown";
		}
	}

}
