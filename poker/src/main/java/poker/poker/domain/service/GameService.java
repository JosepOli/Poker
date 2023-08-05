package poker.poker.domain.service;

import java.util.List;

import poker.poker.domain.model.Game;
import poker.poker.domain.model.Player;

public class GameService {

	HandService handService = new HandService();

	// Method to determine the winner
	public Player determineWinner(Game game) {
		int score;
		int highestScore = 0;
		Player winner = null;
		List<Player> players = game.getPlayers();
		for (Player player : players) {
			score = handService.evaluateHand(player.getHand());
			if (score > highestScore) {
				highestScore = score;
				winner = player;
			}
		}

		return winner;
	}

}
