package pack1;
 
class CurrentAccount extends Account {
    private static final double OVERDRAFT_LIMIT = 100000.0;
 
    public CurrentAccount(double initialBalance, Person accHolder) {
        super(accHolder, initialBalance);
    }
 
    public void withdraw(double amount) {
        if (getBalance() - amount >= -OVERDRAFT_LIMIT) {
            setBalance(getBalance() - amount);
            System.out.println("Withdrew " + amount + ". New balance: " + getBalance());
            return;
        } else {
            System.out.println("Withdrawal denied! Overdraft limit exceeded.");
            return;
        }
    }
}