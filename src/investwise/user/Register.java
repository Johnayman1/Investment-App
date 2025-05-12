package investwise.user;

import java.util.Scanner;

import investwise.controller.ValidationService;


public class Register {

    public boolean start() {

        boolean login = false;
        Scanner sc = new Scanner(System.in);
        Investor investor = new Investor();
        ValidationService validationService = new ValidationService();
        String choice , inputName, inputUsername, inputEmail, inputPassword;

        while (true) {

            System.out.println("1) Sign Up");
            System.out.println("2) Log In");

            System.out.print("\nPlease enter your choice: ");
            choice = sc.nextLine();

            if (choice.equals("1")) {

                System.out.print("\nPlease enter your name: ");
                inputName = sc.nextLine();

                System.out.print("Please enter your username: ");
                inputUsername = sc.nextLine();


                while(true){

                    System.out.print("\nPlease enter your email: ");
                    inputEmail = sc.nextLine();

                    System.out.print("Please enter your password: ");
                    inputPassword = sc.nextLine();


                    if (!validationService.validEmail(inputEmail) || !validationService.validPassword(inputPassword)) {

                        System.out.println("\nInvalid email or password format.");

                    }else {
                        break;
                    }

                }

                investor.signup( inputName, inputEmail, inputUsername, inputPassword);
                login = true;

            } else if (choice.equals("2")) {

                System.out.print("\nPlease enter your email: ");
                inputEmail = sc.nextLine();

                System.out.print("Please enter your password: ");
                inputPassword = sc.nextLine();

                if (investor.login(inputEmail, inputPassword)){
                    System.out.println("\nYou have successfully logged in.");
                    login = true;
                }
                break ;

            }
            System.out.println("*************************");
            System.out.println("Invalid choice.Try again.");
            System.out.println("*************************");
        }
        return login;
    }
} 