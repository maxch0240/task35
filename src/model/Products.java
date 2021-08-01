package model;

public class Products {
    private String id;
    private String name;
    private int pricePerUnit;

    public Products(String id, String name, int pricePerUnit) {
        this.id = id;
        this.name = name;
        this.pricePerUnit = pricePerUnit;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPricePerUnit() {
        return pricePerUnit;
    }
}
