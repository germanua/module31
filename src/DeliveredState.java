public class DeliveredState implements OrderState {
    @Override
    public void handle(Order order) {
        System.out.println("Order has been delivered.");
    }
}