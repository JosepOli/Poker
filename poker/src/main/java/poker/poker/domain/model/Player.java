package poker.poker.domain.model;

public class Player {

	private Long id;
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

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
