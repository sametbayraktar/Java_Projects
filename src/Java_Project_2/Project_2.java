package Java_Project_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Project_2 {
    public static void main(String[] args) {

        // Hello,
        // In this project, an exemplary study was carried out for some transactions to be made at bank ATMs.

        // Define a scanner class...
        Scanner scanStr = new Scanner(System.in);
        Scanner scanInt = new Scanner(System.in);

        // Defining information about bank customers to the system

        // Define a list of bank transactions...
        List<String> transactions = new ArrayList<>(Arrays.asList("Deposit", "Withdraw", "Transfer", "Exit"));

        // Define a list of customer usernames
        List<String> customers = new ArrayList<>(Arrays.asList("User1", "User2", "User3", "User4"));

        // Define a list of customer passwords
        List<String> passwords = new ArrayList<>(Arrays.asList("password1", "password2", "password3", "password4"));

        // Define a list of customer accounts
        List<String> accounts = new ArrayList<>(Arrays.asList("1234", "5678", "9876", "5432"));

        // Define a list of the amounts of money in the bank accounts of customers
        List<Integer> balances = new ArrayList<>(Arrays.asList(200, 1000, 5000, 7000));

        // Verifying that the customer has logged into the system with the correct user information

        // Ask the user to enter username and password in an endless loop.
        // Confirm the username and password entered from the console by calling the **confirmUsernameAndPassword()** method.
        // If the correct username and password are entered, ask for the desired action by printing the message "You have successfully logged in".
        // If invalid username and password are entered, show the message "No such user found in the system. Try again" and return the user to the username and password entry again.
        boolean isTrue = false;
        do {

            System.out.print("Please enter your username : ");
            String username = scanStr.next();
            System.out.print("Please enter your password : ");
            String password = scanStr.next();

            isTrue = confirmUsernameAndPassword(customers, passwords, username, password);

            if (isTrue == false) {
                System.out.println("No such user found in the system. Try again!");
            }

        } while (isTrue == false);

        System.out.println("You have successfully logged in");

        // Performing the action requested by the customer

        // Ask the customer the transaction they want to do
        // If the choice is wrong, let's give the warning "You did not make a successful choice. Try again!" and ask her to choose again
        // When the right choice is made, the operation selected by the user will be transferred to the code via SWITCH Statements.
        // Case 1: "This ATM is temporarily closed for deposits... We are sorry!".
        // Case 2: "Which account do you want to withdraw money from?" ask the user
        // Take the account numbers from the List above and print them on the screen. Key in the account number the user chooses.
        // "How much money do you want to withdraw?" Let's ask.. Let's take the user input.
        // Complete the withdrawal from the account by calling the **withdraw()** method below.
        // Go back to the operations loop again.
        // Case 3: Back to the head saying "We can't do this process right now...".
        // Case 4: System.exit(1); Copy and paste the code here into case 4 exactly.
        // default: Send a message "You did not make a successful selection...".

        while (true) {

            for (int i = 0; i < transactions.size(); i++) {

                System.out.println((i + 1) + " - " + transactions.get(i));

            }
            System.out.print("Please select the action you want to do : ");
            int userChoice = scanInt.nextInt();

            switch (userChoice) {

                case 1:
                    System.out.println("This ATM is temporarily closed for deposits... We are sorry!");
                    break;
                case 2:
                    for (int i = 0; i < accounts.size(); i++) {

                        System.out.println("Account " + (i + 1) + " - " + accounts.get(i) + " : " + balances.get(i) + "€");

                    }
                    System.out.print("Which account do you want to withdraw money from? : ");
                    String chosenAccount = scanStr.next();
                    System.out.print("How much money do you want to withdraw? : ");
                    int amountToWithdraw = scanInt.nextInt();

                    withdraw(accounts, balances, chosenAccount, amountToWithdraw);
                    break;

                case 3:
                    System.out.println("We can't do this process right now...");
                    break;

                case 4:
                    System.out.println("Have a nice day!");
                    System.exit(1);
                    break;

                default:
                    System.out.println("You did not make a successful selection...");
            }
        }
    }

    private static boolean confirmUsernameAndPassword(List<String> customers, List<String> passwords, String username, String password) {

        boolean isTrue = false;

        for (int i = 0; i < customers.size(); i++) {

            if (customers.get(i).equals(username) && passwords.get(i).equals(password)) {

                isTrue = true;
                break;

            }

        }

        return isTrue;
    }

    private static void withdraw(List<String> accounts, List<Integer> balances, String chosenAccount, int amountToWithdraw) {

        for (int i = 0; i < accounts.size(); i++) {

            if (accounts.get(i).equals(chosenAccount)) {

                if (balances.get(i) > amountToWithdraw) {
                    System.out.println("Please take your money! Your new balance is : " + (balances.get(i) - amountToWithdraw) + "€");

                } else
                    System.out.println("You do not have enough balance. Your balance is : " + balances.get(i));
                break;
            }

            System.out.println("You selected the wrong account.");

        }

    }

}
