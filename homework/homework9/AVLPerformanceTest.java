import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AVLPerformanceTest {
    public static void main(String[] args) throws InterruptedException {
        final int FIXED_SIZE = 1000000; //setting a constant fixed size
        Integer[] list = new Integer[FIXED_SIZE]; //setting an fixed size array
        Random rnd = new Random(); //creating a new random object

        System.out.print("Run:\n");

        for (int i = 0; i < 6; i++) { //for() to hit each case statement
            System.out.print("\n\tTree creation through constructor (E[] objects)");
            int searchInt = rnd.nextInt(99);

            //switch statement to create and bubble sort an array of 10, 100, 1000, 10000, 100000 & 1000000 elements
            //while measuring the time of the sorting that is taking place
            switch (i){
                case 0:
                    for (int j = 0; j < 10; j++) {
                        list[j] = rnd.nextInt(FIXED_SIZE);
                    }
                    System.out.print("\nBST constructor() execution time for 10 ");
                    BST list1 = measureTimeBSTConstructor(list);
                    System.out.print("AVL constructor() execution time for 10 ");
                    AVLTree list2 = measureTimeAVLConstructor(list);
                    System.out.print("\tAverage element search time comparison:");
                    System.out.print("\nBST average search execution time for 10 ");
                    measureTimeBSTSearch(list1, searchInt);
                    System.out.print("AVL average search time for 10 ");
                    measureTimeAVLSearch(list2, searchInt);
                    break;
                case 1:
                    for (int j = 0; j < 100; j++) {
                        list[j] = rnd.nextInt(FIXED_SIZE);
                    }
                    System.out.print("\nBST constructor() execution time for 100 ");
                    BST list3 = measureTimeBSTConstructor(list);
                    System.out.print("AVL constructor() execution time for 100 ");
                    AVLTree list4 = measureTimeAVLConstructor(list);
                    System.out.print("\tAverage element search time comparison:");
                    System.out.print("\nBST average search execution time for 100 ");
                    measureTimeBSTSearch(list3, searchInt);
                    System.out.print("AVL average search time for 100 ");
                    measureTimeAVLSearch(list4, searchInt);
                    break;
                case 2:
                    for (int j = 0; j < 1000; j++) {
                        list[j] = rnd.nextInt(FIXED_SIZE);
                    }
                    System.out.print("\nBST constructor() execution time for 1,000 ");
                    BST list5 = measureTimeBSTConstructor(list);
                    System.out.print("AVL constructor() execution time for 1,000 ");
                    AVLTree list6 = measureTimeAVLConstructor(list);
                    System.out.print("\tAverage element search time comparison:");
                    System.out.print("\nBST average search execution time for 1,000 ");
                    measureTimeBSTSearch(list5, searchInt);
                    System.out.print("AVL average search time for 1,000 ");
                    measureTimeAVLSearch(list6, searchInt);
                    break;
                case 3:
                    for (int j = 0; j < 10000; j++) {
                        list[j] = rnd.nextInt(FIXED_SIZE);
                    }
                    System.out.print("\nBST constructor() execution time for 10,000 ");
                    BST list7 = measureTimeBSTConstructor(list);
                    System.out.print("AVL constructor() execution time for 10,000 ");
                    AVLTree list8 = measureTimeAVLConstructor(list);
                    System.out.print("\tAverage element search time comparison:");
                    System.out.print("\nBST average search execution time for 10,000 ");
                    measureTimeBSTSearch(list7, searchInt);
                    System.out.print("AVL average search time for 10,000 ");
                    measureTimeAVLSearch(list8, searchInt);
                    break;
                case 4:
                    for (int j = 0; j < 100000; j++) {
                        list[j] = rnd.nextInt(FIXED_SIZE);
                    }
                    System.out.println("\nBST constructor() execution time for 100,000 ");
                    BST list9 = measureTimeBSTConstructor(list);
                    System.out.println("AVL constructor() execution time for 100,000 ");
                    AVLTree list10 = measureTimeAVLConstructor(list);
                    System.out.println("\tAverage element search time comparison:");
                    System.out.println("\nBST average search execution time for 100,000 ");
                    measureTimeBSTSearch(list9, searchInt);
                    System.out.println("AVL average search time for 100,000 ");
                    measureTimeAVLSearch(list10, searchInt);
                    break;
                case 5:
                    for (int j = 0; j < FIXED_SIZE; j++) {
                        list[j] = rnd.nextInt(FIXED_SIZE);
                    }
                    System.out.println("\nBST constructor() execution time for 1,000,000 ");
                    BST list11 = measureTimeBSTConstructor(list);
                    System.out.println("AVL constructor() execution time for 1,000,000 ");
                    AVLTree list12 = measureTimeAVLConstructor(list);
                    System.out.println("\tAverage element search time comparison:");
                    System.out.println("\nBST average search execution time for 1,000,000 ");
                    measureTimeBSTSearch(list11, searchInt);
                    System.out.println("AVL average search time for 1,000,000 ");
                    measureTimeAVLSearch(list12, searchInt);
                    break;
            } //end switch(i)
        } //end for()
    } //end main()

    /** Measuring and outputting the time of the bubble sort
     * @return*/
    public static BST measureTimeBSTConstructor(Integer[] list) throws InterruptedException {
        long startTime = System.nanoTime();

        // ... the code being measured starts ...
        // sleep for 5 seconds
        TimeUnit.SECONDS.sleep(5);

        BST bstList = new BST(list);

        // ... the code being measured ends ...
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;

        System.out.println("elements is " + timeElapsed + " nanoseconds");

        return bstList;
    }

    /** Measuring and outputting the time of the bubble sort */
    public static void measureTimeBSTSearch(BST list, int searchInt) throws InterruptedException {
        long startTime = System.nanoTime();

        // ... the code being measured starts ...
        // sleep for 5 seconds
        TimeUnit.SECONDS.sleep(5);

        // BST average search
        list.search(searchInt);

        // ... the code being measured ends ...
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;

        System.out.println("elements is " + timeElapsed + " nanoseconds");
    }

    /** Measuring and outputting the time of the bubble sort */
    public static AVLTree measureTimeAVLConstructor(Integer[] list) throws InterruptedException {
        long startTime = System.nanoTime();

        // ... the code being measured starts ...
        // sleep for 5 seconds
        TimeUnit.SECONDS.sleep(5);

        AVLTree avlList = new AVLTree(list);

        // ... the code being measured ends ...
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;

        System.out.println("elements is " + timeElapsed + " nanoseconds");

        return avlList;
    }

    /** Measuring and outputting the time of the bubble sort */
    public static void measureTimeAVLSearch(AVLTree list, int searchInt) throws InterruptedException {
        long startTime = System.nanoTime();

        // ... the code being measured starts ...
        // sleep for 5 seconds
        TimeUnit.SECONDS.sleep(5);

        //AVLTree average search
        list.search(searchInt);

        // ... the code being measured ends ...
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;

        System.out.println("elements is " + timeElapsed + " nanoseconds");
    }

} //end class AVLPerformanceTest