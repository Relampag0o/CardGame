package org.example;

import org.example.cards.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// This class is the entry point of the application
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

        // Create teams
        Team team1 = new Team(players.get(0), players.get(1));
        Team team2 = new Team(players.get(2), players.get(3));
        List<Team> teams = new ArrayList<>();
        teams.add(team1);
        teams.add(team2);

        // Play the game
        playGame(teams);
    }

    public static void playGame(List<Team> teams) {
        int round = 1;
        while (teams.get(0).getPoints() < 3 && teams.get(1).getPoints() < 3) {
            System.out.println("Round " + round + ":");
            String suitToPlay = playRound(teams);
            round++;
        }
        // Determine the winning team
        Team winningTeam = teams.get(0).getPoints() >= 3 ? teams.get(0) : teams.get(1);
        System.out.println("The winning team is: Team " + (teams.indexOf(winningTeam) + 1));
    }

    public static String playRound(List<Team> teams) {
        // Create a deck of cards
        List<Card> deck = new ArrayList<>();
        String[] suits = {"oros", "copas", "espadas", "bastos"};
        for (String suit : suits) {
            deck.add(new Ace(suit));
            deck.add(new Three(suit));
            deck.add(new Ten(suit));
            deck.add(new Jack(suit));
            deck.add(new Queen(suit));
        }

        // Shuffle the deck
        Collections.shuffle(deck);

        // Save the last card to determine the suit to play
        Card lastCard = deck.get(deck.size() - 1);
        String suitToPlay = lastCard.getSuit();
        System.out.println("The suit to play in this round is: " + suitToPlay);

        // Deal cards to players
        for (Team team : teams) {
            for (Player player : team.getPlayers()) {
                for (int i = 0; i < 5; i++) {
                    player.addCardToHand(deck.remove(deck.size() - 1));
                }
            }
        }

        // Play 5 cards
        for (int i = 0; i < 5; i++) {
            List<Card> cardsPlayed = new ArrayList<>();
            for (Team team : teams) {
                for (Player player : team.getPlayers()) {
                    Card playedCard = player.playCard(suitToPlay);
                    cardsPlayed.add(playedCard);
                    System.out.println("Player from Team " + (teams.indexOf(team) + 1) + " played: " + playedCard);
                }
            }
            // Determine which card  wins the round
            Card winningCard = cardsPlayed.get(0);
            Team winningTeam = teams.get(0);
            for (int j = 1; j < cardsPlayed.size(); j++) {
                Card card = cardsPlayed.get(j);
                if (card.getSuit().equals(suitToPlay) && card.getValue() > winningCard.getValue()) {
                    winningCard = card;
                    winningTeam = teams.get(j / 2); // Each team has 2 players
                }
            }
            // Update points of the winning team
            winningTeam.addPoint();
            System.out.println("The winning card is: " + winningCard);
            System.out.println("The winning team of this round is: Team " + (teams.indexOf(winningTeam) + 1));
        }

        // Clear players' hands before the next round
        for (Team team : teams) {
            for (Player player : team.getPlayers()) {
                player.clearHand();
            }
        }

        return suitToPlay;
    }
}