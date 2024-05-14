// Practice 1
// Arrays, one-dimensional arrays, using a loop for arrays


// Task 24
// The program requests the number n. 
// Next, we enter n numbers and store all the entered numbers in an array. Next, the program asks the user for the number m. 
// If the number m exists in our array, the program should print the word "YES" and print the index (location, address) of this number. 
// Otherwise, print the word "NO".

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Insert n: ");
        int n = in.nextInt();
        int [] arr = new int [n];
        System.out.println("Insert " + n + " numbers: ");
        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }
        System.out.println("Insert m: ");
        int m = in.nextInt();
        boolean found = false;
        for(int i=0; i<n; i++) {
            if (arr[i] == m) {
                System.out.println("YES " + i);
                found = true;
                break;
            }
        }
        if (found == false) {
            System.out.println("NO");
        }
    }
}


// Task 25
// The program requests the number n. 
// Next, we enter n numbers and store all the entered numbers in an array. Then we enter the number m. 
// The program should output the average value of all elements that are greater than m.

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Insert n: ");
        int n = in.nextInt();
        int [] arr = new int [n];
        System.out.println("Insert " + n + " numbers: ");
        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }
        System.out.println("Insert m: ");
        int m = in.nextInt();
        int count = 0;
        int numbers = 0;
        for(int i=0; i<n; i++){
            if(arr[i] > m){
                count += 1;
                numbers += arr[i];
            }
        }
        double average = (double) numbers / count;
        System.out.println("Average: " + average);
    }
}


// Task 26
// The program requests the number n. 
// Next, we enter n numbers and store all the entered numbers in an array. 
// Print all the elements in reverse order at the end.

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Insert n: ");
        int n = in.nextInt();
        int [] arr = new int [n];
        System.out.println("Insert " + n + " numbers: ");
        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }
        for(int i=n-1; i>=0 ; i--){
            System.out.println(arr[i]);
        }
    }
}


// Task 27
// The program requests the number n. 
// Next, we enter n numbers and store all the entered numbers in an array. 
// The program should replace the maximum and minimum elements.

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Insert n: ");
        int n = in.nextInt();
        int[] arr = new int[n];
        System.out.println("Insert 1 number: ");
        arr[0] = in.nextInt();
        int max = arr[0];
        int min = arr[0];
        int indexMax = 0;
        int indexMin = 0;
        System.out.println("Insert next numbers: ");
        for (int i = 1; i < n; i++) {
            arr[i] = in.nextInt();
            if (arr[i] > max) {
                max = arr[i];
                indexMax = i;
            }
            if (arr[i] < min) {
                min = arr[i];
                indexMin = i;
            }
        }
        int temp = arr[indexMax];
        arr[indexMax] = arr[indexMin];
        arr[indexMin] = temp;
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}


// Task 28
// The program requests the number n. 
// Next, we enter n numbers and store all the entered numbers in an array. 
// Create a second array from the even elements of the first array.

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Insert n: ");
        int n = in.nextInt();
        int [] arr1 = new int [n];
        int m = 0;
        System.out.println("Insert " + n + " numbers: ");
        for(int i=0; i<n; i++){
            arr1[i] = in.nextInt();
            if(arr1[i] % 2 == 0){
                m += 1;
            }
        }
        System.out.println("m: " + m);
        int [] arr2 = new int[m];
        int index = 0;
        for(int i=0; i<n; i++){
            if(arr1[i] % 2 == 0){
                arr2[index] = arr1[i];
                index++;
            }
        }
        System.out.println("New array #2: ");
        for(int j=0; j<m; j++){
            System.out.println(arr2[j]);
        }
    }
}


// Task 29
// The program requests the number n. 
// Next, we enter n numbers and store all the entered numbers in an array. 
// The program should output the sum of all the numbers that are between zeros.

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Insert n: ");
        int n = in.nextInt();
        int [] arr1 = new int [n];
        int zerocount = 0;
        int sum = 0;
        System.out.println("Insert " + n + " numbers: ");
        for(int i=0; i<n; i++){
            arr1[i] = in.nextInt();
            if(arr1[i] == 0){
                zerocount++;
            }
            if(zerocount == 1){
                sum += arr1[i];
            }
        }
        System.out.println("Summ: " + sum);
    }
}


// Task 30
// The program requests the number n. 
// Next, we enter n numbers and store all the entered numbers in an array. 
// The program should check whether positive and negative numbers alternate in it. 
// If they alternate, then print YES, otherwise NO.

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Insert n: ");
        int n = in.nextInt();
        int[] arr = new int[n];
        System.out.println("Insert " + n + " numbers: ");
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        boolean status = true;
        for (int i = 1; i < n; i++) {
            if ((arr[i] > 0 && arr[i - 1] > 0) || (arr[i] < 0 && arr[i - 1] < 0)) {
                status = false;
                break;
            }
        }
        if (status) {
            System.out.println("\nYES");
        } else {
            System.out.println("\nNO");
        }
    }
}
