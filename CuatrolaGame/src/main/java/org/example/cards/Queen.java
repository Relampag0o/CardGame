package org.example.cards;

public class Queen extends Card {
    public Queen(String suit){
        super(suit, 12);
    }

    @Override
    public String toString(){
        return "Queen of " + getSuit();
    }
}
