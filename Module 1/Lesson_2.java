// Practice 1


// Task 25
// Write a program where I enter two numbers.
// If the first number is greater than the second, then print YES, otherwise change the values of the variables and output.

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Insert a");
        int a = in.nextInt();
        System.out.println("Insert b");
        int b = in.nextInt();

        if (a > b){
            System.out.println("Yes");
        }else{
            System.out.println(b + " " + a);
        }
    }
}


// Task 26
// Write a program where I enter the number of the month, print the name of the month.

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Insert a number of the month");
        int a = in.nextInt();
        String month = "";

        switch (a){
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



// Task 27
// A natural number is given. It is required to determine whether the year is a leap year. 
// If the year is a leap year, then print YES, otherwise print NO. 
// (Recall that a year is a leap year if its number is divisible by 4 but not divisible by 100, or if it is divisible by 400.)

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Insert an year:");
        int year = in.nextInt();

        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}


// Task 28
// Write a program where I enter my username and password. 
// And if the data was entered correctly, then we output Authentication completed, otherwise Invalid login or password.
// (Login must be user, password must be qwerty)

import java.util.Objects;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a login:");
        String login = in.next();
        System.out.println("Enter a password:");
        String pass = in.next();

        String stat_login = "user";
        String stat_pass = "qwerty";

        if (Objects.equals(login, stat_login) && Objects.equals(pass, stat_pass)){
            System.out.println("Authentication completed");
        } else {
            System.out.println("Invalid Login or Password");
        }
    }
}


// Task 29
// Write a currency exchange program where I enter the amount in tenge and choose which currency I want to transfer to. 
// (Exchange rate USD – 420, EUR – 510, RUB - 5.8)

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Amount in tenge:");
        double tenge = in.nextDouble();

        int USD = 420;
        int EUR = 510;
        double RUB = 5.8;

        System.out.println("Choose currency:" + "\n[1] USD\n[2] EUR\n[3] RUB");
        int currency = in.nextInt();
        double result;
        String CurrencySymb = "";
        
        switch (currency){
            case 1: result = tenge / USD;
                CurrencySymb = "USD";
                break;
            case 2: result = tenge / EUR;
                CurrencySymb = "EUR";
                break;
            case 3: result = tenge / RUB;
                CurrencySymb = "RUB";
                break;
            default:
                System.out.println("Invalid currency selection");
                return;
        }
        System.out.printf("%.2f %s%n", result, CurrencySymb);
    }
}


// Task 30
// Write a program that can determine your future profession based on your abilities. 
// The program will ask several questions and roughly determine who you need to become in the future.

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose your branch:" + "\n" +
                "1 - Science, 2 - Humanitarian subjects, 3 - Art, 4 - Sport:");
        int a = in.nextInt();
        String profession = "";

        switch (a){
            case 1:
                System.out.println("You have chosen Science" + "\nChoose one:" +
                        "\n1 - Math, 2 - Physics:");
                int a1 = in.nextInt();
                if (a1 == 1){profession = "You are Financier";}
                else if (a1 == 2) {profession = "You are Engineer";}
                else{profession = "Invalid selection";}
                break;
            case 2:
                System.out.println("You have chosen Humanitarian subjects" + "\nChoose one:" +
                        "\n1 - History, 2 - Foreign Languages:");
                int a2 = in.nextInt();
                if (a2 == 1){profession = "You are Historic or Diplomat";}
                else if (a2 == 2) {profession = "You are Translator";}
                else{profession = "Invalid selection";}
                break;
            case 3:
                System.out.println("You have chosen Art" + "\nChoose one:" +
                        "\n1 - Drawing, 2 - Singing:");
                int a3 = in.nextInt();
                if (a3 == 1){profession = "You are Painter or Architect";}
                else if (a3 == 2) {profession = "You are Singer or Tamada";}
                else{profession = "Invalid selection";}
                break;
            case 4:
                System.out.println("You have chosen Sport" + "\nChoose one:" +
                        "\n1 - Team, 2 - Individual:");
                int a4 = in.nextInt();
                if (a4 == 1){profession = "You are footballer or Basketball player";}
                else if (a4 == 2) {profession = "You are boxer or tennis player";}
                else{profession = "Invalid selection";}
                break;
            default:
                System.out.println("Invalid selection");
                }
        System.out.println("\n" + profession);
    }
}

