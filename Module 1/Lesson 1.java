### Practice 1

## Task 28
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

## Task 29
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

## Task 30
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
