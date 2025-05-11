
package investwise.controller;

import java.io.*;

public class ValidationService {

    private static final String FILE_NAME = "users.txt";

// ----------------------------------------------- Validation of Email

    public boolean validEmail(String email) {
        if (email == null) return false;
        String emailRegex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }

// ----------------------------------------------- Validation of Password

    public boolean validPassword(String password) {
        if (password == null || password.length() < 8) {
            System.out.println("lengh of Password Must be more than 7 ");
            return false;
        }else return true ;

    }

// ----------------------------------------------- Check Mail
  
    public boolean checkMail(String mail) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2 && parts[1].equals(mail)) {
                    return true;
                }
            }
        } catch (IOException e) {
        }
        return false;
    }

// ----------------------------------------------- Check Password
   
    public boolean checkPassword(String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3 && parts[2].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
        }
        return false;
    }

// ----------------------------------------------- Is Number
    public boolean isNumber(String number) {
        try {
            int num = Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Invalid value, please enter a number.");
            return false;
        }
    }

// ----------------------------------------------- Valid Asset Type
  
    public boolean validAssetType(String type){
        if(type.equals("(Stocks") || type.equals("RealEstate") || type.equals("Crypto") || type.equals("Gold")){
            return true;
        }else{
            System.out.println("Invalid asset type!! . Please enter a valid asset type.");
            return false;
        }
    }

// ----------------------------------------------- Valid Card Number
    
    public boolean validCardNumber(String account) {
        if(account != null && account.matches("\\d{16}")) return true;
        else{
            System.out.println("Invalid card number!! Please enter a valid card number.");
            return false;
        }
    }

// ----------------------------------------------- Valid Card Cvv
 
    public boolean validCardCvv(String cvv) {
        if(cvv != null && cvv.matches("\\d{3}")) return true ;
        else{
            System.out.println("Invalid card cvv!! Please enter a valid card cvv.");
            return false;
        }
    }

// ----------------------------------------------- Valid Date
    
    public boolean validDate(String expiryDate) {
        if(expiryDate != null && expiryDate.matches("^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-\\d{4}$")){
            return true;
        }
        else{
            System.out.println("Invalid date format!! Please enter a valid date.");
            return false;
        }
    }

// ----------------------------------------------- Is Double
     
    public boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
