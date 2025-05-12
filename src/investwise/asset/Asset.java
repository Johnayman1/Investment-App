
package investwise.asset;

public class Asset {
    
    private int assetID;
    private String name;
    private String type;
    private int quantity;
    private int purchasePrice;
    private String purchaseDate;


    public Asset(int assetID, String name,String type,int quantity , int purchasePrice,String purchaseDate) {
        this.assetID = assetID;
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.purchasePrice = purchasePrice;
        this.purchaseDate = purchaseDate;
    }

    public void printAssetDetails() {
        System.out.println("ID: " + getAssetID());
        System.out.println("Name: " + getName());
        System.out.println("Type: " + getType());
        System.out.println("Quantity: " + getQuantity());
        System.out.println("Price: $" + getPurchasePrice());
        System.out.println("Purchase Date: " + getPurchaseDate());
    }
    public int getAssetID() { return assetID; }
    public String getName() { return name; }
    public String getType() { return type; }
    public double getQuantity() { return quantity; }
    public int getPurchasePrice() { return purchasePrice; }
    public String getPurchaseDate() { return purchaseDate; }

    public void setName(String name) { this.name = name; }
    public void setType(String type) { this.type = type; }
    public void setValue(int purchasePrice) { this.purchasePrice = purchasePrice; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

}
