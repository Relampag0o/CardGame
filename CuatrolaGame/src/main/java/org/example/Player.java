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
