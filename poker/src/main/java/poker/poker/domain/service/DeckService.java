package poker.poker.domain.service;

import java.util.Collections;

import poker.poker.domain.model.Card;
import poker.poker.domain.model.Deck;

public class DeckService {

	private Deck deck;

	public DeckService() {
		deck = new Deck();
	}

	public void shuffleDeck() {
		Collections.shuffle(deck.getCards());
	}

	public Card drawCard() {
		return deck.drawCard();
	}
}
