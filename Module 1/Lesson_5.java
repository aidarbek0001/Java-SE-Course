// Practice 1


// Task 21
// Make a kind of calculator that accepts two numbers and the operator (+, -, *, /) between them in the form of text. 
// Display the result of the operation.

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an expression: ");
        String input = in.nextLine();
        int operatorIndex = -1;
        char operator = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/') {
                operator = input.charAt(i);
                operatorIndex = i;
                break;
            }
        }
        if (operatorIndex == -1) {
            System.out.println("The operator was not found");
            return;
        }
        double num1 = Double.parseDouble(input.substring(0, operatorIndex));
        double num2 = Double.parseDouble(input.substring(operatorIndex + 1));
        double result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("Error: division by zero");
                    return;
                }
                result = num1 / num2;
                break;
            default:
                System.out.println("Unsupported operator: " + operator);
                return;
        }
        System.out.println("Result: " + result);
    }
}


// Task 26
// The program should accept the text and show on the screen only those words that are between the characters < and >.

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter text with tags: ");
        String input = in.nextLine();
        System.out.println("The words between the characters < and >: ");
        int start = 0;
        while (start < input.length()) {
            int startP = input.indexOf('<', start);
            int endP = input.indexOf('>', startP);
            if (startP == -1 || endP == -1) {
                break;
            }
            if (endP > startP + 1) {
                System.out.println(input.substring(startP + 1, endP));
            }
            start = endP + 1;
        }
    }
}


// Task 27
// Write a program that accepts a long text (String text) and two separate words (String S1 and String S2). 
// The program should replace the first word(S1) wherever it occurs with the second word (S2).

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the long text:");
        String text = in.nextLine();
        System.out.println("Enter the first word (S1):");
        String S1 = in.nextLine();
        System.out.println("Enter the second word (S2):");
        String S2 = in.nextLine();
        String replacedText = text.replace(S1, S2);
        System.out.println("Upgraded Text:");
        System.out.println(replacedText);
    }
}


// Task 28
// Write a program that replaces the numbers written in text form with a numeric format.

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter text with numbers in text format:");
        String input = in.nextLine();
        String[] words = input.split("\\s+");
        String output = "";
        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();
            switch (word) {
                case "one":
                    word = "1";
                    break;
                case "two":
                    word = "2";
                    break;
                case "three":
                    word = "3";
                    break;
                case "four":
                    word = "4";
                    break;
                case "five":
                    word = "5";
                    break;
                case "six":
                    word = "6";
                    break;
                case "seven":
                    word = "7";
                    break;
                case "eight":
                    word = "8";
                    break;
                case "nine":
                    word = "9";
                    break;
                case "ten":
                    word = "10";
                    break;
                default:
                    break;
            }
            output += word;
            if (i < words.length - 1) {
                output += " ";
            }
        }
        System.out.println("Converted text:");
        System.out.println(output);
    }
}














