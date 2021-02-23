//package Lesson5.Liang.chpt19;

import java.util.Scanner;
import java.util.Iterator;

/**
 *
 * @author CSC161 Computer Science II
 */
public class GenericStackDemo{
    public static void main(String[] args){
        GenericStack<MyFoo> foos = new GenericStack<>();
        Scanner input = new Scanner(System.in);

        System.out.print("Enter two words: ");
        MyFoo<String> v1 = new MyFoo(input.next());
        MyFoo<String>  v2 = new MyFoo(input.next());


        foos.push(v1);
        foos.push(v2);

        for(Object e : foos.peek()){
            //do something class MyFoo object
        }


        System.out.printf("the two object %s the same\n? ",
                foos.pop().compareTo(foos.pop()) != 0 ? "are not" : "are");
//      System.out.println("are two objects are the same? " + (foos.pop().compareTo(foos.pop())));



    }
}

class MyFoo<E extends Comparable<E>> implements Comparable<E>, Iterable {
    E data;
    MyFoo(E s){
        data = s;
    }
    public int compareTo(E o){
        return data.compareTo(o);
    }

    public int compareTo(MyFoo<E> o){
        return data.compareTo(o.data);
    }

    public Iterator<E> iterator() {
        return new MyFooIterator<E>();
    }

    class MyFooIterator<E> implements Iterator<E> {
        public boolean hasNext(){
            return false;
        }

        public E next(){
            return null;
        }
    }
}