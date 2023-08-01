package poker.poker.domain.model.factory;

import poker.poker.domain.model.Deck;
import poker.poker.domain.model.Game;

public class GameFactory {

	public Game createStandardGame() {
		DeckFactory deckFactory = new DeckFactory();
		Deck deck = deckFactory.createStandardDeck();

		Game game = new Game(deck);
		return game;
	}
}
