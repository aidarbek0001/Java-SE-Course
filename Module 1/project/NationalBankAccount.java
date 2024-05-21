import java.util.Scanner;

public class NationalBankAccount implements BankAccount{
    String fullName;
    int balance;
    String accountNumber;
    String pinCode;
    Scanner in = new Scanner(System.in);

    public NationalBankAccount(String fullName, String accountNumber, String pinCode, int balance) {
        this.fullName = fullName;
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
        return "Client: "+fullName+"\nAccount number: "+accountNumber;
    }
}
