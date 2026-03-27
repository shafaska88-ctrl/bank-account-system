import java.util.ArrayList;

public class Bank {

    private String bankName;
    private ArrayList<Account> accounts;


    public Bank(String bankName) {
        this.bankName = bankName;
        this.accounts = new ArrayList<>();
    }


    public void createAccount(String owner,
                              String accountId) {

        if (findAccount(accountId) != null) {
            System.out.println("Account ID already exists.");
            return;
        }
        accounts.add(new Account(owner, accountId, 0.0));
        System.out.println("Account created for " + owner
                + " with ID: " + accountId);
    }


    public Account findAccount(String accountId) {
        for (Account a : accounts) {
            if (a.getAccountId().equals(accountId)) {
                return a;
            }
        }
        return null;
    }


    public void deposit(String accountId, double amount) {
        Account a = findAccount(accountId);
        if (a != null) {
            a.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }


    public void withdraw(String accountId, double amount) {
        Account a = findAccount(accountId);
        if (a != null) {
            a.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }


    public void transfer(String fromId, String toId,
                         double amount) {
        Account from = findAccount(fromId);
        Account to   = findAccount(toId);

        if (from == null || to == null) {
            System.out.println("One or both accounts "
                    + "not found.");
            return;
        }
        if (from.withdraw(amount)) {
            to.deposit(amount);
            System.out.println("Transfer of €" + amount
                    + " completed.");
        }
    }


    public void checkBalance(String accountId) {
        Account a = findAccount(accountId);
        if (a != null) {
            System.out.println("Balance for "
                    + a.getOwner() + ": €" + a.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }


    public void printAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }
        System.out.println("\n=== " + bankName
                + " — All Accounts ===");
        for (Account a : accounts) {
            System.out.println(a);
        }
    }


    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public String getBankName() {
        return bankName;
    }
}
