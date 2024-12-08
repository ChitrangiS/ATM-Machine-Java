package ATM1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    // Declare instance variables
    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;

    // Initialize scanner and money format
    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    // Getters and setters for customer number and pin
    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    // Getters for balance information
    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    // Methods for withdrawing from checking
    public void withdrawFromChecking(double amount) {
        if (checkingBalance >= amount) {
            checkingBalance -= amount;
            System.out.println("Withdrawn: " + moneyFormat.format(amount));
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    // Methods for depositing to checking
    public void depositToChecking(double amount) {
        checkingBalance += amount;
        System.out.println("Deposited: " + moneyFormat.format(amount));
    }

    // Methods for withdrawing from saving
    public void withdrawFromSaving(double amount) {
        if (savingBalance >= amount) {
            savingBalance -= amount;
            System.out.println("Withdrawn: " + moneyFormat.format(amount));
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    // Methods for depositing to saving
    public void depositToSaving(double amount) {
        savingBalance += amount;
        System.out.println("Deposited: " + moneyFormat.format(amount));
    }
}
