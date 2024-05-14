// Practice 1
// Library installation, variables, basic operators, Scanner class


// Task 28
// Write a program in which I enter the number a. 
// If the number a is even, the program outputs true, otherwise false.

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Insert a");
        int a = in.nextInt();
        boolean c = (a % 2 == 0);
        System.out.println(c);
    }
}


// Task 29
// Write a program in which I enter integers a, b, c. 
// If there is a triangle with sides a, b, c, then the program will output true, otherwise false.

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Insert a");
        int a = in.nextInt();
        System.out.println("Insert b");
        int b = in.nextInt();
        System.out.println("Insert c");
        int c = in.nextInt();
        boolean d = (a + b > c) && (b + c > a) && (a + c > b);
        System.out.println(d);
    }
}


// Task 30
// A three-digit number is given. 
// Print first its last digit (units), and then its average digit (tens).

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Insert a");
        int a = in.nextInt();
        int b = a % 10;
        int c = (a / 10) % 10;
        System.out.println(b);
        System.out.println(c);
    }
}
