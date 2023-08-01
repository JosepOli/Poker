package poker.poker.domain.model.factory;

import poker.poker.domain.model.Card;
import poker.poker.domain.model.Deck;

public class DeckFactory {

	// Deck constructor for the four suits and the card values from 2-14, where 14
	// would be the ace
	public Deck createStandardDeck() {
		Deck deck = new Deck();
		for (int suit = Card.CLUBS; suit <= Card.SPADES; suit++) {
			for (int number = 2; number <= 14; number++) {
				deck.addCard(new Card(suit, number));
			}
		}
		return deck;
	}
}
