package app.domain.models.view;

public class CarViewModel {
    private String brand;

    private int year;

    private String engine;
    private String model;

    public CarViewModel(String brand, int year, String engine, String model) {
        this.brand = brand;
        this.year = year;
        this.engine = engine;
        this.model = model;
    }

    public CarViewModel() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
