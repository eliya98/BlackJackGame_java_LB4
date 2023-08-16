/**
 * Dealer Class
 * Represents a dealer in the card game, extending the PlayerBase class.
 * Manages the dealer's decisions during the game.
 *
 * Lab 4 -- BlackJack Game
 * Author: Elijah Yakimyuk
 * Course: CS& Computer Science & Java II
 * Instructor: Jeremiah Ramsey
 * Date: 07/17/2023
 */

// Class Dealer represents a dealer in the card game, which extends PlayerBase class.
class Dealer extends PlayerBase {

    // Constructor for the Dealer class, calling the constructor of its superclass.
    public Dealer() {
        super();
    }

    // Decide method for dealer. The dealer must hit if hand value is less than 17.
    public boolean decide() {
        return getHandValue() < 17;
    }
}
