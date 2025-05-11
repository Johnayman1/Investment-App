
package investwise.bank;

public class BankAccount {
    private int accountNumber;
    private String bankName;
    private String userId;
    private String cardNumber;
    private String cvv;
    private String expiryDate;

    public BankAccount(int accountNumber, String bankName, String userId, String cardNumber, String cvv, String expiryDate) {
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.userId = userId;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    };

    public int getAccountNumber() {
        return accountNumber;
    };

    public String getBankName() {
        return bankName;
    };

    public String getUserId() {
        return userId;
    };

    public String getCardNumber() {
        return cardNumber;
    };

    public String getCvv() {
        return cvv;
    }

    public String getExpiryDate() {
        return expiryDate;
    }


}
