/*
 * This program takes an ArrayList of Integer[].
 * It sorts the list into a heap and prints the parent and it's right and left child.
 *
 * @author Elita Danilyuk, S02664865
 * @version2021-03-28, CSC-160 Homework 8, Assignment 8.0
 */

import java.util.Random;

public class HeapSort extends Heap {
  /** Heap sort method */
  public static <E extends Comparable> void heapSort(E[] list) {
    // Create a Heap of integers
    Heap<E> heap = new Heap<E>();

    // Add elements to the heap
    for (int i = 0; i < list.length; i++)
      heap.add(list[i]);

    // Remove elements from the heap
    for (int i = list.length - 1; i >= 0; i--)
      list[i] = heap.remove();

    // print the heap
    printHeap(list);
  }

  public static <E> void printList(E[] list){
    System.out.println("List:");
    for(int i = 0; i < list.length; i++){
      System.out.print(list[i] + " ");
    }
  }
  
  /** A test method */
  public static void main(String[] args) {
    Random rndm = new Random();
    Integer[] newList = new Integer[20];
    for (int i = 0; i < newList.length; i++) {
      newList[i] = rndm.nextInt(100);
    }

    Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53, 54, 57, 67, 68, 71, 71, 75};

    printList(newList);
    heapSort(newList);
  }
}
