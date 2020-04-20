package models.view;

public class CarViewModel {
    private String userUsername;

    private String brand;

    private String model;

    private int year;

    private String engine;

    public CarViewModel() {
    }

    public CarViewModel(String userUsername, String brand, String model, int year, String engine) {
        this.userUsername = userUsername;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engine = engine;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }
}
