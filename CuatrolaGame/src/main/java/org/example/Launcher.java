package org.example;

import org.example.cards.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Launcher {
    public static void main(String[] args) {
        // 1. Create a deck of cards
        List<Card> deck = new ArrayList<>();
        String[] suits = {"oros", "copas", "espadas", "bastos"};
        for (String suit : suits) {
            deck.add(new Ace(suit));
            deck.add(new Three(suit));
            deck.add(new Ten(suit));
            deck.add(new Jack(suit));
            deck.add(new Queen(suit));
        }

        // 2. Shuffle the deck
        Collections.shuffle(deck);

        // Save the last card to determine the suit to play
        Card lastCard = deck.getLast();
        String suitToPlay = lastCard.getSuit();

        // 3. Create players
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            players.add(new Player());
        }

        // 4. Deal cards to players
        int playerIndex = 0;
        while (!deck.isEmpty()) {
            players.get(playerIndex).addCardToHand(deck.removeLast());
            playerIndex = (playerIndex + 1) % players.size();
        }

        // 5. Simulate the game
        // Each player shows their hand
        for (Player player : players) {
            System.out.println("Player's hand:");
            player.showHand();
            System.out.println();
        }

        // Print the suit to play
        System.out.println("The suit to play is: " + suitToPlay);
    }
}
