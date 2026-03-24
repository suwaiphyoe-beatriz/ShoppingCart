import java.util.*;

public class ShoppingCart {

    public static double calculateItemTotal(double price, int quantity) {
        return price * quantity;
    }

    public static double calculateCartTotal(List<Double> totals) {
        double sum = 0;
        for (double t : totals) {
            sum += t;
        }
        return sum;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Select language: en, fi, sv, ja");
        String lang = scanner.nextLine();

        Locale locale;

        switch (lang) {
            case "fi":
                locale = new Locale("fi", "FI");
                break;
            case "sv":
                locale = new Locale("sv", "SE");
                break;
            case "ja":
                locale = new Locale("ja", "JP");
                break;
            default:
                locale = new Locale("en", "US");
        }

        ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);

        System.out.println(messages.getString("enter_items"));
        int items = scanner.nextInt();

        List<Double> totals = new ArrayList<>();

        for (int i = 0; i < items; i++) {

            System.out.println(messages.getString("enter_price"));
            double price = scanner.nextDouble();

            System.out.println(messages.getString("enter_quantity"));
            int quantity = scanner.nextInt();

            double itemTotal = calculateItemTotal(price, quantity);
            totals.add(itemTotal);
        }

        double cartTotal = calculateCartTotal(totals);

        System.out.println(messages.getString("total_cost") + " " + cartTotal);
    }
}