import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class BillGenerator {
    static float SGST = 2.5f;
    static float CGST = 2.5f;

    public static double SGST() {
        return (Items.getBeforeTaxBill() * SGST / 100);
    }

    public static double CGST() {
        return (Items.getBeforeTaxBill() * CGST / 100);
    }

    public static double getAfterTaxBill() {
        return Items.getBeforeTaxBill() + CGST() + SGST();
    }

    public static void totalBill(Items[] totalItems, Customer customer) {
        int i = 0;
        System.out.println("\n-----------------------------------------------");
        System.out.println("|\t       **S.A RESTAURANT**\t      |\n|=============================================|\n|no.40, Medavakkam mainroad, chennai - 600117.|\n|Phone\uD83D\uDCDE: 1234567890\t\t\t      |");
        System.out.println("|Customer Name: " + customer.getName() + "\t\t\t      |");
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        Random random = new Random();
        int billNo = random.nextInt(1000 - 100 + 1) + 100;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedTime = currentTime.format(formatter);
        String formattedDate = currentDate.format(formatter1);
        System.out.println("|\t\t\t      Date:" + formattedDate + " |");
        System.out.println("|Billno:" + billNo + "\t\t      Time:" + formattedTime + "   |");
        System.out.println("|=============================================|");
        System.out.println("|Item\t\t\tQty\tRate\tTotal |");
        System.out.println("|---------------------------------------------|");

        while (i < totalItems.length) {
            if (totalItems[i] != null) {
                System.out.println("|" + totalItems[i].getItemName() + "\t\t" + totalItems[i].getQuantity() + "\t" + PriceList.itemPrice(totalItems[i].getItemName()) + "\t" + totalItems[i].getSubTotal() + " |");
                i++;
            } else {
                break;
            }
        }
        System.out.println("|---------------------------------------------|");
        System.out.println("|\t\tSubtotal     - \t" + "\t" + Items.getBeforeTaxBill() + "|");
        System.out.println("|\t\t\t     -----------------|");
        System.out.println("|\t\tSGST(" + BillGenerator.SGST + "%)   -\t" + "\t" + BillGenerator.SGST() + "|");
        System.out.println("|\t\tCGST(" + BillGenerator.CGST + "%)   -\t" + "\t" + BillGenerator.CGST() + "|");
        System.out.println("|\t\t\t     -----------------|");
        System.out.println("|\t\tTotal Amount -\t" + "\t" + (int) BillGenerator.getAfterTaxBill() + "  |");
        System.out.println("|---------------------------------------------|");
        System.out.println("|GST NO 27AADFH5037M1Z8\t\t\t      |");
        System.out.println("|---------------------------------------------|");
        System.out.println("|\t   Thank You Visit Again...\uD83D\uDE0A\uD83D\uDE0A       |");
        System.out.println("'---------------------------------------------'");
    }
}
