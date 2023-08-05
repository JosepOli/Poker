package poker.poker.domain.model.factory;

import poker.poker.domain.model.Deck;
import poker.poker.domain.model.Game;
import poker.poker.domain.service.DealerService;

public class GameFactory {

	public Game createStandardGame(DeckFactory deckfactory) {
		DealerService dealerService = new DealerService();
		dealerService.shuffleDeck();
		Game game = new Game(dealerService);
		game.addPlayer(player);
		return game;
	}
}
