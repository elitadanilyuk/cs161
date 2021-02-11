//public class Main
//{
////    static int j = 50;
//    public static void main(String[] args)
//    {
////        System.out.println("j is " + j + " and k is " + 101);
////        System.out.println((25/4) + " " + (25.0/4.0) + " " + (25/4.0));
//
//        new B();
//    }
//}
// class A{
//    int i = 7;
//
//    A(){
//        setI(20);
//        System.out.println("i from A is " + i);
//    }
//
//    public void setI(int i){
//        this.i = 2*i;
//    }
// }
//
// class B extends A{
//    public B(){
//        setI(20);
//    }
//
//    @Override
//     public void setI(int i){
//        this.i= 3*i;
//    }
// }

public class Main {
    public static void main(String[] args) {
        new Person().printPerson();
        new Student().printPerson();
    }
}

class Student extends Person {
    
    private String getInfo() {
        return "Student";
    }
}

class Person {
    private String getInfo() {
        return "Person";
    }

    public void printPerson() {
        System.out.println(getInfo());
    }
}