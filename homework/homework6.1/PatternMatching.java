/*
 * This program takes in two strings from the user and tests whether the second string is a subset of the first.
 *
 * @author Elita Danilyuk, S02664865
 * @version2021-02-27, CSC-160 Homework 6, Assignment 6.1
 */
import java.util.Scanner;

public class PatternMatching {

    public static void main(String[] args) {
        // Initializing and Declaring local variables
        String str1;
        String str2;
        int currIndex = 0; // current index of str2
        int count = 0;
        boolean matched = false;
        boolean keepGoing;

        // do while(keepGoing == true)
        do{
            Scanner scnr = new Scanner(System.in); //Scanner to read user input

            //recieving input from user
            System.out.println("Enter a string s1: ");
            str1 = scnr.nextLine();
            System.out.println("Enter a string s2: ");
            str2 = scnr.nextLine();

            //for() to test if the second string is the subset of the first string
            for (int i = 0; i < str1.length(); i++) {
                if((str1.charAt(i) != str2.charAt(count))){
                    count = 0;
                    matched = false;
                }
                else if (str1.charAt(i) == str2.charAt(count)){
                    if(count == 0)
                        currIndex = i;
                    count++;
                    matched = true;
                    break;
                }

                if(count == str2.length()){
                    matched = true;
                    break;
                }
            } //end for()

            //display results
            if(matched)
                System.out.println("Strings matched at index " + currIndex);
            else
                System.out.println("The second string is not a substring of the first.");

            //ask user if they'd like to continue
            System.out.println("Would you like to go again? y/n");
            String goAgain = scnr.next();

            //if else to evaluate whether to continue evaluating Strings
            if (goAgain.equals("y") || goAgain.equals("y"))
                keepGoing = true;
            else
                keepGoing = false;
        }while(keepGoing);

    } //end main()
} //end class PatternMatching
