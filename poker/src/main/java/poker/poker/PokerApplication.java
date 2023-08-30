package poker.poker;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import poker.poker.domain.model.Card;
import poker.poker.domain.model.Game;
import poker.poker.domain.model.Hand;
import poker.poker.domain.model.Player;
import poker.poker.domain.model.factory.DeckFactory;
import poker.poker.domain.model.factory.GameFactory;
import poker.poker.domain.service.PlayerService;
import poker.poker.domain.service.HandService;
import poker.poker.domain.service.GameService;

@SpringBootApplication
public class PokerApplication {

	public static void main(String[] args) {
		// SpringApplication.run(PokerApplication.class, args);
		// Create necessary services and factories
		DeckFactory deckFactory = new DeckFactory();
		PlayerService playerService = new PlayerService();
		GameFactory gameFactory = new GameFactory();

		// Create a game with one human player and 3 IA players
		Game game = gameFactory.createStandardGame(deckFactory, playerService, 3);

		// Print player hands and cards
		for (Player player : game.getPlayers()) {
			System.out.println("Player: " + player.getName());
			Hand hand = player.getHand();
			List<Card> cards = hand.getCards();
			for (Card card : cards) {
				System.out.println(card.getNumberAsString() + " of " + card.getSuitAsString());
			}
		}

		// Evaluate hands and print scores
		HandService handService = new HandService();
		for (Player player : game.getPlayers()) {
			int score = handService.evaluateHand(player.getHand());
			System.out.println("Player: " + player.getName());
			System.out.println("Score: " + score);
		}

		// Determine winner and print winner
		GameService gameService = new GameService();
		Player winner = gameService.determineWinner(game);
		System.out.println("Winner: " + winner.getName());
	}

}
