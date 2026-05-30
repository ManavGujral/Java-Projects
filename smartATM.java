import java.util.*;

public class smartATM {

    // Account details
    private static double balance = 5000.00;
    private static final String PIN = "1234";
    private static List<String> miniStatement = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Welcome Screen
        System.out.println("=====================================");
        System.out.println("        💳 SMART ATM MACHINE         ");
        System.out.println("=====================================");

        // PIN Authentication
        System.out.print("Enter your 4-digit PIN: ");
        String enteredPin = sc.nextLine();

        if (!enteredPin.equals(PIN)) {
            System.out.println("❌ Incorrect PIN. Transaction Cancelled.");
            return;
        }

        System.out.println("✅ Login Successful!");

        int choice;

        do {
            // ATM Menu
            System.out.println("\n=========== MAIN MENU ===========");
            System.out.println("1. 💰 Check Balance");
            System.out.println("2. 💵 Withdraw Cash");
            System.out.println("3. 💳 Deposit Money");
            System.out.println("4. 📄 Mini Statement");
            System.out.println("5. 🚪 Exit");
            System.out.println("=================================");
            System.out.print("Choose an option: ");

            // Input validation
            if (!sc.hasNextInt()) {
                System.out.println("⚠️ Please enter a valid number!");
                sc.next(); // clear invalid input
                continue;
            }

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    checkBalance();
                    break;

                case 2:
                    withdraw(sc);
                    break;

                case 3:
                    deposit(sc);
                    break;

                case 4:
                    showMiniStatement();
                    break;

                case 5:
                    exitATM();
                    break;

                default:
                    System.out.println("⚠️ Invalid choice. Try again.");
            }

        } while (true);
    }

    // Check Balance
    public static void checkBalance() {
        System.out.println("\n💰 Current Balance: ₹" + balance);
    }

    // Withdraw Money
    public static void withdraw(Scanner sc) {
        System.out.print("\nEnter amount to withdraw: ₹");

        if (!sc.hasNextDouble()) {
            System.out.println("⚠️ Invalid amount!");
            sc.next();
            return;
        }

        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("⚠️ Amount must be greater than 0.");
        } else if (amount > balance) {
            System.out.println("❌ Insufficient balance.");
        } else {
            balance -= amount;
            miniStatement.add("Withdrawn: ₹" + amount);
            System.out.println("✅ Please collect your cash.");
        }
    }

    // Deposit Money
    public static void deposit(Scanner sc) {
        System.out.print("\nEnter amount to deposit: ₹");

        if (!sc.hasNextDouble()) {
            System.out.println("⚠️ Invalid amount!");
            sc.next();
            return;
        }

        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("⚠️ Amount must be greater than 0.");
        } else {
            balance += amount;
            miniStatement.add("Deposited: ₹" + amount);
            System.out.println("✅ Amount deposited successfully.");
        }
    }

    // Mini Statement
    public static void showMiniStatement() {
        System.out.println("\n📄 MINI STATEMENT");
        System.out.println("-----------------------------");

        if (miniStatement.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String transaction : miniStatement) {
                System.out.println(transaction);
            }
        }
    }

    // Exit ATM
    public static void exitATM() {
        System.out.println("\n🙏 Thank you for using Smart ATM!");
        System.out.println("Please collect your card.");
        System.exit(0);
    }
}