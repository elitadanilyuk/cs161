public class GenericDemo {
    public static void main(String[] args){
        Integer[] myInts = {1, 2, 3, 4, 5};
        String[] myStrings = {"Trenton", "Sacremento", "Helena"};
        MyClass myClass = new MyClass();

        int myInt = 0;

        printArray(myInts);
        printArray(myStrings);
        printArray(myClass);
        printArray(myInt);
    }

    static <E> void printArray(E[] anArray){
        for(Object e : anArray){
            System.out.println("Value: " + e);
        } // only applicable for arrays

//        E someValue = (E)(new Object());
//        anArray(anArray.length) = someValue;
    }

    static <E> void printArray(E stuff){
        System.out.println("Value: " + stuff);
    }
}

class MyClass{

}