public interface DeliveryStrategy {
    void deliver();
}

class SelfPickupStrategy implements DeliveryStrategy {
    @Override
    public void deliver() {
        System.out.println("Self-pickup: Ready for collection.");
    }
}

class CourierDeliveryStrategy implements DeliveryStrategy {
    @Override
    public void deliver() {
        System.out.println("Courier delivery: Out for delivery.");
    }
}
