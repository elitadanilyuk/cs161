import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n = 10000 * 10000 * 10000;
        System.out.println(n);

        int y = 0;
        for (int i = 0; i < 10; i++) {
            y += 1;
        }
        System.out.println(y);

        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = input.nextInt();

        int i;

        boolean isPrime = true;
        for (i = 2; i < number && isPrime; i++) {
            if (number % i == 0) {
                isPrime = false;
            }
        }

        System.out.println("i is " + i);

        if (isPrime)
            System.out.println(number + " is prime");
        else
            System.out.println(number + " is not prime");

    }
}
