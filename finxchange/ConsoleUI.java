package finxchange;

import java.math.BigDecimal;
import java.util.Scanner;

public class ConsoleUI {

    private CurrencyEngine engine;

    public ConsoleUI() {
        engine = new CurrencyEngine(new StaticRateProvider());
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("     💱 FinXChange Engine v1.0      ");
        System.out.println("  Precision Currency Conversion     ");
        System.out.println("====================================");

        while (true) {
            try {
                System.out.print("\nEnter Base Currency (USD/INR/EUR/GBP): ");
                String from = sc.next().toUpperCase();

                System.out.print("Enter Target Currency: ");
                String to = sc.next().toUpperCase();

                System.out.print("Enter Amount: ");
                BigDecimal amount = sc.nextBigDecimal();

                BigDecimal result = engine.convert(from, to, amount);

                System.out.println("\n💰 Converted Amount: " + result + " " + to);

            } catch (Exception e) {
                System.out.println("⚠️ Error: " + e.getMessage());
            }

            System.out.print("\nDo another conversion? (yes/no): ");
            String choice = sc.next();

            if (!choice.equalsIgnoreCase("yes")) {
                System.out.println("👋 Thank you for using FinXChange!");
                break;
            }
        }

        sc.close();
    }
}