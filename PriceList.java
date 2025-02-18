public class PriceList {
    public static double itemPrice(String itemName) {
        switch (itemName) {
            case "Chicken Rice":
                return 120.0;
            case "Chicken Biryani":
                return 150.0;
            case "Mutton Biryani":
                return 200.0;
            case "Chicken Tandoori":
                return 225.0;
            case "Vegetable Rice":
                return 120.0;
            case "Vegetable Soup":
                return 150.0;
            case "Vegetable Sandwich":
                return 100.0;
            case "Kimchi":
                return 220.0;
            default:
                return 0.0;
        }
    }
}
