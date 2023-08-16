/*
  Player Class extended player base
  This class, inherits the playerbase class and establishes the special charcterists of the player
  Scanner takes user input to hit or stand on card deck

 * Lab 4 -- BlackJack Game
 * Author: Elijah Yakimyuk 
 * Course: CS& Computer Science & Java II
 * Instructor: Jeremiah Ramsey
 * Date: 07/17/2023
*/

import java.util.Scanner;

// Player class extends the PlayerBase class.
// This class handles the user input for the playable character.
class Player extends PlayerBase {
    
    // Declare Scanner for user input.
    Scanner input;

    // The playable character's constructor.
    public Player() {
        // Call the parent constructor.
        super();
        // Initialize the Scanner object.
        input = new Scanner(System.in);
    }

    // Method for the player to decide their next move.
    public boolean decide() {

        // Continuously ask the player for their decision until a valid input is given.
        while (true) {
            System.out.println("Do you want to hit or stand? (enter 'hit' or 'stand')");

            // Convert user input to lower case for comparison.
            String decision = input.nextLine().toLowerCase();

            // If user inputs 'hit', return true to indicate they want another card.
            if (decision.equals("hit")) {
                return true;
            } // If user inputs 'stand', return false to indicate they don't want another card.
            else if (decision.equals("stand")) {
                return false;
            } // If the user input is neither 'hit' nor 'stand', prompt them to input again.
            else {
                System.out.println("Invalid input. Please enter 'hit' or 'stand'.");
            }
        }
    }
}
