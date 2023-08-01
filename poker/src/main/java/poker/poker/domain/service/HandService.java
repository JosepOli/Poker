package poker.poker.domain.service;

import java.util.List;

import poker.poker.domain.model.Card;
import poker.poker.domain.model.Hand;

public class HandService {

	public int evaluateHand(Hand hand) {
		int score = 0;
		sortHand(hand);
		if (isRoyalFlush(hand))
			score = 10;
		if (isStraightFlush(hand))
			score = 9;
		if (isFourOfAKind(hand))
			score = 8;
		if (isFullHouse(hand))
			score = 7;
		if (isFlush(hand))
			score = 6;
		if (isStraight(hand))
			score = 5;
		if (isThreeOfAKind(hand))
			score = 4;
		if (isTwoPair(hand))
			score = 3;
		if (isPair(hand))
			score = 2;
		if (isHighCard(hand))
			score = 1;
		// TODO
		return score;
	}

	private boolean isRoyalFlush(Hand hand) {
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
		// Verify the royal flush sequence
		int counterDecrementer = 14; // Ace value and going down
		for (Card card : cards) {
			if (card.getNumber() != counterDecrementer) {
				return false;
			}
			counterDecrementer--;
		}

		return true;
	}

	private boolean isStraightFlush(Hand hand) {
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

		int expectedNumber = cards.get(0).getNumber(); // Expecting the highest number first

		for (Card card : cards) {
			if (card.getNumber() != expectedNumber) {
				return false;
			}
			expectedNumber--;
		}

		return true;

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
	}

	private boolean isThreeOfAKind(Hand hand) {
		List<Card> cards = hand.getCards();
	}

	private boolean isTwoPair(Hand hand) {
		List<Card> cards = hand.getCards();
	}

	private boolean isPair(Hand hand) {
		List<Card> cards = hand.getCards();
	}

	private boolean isHighCard(Hand hand) {
		List<Card> cards = hand.getCards();
	}

	private boolean isValidHand(List<Card> cards) {
		return cards != null && cards.size() == 5;
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