package investwise.asset;

public class Risk extends Asset {
    private String strategy;
    private double riskScore;

    public Risk(int assetID, String strategy, double riskScore, String name, 
               String type, int quantity, int purchasePrice, String purchaseDate) {
        super(assetID, name, type, quantity, purchasePrice, purchaseDate);
        this.strategy = strategy;
        this.riskScore = riskScore;
    }

    public void printRiskDetails() {
        System.out.println("\n--- Risk Asset Details ---");
        System.out.println("ID: " + getAssetID());
        System.out.println("Name: " + getName());
        System.out.println("Type: " + getType());
        System.out.println("Strategy: " + strategy);
        System.out.println("Risk Score: " + riskScore);
        System.out.println("Quantity: " + getQuantity());
        System.out.println("Purchase Price: $" + getPurchasePrice());
        System.out.println("Purchase Date: " + getPurchaseDate());
        System.out.println("Risk Category: " + getRiskCategory());
        System.out.println("-----------------------");
    }

    public String getRiskCategory() {
        if (riskScore < 3) return "Low";
        if (riskScore < 7) return "Medium";
        return "High";
    }

    @Override
    public String toString() {
        return String.format("Risk Asset [ID: %d, Name: %s, Risk: %.1f (%s), Strategy: %s]",
                getAssetID(), getName(), riskScore, getRiskCategory(), strategy);
    }
   
    // Getters
    public String getStrategy() {
        return strategy;
    }

    public double getRiskScore() {
        return riskScore;
    }

    // Setters
    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public void setRiskScore(double riskScore) {
        this.riskScore = riskScore;
    }
}