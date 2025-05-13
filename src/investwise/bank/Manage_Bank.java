package investwise.bank;
import java.util.Scanner;
import investwise.user.Investor;
import investwise.controller.ValidationService;
public class Manage_Bank {

    private static int accountNumber = 1 ;
    public void Bank(Investor investor){

        ValidationService vs = new ValidationService();
        Scanner sc = new Scanner(System.in);
        String choice = "";


        System.out.println("\n\n-------------------------- Bank Account --------------------------");
        while(true){

            System.out.println("\n1) Add Bank Account");
            System.out.println("2) Remove Bank Account");
            System.out.println("3) Display All Bank Accounts");
            System.out.println("4) Exit");


            System.out.print("\nPlease, enter your choice: ");
            choice = sc.nextLine();

            if (choice.equals("1")) {

                System.out.print("Please, enter bank name: ");
                String bankName = sc.nextLine();

                System.out.print("Please, enter userId: ");
                String userId = sc.nextLine();

                String cardNumber , cardNumberInput;
                while (true){
                    System.out.print("Please, enter card number: ");
                    cardNumberInput = sc.nextLine();
                    if(vs.validCardNumber(cardNumberInput)) {
                        cardNumber = cardNumberInput;
                        break;
                    }
                }

                String cvv , inputCvv;
                while (true){
                    System.out.print("Please, enter CVV: ");
                    inputCvv = sc.nextLine();
                    if(vs.validCardCvv(inputCvv)) {
                        cvv = inputCvv;
                        break;
                    }
                }

                String expiryDate , inputExpiryDate;
                while (true){
                    System.out.print("Please, enter expiry date: ");
                     inputExpiryDate = sc.nextLine();
                    if(vs.validDate(inputExpiryDate)) {
                        expiryDate = inputExpiryDate;
                        break;
                    }
                }

                BankAccount bankAccount = new BankAccount(accountNumber++, bankName, userId, cardNumber, cvv, expiryDate);
                investor.addBankAccount(bankAccount);
                break;

            } else if (choice.equals("2")) {

                int accNumber; String inputAccNumber;
                while (true){
                    System.out.print("Please, enter account number: ");
                    inputAccNumber = sc.nextLine();
                    if(vs.isNumber(inputAccNumber)) {
                        accNumber = Integer.parseInt(inputAccNumber);
                        break;
                    }
                }
                investor.removeBankAccount(accNumber);
                break;

            }else if (choice.equals("3")) {
                investor.displayBankAccounts();
                break;
            }
            else if (choice.equals("4")){
                System.out.println("\n***************************************************************\n\n");
                break ; 
            }
            System.out.println("Invalid choice. Try again.");
        }
    }
}
