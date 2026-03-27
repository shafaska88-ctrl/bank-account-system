import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc   = new Scanner(System.in);
        Bank bank    = new Bank(" National Bank");


        bank.getAccounts().addAll(
                FileHandler.loadAccounts());

        System.out.println("Welcome to "
                + bank.getBankName());

        boolean running = true;

        while (running) {
            printMenu();
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.print("Enter owner name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter account ID: ");
                    String id = sc.nextLine();
                    bank.createAccount(name, id);
                    break;

                case 2:
                    System.out.print("Enter account ID: ");
                    String dId = sc.nextLine();
                    System.out.print("Enter amount: ");
                    try {
                        double dAmt = Double.parseDouble(
                                sc.nextLine());
                        bank.deposit(dId, dAmt);
                    } catch (NumberFormatException e) {
                        System.out.println(
                                "Invalid amount.");
                    }
                    break;

                case 3: // Withdraw
                    System.out.print("Enter account ID: ");
                    String wId = sc.nextLine();
                    System.out.print("Enter amount: ");
                    try {
                        double wAmt = Double.parseDouble(
                                sc.nextLine());
                        bank.withdraw(wId, wAmt);
                    } catch (NumberFormatException e) {
                        System.out.println(
                                "Invalid amount.");
                    }
                    break;

                case 4:
                    System.out.print("From account ID: ");
                    String fId = sc.nextLine();
                    System.out.print("To account ID: ");
                    String tId = sc.nextLine();
                    System.out.print("Enter amount: ");
                    try {
                        double tAmt = Double.parseDouble(
                                sc.nextLine());
                        bank.transfer(fId, tId, tAmt);
                    } catch (NumberFormatException e) {
                        System.out.println(
                                "Invalid amount.");
                    }
                    break;

                case 5:
                    System.out.print("Enter account ID: ");
                    String bId = sc.nextLine();
                    bank.checkBalance(bId);
                    break;

                case 6:
                    bank.printAllAccounts();
                    break;

                case 7:
                    FileHandler.saveAccounts(
                            bank.getAccounts());
                    System.out.println("Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Try again.");
            }
        }
        sc.close();
    }


    private static void printMenu() {
        System.out.println("\n=== BANK MENU ===");
        System.out.println("1. Create account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. Check balance");
        System.out.println("6. View all accounts");
        System.out.println("7. Save and exit");
        System.out.println("=================");
    }
}
