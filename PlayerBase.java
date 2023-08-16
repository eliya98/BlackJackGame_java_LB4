/*
  PlayerBase class 
  This class establishes the common characters that are shared between a player and a dealer

 * Lab 4 -- BlackJack Game
 * Author: Elijah Yakimyuk 
 * Course: CS& Computer Science & Java II
 * Instructor: Jeremiah Ramsey
 * Date: 07/17/2023
*/

import java.util.ArrayList;

// PlayerBase class represents the common characteristics of a player and dealer.
class PlayerBase {
    
    // A list to hold the cards in hand.
    ArrayList<Card> hand;

    // Constructor initializes the hand.
    public PlayerBase() {
        hand = new ArrayList<>();
    }
    // Draw a card from the deck and add to hand.
    public void draw(Deck deck) {
        hand.add(deck.draw());
    }

    // Calculate the value of cards in hand considering the special rules of Blackjack.
    public int getHandValue() {
        int value = 0; // Total value of hand
        int aceCount = 0; // Track aces (which can be 1 or 11)

        // Iterate through cards in hand.
        for (Card card : hand) {
            String cardValue = card.getValue();

            // Ace is worth 11 initially.
            if (cardValue.equals("A")) {
                value += 11;
                aceCount++;
            } // Face cards are worth 10.
            else if (cardValue.equals("K") ||
                     cardValue.equals("Q") ||
                     cardValue.equals("J")) {
                value += 10;
            } // Number cards are worth their face value.
            else {
                value += Integer.parseInt(cardValue);
            }
        }
        // Adjust value for aces if total value is over 21.
        while (value > 21 && aceCount > 0) {
            value -= 10; // Count aces as 1 instead of 11.
            aceCount--;
        }
        return value; // Return total value of hand.
    } // end of getHandValue 

    // Print the cards in hand, hide first card if it's dealer's hand.
    public void showHand(boolean isDealer) {
        
        System.out.println("Cards:");

        for (Card card : hand) {

            // Hide the first card if this is the dealer.
            if (isDealer && hand.indexOf(card) == 0) {
                System.out.println("[hidden]");
            } // Otherwise, show the card.
            else {
                System.out.println(card.getValue() + " of " + card.getSuit());
            }
        }
    }
}
