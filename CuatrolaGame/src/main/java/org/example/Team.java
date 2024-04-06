package org.example;


import java.util.ArrayList;
import java.util.List;

public class Team {
    private List<Player> players;
    private int points;

    public Team(Player player1, Player player2) {
        this.players = new ArrayList<>();
        this.players.add(player1);
        this.players.add(player2);
        this.points = 0;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getPoints() {
        return points;
    }

    public void addPoint() {
        this.points++;
    }
}
