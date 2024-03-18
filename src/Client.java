import java.util.List;

public class Client implements OrderObserver {
    private Cart cart;

    public Client() {
        this.cart = new Cart();
    }

    public void addToCart(Product product) {
        cart.addProduct(product);
    }

    public void placeOrder(Waiter waiter, Order order, DeliveryStrategy deliveryStrategy) {
        List<Product> orderItems = order.getProducts(); // Extract the list of products from the Order object
        waiter.takeOrder(orderItems, deliveryStrategy);
    }

    @Override
    public void update(Order order) {
        System.out.println("Order status updated: " + order.getState());
    }
}
