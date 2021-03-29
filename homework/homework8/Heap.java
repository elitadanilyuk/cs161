/*
 * This program create a heap and prints it.
 *
 * @author Elita Danilyuk, S02664865
 * @version2021-03-28, CSC-160 Homework 8, Assignment 8.0
 */

import java.lang.Math;

public class Heap<E extends Comparable> {
  private java.util.ArrayList<E> list = new java.util.ArrayList<E>();

  /** Create a default heap */
  public Heap() {
  }

  /** Create a heap from an array of objects */
  public Heap(E[] objects) {
    for (int i = 0; i < objects.length; i++)
      add(objects[i]);
  }

  /** Add a new object into the heap */
  public void add(E newObject) {
    list.add(newObject); // Append to the heap
    int currentIndex = list.size() - 1; // The index of the last node

    while (currentIndex > 0) {
      int parentIndex = (currentIndex - 1) / 2;
      // Swap if the current object is greater than its parent
      if (list.get(currentIndex).compareTo(
          list.get(parentIndex)) > 0) {
        E temp = list.get(currentIndex);
        list.set(currentIndex, list.get(parentIndex));
        list.set(parentIndex, temp);
      }
      else
        break; // the tree is a heap now

      currentIndex = parentIndex;
    }
  }

  /** Remove the root from the heap */
  public E remove() {
    if (list.size() == 0) return null;

    E removedObject = list.get(0);
    list.set(0, list.get(list.size() - 1));
    list.remove(list.size() - 1);

    int currentIndex = 0;
    while (currentIndex < list.size()) {
      int leftChildIndex = 2 * currentIndex + 1;
      int rightChildIndex = 2 * currentIndex + 2;

      // Find the maximum between two children
      if (leftChildIndex >= list.size()) break; // The tree is a heap
      int maxIndex = leftChildIndex;
      if (rightChildIndex < list.size()) {
        if (list.get(maxIndex).compareTo(
            list.get(rightChildIndex)) < 0) {
          maxIndex = rightChildIndex;
        }
      }

      // Swap if the current node is less than the maximum
      if (list.get(currentIndex).compareTo(
          list.get(maxIndex)) < 0) {
        E temp = list.get(maxIndex);
        list.set(maxIndex, list.get(currentIndex));
        list.set(currentIndex, temp);
        currentIndex = maxIndex;
      }
      else
        break; // The tree is a heap
    }

    return removedObject;
  }

  /** Get the number of nodes in the tree */
  public int getSize() {
    return list.size();
  }

  public static <E> void printHeap(E[] list){
    // Printing the the heap as an ArrayList
    System.out.println("\nHeap:");
    for(int i = 0; i < list.length; i++){
      System.out.print(list[i] + " ");
    }
    System.out.println();

    // for() to go through each element in the heap
    for(int i = 0; i < list.length; i++){
      int parent = (int) list[i];

      try{ // try-catch for exception of empty children nodes
        try{ // try-catch for exception of empty right child node
          System.out.println("Parent: " + parent + " Depth: " + Math.round(Math.sqrt(i)) +
                  "\n\t\tleft child: " + list[2*i + 1] +
                  "\n\t\tright child: " + list[2*i + 2]);
        }
        catch(Exception e){
          System.out.println("Parent: " + parent + " Depth: " + Math.round(Math.sqrt(i)) +
                  "\n\t\tleft child: " + list[2*i + 1] +
                  "\n\t\tright child: " + "Empty node");
        } //end try-catch for exception of empty right child node
      }
      catch (Exception e){
        System.out.println("Parent: " + parent + " Depth: " + Math.round(Math.sqrt(i)) +
                "\n\t\tleft child: " + "Empty node" +
                "\n\t\tright child: " + "Empty node");
      } //end try-catch for exception of empty children nodes
    } //end for()
  } //end printHeap()

} //end class Heap
