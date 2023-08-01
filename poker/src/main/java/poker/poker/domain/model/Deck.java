package poker.poker.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Deck {
	private List<Card> cards;

	public Deck() {
		cards = new ArrayList<>();
		for (int suit = Card.CLUBS; suit <= Card.SPADES; suit++) {
			for (int number = 2; number <= 14; number++) {
				cards.add(new Card(suit, number));
			}
		}
	}
}
