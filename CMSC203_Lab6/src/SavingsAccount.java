public class SavingsAccount extends BankAccount {

    private double rate = 0.025;     // 2.5% annual interest
    private int savingsNumber = 0;   // starts at 0
    private String accountNumber;    // hides superclass field

    public SavingsAccount(String name, double initialBalance) {
        super(name, initialBalance);
        accountNumber = super.getAccountNumber() + "-" + savingsNumber;
    }

    // Copy constructor
    public SavingsAccount(SavingsAccount original, double initialBalance) {
        super(original, initialBalance);
        this.savingsNumber = original.savingsNumber + 1;
        accountNumber = super.getAccountNumber() + "-" + this.savingsNumber;
    }

    public void postInterest() {
        double monthlyInterest = getBalance() * (rate / 12);
        deposit(monthlyInterest);
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }
}
