package poker.poker.domain.service;

import java.util.List;
import java.util.ArrayList;

import poker.poker.domain.model.Game;
import poker.poker.domain.model.Hand;
import poker.poker.domain.model.Player;

public class GameService {

	HandService handService = new HandService();

	// Method to determine the winner
	public Player determineWinner(Game game) {
		int highestScore = 0;
		Player winner = null;
		int tieCount = 0;
		List<Player> players = game.getPlayers();
		List<Player> playersTied = new ArrayList<>();
		for (Player player : players) {

			Hand hand = handService.evaluateHand(player.getHand());
			int score = hand.getScore();
			if (score > highestScore) {
				highestScore = score;
				winner = player;
				tieCount = 1;
				playersTied.clear(); // Clear the list of tied players
				playersTied.add(player); // Add the current player as they have the highest score for now
			} else if (score == highestScore) {
				tieCount++;
				playersTied.add(player);
			}

		}

		if (tieCount > 1) {
			winner = handService.tieBreak(playersTied);

		}

		return winner;
	}

}
