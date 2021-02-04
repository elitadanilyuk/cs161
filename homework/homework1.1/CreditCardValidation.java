/**
 * This program verifies if a credit card number is valid or invalid
 * through a series of specific arithmetic patterns.
 *
 * @author Elita Danilyuk, S02664865
 * @verson2021-01-24, CSC-160 Homework 1, Assignment 1.1
 */

import java.util.Scanner;

public class CreditCardValidation
{
    public static void main(String[] args)
    {
        Scanner scnr = new Scanner(System.in);

        System.out.print("Enter a credit card number: ");

        long number = scnr.nextLong();

        if(isValid(number) == true)
        {
            System.out.println("The card number is valid.");
        }
        else
            System.out.println("The card number is invalid");
    } //end main()

    /** Return true if card number is valid */
    public static boolean isValid(long number)
    {
        /* The first line verifies the credit card number is between 13-16 digits &&
            the second and third lines verify starting digits match either Visa, Master, Discover, or AmEx cards &&
            the final like verifies that the final sum is divisible by 10. */
        return ((getSize(number) >=13) && (getSize(number) <= 16) &&
                (prefixMatched(number, 4) || prefixMatched(number, 5) ||
                        prefixMatched(number, 6) || prefixMatched(number, 37)) &&
                (((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10) == 0));
    } //end isValid()

    /** Get the result from Step 2 */
    public static int sumOfDoubleEvenPlace(long number)
    {
        // Initializing and declaring local method variables
        int sum = 0;
        String num = number + "";

        // for() to calculate the sum multiplied by two, of even place numbers from right to left
        for(int i = getSize(number) -2; i >= 0; i -=2)
        {
            // setting the sum += the called getDigit() to get the correct number if it is a single or double digit
            sum += getDigit(Integer.parseInt(num.charAt(i)+ "") *2);
        }

        return sum;
    } //end sumOfDoubleEvenPlace()

    /** Return this number if it's a single digit, otherwise
     * return the sum of the two digits */
    public static int getDigit(int number)
    {
        // calculating the digit and digitSize
        int digit = number * 2;
        int digitSize = Integer.toString(digit).length();

        // if the digit is a single digit, it simple returns the number
        if(digitSize < 1)
        {
            return number;
        }

        // returns the first digit plus the second digit of the number *2
        return (number / 10) + (number % 10);
    } //end getDigit()

    /** Return sum of odd-place digits in number */
    public static int sumOfOddPlace(long number)
    {
        // Initializing and declaring local method variables
        int sum = 0;
        String num = number + "";

        // for() to calculate the sum of Odd place numbers from right to left
        for(int i = getSize(number) - 1; i >= 0; i -=2)
        {
            sum += Integer.parseInt(num.charAt(i) + "");
        }
        return sum;
    } //end sumOfOddPlace()

    /** Return true if the number d is a prefix for number */
    public static boolean prefixMatched(long number, int d)
    {
        return (getPrefix(number, getSize(d)) == d);
    } //end prefixMatched

    /** Return the number of digits in d */
    public static int getSize(long d)
    {
        String num = d + "";
        return num.length();
    } //end getSize()

    /** Return the first k number of digits from number.
     *  If the number of digits in number is less than k, return number */
    public static long getPrefix(long number, int k)
    {
        if(getSize(number) > k)
        {
            String num = number + "";
            return Long.parseLong(num.substring(0, k));
        }
        return number;
    } //end getPrefix()

} //end class CreditCardValidation