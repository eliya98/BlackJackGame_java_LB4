/**
 * Game Class
 * Represents a game of Blackjack.
 * Manages interactions between the deck, player, and dealer.
 *
 * Lab 4 -- BlackJack Game
 * Author: Elijah Yakimyuk 
 * Course: CS& Computer Science & Java II
 * Instructor: Jeremiah Ramsey
 * Date: 07/17/2023
 */

import java.util.Collections;
import java.util.List;

class Game {
    // Declare necessary variables for the Game class.
    // Includes the deck of cards, and the player and dealer.
    Deck deck;
    Player player;
    Dealer dealer;

    // Constructor to initialize the game with a deck, player, and dealer.
    public Game() {
        deck = new Deck();
        player = new Player();
        dealer = new Dealer();
    }
    
    // Method to play a round of the game.
    public void playRound() {
        // Shuffle the deck before dealing cards.
        Collections.shuffle(deck.getDeck());

        // Deal two cards each to the player and dealer.
        player.draw(deck);
        player.draw(deck);
        dealer.draw(deck);
        dealer.draw(deck);
        
        // Print player's hand.
        System.out.println("\nPlayer's hand: ");
        printHandSideBySide(player.hand, false);
        
        // Print dealer's hand, hiding the second card.
        System.out.println("\nDealer's hand:");
        printHandSideBySide(dealer.hand.subList(0, 2), true);
        
        // Player's turn - continue drawing cards while they decide to.
        while (player.decide()) {
            player.draw(deck);
            System.out.println("\nPlayer's hand:");
            printHandSideBySide(player.hand, false);

            // If player's hand value exceeds 21, player busts and dealer wins.
            if (player.getHandValue() > 21) {
                System.out.println("\nPlayer busts! *** Dealer wins! ***");
                printHandSideBySide(dealer.hand, false);
                return;
            }
        }

        // Dealer's turn - continue drawing cards while they decide to.
        while (dealer.decide()) {
            dealer.draw(deck);
            System.out.println("\nDealer's hand:");
            printHandSideBySide(dealer.hand.subList(0, 2), true);
            
            // If dealer's hand value exceeds 21, dealer busts and player wins.
            if (dealer.getHandValue() > 21) {
                System.out.println("\nDealer busts! *** Player wins! ***");
                printHandSideBySide(dealer.hand, false);
                return;
            }
        }
        // Calculate and print player's and dealer's hand values.
        int playerValue = player.getHandValue();
        int dealerValue = dealer.getHandValue();
        System.out.println("\nPlayer's hand value: " + playerValue);
        System.out.println("Dealer's hand value: " + dealerValue);

        // Determine the winner based on hand values.
        if (playerValue > dealerValue) {
            System.out.println("\n *** Player wins! ***");
        } else if (playerValue < dealerValue) {
            System.out.println("\n *** Dealer wins! ***");
        } else {
            System.out.println("\n *** It's a tie! ***");
        }
    }

    // Method to get space characters for card alignment.
    public String getSpacing(int count) {
        return " ".repeat(count);
    }

    // Method to print the hand of cards side by side, 
    public void printHandSideBySide(List<Card> hand, boolean hideCard) {

        // Card template to display
        String[] parts = new String[]{
            "┌─────────┐",
            "│ %1$4s    │", // value
            "│         │",
            "│         │",
            "│         │",
            "│         │",
            "│ %2$7s │", // suit
            "└─────────┘"
        };
    
        // hide a card (used for dealer's second card).
        String[] hiddenCardParts = new String[]{
            "┌─────────┐",
            "│ H****** │",
            "│ *I***** │",
            "│ **D**** │",
            "│ ***D*** │",
            "│ ****E** │",
            "│ *****N* │",
            "└─────────┘"
        };
    
        // Iterate through parts and print either visible or hidden card as appropriate.
        for (int i = 0; i < parts.length; i++) {

            for (int j = 0; j < hand.size(); j++) {

                if (hideCard && j == 1) { // second card of dealer's hand
                    System.out.print(hiddenCardParts[i] + "   ");
                } else {
                    String value = hand.get(j).getValue();
                    String suit = hand.get(j).getSuit();
                    System.out.printf(parts[i] + "   ", value, suit);
                }
            }
            System.out.println();
        }
    } // end of print side-by-side
} // end of game class
