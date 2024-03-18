public class PreparingState implements OrderState {
    @Override
    public void handle(Order order) {
        System.out.println("Order is being prepared.");
        order.setState(new DeliveredState());
    }
}