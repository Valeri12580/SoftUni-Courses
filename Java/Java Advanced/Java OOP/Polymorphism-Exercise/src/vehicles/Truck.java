package vehicles;

public class Truck extends Vehicle {
    public Truck(double fuel, double fuelConsumption) {
        super(fuel, fuelConsumption);
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption=fuelConsumption+1.6;
    }



    @Override
    public void refuel(Double liters) {
        double newValue=liters-(liters*0.95);
        setFuel(newValue+this.getFuel());

    }
}
