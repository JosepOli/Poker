package poker.poker.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Hand {

	int score;

	private List<Card> hand;

	 public Hand(Deck deck, int numberOfCards) {
	        hand = new ArrayList<>();
	        for (int i = 0; i < numberOfCards; i++) {
	            addCard(deck.drawCard());
	        }
	    }

	public void addCard(Card card) {
		hand.add(card);
	}

	public void removeCard(Card card) {
		hand.remove(card);
	}

	public List<Card> getCards() {
		return hand;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}

}
