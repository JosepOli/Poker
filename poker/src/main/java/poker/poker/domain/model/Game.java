package poker.poker.domain.model;

import java.util.ArrayList;
import java.util.List;

import poker.poker.domain.service.DealerService;

public class Game {
	private List<Player> players;
	private int currentBet;
	private int gameState;
	private Long id;

	public Game(DealerService dealerService2) {
		this.players = new ArrayList<>();
	}

	public int getCurrentBet() {
		return currentBet;
	}

	public void setCurrentBet(int currentBet) {
		this.currentBet = currentBet;
	}

	public int getGameState() {
		return gameState;
	}

	public void setGameState(int gameState) {
		this.gameState = gameState;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
