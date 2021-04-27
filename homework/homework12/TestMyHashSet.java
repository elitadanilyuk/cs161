public class TestMyHashSet {
    public static void main(String[] args){
        java.util.Collection<String> set = new MyHashSet<>();
        set.add("Smith");
        set.add("Anderson");
        set.add("Lewis");
        set.add("Cook");
        set.add("Smith");

        System.out.println("Elements in set: " + set);
        System.out.println("Number of elements in set: " + set.size());
        System.out.println("Is Smith in set? " + set.contains("Smith"));

        set.remove("Smith");
        System.out.println("Names in set in uppercase are ");
        for (String s : set){
            System.out.println(s.toUpperCase() + " ");
        }

        set.clear();
        System.out.println("\nElements in set: " + set);
    }
}
