import java.util.Scanner;

public class Customer {

    private String name;
    private String mobileNumber;

    Scanner input = new Scanner(System.in);

    public Customer() {
        setName();
        setMobileNo();
    }

    public String getName() {
        return name;
    }

    public void setName() {
        System.out.println("Enter your name: ");
        this.name = input.nextLine();
    }

    public String getMobileNo() {
        return mobileNumber;
    }

    public void setMobileNo() {
        while (true) {
            System.out.print("Enter your PhoneNumber: ");
            this.mobileNumber = input.nextLine();
            if (mobileNumber.matches("\\d{10}")) {
                break;
            } else {
                System.out.println("Enter a valid input");
            }
        }
    }
}
