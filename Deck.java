/**
 * Deck Class
 * Represents a deck of cards.
 * Manages a list of cards, and provides methods to interact with the deck.
 *
 * Lab 4 -- BlackJack Game
 * Author: Elijah Yakimyuk 
 * Course: CS& Computer Science & Java II
 * Instructor: Jeremiah Ramsey
 * Date: 07/17/2023
*/

import java.util.ArrayList;
import java.util.List;

class Deck { // Class Deck is like a deck of cards.

    // List of cards to represent a deck.
    private List<Card> deck;

    // Constructor initializes the deck with 52 cards of different suits and values.
    public Deck() {
        deck = new ArrayList<>();
        String[] suits = {" Spade ", " Heart ", "Diamond", " Clubs "};
        String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        // Nested loop to add all possible combinations of suits and values.
        for (String suit : suits) {
            for (String value : values) {
                deck.add(new Card(suit, value));
            }
        }
    }
    
    // Getter method for the deck list.
    public List<Card> getDeck() {
        return deck;
    }

    // Draw a card from the deck by removing the last card.
    public Card draw() {
        return deck.remove(deck.size() - 1);
    }

    // Check if the deck is empty.
    public boolean isEmpty() {
        return deck.isEmpty();
    }
}
