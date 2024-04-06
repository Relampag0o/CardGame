package org.example.cards;

public class Jack extends Card{

            public Jack(String suit){
                super(suit, 11);
            }

            @Override
            public String toString(){
                return "Jack of " + getSuit();
            }
}
