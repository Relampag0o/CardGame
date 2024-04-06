package org.example.cards;

// THIS IS THE SUPERCLASS FOR EACH CARD!
public class Card {
    private String suit; // this is the "palo" of the card
    private int value; // this is the number of the card


    // Constructor
    public Card(String suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    // GETTERS AND SETTERS:
    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit='" + suit + '\'' +
                ", value=" + value +
                '}';
    }
}
