package AnudipPracticals;

import java.util.Scanner;

class NegativeDepositException extends RuntimeException {
    public NegativeDepositException(String s) {
        super(s);
    }
}

class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class InvalidAccountException extends RuntimeException {
    public InvalidAccountException(String message) {
        super(message);
    }
}

public class BankAccount {
    private static final int VALID_ACCOUNT_NUMBER = 123;
 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to banking");

        System.out.println("Please enter your account number: ");
        int accountNumber = sc.nextInt();

        if (accountNumber != VALID_ACCOUNT_NUMBER) {
            throw new InvalidAccountException("Invalid Account Number.");
        }

        int bal = 10000;

        while (true) {
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check balance");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");

            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Enter the amount you want to withdraw: ");
                    int withdrawAmount = sc.nextInt();
                    if (withdrawAmount > bal) {
                        throw new InsufficientFundsException("Insufficient Funds.");
                    } else {
                        bal = bal - withdrawAmount;
                    }
                    break;

                case 2:
                    System.out.println("Enter the amount you want to deposit: ");
                    int depositAmount = sc.nextInt();

                    if (depositAmount < 0) {
                        throw new NegativeDepositException("Deposit amount cannot be negative.");
                    }

                    bal = bal + depositAmount;
                    break;

                case 3:
                    System.out.println("Current balance: " + bal);
                    break;

                case 4:
                    System.out.println("Thank you for using our service.");
                    return;

                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }
}
    


