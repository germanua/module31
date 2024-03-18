public class Product {
    private String name;
    private int preparationTime; // in minutes

    public Product(String name, int preparationTime) {
        this.name = name;
        this.preparationTime = preparationTime;
    }

    public String getName() {
        return name;
    }

    public int getPreparationTime() {
        return preparationTime;
    }
}
