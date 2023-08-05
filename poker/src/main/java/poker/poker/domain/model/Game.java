package poker.poker.domain.model;

import java.util.ArrayList;
import java.util.List;

import poker.poker.domain.service.DealerService;

public class Game {
	private List<Player> players;
	private DealerService dealerService;
	private int currentBet;
	private int gameState;

	public Game(DealerService dealerService2) {
		this.players = new ArrayList<>();
		this.dealerService = dealerService;
	}

	public void addPlayer(Player player) {
		players.add(player);
	}

	public void removePlayer(Player player) {
		players.remove(player);
	}

	public List<Player> getPlayers() {
		return players;
	}
}
