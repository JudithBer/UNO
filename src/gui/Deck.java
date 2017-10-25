package src.gui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	ArrayList<Card> deck = new ArrayList<Card>();
	Colour col;
	Value val;

	public Deck() {

	}

	public void create() {
		for (int i = 0; i < 5; i++) {
			switch (i) {
			case 0:
				col = Colour.RED;
				break;
			case 1:
				col = Colour.BLUE;
				break;
			case 2:
				col = Colour.GREEN;
				break;
			case 3:
				col = Colour.YELLOW;
				break;
			case 4:
				col = Colour.BLACK;
				break;
			}
			if (i < 4) {
				for (int j = 0; j < 25; j++) {
					switch (j) {
					case 0:
						val = Value.ZERO;
						break;
					case 1:
					case 2:
						val = Value.ONE;
						break;
					case 3:
					case 4:
						val = Value.TWO;
						break;
					case 5:
					case 6:
						val = Value.THREE;
						break;
					case 7:
					case 8:
						val = Value.FOUR;
						break;
					case 9:
					case 10:
						val = Value.FIVE;
						break;
					case 11:
					case 12:
						val = Value.SIX;
						break;
					case 13:
					case 14:
						val = Value.SEVEN;
						break;
					case 15:
					case 16:
						val = Value.EIGHT;
						break;
					case 17:
					case 18:
						val = Value.NINE;
						break;
					case 19:
					case 20:
						val = Value.PLUS2;
						break;
					case 21:
					case 22:
						val = Value.ROTATE;
						break;
					case 23:
					case 24:
						val = Value.SKIP;
						break;
					}
					deck.add(new Card(col, val));
				}
			} else {
				for (int j = 25; j < 33; j++) {
					switch (j) {
					case 25:
					case 26:
					case 27:
					case 28:
						val = Value.REQUEST;
						break;
					case 29:
					case 30:
					case 31:
					case 32:
						val = Value.REQUEST4;
						break;
					}
					deck.add(new Card(col, val));
				}
			}
		}
	}

	public void shuffle() {
		Collections.shuffle(deck);
	}

	public Card getFirstCard() {
		if (this.getDeck().isEmpty()) {
			return null;
		} else {
			return this.getDeck().get(0);
		}
	}

	public void removeFirstCard() {
		if (this.getDeck().isEmpty()) {
			System.out.println("Es gibt keine Karten mehr im Ziehstapel.");
		} else {
			this.getDeck().remove(0);
		}
	}

	public List<Card> getDeck() {
		return deck;
	}

	@Override
	public String toString() {
		for (Card card : deck) {
			System.out.println(card.toString());
		}
		return "Größe des Decks" + deck.size();
	}
}
