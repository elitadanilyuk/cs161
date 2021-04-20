/**
* A composite class to implement a RBTree based Ordered Map.  The map is sorted according to the natural
* ordering of its keys.
* 
* CSC161
* @author Robert Gilanyi
*/

/*
 * @author Elita Danilyuk, S02664865
 * @version2021-04-17, CSC-161 Homework #11
 */

import java.util.Iterator;

public class MyTreeMap<K extends Comparable<K>,V> implements MyOrderedMap<K, V>{

// RBTree used to store each <key, value> entry
  RBTreeMap mapTree;
  
//constructors
  public MyTreeMap(){
      mapTree = new RBTreeMap();
  }
  /** Remove all of the entries from this map */ 
  public void clear(){
      mapTree.clear();
      return;
  }
  
  /** Return true if the specified key is in the map */
  public boolean containsKey(K key){
      return mapTree.searchKey(key);
  }
  
  /** Return true if this map contains the specified value */ 
  public boolean containsValue(V value){
      return mapTree.searchValue(value);
  }

  /** Return a set of entries in the map */
  public java.util.Set<Entry<K, V>> entrySet(){      
      return(java.util.Set<Entry<K, V>>) mapTree.entrySet();
  }
  
  /** Return the value that matches the specified key */
  @Override
  public V get(K key){
      Entry<K,V> e = mapTree.getentry(key);
      return e.getValue();
  }
  
  /** Return true if this map contains no entries */
  public boolean isEmpty(){
      return mapTree.getSize() == 0;
  }

  /** Return a set consisting of the keys in this map */
  public java.util.Set<K> keySet(){
        Entry e = null;
        java.util.HashSet<K> keyset = new java.util.HashSet<>();
        Iterator iter = mapTree.iterator();
        while(iter.hasNext())
            keyset.add(((Entry<K,V>)iter.next()).getKey());
            
      return keyset;
  }

/** Remove the entries for the specified key */
  @Override
  public void remove(K key){
      mapTree.deleteKey(key);
  }
     
  /** Add an entry (key, value) into the map */
  public V put(K key, V value){
      mapTree.insert(key, value);
      return value;
  }


  /** Return the number of mappings in this map */
  public int size(){
      return mapTree.getSize();
  }

  /** Return a set consisting of the values in this map */
  public java.util.Set<V> values(){
      java.util.Set<V> set = new java.util.HashSet<V>();
      Iterator<V> iter = mapTree.valueSet();
      
      while(iter.hasNext())
          set.add(iter.next()); 
      
      return set;
  }
  
    @Override
    public String toString(){
        String s = "";
        Entry e = null;
        Iterator<Entry<K,V>> iter = mapTree.iterator();
        while(iter.hasNext()){
            e = (Entry<K,V>)iter.next();
            s += e.toString() + " ";
        }
        return s+"\n";
    }

// interface MyOrderedMap methods for Ordered Maps
    /** Return true if this map contains no entries */
    @Override
    public Entry<K,V> firstEntry(){
        // TODO: Left as an exercise
        Entry<K, V> x = null;

        try{
            // for() to iterate through the mapTree
            for (Entry<K, V> e : mapTree){
                // setting x as the first iterator and breaking
                // the first iteration will be the first entry
                x = e;
                break;
            } //end for

        } catch (Exception e){
            System.out.println("Index is out of bounds.");
        } //end try-catch

        return x; // x will return null if the current map is empty
    }

    /** Returns the entry with the largest key value; if the map is empty, then it returns null. */
    @Override
    public Entry<K,V> lastEntry(){
        //TODO: Left as an exercise
        Entry<K, V> x = null;

        try {
            // for() to iterate through the mapTree and return the last iterator
            for(Entry<K, V> e : mapTree){
                x = e; //setting x as current iterator
            } //end for()

        } catch (Exception e){
            System.out.println("Index is out of bounds.");
        } //end try-catch

        return x; // x will return null if the current map is empty
    }

    /** Returns the entry with the greatest key value less than or equal to key; if there is no such entry, then
     * it returns null.
     * @return*/
    @Override
     public Entry<K, V> ceilingEntry(K key) {
        //TODO: Left as an exercise
        Entry<K, V> x = null;

        try {
            // for() to iterate through the mapTree
            for(Entry<K, V> e : mapTree){
                //setting x to the current iterator
                x = e;

                // if x is >= the key value return x
                if (x.key.compareTo(key) >= 0){
                    return x;
                }
                else { //if no such value exists set x to null
                    x = null;
                }
            } //end for()

        } catch (Exception e){
            System.out.println("Index is out of bounds.");
        } //end try-catch

        return x;
    }

    /** Returns the entry with the greatest key value less than or equal to key; if there is no such entry, then
     * it returns null. */
    @Override
    public Entry<K,V> floorEntry(K key){
        //TODO: Left as an exercise
        Entry<K, V> last = null;

        try{
            // for() to iterate through the mapTree
            for (Entry<K, V> e : mapTree){
                // if current iterator > key, return last, which is null
                if (e.key.compareTo(key) > 0 ) {
                    return last;
                }

                // current is <= 0 so, set last as the current iterator
                last = e;

            } //end for()

        } catch (Exception e){
            System.out.println("Index is out of bounds.");
        } //end try-catch

        return last;
    }

