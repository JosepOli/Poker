package poker.poker.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private List<Player> players;
	private Deck deck;
	private int currentBet;
	private int gameState;

	public Game(Deck deck) {
		this.players = new ArrayList<>();
		this.deck = deck;
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
