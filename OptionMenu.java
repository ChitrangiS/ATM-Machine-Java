package ATM1;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu extends Account {
    // Declare scanner and money format for input/output
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    // Store account data (customer number, pin)
    HashMap<Integer, Integer> data = new HashMap<>();

    // Method to handle the login process
    public void getLogin() throws IOException {
        int x = 1;

        do {
            try {
                // Predefined accounts for testing
                data.put(9876543, 9876); // Example account 1
                data.put(8989898, 1890); // Example account 2
                data.put(8987889, 1891); // Example account 3

                System.out.println("Welcome to the ATM Project!");

                // Get customer number and pin from user
                System.out.print("Enter Your Customer Number: ");
                setCustomerNumber(menuInput.nextInt());

                System.out.print("Enter Your Pin Number: ");
                setPinNumber(menuInput.nextInt());

                // Check if account number and pin are valid
                if (data.containsKey(getCustomerNumber()) && data.get(getCustomerNumber()) == getPinNumber()) {
                    System.out.println("Login Successful!");
                    getAccountType();  // Proceed to account selection menu
                    x = 0;  // Exit loop after successful login
                } else {
                    System.out.println("Invalid Customer Number or PIN. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                menuInput.nextLine(); // Clear the invalid input
            }
        } while (x == 1);  // Continue retrying until valid login
    }

    // Method to display account selection menu
    public void getAccountType() {
        System.out.println("Select the Account you want to access:");
        System.out.println("1 - Checking Account");
        System.out.println("2 - Saving Account");
        System.out.println("3 - Exit");

        // Get user selection
        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                getCheckingAccountMenu();  // Call checking account menu
                break;
            case 2:
                getSavingAccountMenu();    // Call saving account menu
                break;
            case 3:
                System.out.println("Thank you for using this ATM!");  // Exit message
                break;
            default:
                System.out.println("Invalid choice. Try again.");
                getAccountType();  // Retry if invalid option
        }
    }

    // Method to display checking account options
    public void getCheckingAccountMenu() {
        System.out.println("Checking Account:");
        System.out.println("1 - View Balance");
        System.out.println("2 - Withdraw Funds");
        System.out.println("3 - Deposit Funds");
        System.out.println("4 - Exit");

        // Get user selection
        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                getCheckingAccountMenu();  // Show menu again after operation
                break;
            case 2:
                System.out.print("Enter amount to withdraw: ");
                withdrawFromChecking(menuInput.nextDouble());  // Call withdrawal method
                getCheckingAccountMenu();  // Show menu again after operation
                break;
            case 3:
                System.out.print("Enter amount to deposit: ");
                depositToChecking(menuInput.nextDouble());  // Call deposit method
                getCheckingAccountMenu();  // Show menu again after operation
                break;
            case 4:
                getAccountType();  // Return to main account type menu
                break;
            default:
                System.out.println("Invalid choice.");
                getCheckingAccountMenu();  // Retry if invalid option
        }
    }

    // Method to display saving account options
    public void getSavingAccountMenu() {
        System.out.println("Saving Account:");
        System.out.println("1 - View Balance");
        System.out.println("2 - Withdraw Funds");
        System.out.println("3 - Deposit Funds");
        System.out.println("4 - Exit");

        // Get user selection
        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
                getSavingAccountMenu();  // Show menu again after operation
                break;
            case 2:
                System.out.print("Enter amount to withdraw: ");
                withdrawFromSaving(menuInput.nextDouble());  // Call withdrawal method
                getSavingAccountMenu();  // Show menu again after operation
                break;
            case 3:
                System.out.print("Enter amount to deposit: ");
                depositToSaving(menuInput.nextDouble());  // Call deposit method
                getSavingAccountMenu();  // Show menu again after operation
                break;
            case 4:
                getAccountType();  // Return to main account type menu
                break;
            default:
                System.out.println("Invalid choice.");
                getSavingAccountMenu();  // Retry if invalid option
        }
    }
}
