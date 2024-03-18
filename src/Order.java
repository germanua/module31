import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> products;
    private OrderState state;
    private List<OrderObserver> observers;

    public Order(List<Product> products) {
        this.products = products;
        this.state = new ProcessingState();
        this.observers = new ArrayList<>();
    }

    public void setState(OrderState state) {
        this.state = state;
        notifyObservers();
    }

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public OrderState getState() {
        return state;
    }
}
