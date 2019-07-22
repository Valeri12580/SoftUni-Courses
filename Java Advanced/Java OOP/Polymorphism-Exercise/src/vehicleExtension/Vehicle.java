package vehicleExtension;

public abstract class Vehicle {
    protected double fuel;
    protected double fuelConsumption;
    protected double tankCapacity;


    protected Vehicle(double fuel, double fuelConsumption,double tankCapacity) {
//
        setFuel(fuel);
        setFuelConsumption(fuelConsumption);
        setTankCapacity(tankCapacity);
    }

    private void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
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
