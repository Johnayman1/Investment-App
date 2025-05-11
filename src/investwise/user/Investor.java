package investwise.user;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;

import investwise.asset.Asset;
import investwise.asset.Risk;
import investwise.Goal.FinancialGoal;
import investwise.bank.BankAccount;
import investwise.zakat.ZakatCalculator;
import investwise.controller.ValidationService;

public class Investor extends User {

    private List<Asset> portfolio = new ArrayList<>();
    private List<FinancialGoal> goals = new ArrayList<>();
    private List<BankAccount> bankAccounts = new ArrayList<>();
    public ValidationService validationService;
    public ZakatCalculator zakatCalculator;

    public Investor() {
        this.zakatCalculator = new ZakatCalculator();
    }

    // --------------------- Sign Up Method ---------------------

    @Override
    public void signup(String name, String email, String username, String password) {
        Path filePath = Paths.get("C:\\Users\\COMPUMARTS\\Projects\\investwise\\Investment-App\\src\\investwise\\users.txt");

        if (Files.exists(filePath)) {
            try (Stream<String> lines = Files.lines(filePath)) {
                boolean userExists = lines.anyMatch(line -> {
                    String[] parts = line.split(",");
                    return parts.length >= 4 && (parts[1].equals(email) || parts[2].equals(username));
                });

                if (userExists) {
                    System.out.println("\n\nError: Email or username already registered.");
                    return;
                }
            } catch (IOException e) {
                System.out.println("\n\nError checking existing users: " + e.getMessage());
                return;
            }
        }

        try (FileWriter writer = new FileWriter(filePath.toFile(), true)) {
            String userData = String.join(",", name, email, username, password) + "\n";
            writer.write(userData);
            writer.flush();

            String lastLine = Files.readAllLines(filePath).get(Files.readAllLines(filePath).size() - 1);
            if (lastLine.trim().equals(userData.trim())) {
                System.out.println("\n\nRegistration successful!");
            } else {
                System.out.println("\n\nWarning: Registration data verification failed.");
            }
        } catch (IOException e) {
            System.out.println("\n\nCritical error during registration: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // --------------------- Log In Method ---------------------

    @Override
    public boolean login(String inputEmail, String inputPassword) {
        boolean loginSuccess = false;

        try (Scanner scanner = new Scanner(new File("C:\\Users\\COMPUMARTS\\Projects\\investwise\\Investment-App\\src\\investwise\\users.txt"))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                if (parts.length >= 4 &&
                        parts[1].equals(inputEmail) &&
                        parts[3].equals(inputPassword)) {

                    this.email = inputEmail;
                    this.password = inputPassword;
                    this.name = parts[0];

                    loginSuccess = true;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("\nError: User database not found.");
        }

        if (!loginSuccess) {
            System.out.println("\nLogin failed. Do you already have an account?");
        }
        return loginSuccess;
    }

    // --------------------- Asset Methods ---------------------

    public void addAsset(Asset asset) {
        portfolio.add(asset);
        System.out.println("\nAsset added to your portfolio\n");
    }

    public void removeAsset(int assetID) {
        for (Asset asset : portfolio) {
            if (asset.getAssetID() == assetID) {
                portfolio.remove(asset);
                System.out.println("\nAsset Deleted successfully.\n");
                return;
            }
        }
        System.out.println("\nAsset not found.\n");
    }

    public void editAsset(int assetID, String newName, String newType) {
        for (Asset asset : portfolio) {
            if (asset.getAssetID() == assetID) {
                asset.setName(newName);
                asset.setType(newType);
                System.out.println("\nAsset updated successfully.\n");
                return;
            }
        }
        System.out.println("\nAsset not found.\n");
    }

    public double calculateTotalAssets() {
        return portfolio.stream().mapToDouble(Asset::getPurchasePrice).sum();
    }

    // --------------------- Risk Asset Methods ---------------------

    public void addRiskAsset(int assetID, String strategy, double riskScore, 
                           String name, String type, int quantity, 
                           int purchasePrice, String purchaseDate) {
        Risk riskAsset = new Risk(assetID, strategy, riskScore, name, type, 
                                 quantity, purchasePrice, purchaseDate);
        portfolio.add(riskAsset);
        System.out.println("\nRisk asset added to your portfolio");
    }

    public void printAllRiskAssets() {
        System.out.println("\n=== Your Risk Assets ===");
        boolean hasRiskAssets = false;
        
        for (Asset asset : portfolio) {
            if (asset instanceof Risk) {
                ((Risk) asset).printRiskDetails();
                hasRiskAssets = true;
            }
        }
        
        if (!hasRiskAssets) {
            System.out.println("No risk assets found in your portfolio.");
        }
    }

    public double calculateTotalRiskScore() {
        return portfolio.stream()
                .filter(asset -> asset instanceof Risk)
                .mapToDouble(asset -> ((Risk) asset).getRiskScore())
                .average()
                .orElse(0.0);
    }
    

    // --------------------- Bank Account Methods ---------------------

    public void addBankAccount(BankAccount bankAccount) {
        bankAccounts.add(bankAccount);
        System.out.println("\nBank account added.\n");
    }

    public void removeBankAccount(int accountNumber) {
        for (BankAccount account : bankAccounts) {
            if (account.getAccountNumber() == accountNumber) {
                bankAccounts.remove(account);
                System.out.println("\nBank account deleted Successfully.\n");
                return;
            }
        }
        System.out.println("\nBank account not found.\n");
    }

    // --------------------- Financial Goal Methods ---------------------

    public void addGoal(FinancialGoal goal) {
        goals.add(goal);
        System.out.println("\nGoal added: " + goal.getDescription() + " with target $" + goal.getTargetAmount());
    }

    public void updateGoal(int goalID, String newDescription, double newTargetAmount) {
        for (FinancialGoal goal : goals) {
            if (goal.getGoalID() == goalID) {
                goal.setDescription(newDescription);
                goal.setTargetAmount(newTargetAmount);
                System.out.println("\nGoal updated.");
                return;
            }
        }
        System.out.println("\nGoal not found.");
    }

    public void deleteGoal(int goalID) {
        for (FinancialGoal goal : goals) {
            if (goal.getGoalID() == goalID) {
                goals.remove(goal);
                System.out.println("\nGoal deleted: " + goal.getDescription());
                return;
            }
        }
        System.out.println("\nGoal not found.");
    }

}
