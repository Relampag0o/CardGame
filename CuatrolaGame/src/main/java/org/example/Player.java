package org.example;

import org.example.cards.Card;

import java.util.ArrayList;
import java.util.List;

// The class Player is a simple class that has a list of cards that represent the player's hand.
public class Player {
    private List<Card> hand;

    public Player() {
        this.hand = new ArrayList<>();
    }

    public void addCardToHand(Card card) {
        this.hand.add(card);
    }

    public Card playCard(String suitToPlay) {
        for (Card card : hand) {
            if (card.getSuit().equals(suitToPlay)) {
                hand.remove(card);
                return card;
            }
        }
        // If no card of the suit to play, play any card
        Card card = hand.get(0);
        hand.remove(0);
        return card;
    }

    public List<Card> getHand() {
        return this.hand;
    }

    public void clearHand() {
        this.hand.clear();
    }

    public void showHand() {
        for (Card card : hand) {
            System.out.println(card);
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "hand=" + hand +
                '}';
    }
}
