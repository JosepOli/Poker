package poker.poker.domain.service;

import poker.poker.domain.model.Hand;
import poker.poker.domain.model.Player;
import java.util.Random;

public class PlayerService {

	private String[] names = { "Albert Wilson", "Julio El Tutor", "Samuel Lightbringer", "Amador Heliocentrista",
			"Kevin El Espanol" };
	private Random random = new Random();

	public Player createPlayer(String name, int balance) {
		return new Player(name, balance);
	}

	public void assignHand(Player player, Hand hand) {
		player.setHand(hand);
	}

	public Player createIaPlayer() {
		String name = generateRandomName();
		int balance = generateRandomBalance();
		return new Player(name, balance);
	}

	private String generateRandomName() {
		int randomIndex = random.nextInt(names.length);
		return names[randomIndex];
	}

	private int generateRandomBalance() {
		// Generates a random balance between 100 and 5000
		return random.nextInt(5000 - 100 + 1) + 100;
	}

}
