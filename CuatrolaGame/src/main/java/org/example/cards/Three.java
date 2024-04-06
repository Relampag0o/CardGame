package org.example.cards;

public class Three extends Card{

        public Three(String suit){
            super(suit, 3);
        }

        @Override
        public String toString(){
            return "Three of " + getSuit();
        }
}
