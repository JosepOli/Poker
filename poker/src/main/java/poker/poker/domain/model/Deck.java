package poker.poker.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Deck {
	private List<Card> cards;
	private Long id;

	public Deck() {
		cards = new ArrayList<>();
	}

	public void addCard(Card card) {
		cards.add(card);
	}

	public List<Card> getCards() {
		return cards;
	}

	public Card drawCard() {
		return cards.remove(0);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
