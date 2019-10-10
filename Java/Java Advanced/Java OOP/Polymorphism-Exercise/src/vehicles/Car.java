package vehicles;

public class Car extends Vehicle {


    public Car(double fuel, double fuelConsumption) {
        super(fuel, fuelConsumption);
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption=fuelConsumption+0.9;

    }



    @Override
    public void refuel(Double liters) {
        this.setFuel(getFuel()+liters);

    }
}
