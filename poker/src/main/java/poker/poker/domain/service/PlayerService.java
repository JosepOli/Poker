package poker.poker.domain.service;

import poker.poker.domain.model.Hand;
import poker.poker.domain.model.Player;

public class PlayerService {

	public Player createPlayer(String name, int balance) {
		return new Player(name, balance);
	}

	public void assignHand(Player player, Hand hand) {
		player.setHand(hand);
	}

}
