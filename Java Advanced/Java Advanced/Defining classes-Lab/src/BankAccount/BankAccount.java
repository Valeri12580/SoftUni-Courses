package BankAccount;

public class BankAccount {
    private static int idCounter=1;

    private static final double  RATE_DEFAULT_VALUE=0.2d;

    private int id;
    private double balance;
    private static  double interestRate=RATE_DEFAULT_VALUE;
    public BankAccount(){
        this.id=idCounter++;

    }

    public static void setInterestRate(double interest){
        interestRate=interest;


    }

    public double getInterestRate() {
        return interestRate;
    }


    public void deposit(double amout){
        this.balance+=amout;

    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static double getRateDefaultValue() {
        return RATE_DEFAULT_VALUE;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double getInterest(int years){
        return  BankAccount.interestRate *years *this.balance;
    }
}
