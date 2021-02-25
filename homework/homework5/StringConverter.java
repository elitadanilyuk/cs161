/**
 * This program/class converts a string to its corresponding numeric value.
 * The converted string is output to file "NumberStringConverted.txt" through StringConverterTest.java.
 * There is a NumberFormatException if an invalid character is detected in the argued string.
 *
 * @author Elita Danilyuk, S02664865
 * @verson2021-02-21, CSC-160 Homework 5
 */

public class StringConverter{

    /**
     * The function to convert a String to an int.
     *
     * @param numString the current string that is being evaluated
     * @return the int value of the string (if it is a valid int)
     */
    public static int convert(String numString) {
        // if to return 0 if an empty string
        if (numString.length() == 0)
            return 0;

        // if the string has 1 digit, it returns its value
        if (numString.length() == 1)
            return (numString.charAt(0) - '0');

        // if the string contains an invalid character a NumberFormatException is thrown
        if ((!numString.substring(0, 1).matches("[0-9]")) &&
                (numString.charAt(0) != '-')){
            throw new NumberFormatException("? Invalid numeric string detected starting at " + numString);
            // return 0; ( I was not sure how to return a value after an Exception error )
        }

        // if the string contains a '-' to indicate a negative int
        // returns the int as a negative
        if (numString.charAt(0) == '-'){
            // recursive call for the substring, starting at the index of 2 (3rd character)
            double y = convert(numString.substring(2));
            double x = numString.charAt(1) - '0'; // first digit of the converted number

            // first digit multiplied by correct power of 10, then the added recursive result
            x = (x * Math.pow(10, (numString.length() - 2)) + y) * -1;
            return (int)x;
        }

        // recursive call for the substring, starting at the index of 1 (2nd character)
        double y = convert(numString.substring(1));

        double x = numString.charAt(0) - '0'; // first digit of the converted number

        // first digit multiplied by correct power of 10, then the added recursive result
        x = x * Math.pow(10, (numString.length() - 1)) + y;
        return (int)x;
    } //end Convert()

} //end class StringConverter
