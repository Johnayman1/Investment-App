package investwise.bank;
import java.util.Scanner;
import investwise.user.Investor;

public class Manage_Bank {
    public void Bank(Investor investor){

        Scanner sc = new Scanner(System.in);
        String choice = "";


        System.out.println("\n\n-------------------------- Bank Account --------------------------");
        while(true){

            System.out.println("\n1) Add Bank Account");
            System.out.println("2) Remove Bank Account");
            System.out.println("3) Exit");


            System.out.print("\nPlease, enter your choice: ");
            choice = sc.nextLine();

            if (choice.equals("1")) {

                System.out.print("Please, enter account number: ");
                int accountNumber = Integer.parseInt(sc.nextLine());

                System.out.print("Please, enter bank name: ");
                String bankName = sc.nextLine();

                System.out.print("Please, enter userId: ");
                String userId = sc.nextLine();

                System.out.print("Please, enter card number: ");
                String cardNumber = sc.nextLine();

                System.out.print("Please, enter CVV: ");
                String cvv = sc.nextLine();
                System.out.print("Please, enter expiry date: ");
                String expiryDate = sc.nextLine();

                investor.validationService.validCardNumber(cardNumber);
                investor.validationService.validCardCvv(cvv);
                investor.validationService.validDate(expiryDate);

                BankAccount bankAccount = new BankAccount(accountNumber, bankName, userId, cardNumber, cvv, expiryDate);
                investor.addBankAccount(bankAccount);

            } else if (choice.equals("2")) {
                System.out.print("Please, enter account number to remove: ");
                int accountNumber = Integer.parseInt(sc.nextLine());

                investor.removeBankAccount(accountNumber);

            } else if (choice.equals("3")){
                System.out.println("\n***************************************************************\n\n");
                sc.close();
                break ;
            }
        }
    }
}