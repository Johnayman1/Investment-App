package investwise.asset;

import java.util.Scanner;
import investwise.user.Investor;
import investwise.controller.ValidationService;

public class Manage_Asset {

// ----------------------------------------------- Management

    public void asset(Investor investor) {
        ValidationService vs = new ValidationService();
        Scanner sc = new Scanner(System.in);
        String choice;

        System.out.println("\n\n-------------------------- Assets Management --------------------------");
        
        while(true) {
            System.out.println("\n1) Add Regular Assets");
            System.out.println("2) Add Risk Assets");
            System.out.println("3) Edit Assets");
            System.out.println("4) Remove Assets");
            System.out.println("5) Calculate Total Assets");
            System.out.println("6) View Risk Assets");
            System.out.println("7) Exit");

            System.out.print("\nPlease, Please, enter your choice: ");
            choice = sc.nextLine();

            switch(choice) {
                case "1": // Add Regular Assets
                    addRegularAssets(investor, vs, sc);
                    break;
                    
                case "2": // Add Risk Assets
                    addRiskAssets(investor, vs, sc);
                    break;
                    
                case "3": // Edit Assets
                    editAssets(investor, vs, sc);
                    break;
                    
                case "4": // Remove Assets
                    removeAssets(investor, sc);
                    break;
                    
                case "5": // Calculate Total Assets
                    calculateTotalAssets(investor);
                    break;
                    
                case "6": // View Risk Assets
                    investor.printAllRiskAssets();
                    break;
                    
                case "7": // Exit
                    System.out.println("***************************************************************\n\n");
                    return;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

// ----------------------------------------------- Add Regular Assets

    private void addRegularAssets(Investor investor, ValidationService vs, Scanner sc) {

        String number , purchaseDate , name, type;
        int num, quantity = 0 , purchasePrice;

        while (true) {
            System.out.print("\nPlease, enter the number of assets: ");
            number = sc.nextLine();
            if (vs.isNumber(number)) {
                num = Integer.parseInt(number);
                break;
            }
        }
        
        System.out.println("\nAssets will take ids from 1 to " + num + "!");
        for (int i = 0; i < num; i++) {
            String price, date, quant;
            
            System.out.print("\nPlease, enter name of asset number " + (i + 1) + ": ");
            name = sc.nextLine();

            do {
                System.out.print("\nPlease, enter type of asset (Stocks, RealEstate, Crypto, Gold): ");
                type = sc.nextLine();
            } while (!vs.validAssetType(type));

            while (true) {
                System.out.print("\nPlease, enter quantity of assets: ");
                quant = sc.nextLine();
                if (vs.isNumber(quant)) {
                    quantity = Integer.parseInt(quant);
                    break;
                }
            }

            while (true) {
                System.out.print("\nPlease, enter price of asset: ");
                price = sc.nextLine();
                if (vs.isNumber(price)) {
                    purchasePrice = Integer.parseInt(price);
                    break;
                }
            }

            while (true) {
                System.out.print("\nPlease, enter Purchase Date of asset (dd-MM-yyyy): ");
                date = sc.nextLine();
                if (vs.validDate(date)) {
                    purchaseDate = date;
                    break;
                }
            }
            
            Asset asset = new Asset(i + 1, name, type, quantity, purchasePrice, purchaseDate);
            investor.addAsset(asset);
        }
    }

// ----------------------------------------------- Add Risk Assets

    private void addRiskAssets(Investor investor, ValidationService vs, Scanner sc) {

        String number , name, type, strategy , purchaseDate;
        int num , quantity = 0 , purchasePrice;
        double riskScore;

        while (true) {
            System.out.print("\nPlease, enter the number of risk assets: ");
            number = sc.nextLine();
            if (vs.isNumber(number)) {
                num = Integer.parseInt(number);
                break;
            }
        }
        
        System.out.println("\nRisk assets will take ids from 1 to " + num + "!");
        for (int i = 0; i < num; i++) {
            String price, date, quant, risk;
            
            System.out.print("\nPlease, enter name of risk asset number " + (i + 1) + ": ");
            name = sc.nextLine();

            do {
                System.out.print("\nPlease, enter type of asset (stocks, realEstate, crypto, gold): ");
                type = sc.nextLine();
            } while (!vs.validAssetType(type));

            System.out.print("\nPlease, enter investment strategy : ");
            strategy = sc.nextLine();


            while (true) {
                System.out.print("\nPlease, enter quantity of assets: ");
                quant = sc.nextLine();
                if (vs.isNumber(quant)) {
                    quantity = Integer.parseInt(quant);
                    break;
                }
            }

            while (true) {
                System.out.print("Please Please, enter price of asset: ");
                price = sc.nextLine();
                if (vs.isNumber(price)) {
                    purchasePrice = Integer.parseInt(price);
                    break;
                }
            }

            while (true) {
                System.out.print("Please Please, enter Purchase Date (dd-MM-yyyy): ");
                date = sc.nextLine();
                if (vs.validDate(date)) {
                    purchaseDate = date;
                    break;
                }
            }

            while (true) {
                System.out.print("Please Please, enter risk score (0-10): ");
                risk = sc.nextLine();
                if (vs.isDouble(risk) && Double.parseDouble(risk) >= 0 && Double.parseDouble(risk) <= 10) {
                    riskScore = Double.parseDouble(risk);
                    break;
                }
                System.out.println("Risk score must be between 0 and 10.");
            }
            
            investor.addRiskAsset(i + 1, strategy, riskScore, name, type, quantity, purchasePrice, purchaseDate);
        }
    }

// ----------------------------------------------- Edit Assets

    private void editAssets(Investor investor, ValidationService vs, Scanner sc) {
        System.out.print("Please, enter Asset ID to update: ");
        int assetID = Integer.parseInt(sc.nextLine());

        System.out.print("Please, enter new name: ");
        String newName = sc.nextLine();

        String newType;
        do {
            System.out.print("Please, enter new Type: ");
            newType = sc.nextLine();
        } while (!vs.validAssetType(newType));

        investor.editAsset(assetID, newName, newType);
    }

// ----------------------------------------------- Remove Assets

    private void removeAssets(Investor investor, Scanner sc) {
        System.out.print("Please, enter Asset ID to delete: ");
        int assetID = Integer.parseInt(sc.nextLine());
        investor.removeAsset(assetID);
    }

// ----------------------------------------------- Calculate Total Assets

    private void calculateTotalAssets(Investor investor) {
        double netAssets = investor.calculateTotalAssets();
        System.out.println("Your Total assets: $" + netAssets);
    }
}