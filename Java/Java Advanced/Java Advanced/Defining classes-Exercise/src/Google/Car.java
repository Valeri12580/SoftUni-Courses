package Google;

public class Car {
    private String model;
    private int maxSpeed;

    Car(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    String getInfo() {
        return String.format("%s %d", this.model, this.maxSpeed);
    }
}