    /** Returns the entry with the greatest key value strictly less than key; if there is no such entry, then
     * it returns null. */
    @Override
    public Entry<K,V> lowerEntry(K key){
        //TODO: Left as an exercise
        Entry<K, V> last = null;

        try{
            // for() to iterate through the mapTree
            for (Entry<K, V> e : mapTree){
                // if current iterator >= key return last, which is null
                if (e.key.compareTo(key) >= 0 ) {
                    return last;
                }

                // the current iterator is < 0, so set last as the current iterator
                last = e;

            } //end for()

        } catch (Exception e){
            System.out.println("Index is out of bounds.");
        } //end try-catch

        return last;
    }

    /** Returns the entry with the least key value strictly greater than key; if there is no such entry, then
     * it returns null. */
    @Override
    public Entry<K,V> higherEntry(K key){
        //TODO: Left as an exercise
        Entry<K, V> current = null;

        try{
            // for() to iterate through the mapTree
            for (Entry<K, V> e : mapTree){
                // setting current to the current iterator
                current = e;

                // if current > key return current iterator
                if (current.key.compareTo(key) > 0 ) {
                    return current;
                }
            } //end for()

        } catch (Exception e){
            System.out.println("Index is out of bounds.");
        } //end try-catch

        return current;
    }    
    
class RBTreeMap extends RBTree<Entry<K,V>> {
    private MyOrderedMap.Entry<K,V> newEntry;

    public RBTreeMap(){
        super();
    }
    
    public int getSize(){
        return size;
    } 
    
    public Entry getentry(K key){
        for(Entry p : mapTree.entrySet()){
            if(p.getKey().equals(key))
                return p;
        }
        return null;
    }
    
    public Entry getentry(V value){
        for(Entry p : mapTree.entrySet()){
            if(p.getValue().equals(value))
                return p;
        }
        return null;
    }
    
    public boolean insert(K k, V v){
 //      create Entry object and insert it into tree
        if(super.insert(new MyOrderedMap.Entry(k,v))){
            return true;
        } else {
                return false;
        }
    }
    
    public boolean deleteKey(K key){
        Entry<K,V> entry = mapTree.getentry(key); 
        return super.delete(entry);
    }
    
    public boolean searchKey(K key){
        Entry<K,V> entry = mapTree.getentry(key);
        if (entry != null)
            return true;
        else
            return false;
    }
    
    public boolean searchValue(V value){
        Entry<K,V> entry = mapTree.getentry(value);
        if (entry != null)
            return true;
        else
            return false;
    }
    
    // Support for iteration
    /**
     * Returns an iterable collection of all key-value entries of the map.
     *
     * @return iterable collection of the map's entries
     */
    public Iterable<Entry<K,V>> entrySet() {
        java.util.Set<Entry<K, V>> buffer = new java.util.HashSet<>();
          Entry<K,V> p;
          Iterator iter = mapTree.iterator();
          while(iter.hasNext()){
              p = (Entry<K,V>)iter.next();
              buffer.add(p);
          }  
          return buffer;
    }

    /**
     * Returns an iterable collection of the items contained in the map.
     *
     * @return iterable collection of the map's keys
     */
    public Iterator<K> keySet() { 
        return new KeyIterator(); 
    }

    /**
       * @return iterable collection of the map's values
     */
    public Iterator<V> valueSet(){
        return new ValueIterator();
    }

      // Override createNewNode() to create a MyTreeMapNode
  //    @Override
  //    protected RBTreeMapNode<K,V> createNewNode(K k){
  //        return new RBTreeMapNode(k,newEntry.value);
  //    }

      public Iterator iterator(){
         return new RBTreeMapIterator<K,V>();
        }

      class RBTreeMapIterator<K extends Comparable<K>,V> implements Iterator{
     // Store the elements in a list
      private java.util.ArrayList<Entry<K,V>> elist = new java.util.ArrayList<>();
      private int current = 0; // Point to the current element in list

      public RBTreeMapIterator() {
        inorder(); // Traverse binary tree and store elements in list
      }

      /** Inorder traversal from the root*/
      private void inorder() {
        inorder((TreeNode<K>)root);
      }

      /** Inorder traversal from a subtree */
      private void inorder(TreeNode<K> root) {
        if (root == null)return;
        inorder(root.left);
        elist.add((Entry<K,V>)(root.element));
        inorder(root.right);
      }

      @Override /** More elements for traversing? */
      public boolean hasNext() {
        if (current < elist.size())
          return true;

        return false;
      }

      @Override /** Get the current element and move to the next */
      public Entry<K,V> next() {
        return elist.get(current++);
      }

      public void remove() {
              throw new UnsupportedOperationException("remove not supported"); 
          }
      } // end class RBTreeMapIterator

    //---------------- nested KeyIterator class ----------------
      protected class KeyIterator implements Iterator<K> {
      private Iterator<Entry<K,V>> entries = entrySet().iterator();   // reuse entrySet

      public boolean hasNext() {
          return entries.hasNext();
      } 
      public K next() { 
          return entries.next().getKey();
      }              // return key!
      public void remove() {
      throw new UnsupportedOperationException("remove not supported"); }
      } //----------- end of nested KeyIterator class -----------

      //---------------- nested ValueIterator class ----------------
      private class ValueIterator implements Iterator<V> {
          private Iterator<Entry<K,V>> entries = entrySet().iterator();   // reuse entrySet

          public boolean hasNext() { 
              return entries.hasNext();
          }
          public V next(){
           return entries.next().getValue(); // return value!
          }           

          public void remove() {
              throw new UnsupportedOperationException("remove not supported"); 
          }
      } //----------- end of nested ValueIterator class -----------

    } //end class RBTreeMap
} //end class MyTreeMap
