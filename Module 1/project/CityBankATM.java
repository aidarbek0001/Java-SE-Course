import java.util.Objects;
import java.util.Scanner;

public class CityBankATM {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Insert an account number:");
        String accNumber = in.next();
        System.out.println("Enter a pin:");
        String pinCode = in.next();

        checkAccount(accNumber, pinCode);

    }
    public static void checkAccount(String acc, String pin){
        for(int i=0; i<Database.allAccounts.length; i++){
            if(Objects.equals(acc, Database.allAccounts[i].getAccountNumber()) &&
                    Objects.equals(pin, Database.allAccounts[i].getPinCode())){
                if (Database.allAccounts[i] instanceof CityBankAccount){
                    System.out.println("CityBank account");
                    bigMenu(acc);
                } else if (Database.allAccounts[i] instanceof NationalBankAccount) {
                    System.out.println("Other bank account");
                    miniMenu(acc);
                }
            }
        }
        System.out.println("Invalid account number or password");
    }

    public static void bigMenu(String acc){
        boolean process = true;
        int n = 0;
        for(int i=0;i<Database.allAccounts.length;i++){
            if(Objects.equals(acc, Database.allAccounts[i].getAccountNumber())){
                n = i;
                break;
            }
        }
        BankAccount account = Database.allAccounts[n];
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("\nPRESS [1] TO CASH WITHDRAWAL\n" +
                    "PRESS [2] TO VIEW BALANCE\n" +
                    "PRESS [3] TO CHANGE PIN CODE\n" +
                    "PRESS [4] TO CASH IN ACCOUNT\n" +
                    "PRESS [5] TO VIEW ACCOUNT DATA\n" +
                    "PRESS [6] TO EXIT");
            int num = in.nextInt();
            if (num == 1) {
                System.out.println("Enter the withdrawal amount");
                int credit = in.nextInt();
                account.creditBalance(credit);
                System.out.println(credit + " withdrawn");
            } else if (num == 2) {
                System.out.println("Account balance:");
                System.out.println(account.totalBalance());
            } else if (num == 3) {
                System.out.println("Insert a new PIN CODE:");
                String newPin = in.next();
                account.setPinCode(newPin);
                System.out.println("A new PIN CODE has been set");
            } else if (num == 4) {
                System.out.println("Enter the deposit amount:");
                int deposit = in.nextInt();
                account.debetBalance(deposit);
                System.out.println(deposit + " deposited");
            } else if (num == 5) {
                System.out.println(account.accountData());
            } else if (num == 6) {
                System.out.println("Exiting..");
                process = false;
            } else {
                System.out.println("Invalid number");
            }
        }while (process);
    }

    public static void miniMenu(String acc){
        boolean process = true;
        int n = 0;
        for(int i=0;i<Database.allAccounts.length;i++){
            if(Objects.equals(acc, Database.allAccounts[i].getAccountNumber())){
                n = i;
                break;
            }
        }
        BankAccount account = Database.allAccounts[n];
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("\nPRESS [1] TO CASH WITHDRAWAL\n" +
                    "PRESS [2] TO VIEW BALANCE\n" +
                    "PRESS [3] TO EXIT");
            int num = in.nextInt();
            if (num == 1) {
                System.out.println("Enter the withdrawal amount");
                int credit = in.nextInt();
                account.creditBalance(credit);
                System.out.println(credit + " withdrawn");
            } else if (num == 2) {
                System.out.println("Account balance:");
                System.out.println(account.totalBalance());
            } else if (num == 3) {
                System.out.println("Exiting..");
                process = false;
            } else {
                System.out.println("Invalid number");
            }
        }while (process);
    }
}
