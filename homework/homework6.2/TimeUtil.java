/*
 * This program does a bubble sort on an array of random numbers and measures the execution time for each.
 *
 * @author Elita Danilyuk, S02664865
 * @version2021-02-27, CSC-160 Homework 6, Assignment 6.2
 */

import java.util.concurrent.TimeUnit;
import java.util.Random;

// Program to calculate execution time or elapsed time in Java
public class TimeUtil {
    public static void main(String[] args) throws InterruptedException {
        final int FIXED_SIZE = 10000; //setting a constant fixed size
        int[] list = new int[FIXED_SIZE]; //setting an fixed size array
        Random rnd = new Random(); //creating a new random object

        for (int i = 0; i < 4; i++) { //for() to hit each case statement
            //switch statement to create and bubble sort an array of 100, 1000, 5000 & 10000 elements
            //while measuring the time of the sorting that is taking place
            switch (i){
                case 0:
                    System.out.println("Bubble sorting an array of 100 elements:");
                    for (int j = 0; j < 100; j++) {
                        list[j] = rnd.nextInt(FIXED_SIZE);
                    }
                    measureTime(list);
                    break;
                case 1:
                    System.out.println("Bubble sorting an array of 1,000 elements:");
                    for (int j = 0; j < 1000; j++) {
                        list[j] = rnd.nextInt(FIXED_SIZE);
                    }
                    measureTime(list);
                    break;
                case 2:
                    System.out.println("Bubble sorting an array of 5,000 elements:");
                    for (int j = 0; j < 5000; j++) {
                        list[j] = rnd.nextInt(FIXED_SIZE);
                    }
                    measureTime(list);
                    break;
                case 3:
                    System.out.println("Bubble sorting an array of 10,000 elements:");
                    for (int j = 0; j < FIXED_SIZE; j++) {
                        list[j] = rnd.nextInt(FIXED_SIZE);
                    }
                    measureTime(list);
                    break;
            } //end switch(i)
        } //end for()
    } //end main()

    /** Bubble sort method */
    public static void bubbleSort(int[] list) {
        boolean needNextPass = true;

        for (int k = 1; k < list.length && needNextPass; k++) {
            // Array may be sorted and next pass not needed
            needNextPass = false;
            for (int i = 0; i < list.length - k; i++) {
                if (list[i] > list[i + 1]) {
                    // Swap list[i] with list[i + 1]
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;

                    needNextPass = true; // Next pass still needed
                }
            }
        }
    } //end bubbleSort()

    /** Measuring and outputting the time of the bubble sort */
    public static void measureTime(int[] list) throws InterruptedException {
        long startTime = System.nanoTime();

        // ... the code being measured starts ...

        // sleep for 5 seconds
        TimeUnit.SECONDS.sleep(5);
        bubbleSort(list);

        // ... the code being measured ends ...

        long endTime = System.nanoTime();

        long timeElapsed = endTime - startTime;

        // outputting the array list (values above 0, to show array 'size')
        for (int i : list) {
            if (i > 0)
                System.out.print(i + " ");
        }
        System.out.println("\nExecution time in nanoseconds: " + timeElapsed);
        System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000 + "\n");
    }

} //end class TimeUtil