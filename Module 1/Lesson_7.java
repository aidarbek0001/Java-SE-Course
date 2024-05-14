// Practice 1
// Methods and arguments 


// Task 1
// Write a method that takes 3 values of integral numbers as arguments, and returns the highest of them.

import java.util.Scanner;
import static sun.swing.MenuItemLayoutHelper.max;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Insert 3 nums:");
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        maxNum(a, b, c);
    }
    public static void maxNum(int a, int b, int c){
        System.out.println("-----------");
        System.out.println("Max num is: " + max(a,b,c));
    }
}


//Task 16
// Create a method that takes a two-dimensional array of size NxM as arguments. 
// The program should output the maximum element in each line.

import java.util.Scanner;
import static sun.swing.MenuItemLayoutHelper.max;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Insert N:");
        int N = in.nextInt();
        System.out.println("Insert M:");
        int M = in.nextInt();
        int[][] arr = new int[N][M];
        System.out.println("Enter elements of array:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        maxNum(arr, N, M);
    }
    public static void maxNum(int[][] arr, int n, int m){
        System.out.println("---------");
        for (int i = 0; i < n; i++) {
            int max = arr[i][0];
            for (int j = 1; j < m; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
            System.out.println(max);
        }
    }
}


// Task 17
// Create a method that takes an array of integers as arguments. 
// The program should output odd numbers from the array and will stop if it encounters the number 23.

import java.util.Scanner;
import static sun.swing.MenuItemLayoutHelper.max;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Insert n:");
        int n = in.nextInt();
        int[] arr = new int[n];
        System.out.println("Insert " + n + " numbers: ");
        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        oddNum(arr);
    }
    public static void oddNum(int[] arr){
        System.out.println("---------");
        for (int j : arr) {
            if (j == 23) {
                break;
            } else if (j % 2 != 0) {
                System.out.println(j);
            }
        }
    }
}


// Task 18
// Create a method that takes an array of integers as arguments. 
// It is necessary to output elements that are simultaneously less than 50 and divisible by 5 without remainder.

import java.util.Scanner;
import static sun.swing.MenuItemLayoutHelper.max;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Insert n:");
        int n = in.nextInt();
        int[] arr = new int[n];
        System.out.println("Insert " + n + " numbers: ");
        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        specNum(arr);
    }
    public static void specNum(int[] arr){
        System.out.println("---------");
        for (int j : arr) {
            if (j < 50 && j % 5 == 0) {
                System.out.println(j);
            }
        }
    }
}


// Task 19
// Create a method that takes an array of integers as arguments. 
// It is necessary to sum up the elements of the array without taking into account the elements that are divided by 5 without remainder.

import java.util.Scanner;
import static sun.swing.MenuItemLayoutHelper.max;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Insert n:");
        int n = in.nextInt();
        int[] arr = new int[n];
        System.out.println("Insert " + n + " numbers: ");
        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        sumNum(arr);
    }
    public static void sumNum(int[] arr){
        System.out.println("---------");
        int sum = 0;
        for (int j : arr) {
            if (j % 5 != 0) {
                sum += j;
            }
        }
        System.out.println(sum);
    }
}


// Task 20
// Create a method that takes the month number as arguments and returns the name of the season. (Winter, Spring, Summer, Autumn)

import java.util.Scanner;
import static sun.swing.MenuItemLayoutHelper.max;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Insert n:");
        int n = in.nextInt();
        month(n);
    }
    public static void month(int n){
        System.out.println("---------");
        String month;
        switch (n){
            case 1: month = "January";
                break;
            case 2: month = "February";
                break;
            case 3: month = "March";
                break;
            case 4: month = "April";
                break;
            case 5: month = "May";
                break;
            case 6: month = "June";
                break;
            case 7: month = "July";
                break;
            case 8: month = "August";
                break;
            case 9: month = "September";
                break;
            case 10: month = "October";
                break;
            case 11: month = "November";
                break;
            case 12: month = "December";
                break;
            default: month = "No month";
        }
        System.out.println(month);
    }
}




