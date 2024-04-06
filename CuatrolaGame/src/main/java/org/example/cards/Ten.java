package org.example.cards;

public class Ten extends Card{

        public Ten(String suit){
            super(suit, 10);
        }

        @Override
        public String toString(){
            return "Ten of " + getSuit();
        }
}
