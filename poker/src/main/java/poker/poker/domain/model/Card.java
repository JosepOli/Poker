package poker.poker.domain.model;

public class Card {
	
	private int suit;
	
	private int number;
	
	final int CLUBS = 1;
	final int DIAMONDS = 2;
	final int HEARTS = 3;
	final int SPADES = 4;
	
	public Card(int suit, int number) {
		if(suit < CLUBS || suit > SPADES) {
			
		}
	}
	

}
