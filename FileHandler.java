import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    private static final String FILE_NAME = "accounts.txt";


    public static void saveAccounts(
            ArrayList<Account> accounts) {
        try (PrintWriter pw = new PrintWriter(
                new FileWriter(FILE_NAME))) {
            for (Account a : accounts) {
                pw.println(a.getOwner() + ","
                        + a.getAccountId() + ","
                        + a.getBalance());
            }
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: "
                    + e.getMessage());
        }
    }


    public static ArrayList<Account> loadAccounts() {
        ArrayList<Account> accounts = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("No saved data found. "
                    + "Starting fresh.");
            return accounts;
        }

        try (BufferedReader br = new BufferedReader(
                new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String owner     = parts[0];
                    String id        = parts[1];
                    double balance   = Double.parseDouble(
                            parts[2]);
                    accounts.add(
                            new Account(owner, id, balance));
                }
            }
            System.out.println("Data loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading data: "
                    + e.getMessage());
        }
        return accounts;
    }
}