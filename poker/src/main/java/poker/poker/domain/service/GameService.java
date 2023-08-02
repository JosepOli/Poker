package poker.poker.domain.service;

import poker.poker.domain.model.Card;
import poker.poker.domain.model.Hand;

public class GameService {

	public void dealCardToHand(Hand hand) {
		DealerService deckService = new DealerService();
		Card drawnCard = deckService.drawCard();
		hand.addCard(drawnCard);
	}
}
