package poker.poker.domain.service;

import java.util.Collections;

import poker.poker.domain.model.Card;
import poker.poker.domain.model.Deck;
import poker.poker.domain.model.factory.DeckFactory;

public class DealerService {

	private Deck deck;

	public DealerService() {
		DeckFactory deckFactory = new DeckFactory();
		deck = deckFactory.createStandardDeck();
	}

	public void shuffleDeck() {
		Collections.shuffle(deck.getCards());
	}

	public Card drawCard() {
		return deck.drawCard();
	}
}
