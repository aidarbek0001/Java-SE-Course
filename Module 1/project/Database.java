public class Database{

    public static BankAccount allAccounts[] = new BankAccount[3];
    static{
        allAccounts[0] = new CityBankAccount("Ilyas","Zhuanyshev","KZ010322312","0102", 20000);
        allAccounts[1] = new CityBankAccount("Erbol","Assanbek","KZ010322313","0101", 10000);
        allAccounts[2] = new NationalBankAccount("Ilyas Zhuanyshev","KZ0101112","0102", 2000);
    }
}