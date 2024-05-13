// Practice 1


// Task 15
// Write a program that takes values into a two-dimensional array of size NxM, as well as a certain number k. 
// If an array element is divisible by k without remainder, 
// the program must replace this element with the result of dividing this number by k

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Insert N:");
        int N = in.nextInt();
        System.out.println("Insert M:");
        int M = in.nextInt();
        int[][] arr = new int[N][M];
        System.out.println("Insert elements of array:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println("Insert k:");
        int k = in.nextInt();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] % k == 0) {
                    arr[i][j] = arr[i][j] / k;
                }
            }
        }
        System.out.println("Modified array:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}


// Task 16
// Write a program that outputs a two dimensional array in a mirror image relative to the vertical.

import java.util.Scanner;
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
        int[][] arr2 = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr2[i][j] = arr[i][M - 1 - j];
            }
        }
        System.out.println("Changed array:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println();
        }
    }
}


// Task 18
// Write a program in which I enter two numbers N and M. 
// Then I create a two-dimensional NxM array. Next, we fill this array with numbers. 
// The program should output the maximum element in each line.

import java.util.Scanner;
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
        System.out.println("Maximum element in each line:");
        for (int i = 0; i < N; i++) {
            int max = arr[i][0];
            for (int j = 1; j < M; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
            System.out.println(max);
        }
    }
}


// Task 20
// The program requests the number N, then we create a two-dimensional array N x N and fill them with numbers. 
// The program must replace the first null line of the array with the last line of the array.

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Insert N:");
        int N = in.nextInt();
        int[][] arr = new int[N][N];
        System.out.println("Enter elements of array:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println("Result:");
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}





















