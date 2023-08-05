package poker.poker.domain.model.factory;

import poker.poker.domain.model.Game;
import poker.poker.domain.model.Player;
import poker.poker.domain.service.DealerService;
import poker.poker.domain.service.PlayerService;

public class GameFactory {

	public Game createStandardGame(DeckFactory deckfactory, PlayerService playerService, int numIaPlayers) {
		DealerService dealerService = new DealerService();
		dealerService.shuffleDeck();
		Game game = new Game(dealerService);

		addPlayersToGame(game, playerService, numIaPlayers);

		// Deal cards to all players
		dealerService.dealCardsToPlayers(game.getPlayers());

		return game;
	}

	private void addPlayersToGame(Game game, PlayerService playerService, int numIaPlayers) {
		// Create and add the human player
		Player humanPlayer = playerService.createPlayer("Player", 5000);
		game.addPlayer(humanPlayer);

		// Create and add the IA players
		for (int i = 0; i < numIaPlayers; i++) {
			Player iaPlayer = playerService.createIaPlayer();
			game.addPlayer(iaPlayer);
		}
	}
}
