package poker.poker.domain.model;

public class Player {

	private String name;
	private int balance;

	private Hand hand;

	public Player(String name, int balance) {
		this.name = name;
		this.balance = balance;
		this.hand = new Hand();
	}

	public String getName() {
		return name;
	}

	public int getBalance() {
		return balance;
	}

}
