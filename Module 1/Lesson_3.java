// Practice 1


// Task 25
// Write a program that requests fractional numbers (double d). The program should stop requesting when we enter 0. The program should output the multiplication of all entered numbers.

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double b = 1.0;
        double a;

        do{
            System.out.println("Insert a number (type: double): ");
            a = in.nextDouble();
            if(a == 0){
                break;
            }
            b = b * a;
        }while (a != 0);

        System.out.printf("Multiplication of inserted numbers: %.2f%n", b);
    }
}


// Task 26
// Write a program that asks for a number. The program should stop requesting when we enter 0. The program should output the sum of the odd elements that we entered.

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum = 0;
        int a;

        do{
            a = in.nextInt();
            if(a == 0){
                break;
            }
            sum += a;
            a = in.nextInt();
        }while(a != 0);

        System.out.println("Summ of inserted numbers: " + sum);
    }
}


// Task 27
// The program requests the number n. The program should output the sum of the first n numbers in the sequence 1+1/2+1/3+1/4 ...

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Insert n: ");
        double sum = 0;
        int n = in.nextInt();

        for(int i=1; i<=n; i++){
            sum += (double) 1 /i;
        }
        System.out.printf("Summ: %.5f%n", sum);
    }
}


// Task 28
// 4 numbers are entered: int a, int b, int c and int d. Print all the numbers in the interval from a to b, giving the remainder of c when divided by d. If such numbers do not exist, then nothing needs to be output.

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Insert 4 numbers: ");
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();
        System.out.println("done");
        for(int i=a; i<b; i++) {
            if (i % d == c) {
                System.out.println(i);
            }
        }
    }
}


// Task 29
// For this natural n , calculate the sum of 1**2 + 2**2 + ... + n**2.

import java.util.Scanner;
import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Insert n: ");
        int n = in.nextInt();
        int sum = 0;
        for(int i=1; i<=n; i++){
            sum += pow(i, 2);
        }
    System.out.println("Summ: " + sum);
    }
}


// Task 30
// The soldier wants to buy w bananas in the store. He needs to pay k dollars for the first banana, 2k dollars for the second, and so on (in other words, he needs to pay i·k dollars for the ith banana). He has n dollars. How many dollars will he have to borrow from a fellow soldier to buy w bananas?
// The first line contains three positive integers k, n, w (1 ≤ k, w ≤ 1000, 0 ≤ n ≤ 109), the cost of the first banana, the initial number of dollars from the soldier and the number of bananas he wants to buy.
// Print a single integer - the number of dollars that a soldier needs to borrow from a fellow soldier. If you don't need to borrow money, print 0.

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Cost of the first banana: ");
        int k = in.nextInt();
        System.out.println("Initial number of dollars: ");
        int w = in.nextInt();
        System.out.println("Number of bananas: ");
        int n = in.nextInt();
        int sum = 0;
        for(int i=1; i<=n; i++){
            sum += i*k;
        }
        int debt = sum - w;
        System.out.println("\nTotal amount of debt: " + debt);
    }
}
