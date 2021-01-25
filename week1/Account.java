public class Account {

    public int id;
    private double balance;
    private static double annualInterestRate;
    private java.util.Date dateCreated;

    public Account() {
        dateCreated = new java.util.Date();
    }

    public Account(int newId, double balance) {
        this.id = newId;
        this.balance = balance;
    }

    public int getId() {
        return this.id;
    }

    public double getBalance() {
        return balance;
    }

    public static void setAnnualInterestRate(double rate) {
        //
    }

    public static void withdraw(double amountWithdraw) {
        //
    }

    public static void deposit(double amountDeposit) {
        //
    }

    public static double getMonthlyInterest() {
        //
        return 0;
    }

    public java.util.Date getDateCreated() {
        //
        return dateCreated;
    }

} //end class Account
