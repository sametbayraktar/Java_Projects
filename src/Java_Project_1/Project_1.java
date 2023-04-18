package Java_Project_1;

import java.util.Scanner;

public class Project_1 {
    public static void main(String[] args) {
        // Define the Scanner class...
        Scanner scanStr = new Scanner(System.in);

        // Ask the user to enter their name and change the first letter of the entered name to uppercase...
        System.out.print("Please enter your name : ");
        String name = scanStr.nextLine();
        String naMe = name.substring(0, 1).toUpperCase() + name.substring(1);

        // By printing the name entered by the user on the screen,  Let's ask "Hello #name, can you enter your last name?"...
        System.out.print("Hello " + naMe + ", can you enter your last name? : ");
        String surname = scanStr.nextLine();
        String surName = surname.substring(0, 1).toUpperCase() + surname.substring(1);

        // Let's print the first letter of the user's name and surname in capital letters and the others in small letters...
        System.out.println(naMe + " " + surName);

        // If the name and surname displayed on the screen is correct, let's press the "Y" key to create a loop to continue...
        // If the user presses any key other than "Y", Let's point out "You didn't make the right choice... Please try again..."...
        // Let's continue the loop until the user presses the "Y" key again...
        // When the user presses the "Y" key, Let's point out "Your Name and Surname have been successfully registered in the system..."...
        System.out.print("If your name and surname are correct, Please press the key \"Y\" : ");
        String key = scanStr.next();

        while (!key.equalsIgnoreCase("y")){
            
            System.out.println("You didn't make the right choice... Please try again... : ");
            key = scanStr.next();

        }

        System.out.println("Your Name and Surname have been successfully registered in the system...");

        // Let's continue with the username creation. -> " Please enter your username...:"...
        System.out.print("Please enter your username... : ");
        String username = scanStr.next();

        // Let's continue with password creation. -> " Please enter your password...:"...
        System.out.print("Please enter your password... : ");
        String password = scanStr.next();

        // Password must be re-entered. -> " Re-enter your password...:"...
        // The two passwords entered must be the same. If not, let's give a warning "You entered an incorrect or wrong password, please try again..."...
        // If the passwords are the same, let's print "Congratulations..." + username + " you have registered to the system...".
        System.out.print("Please re-enter your password... : ");
        String rePassword;
        rePassword = scanStr.next();

        while (!rePassword.equals(password)){

            System.out.print("You didn't make the right choice... Please try again... : ");
            rePassword = scanStr.next();
        }

        System.out.println("Congratulations... " + username + "! You have registered to the system...");
    }
}
