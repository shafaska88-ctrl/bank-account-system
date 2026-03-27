public class Account {

    private String owner;
    private String accountId;
    private double balance;


    public Account(String owner, String accountId,
                   double balance) {
        this.owner = owner;
        this.accountId = accountId;
        this.balance = balance;
    }


    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited €"
                    + amount);
        } else {
            System.out.println("Amount must be positive.");
        }
    }


    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return false;
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
            return false;
        } else {
            balance -= amount;
            System.out.println("Successfully withdrawn €"
                    + amount);
            return true;
        }
    }


    public String getOwner()     { return owner; }
    public String getAccountId() { return accountId; }
    public double getBalance()   { return balance; }


    @Override
    public String toString() {
        return "ID: " + accountId
                + " | Owner: " + owner
                + " | Balance: €" + balance;
    }
}
