package poker.poker.domain.service;

import java.util.Collections;
import java.util.List;

import poker.poker.domain.model.Card;
import poker.poker.domain.model.Deck;
import poker.poker.domain.model.Hand;
import poker.poker.domain.model.Player;
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

	public void dealCardToHand(Hand hand) {
		Card drawnCard = drawCard();
		hand.addCard(drawnCard);
	}

	public void dealCardsToPlayers(List<Player> players) {
		for (Player player : players) {
			for (int i = 0; i < 5; i++) {
				dealCardToHand(player.getHand());
			}
		}
	}
}
