package model;

public class Orders {
    private String id;
    private String dateTime;

    public Orders(String id, String dateTime) {
        this.id = id;
        this.dateTime = dateTime;
    }

    public String getId() {
        return id;
    }

    public String getDateTime() {
        return dateTime;
    }
}
