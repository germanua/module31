public class ProcessingState implements OrderState {
    @Override
    public void handle(Order order) {
        System.out.println("Order is being processed.");
        order.setState(new PreparingState());
    }
}
