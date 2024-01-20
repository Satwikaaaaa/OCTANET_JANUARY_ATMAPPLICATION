import java.util.HashMap;
import java.util.Scanner;

public class application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Long, Integer> currentAccounts = new HashMap<>();
        currentAccounts.put(123456789L, 1234);
        currentAccounts.put(123789456L, 1237);
        currentAccounts.put(789456123L, 7894);

        HashMap<Long, Double> accountBalance = new HashMap<>();
        accountBalance.put(123456789L, 10000.00);
        accountBalance.put(123789456L, 20000.00);
        accountBalance.put(789456123L, 30000.00);

        System.out.println("Welcome!");
        System.out.println("Please enter your account number:");
        long enteredNumber = scanner.nextLong();

        if (currentAccounts.containsKey(enteredNumber)) {
            System.out.println("Thanks for entering the account number");

            System.out.println("Please enter your PIN:");
            int enteredPIN = scanner.nextInt();

            if (currentAccounts.get(enteredNumber) == enteredPIN) {
                System.out.println("\nWhat would you like to do today?\n" +
                        "1. Check my balance\n" +
                        "2. Make a withdrawal\n" +
                        "3. Make a deposit\n" +
                        "4. Log out");

                int activity = scanner.nextInt();
                double balance = accountBalance.get(enteredNumber);

                if (activity == 1) {
                    System.out.println("Your current balance is " + balance);
                } else if (activity == 2) {
                    System.out.println("How much would you like to withdraw today?");
                    int withdrawAmount = scanner.nextInt();

                    if (withdrawAmount > balance) {
                        System.out.println("You do not have enough money.");
                    } else if (withdrawAmount % 5 != 0) {
                        System.out.println("Please enter in multiples of Rs100, Rs200, or Rs500");
                    } else {
                        System.out.println("Please take your Rs" + withdrawAmount);
                        accountBalance.put(enteredNumber, balance - withdrawAmount);
                        System.out.println("Your current balance is Rs" + accountBalance.get(enteredNumber));
                    }
                } else if (activity == 3) {
                    System.out.println("How much would you like to deposit today?");
                    int depositAmount = scanner.nextInt();

                    System.out.println("You have deposited Rs" + depositAmount);
                    System.out.println("Your current balance is Rs" + (balance + depositAmount));
                    accountBalance.put(enteredNumber, balance + depositAmount);
                } else if (activity == 4) {
                    System.out.println("Thank you and please come again.");
                } else {
                    System.out.println("Invalid option. Please try again.");
                }
            } else {
                System.out.println("Incorrect PIN. Exiting.");
            }
        } else {
            System.out.println("Invalid account number entered. Goodbye!");
        }
    }
}