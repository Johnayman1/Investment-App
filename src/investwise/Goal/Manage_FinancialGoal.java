package investwise.Goal;

import java.util.Scanner;
import investwise.user.Investor;
import investwise.controller.ValidationService;

public class Manage_FinancialGoal {

    private static int goalID = 1;
    public void financialGoal(Investor investor) {

        ValidationService vs = new ValidationService();
        Scanner sc = new Scanner(System.in);
        String choice;

        System.out.println("\n\n---------------------- Financial Goals Management ----------------------");

        while (true) {

            System.out.println("\n1) Add Financial Goals");
            System.out.println("2) Update Financial Goals");
            System.out.println("3) Delete Financial Goals");
            System.out.println("4) Display Financial Goals");
            System.out.println("5) Exit");

            System.out.print("\nPlease, enter your choice: ");
            choice = sc.nextLine();

            if (choice.equals("1")) {

                String number; int num;
                while (true) {
                    System.out.print("Please enter the number of financial goals: ");
                    number = sc.nextLine();
                    if (vs.isNumber(number)) {
                        num = Integer.parseInt(number);
                        break;
                    }
                }

                for (int i = 0; i < num; i++) {

                    System.out.print("\nEnter the description of Goal ID " + goalID + " : ");
                    String desc = sc.nextLine();

                    String amount;
                    double targetAmount;
                    while (true) {
                        System.out.print("Please enter target amount of Goal ID " + goalID + ": " );
                        amount = sc.nextLine();
                        if (vs.isDouble(amount)) {
                            targetAmount = Double.parseDouble(amount);
                            break;
                        }
                    }

                    FinancialGoal goal = new FinancialGoal(goalID++, desc, targetAmount);
                    investor.addGoal(goal);
                }
                break;

            } else if (choice.equals("2")) {

                System.out.print("Enter Goal ID to update: ");
                int goalID = Integer.parseInt(sc.nextLine());

                System.out.print("Enter new description: ");
                String newDesc = sc.nextLine();

                String amount;
                double newTargetAmount;
                while (true) {
                    System.out.print("Enter new target amount: ");
                    amount = sc.nextLine();
                    if (vs.isDouble(amount)) {
                        newTargetAmount = Double.parseDouble(amount);
                        break;
                    }
                }

                investor.updateGoal(goalID, newDesc, newTargetAmount);
                break;

            } else if (choice.equals("3")) {

                System.out.print("Enter Goal ID to delete: ");
                int goalID = Integer.parseInt(sc.nextLine());

                investor.deleteGoal(goalID);
                break;

            }else if (choice.equals("4")) {
                investor.displayGoals();
                break;
            }
            else if (choice.equals("5")) {
                System.out.println("***************************************************************\n\n");
                break;
            }
            System.out.println("Invalid choice. Try again.");
        }
    }
}
