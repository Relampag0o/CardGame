package org.example.cards;

public class Ace extends Card {

    public Ace(String suit){
        super(suit, 15);
    }

    @Override
    public String toString(){
        return "Ace of " + getSuit();
    }
}
