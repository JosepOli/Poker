package poker.poker.domain.service;

import java.util.List;

import poker.poker.domain.model.Card;
import poker.poker.domain.model.Hand;

public class HandService {

	public static final int ROYAL_FLUSH = 10;
	public static final int STRAIGHT_FLUSH = 9;
	public static final int FOUR_OF_A_KIND = 8;
	public static final int FULL_HOUSE = 7;
	public static final int FLUSH = 6;
	public static final int STRAIGHT = 5;
	public static final int THREE_OF_A_KIND = 4;
	public static final int TWO_PAIR = 3;
	public static final int PAIR = 2;
	public static final int HIGH_CARD = 1;

	public int evaluateHand(Hand hand) {
		sortHand(hand);
		if (isRoyalFlush(hand))
			return ROYAL_FLUSH;
		else if (isStraightFlush(hand))
			return STRAIGHT_FLUSH;
		else if (isFourOfAKind(hand))
			return FOUR_OF_A_KIND;
		else if (isFullHouse(hand))
			return FULL_HOUSE;
		else if (isFlush(hand))
			return FLUSH;
		else if (isStraight(hand))
			return STRAIGHT;
		else if (isThreeOfAKind(hand))
			return THREE_OF_A_KIND;
		else if (isTwoPair(hand))
			return TWO_PAIR;
		else if (isPair(hand))
			return PAIR;
		else
			return HIGH_CARD;
	}

	private boolean isRoyalFlush(Hand hand) {
		List<Card> cards = hand.getCards();

		if (!isValidHand(cards)) {
			return false;
		}

		// Verify the royal flush sequence
		int counterDecrementer = 14; // Ace value and going down
		for (Card card : cards) {
			if (card.getNumber() != counterDecrementer) {
				return false;
			}
			counterDecrementer--;
		}

		return isSameSuit(cards);
	}

	private boolean isStraightFlush(Hand hand) {
		List<Card> cards = hand.getCards();
		if (!isValidHand(cards)) {
			return false;
		}

		int expectedNumber = cards.get(0).getNumber(); // Expecting the highest number first

		for (Card card : cards) {
			if (card.getNumber() != expectedNumber) {
				return false;
			}
			expectedNumber--;
		}

		return isSameSuit(cards);

	}

	private boolean isFourOfAKind(Hand hand) {
		List<Card> cards = hand.getCards();
		if (!isValidHand(cards)) {
			return false;
		}

		int[] counts = new int[15];

		for (Card card : cards) {
			counts[card.getNumber()]++;
		}

		boolean hasFour = false;
		boolean hasOne = false;

		for (int count : counts) {
			if (count == 4) {
				hasFour = true;
			} else if (count == 1) {
				hasOne = true;
			}
		}

		return hasFour && hasOne;
	}

	private boolean isFullHouse(Hand hand) {
		List<Card> cards = hand.getCards();
		if (!isValidHand(cards)) {
			return false;
		}
		int[] counts = new int[15];

		for (Card card : cards) {
			counts[card.getNumber()]++;
		}

		boolean hasThree = false;
		boolean hasTwo = false;

		for (int count : counts) {
			if (count == 3) {
				hasThree = true;
			} else if (count == 2) {
				hasTwo = true;
			}
		}

		return hasThree && hasTwo;
	}

	private boolean isFlush(Hand hand) {
		List<Card> cards = hand.getCards();

		if (!isValidHand(cards)) {
			return false;
		}

		int suitOfFirstCard = cards.get(0).getSuit();

		// Verify if all 5 cards have the same suit property
		for (Card card : cards) {
			if (card.getSuit() != suitOfFirstCard) {
				return false;
			}
		}

		return true;
	}

	private boolean isStraight(Hand hand) {
		List<Card> cards = hand.getCards();
		if (!isValidHand(cards)) {
			return false;
		}
		int expectedNumber = cards.get(0).getNumber(); // Expecting the highest number first

		for (Card card : cards) {
			if (card.getNumber() != expectedNumber) {
				return false;
			}
			expectedNumber--;
		}

		return true;
	}

	private boolean isThreeOfAKind(Hand hand) {
		List<Card> cards = hand.getCards();
		if (!isValidHand(cards)) {
			return false;
		}

		int[] counts = new int[15];

		for (Card card : cards) {
			counts[card.getNumber()]++;
		}

		boolean hasThree = false;

		for (int count : counts) {
			if (count == 3) {
				hasThree = true;
			}
		}

		return hasThree;
	}

	private boolean isTwoPair(Hand hand) {
		List<Card> cards = hand.getCards();
		if (!isValidHand(cards)) {
			return false;
		}
		int[] counts = new int[15];

		for (Card card : cards) {
			counts[card.getNumber()]++;
		}
		boolean hasTwoPair = false;

		int pairs = 0;
		for (int count : counts) {
			if (count == 2) {
				pairs++;
			}
		}
		if (pairs == 2) {
			hasTwoPair = true;
		}

		return hasTwoPair;
	}

	private boolean isPair(Hand hand) {
		List<Card> cards = hand.getCards();
		if (!isValidHand(cards)) {
			return false;
		}

		int[] counts = new int[15];

		for (Card card : cards) {
			counts[card.getNumber()]++;
		}
		boolean hasPairOne = false;

		for (int count : counts) {
			if (count == 2) {
				return true;
			}
		}

		return hasPairOne;
	}

	private boolean isValidHand(List<Card> cards) {
		return cards != null && cards.size() == 5;
	}

	private boolean isSameSuit(List<Card> cards) {
		int suitOfFirstCard = cards.get(0).getSuit();
		for (Card card : cards) {
			if (card.getSuit() != suitOfFirstCard) {
				return false;
			}
		}
		return true;
	}

	public void sortHand(Hand hand) {
		List<Card> cards = hand.getCards();

		for (int i = 0; i < cards.size() - 1; i++) {
			for (int j = i + 1; j < cards.size(); j++) {
				if (cards.get(i).getNumber() < cards.get(j).getNumber()) {
					Card temp = cards.get(i);
					cards.set(i, cards.get(j));
					cards.set(j, temp);
				}
			}
		}
	}
}