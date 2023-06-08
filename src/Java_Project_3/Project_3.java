package Java_Project_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Project_3 {
    public static void main(String[] args) {

        Scanner scanStr = new Scanner(System.in);
        Scanner scanInt = new Scanner(System.in);

        Actions transaction1 = new Actions("Deposit");
        Actions transaction2 = new Actions("Withdraw");
        Actions transaction3 = new Actions("Transfer");
        Actions transaction4 = new Actions("Exit");

        List<Actions> transactions =new ArrayList<>(Arrays.asList(transaction1,transaction2,transaction3,transaction4));

        //Create 2 account for Customer1
        Account acc11 = new Account();
        acc11.accNumber = "1234";
        acc11.accBalances = 500;
        Account acc12 = new Account();
        acc12.accNumber = "2345";
        acc12.accBalances = 750;
        //Customer2
        Account acc21 = new Account();
        acc21.accNumber = "3456";
        acc21.accBalances = 300;
        Account acc22 = new Account();
        acc22.accNumber = "4567";
        acc22.accBalances = 1000;
        //Customer3
        Account acc31 = new Account();
        acc31.accNumber = "5678";
        acc31.accBalances = 2000;
        Account acc32 = new Account();
        acc32.accNumber = "6789";
        acc32.accBalances = 800;

        //Customer1
        Customer customer1 = new Customer();
        customer1.username = "User1";
        customer1.password = "password1";
        customer1.accounts.add(acc11);
        customer1.accounts.add(acc12);
        //Customer2
        Customer customer2 = new Customer();
        customer2.username = "User2";
        customer2.password = "password2";
        customer2.accounts.add(acc21);
        customer2.accounts.add(acc22);
        //Customer3
        Customer customer3 = new Customer();
        customer3.username = "User3";
        customer3.password = "password3";
        customer3.accounts.add(acc31);
        customer3.accounts.add(acc32);

        ArrayList<Customer> customers = new ArrayList<>(Arrays.asList(customer1,customer2,customer3));

        Customer activeUser;
        Account selectedAccount;
        boolean isTrue = false;
        do {

            System.out.print("Please enter your username : ");
            String username = scanStr.next();
            System.out.print("Please enter your password : ");
            String password = scanStr.next();

            isTrue = confirmUsernameAndPassword(customers, username, password);

            if (isTrue == false) {
                System.out.println("No such user found in the system. Try again!");
            }

        } while (isTrue == false);

        System.out.println("You have successfully logged in");

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
                    for (int i = 0; i < customers.size(); i++) {

                        System.out.println("Account " + (i + 1) + " - " + customers.get(i) + " : " + customers.get(i) + "€");

                    }
                    System.out.print("Which account do you want to withdraw money from? : ");
                    Account chosenAccount = null;
                    System.out.print("How much money do you want to withdraw? : ");
                    int amountToWithdraw = scanInt.nextInt();

                    withdraw(chosenAccount, amountToWithdraw);
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

    private static boolean confirmUsernameAndPassword(ArrayList<Customer> customers, String username, String password) {

        boolean isTrue = false;

        for (int i = 0; i < customers.size(); i++) {

            if (customers.get(i).equals(username) && customers.get(i).equals(password)) {

                isTrue = true;
                break;

            }

        }

        return isTrue;
    }

    public static Account confirmAccountNumber(Customer activeUser, String chosenAccount){

        Account selectedAccount = null;

        for (Account a: activeUser.accounts) {
            if (a.accNumber.equals(chosenAccount))
                selectedAccount=a;
        }

        return selectedAccount;
    }

    private static boolean withdraw(Account chosedAccount, int amountToWithdraw) {

        if (chosedAccount.accBalances>=amountToWithdraw) {

            System.out.println("Please take your money. Your balance is " + ((chosedAccount.accBalances) - amountToWithdraw) + " euro.");

            chosedAccount.accBalances-=amountToWithdraw;

            return true;

        }else

            return false;

    }

}

