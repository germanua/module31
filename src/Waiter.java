import java.util.List;
public class Waiter {
    public void takeOrder(List<Product> products, DeliveryStrategy deliveryStrategy) {
        Kitchen.prepareOrder(products);
        deliveryStrategy.deliver();
    }
}
