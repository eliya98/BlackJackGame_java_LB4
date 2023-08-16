/**
 * Card Class
 * Represents a playing card in the deck.
 * Each card has a suit (like hearts, diamonds, clubs, spades) and a value (like 2, 3, 4...10,
 * J, Q, K, A). This class provides methods to access the card's suit and value.
 *
 * Lab 4 -- BlackJack Game
 * Author: Elijah Yakimyuk
 * Course: CS& Computer Science & Java II
 * Instructor: Jeremiah Ramsey
 * Date: 07/17/2023
 */

class Card {  // Class Card represents a playing card in the deck.

    String suit; // Each card has a suit (like hearts, diamonds, clubs, spades)

    String value; // Each card has a value (like 2, 3, 4...10, J, Q, K, A)

    // Constructor for the Card class, which initializes the suit and value.
    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }

    // Getter method for the suit of the card.
    public String getSuit() {
        return this.suit;
    }

    // Getter method for the value of the card.
    public String getValue() {
        return this.value;
    }
}
