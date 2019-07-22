package vehicles;

public abstract class Vehicle {
    protected double fuel;
    protected double fuelConsumption;

    protected Vehicle(double fuel, double fuelConsumption) {
//
        setFuel(fuel);
        setFuelConsumption(fuelConsumption);
    }

    protected abstract void setFuelConsumption(double fuelConsumption);

    protected  void setFuel(double fuel){
        this.fuel=fuel;
    }
    public  abstract void refuel(Double liters);

    public double getFuel() {
        return fuel;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }
}
