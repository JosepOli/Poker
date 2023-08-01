package poker.poker.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Deck {
	private List<Card> cards;

	// Deck generator for the four suits and the card values from 2-14, where 14
	// would be the ace
	public Deck() {
		cards = new ArrayList<>();
		for (int suit = Card.CLUBS; suit <= Card.SPADES; suit++) {
			for (int number = 2; number <= 14; number++) {
				cards.add(new Card(suit, number));
			}
		}
	}

	public List<Card> getCards() {
		return cards;
	}

	public Card drawCard() {
		return cards.remove(0);
	}
}
