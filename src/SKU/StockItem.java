package SKU;

import java.util.UUID;

public class StockItem {

    private char item;
    private String itemId;
    private float unitPrice;

    public StockItem(char item, float unitPrice) {
        this.item = item;
        this.itemId = UUID.randomUUID().toString(); //initializing a unique random identifier for each stock item
        this.unitPrice = unitPrice;
    }

    public String getItemId() {
        return itemId;
    }
    public char getItem() {
        return item;
    }
    public float getUnitPrice() {
        return unitPrice;
    }

}
