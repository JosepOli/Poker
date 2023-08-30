package poker.poker.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Hand {

	private int score;
	private Long id;
	private Player player;
	private List<Card> cards;

	public Hand() {
		cards = new ArrayList<>();
	}

	public void addCard(Card card) {
		cards.add(card);
	}

	public void removeCard(Card card) {
		cards.remove(card);
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setHand(List<Card> hand) {
		this.cards = hand;
	}

	public int getScore() {
		return score;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
