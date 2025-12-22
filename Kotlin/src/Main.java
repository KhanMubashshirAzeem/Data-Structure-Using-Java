import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        productIn();
    }

    private static void productIn() {
        Scanner sc = new Scanner(System.in);

        // Input base price
        System.out.print("\nEnter base price: ");
        float basePrice = sc.nextFloat();

        // Input GST choice
        System.out.print("\nAdd GST? (1 = Yes, 0 = No): ");
        int addGst = sc.nextInt();

        float withGstPrice;

        if (addGst == 1) {
            // Ask user for GST percentage
            System.out.print("\nEnter GST percentage (%): ");
            float gstPercent = sc.nextFloat();

            float gstAmount = basePrice * (gstPercent / 100);
            withGstPrice = basePrice + gstAmount;

            System.out.print("\nGST added (" + gstPercent + "%). Price with GST: " + withGstPrice);
        } else {
            withGstPrice = basePrice;
            System.out.print("\nGST not added. Price: " + withGstPrice);
        }

        // Input transport cost
        System.out.print("\nEnter transport cost: ");
        float transport = sc.nextFloat();

        float finalPrice = withGstPrice + transport;

        System.out.print("\nFinal price after adding transport: " + finalPrice);
    }
}
