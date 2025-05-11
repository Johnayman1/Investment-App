package investwise.controller;

import java.util.Scanner;
import investwise.user.Investor;
import investwise.Goal.Manage_FinancialGoal;
import investwise.asset.Manage_Asset;
import investwise.bank.Manage_Bank;

public class Dashboard {

    public void dashboard(){

        Scanner sc = new Scanner(System.in);
        Investor investor = new Investor();
        String choice;


        while (true) {

            System.out.println("\n\n---------------------------Your DashBoard---------------------------");
            System.out.println("\n1) Assets");
            System.out.println("2) Bank Account");
            System.out.println("3) Financial Goal");
            System.out.println("4) Zakat Calculation");
            System.out.println("5) Exit");

            System.out.print("\nPlease enter your choice: ");
            choice = sc.nextLine();

            if (choice.equals("1")) {

                Manage_Asset asset = new Manage_Asset();
                asset.asset(investor);

            } else if (choice.equals("2")) {

                Manage_Bank bank = new Manage_Bank();
                bank.Bank(investor);

            }else if (choice.equals("3")) {
          
                 Manage_FinancialGoal goals = new Manage_FinancialGoal();
                 goals.financialGoal(investor);
                 
            } else if (choice.equals("4")) {

                double netAssets = investor.calculateTotalAssets();
                double zakat = investor.zakatCalculator.calculateZakat(netAssets);
                System.out.println("Your Zakat is: " + zakat);

            } else if (choice.equals("5")) {
                System.out.println("************* Thanks for using our Investment App ******************************\n\n");
                return;
            }
        }
    }

}