package org.example.cards;

public class Ace extends Card {

    public Ace(String suit){
        super(suit, 14);
    }

    @Override
    public String toString(){
        return "Ace of " + getSuit();
    }
}
