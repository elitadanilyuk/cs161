/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Iterator;

/**
 *
 * @author Y. Daniel Liang
 */


public class TestTree24 implements Tree{
  public static void main(String[] args) {
    // Create a 2-4 tree
    Integer[] nums = new Integer[]{3,15,20,27,16,34,24,25,29,35,36,50};
    Tree24<Integer> tree = new Tree24<>(nums);

    tree.delete(35);
    tree.delete(36);
    tree.delete(17);
    System.out.print("\nInitial tree:");
    for (int i = 0; i < tree.getSize(); i++){
      System.out.printf("%3d",i);}
    printTree(tree);

    tree.delete(20);
    System.out.print("\nAfter deleting 20:");
    printTree(tree);
  }

  public static <E extends Comparable<E>> void printTree(Tree24<E> tree) {
    // Traverse tree
    System.out.print("\nPreorder: ");
    tree.preorder();
    System.out.print("\nThe number of nodes is " + tree.getSize());
    System.out.println();

    System.out.print("\nInorder: ");
    tree.inorder();
    System.out.print("\nThe number of nodes is " + tree.getSize());
    System.out.println();

    System.out.print("\nPostorder: ");
    tree.postorder();
    System.out.print("\nThe number of nodes is " + tree.getSize());
    System.out.println();
  }

  @Override
  public boolean search(Object o) {
    return false;
  }

  @Override
  public boolean insert(Object o) {
    return false;
  }

  @Override
  public boolean delete(Object o) {
    return false;
  }

  @Override
  public int getSize() {
    return 0;
  }

  @Override
  public Iterator iterator() {
    return null;
  }

  @Override
  public void clear() {

  }
}