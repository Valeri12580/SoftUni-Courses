package vehicle;

public class Vehicle {
    protected final static double  DEFAULT_FUEL_CONSUMPTION=1.25;
    protected double  fuelConsumption;
    protected double fuel;
    protected  int horsePower;

    public Vehicle(double fuel,int horsePower){
        this.fuelConsumption=DEFAULT_FUEL_CONSUMPTION;
        this.horsePower=horsePower;
        this.fuel=fuel;
    }


    public static double getDefaultFuelConsumption() {
        return DEFAULT_FUEL_CONSUMPTION;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
}
