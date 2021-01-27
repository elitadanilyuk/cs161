/**
 * This program randomly generates a word and prompts the user to guess one letter at a time.
 * If the guess is correct, the letter is displayed. Once the full word is guessed, the number
 * mistakes are listed and the user is asked again whether they would like to continue playing.
 *
 * @author Elita Danilyuk, S02664865
 * @verson2021-01-24, CSC-160 Homework 1, Assignment 1.2
 */

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class HangMan
{
    public static void main(String[] args)
    {
        // Initialized and declared boolean to keep playing until user decides to stop
        boolean continuePlaying = false;

        do
        {
            // Initializations & declarations
            ArrayList<Character> guesses = new ArrayList<>(); // ArrayList to track if guess has already been made
            Scanner scnr = new Scanner(System.in);

            int timesIncorrect = 0; // Incrementer to count the times incorrect guesses are made

            String currWord = setRandomWord(); // Setting the current word from the method setRandomWord()
            String tempWord = ""; // Temporary word to store * and correct character guesses

            // for() to set the temporary word to display with all asterisks
            for (int i = 0; i < currWord.length(); i++)
            {
                tempWord += "*";
            }

            // while() to continue until the temporary word no longer contains asterisks
            while (tempWord.contains("*"))
            {
                System.out.print("(Guess) Enter a letter in word " + tempWord + " > "); // Output for user
                char currGuess = scnr.next().charAt(0); // Input from user

                // creating a new temporary word to concatenate itself with the guessed character and/or asterisks
                String newTempWord = "";

                if (guesses.contains((currGuess))) // comparing the current guess to previous guesses
                {
                    // Output if user already guessed the current character
                    System.out.println("\t" + currGuess + " is already in the word");
                }
                else if (currWord.contains(String.valueOf(currGuess)))
                {
                    /* if the current word DOES contain the current character it goes through a
                        for() to concatenate itself in the correct position */
                    for (int j = 0; j < currWord.length(); j++)
                    {
                        if (currWord.charAt(j) == currGuess)
                        {
                            // true if the current character is equal to the current guess
                            newTempWord += currGuess;
                        }
                        else if (tempWord.charAt(j) != '*')
                        {
                            // this is for the case that a character is already guessed, to concat correctly
                            newTempWord += currWord.charAt(j);
                        }
                        else
                        {
                            // if the current character is not equal to the current guess
                            newTempWord += "*";
                        }
                    } // end for(currWord.length())

                    /* setting the temporary word equal to the new temporary word for outputting the updated guess
                        and to allow the new temporary word to reset for the next guess. */
                    tempWord = newTempWord;
                }
                else
                {
                    timesIncorrect += 1;
                    System.out.println("\t" + currGuess + " is not in the word");
                } // end if/elseif - comparing the character guess to each character in the current word

                // adding the current guess to ArrayList<Character> to check already guessed characters
                guesses.add(currGuess);

                /* if case for output/continue playing if the temporary word is completely guessed
                    and equal to the current word */
                if (tempWord.equals(currWord))
                {
                    System.out.println("The word is " + currWord + ". You missed " + timesIncorrect + " times.\n" +
                            "Do you want to guess another word? Enter y or n>");
                    // Input from user if they want to continue playing
                    String playAgain = scnr.next();

                    if((playAgain.equals("y")) || (playAgain.equals("Y")))
                    {
                        // will continue in while(continuePlaying == true)
                        continuePlaying = true;
                    }
                    else
                    {
                        // end the game for the user
                        continuePlaying = false;
                    }
                }
            } //end while(tempWord.contains("*"))

        } //end do{}while(continuePlaying == true) - until user decides to stop
        while(continuePlaying == true);

    } //end main()

    /** Returns a random word for the game */
    public static String setRandomWord()
    {
        // Generating a random int with limitations for the switch statement
        Random currRandom = new Random();
        final int MAX = 5;
        int randomInt = currRandom.nextInt(MAX);

        // Switch statement to 'set' the random word
        /* my IDE will not compile if I place a "break;" statement after each 'return'
            (syntax error: "Delete unreachable statement") */
        switch(randomInt) {
            case 0:
                return "papaya";
                break;
            case 1:
                return "grapefruit";
            case 2:
                return "watermelon";
            case 3:
                return "pomegranate";
            case 4:
                return "pineapple";
            default:
                return "blueberry";
        } //end switch(randomInt)
    } //end setRandomWord()

} //end class HangMan
