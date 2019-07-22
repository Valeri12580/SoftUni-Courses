package vehicleExtension;

public class Bus extends Vehicle {
    protected Bus(double fuel, double fuelConsumption, double tankCapacity) {
        super(fuel, fuelConsumption, tankCapacity);
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption=fuelConsumption;

    }




    @Override
    public void refuel(Double liters) {
        if(liters<=0){
            System.out.println("Fuel must be a positive number");
        }else if(getFuel()+liters>this.tankCapacity){
            System.out.println("Cannot fit fuel in tank");
        }else{
            this.setFuel(getFuel()+liters);
        }

    }
}
