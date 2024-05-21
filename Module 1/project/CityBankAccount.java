import java.util.Scanner;

public class CityBankAccount implements BankAccount{
    String name;
    String surname;
    int balance;
    String accountNumber;
    String pinCode;
    Scanner in = new Scanner(System.in);

    public CityBankAccount(String name, String surname, String accountNumber, String pinCode, int balance) {
        this.name = name;
        this.surname = surname;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.pinCode = pinCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public String getPinCode() {
        return pinCode;
    }
    public void setPinCode(String pin) {
        pinCode = pin;
        System.out.println("Pin has changed");
    }
    public int totalBalance() {
        return balance;
    }
    public void creditBalance(int credit) {
        balance -= credit;
    }
    public void debetBalance(int debet) {
        balance += debet;
    }
    public String accountData() {
        return "Client: "+name+" "+surname+"\nAccount number: "+accountNumber;

    }
}
