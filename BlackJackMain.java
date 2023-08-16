/*
 * Lab 4 -- BlackJack Game
 * Author: Elijah Yakimyuk 
 * Course: CS& Computer Science & Java II
 * Instructor: Jeremiah Ramsey
 * Date: 07/17/2023
 *
  This program is a digital implementation of the classic card game, Black Jack, also known as "21"
  The purpose of the program is to create an interactive gaming experience, where the user can play
  Black Jack against a computer-controlled dealer.
*/

import java.util.Scanner;

// Class BlackJackMain is the entry point of the application.
public class BlackJackMain {
    public static void main(String[] args) {

        // Create a new Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        String userChoice;

        do { // Game loop
            // Create and play a new game
            Game game = new Game();
            game.playRound();

            // Ask the user if they want to play again
            System.out.println("\n Would you like to play another round? (yes/no)");

            // Get the user's choice
            userChoice = scanner.nextLine().toLowerCase();
            
            // Loop while the user's choice is neither 'yes' nor 'no'
            while (!userChoice.equals("yes") && !userChoice.equals("no")) {
                System.out.println(" Invalid input. Please enter 'yes' or 'no'.");
                userChoice = scanner.nextLine().toLowerCase();
            }

        } while (userChoice.equals("yes")); // Continue the loop if the user enters 'yes'

        // Close the Scanner
        scanner.close();

        System.out.println(" Thank you for playing! See you next time.");
    }
}

