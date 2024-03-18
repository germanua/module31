import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FoodOrderingSystem {
    public static void main(String[] args) {
        // Create components
        Client client = new Client();
        Waiter waiter = new Waiter();
        Scanner scanner = new Scanner(System.in);

        // Display menu and take order
        System.out.println("Welcome to the Food Ordering System!");
        List<Product> orderItems = new ArrayList<>();

        while (true) {
            displayMenu();
            String choice = getUserChoice(scanner);

            // Add selected dish to cart
            Product selectedProduct = getMenuSelection(choice);
            if (selectedProduct != null) {
                orderItems.add(selectedProduct);
                System.out.println("You have added " + selectedProduct.getName() + " to your order.");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

            // Ask if the user wants to add more items or finalize the order
            System.out.print("Would you like to add more items? (Y/N): ");
            String moreItems = scanner.nextLine().toUpperCase();
            if (!moreItems.equals("Y")) {
                break;
            }
        }

        // Create an Order object with the selected products
        Order order = new Order(orderItems);

        // Choose delivery method
        System.out.println("Choose delivery method:");
        System.out.println("1. Self-pickup");
        System.out.println("2. Courier delivery");
        System.out.print("Enter your choice: ");
        int deliveryChoice = Integer.parseInt(scanner.nextLine());
        DeliveryStrategy deliveryStrategy = createDeliveryStrategy(deliveryChoice);

        // Place order
        client.placeOrder(waiter, order, deliveryStrategy);
    }

    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Pizza (20 minutes)");
        System.out.println("2. Burger (15 minutes)");
        System.out.println("3. Salad (10 minutes)");
        System.out.print("Enter your choice: ");
    }

    private static String getUserChoice(Scanner scanner) {
        return scanner.nextLine();
    }

    private static Product getMenuSelection(String choice) {
        switch (choice) {
            case "1":
                return new Product("Pizza", 20);
            case "2":
                return new Product("Burger", 15);
            case "3":
                return new Product("Salad", 10);
            default:
                return null;
        }
    }

    private static DeliveryStrategy createDeliveryStrategy(int choice) {
        switch (choice) {
            case 1:
                return new SelfPickupStrategy();
            case 2:
                return new CourierDeliveryStrategy();
            default:
                throw new IllegalArgumentException("Invalid delivery method choice.");
        }
    }
}
