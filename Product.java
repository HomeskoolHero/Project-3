
import java.util.ArrayList;

/**
 *
 * @author clarencegrimaldo
 */
public class Product {
    private String productName = null;
    private double productPrice = 0.00;
    private int productAmount = 0;
    private String productType = null;

    private static int bookInventory = 0;
    private static int cdInventory = 0;
    private static int dvdInventory = 0;

    public Product(String name, double price, int amount, String type) {
        productName = name;
        productPrice = price;
        productAmount = amount;
        productType = type;

        switch (productType) {
            case "Book":
                bookInventory++;
                break;
            case "CD":
                cdInventory++;
                break;
            case "DVD":
                dvdInventory++;
                break;
        }

    }

    public String getName() {
        return productName;
    }

    public double getPrice() {
        return productPrice;
    }

    public int getAmount() {
        return productAmount;
    }

    public int getBookInventory() {
        return bookInventory;
    }

    public int getCDInventory() {
        return cdInventory;
    }

    public int getDVDInventory() {
        return dvdInventory;
    }

    public String getType() {
        return productType;
    }

    public void setName(String newName) {
        productName = newName;
    }

    public void setPrice(double newPrice) {
        productPrice = newPrice;
    }

    public void setAmount(int amount) {
        productAmount = amount;
    }

    public void setType(String newType) {
        productType = newType;
    }

    public void decreaseAmount() {
        productAmount--;
    }

    public void decreaseBook() {
        bookInventory--;
    }

    public void decreaseCD() {
        cdInventory--;
    }

    public void decreaseDVD() {
        dvdInventory--;
    }

    public String productDisplay() {
        return "(" + productType + ") | " + productName + " | $" +
                productPrice + " | Stock: " + productAmount + " left";
    }
}
