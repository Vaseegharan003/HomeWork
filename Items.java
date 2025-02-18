public class Items {
    private String foodName;
    private double foodPrice;
    private int quantity;
    private double subTotal;
    private static double totalBill;

    public Items(String foodName, double foodPrice, int quantity) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.quantity = quantity;
        this.subTotal = quantity * foodPrice;
        totalBill += subTotal;
    }

    public static void setTotalBill(double subTotal) {
        totalBill += subTotal;
    }

    public static double getBeforeTaxBill() {
        return totalBill;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void subTotalBill() {
        System.out.println("Item name: " + foodName + ", Item Price: " + foodPrice + ", Quantity: " + quantity + ", Sub Total: " + subTotal);
    }

    public String getItemName() {
        return foodName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getFoodCost() {
        return foodPrice;
    }

    public void setQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void setSubTotal(int quantity, double foodPrice) {
        subTotal = quantity * foodPrice;
    }

    // To search if the food already added in bill increase the item and return true else false
    public static boolean search(Items[] items, String foodName, int quantity) {
        for (Items item : items) {
            if (item != null && item.getItemName().equals(foodName)) {
                item.setQuantity(quantity);
                item.setSubTotal(item.getQuantity(), PriceList.itemPrice(foodName));
                Items.setTotalBill(quantity * PriceList.itemPrice(foodName));
                item.subTotalBill();
                return true;
            }
        }
        return false;
    }
}
