/*
 * This program inputs, sorts and outputs an Integer and Float array.
 * The arrays are sorted through a Generic Method selectionSort().
 *
 * @author Elita Danilyuk, S02664865
 * @version2021-02-27, CSC-160 Homework 5, Assignment 5.1
 */

// SelectionSortTest.java
// Sorting an array with selection sort.
import java.security.SecureRandom;
import java.util.Arrays;



public class SelectionSortTest
{
    /**
     * SelectionSort() takes in an object array and sorts it from smallest to largest.
     *
     * @param array </T> current array that is being sorted
     */
    public  static < T extends Comparable<T>> void selectionSort(T[] array){
        // for() to loop through array.length - 1 elements
        for (int i = 0; i < array.length -1; i++){
            int smallest = i; //first index of remaining array

            // for() to find the index of the smallest element
            for (int j = i + 1; j < array.length; j++){
                if((array[smallest].compareTo((array[j])) > 0)){
                    smallest = j;
                }
            }

            swap(array, smallest, i); //swap smallest element into correct position
            printPass(array, i + 1, smallest); //output the pass of the algorithm

        } //end for(array.length-1)
    } //end selectionSort()

    /**
     * swap() is a helper method to swap values in two elements
     *
     * @param data T[] is the current array
     * @param first int is the first element
     * @param second int is the second element
     */
    private static <T> void swap(T[] data, int first, int second)
    {
        T temporary = data[first]; // store first in temporary
        data[first] = data[second]; // replace first with second
        data[second] = temporary; // put temporary in second
    } //end swap()

    /**
     * prints a pass of the algorithm
     *
     * @param data T[] is the current array
     * @param pass int is the number of passes
     * @param index int is the initial index
     */
    private static <T> void printPass(T[] data, int pass, int index)
    {
        System.out.printf("after pass %2d: ", pass);

        // output elements till selected item
        for (int i = 0; i < index; i++)
            System.out.printf("%s  ", data[i]);

        System.out.printf("%s* ", data[index]); // indicate swap

        // finish outputting array
        for (int i = index + 1; i < data.length; i++)
            System.out.printf("%s  ", data[i]);

        System.out.printf("%n               "); // for alignment

        // indicate amount of array that's sorted
        for (int j = 0; j < pass; j++)
            System.out.print("--  ");
        System.out.println();
    } //end printPass()

    public static void main(String[] args)
    {
        SecureRandom generator = new SecureRandom();

        Integer[] data = new Integer[10]; // create array

        for (int i = 0; i < data.length; i++) // populate array
        {
            data[i] = 10 + generator.nextInt(90);
        }

        System.out.printf("Unsorted array:%n%s%n%n",
                Arrays.toString(data)); // display array
        selectionSort(data); // sort array

        System.out.printf("Sorted array:%n%s%n%n",
                Arrays.toString(data)); // display array


        Float[] data2 = new Float[10]; //create Float array

        for (int i = 0; i < data2.length; i++) // populate array
        {
            data2[i] = 10 + generator.nextFloat()*(90);
        }

        System.out.printf("Unsorted array:%n%s%n%n",
                Arrays.toString(data2)); // display array
        selectionSort(data2); // sort array

        System.out.printf("Sorted array:%n%s%n%n",
                Arrays.toString(data2)); // display array
    }//end main()
} // end class SelectionSortTest
