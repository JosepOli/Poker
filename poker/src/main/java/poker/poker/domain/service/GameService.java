package poker.poker.domain.service;

import poker.poker.domain.model.Card;
import poker.poker.domain.model.Hand;

public class GameService {

	public void dealCardToHand(Hand hand) {
		DeckService deckService = new DeckService();
		Card drawnCard = deckService.drawCard();
		hand.addCard(drawnCard);
	}
}
