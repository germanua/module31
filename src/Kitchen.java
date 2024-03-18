import java.util.List;
public class Kitchen {
    public static void prepareOrder(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("No items in the order.");
            return;
        }

        int totalPreparationTime = 0;
        for (Product product : products) {
            totalPreparationTime += product.getPreparationTime();
        }
        int averagePreparationTime = totalPreparationTime / products.size();
        System.out.println("Estimated preparation time: " + averagePreparationTime + " minutes");
    }
}
