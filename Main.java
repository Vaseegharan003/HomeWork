import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int count = 0;
        Items[] totalItems = new Items[50]; 
        Scanner input = new Scanner(System.in);
        Items item;

        Customer customer = new Customer();
        System.out.println("Enter the foodtype:");
        String foodType = input.nextLine().toLowerCase();

        if (foodType.equals("nonveg")) {
            String[] nonVegItems = {"Chicken Rice", "Chicken Biryani", "Mutton Biryani", "Chicken Tandoori"};
            selectItems(nonVegItems, totalItems, count, input);

        } else if (foodType.equals("veg")) {
            String[] vegItems = {"Vegetable Rice", "Vegetable Soup", "Vegetable Sandwich", "Kimchi"};
            selectItems(vegItems, totalItems, count, input);

        } else {
            System.out.println("Food type not available");
        }

        BillGenerator.totalBill(totalItems, customer);
        input.close();
    }

    public static void selectItems(String[] items, Items[] totalItems, int count, Scanner input) {
        int quantity;
        int choice;
        char addMore;
        Items item;

        do {
            System.out.println("\n\t\t**S.A Restaurant**      \nno.40, Medavakkam mainroad, chennai - 600117.\nPhone : 1234567890");
            System.out.println("----------------------------------------------");

            for (int i = 0; i < items.length; i++) {
                System.out.println((i + 1) + ". " + items[i] + " - ₹" + PriceList.itemPrice(items[i]));
            }

            // Validate item number
            do {
                System.out.print("Select the item number: ");
                while (!input.hasNextInt()) {
                    System.out.println("Invalid input. Select the item number again.");
                    input.next();
                }
                choice = input.nextInt();
                if (choice < 1 || choice > items.length) {
                    System.out.println("Invalid choice.");
                }
            } while (choice < 1 || choice > items.length);

            do {
                System.out.print("Enter the quantity: ");
                if (!input.hasNextInt()) {
                    System.out.println("Enter a valid quantity.");
                    input.next();
                }
            } while (!input.hasNextInt());

            String selectedItem = items[choice - 1];
            quantity = input.nextInt();

            // Handle adding the item to the list of ordered items
            if (!Items.search(totalItems, selectedItem, quantity)) {
                item = new Items(selectedItem, PriceList.itemPrice(selectedItem), quantity);
                totalItems[count] = item;
                count++;
                item.subTotalBill();
            }

            // Ask if the user wants to add more items
            do {
                System.out.print("Do you want to add more items? (Y/N): ");
                addMore = input.next().charAt(0);
                if (addMore != 'Y' && addMore != 'y' && addMore != 'N' && addMore != 'n') {
                    System.out.println("Invalid input. Please enter 'Y' for yes (or) 'N' for no.");
                }
            } while (addMore != 'Y' && addMore != 'y' && addMore != 'N' && addMore != 'n');

        } while (addMore == 'Y' || addMore == 'y');
    }
}
