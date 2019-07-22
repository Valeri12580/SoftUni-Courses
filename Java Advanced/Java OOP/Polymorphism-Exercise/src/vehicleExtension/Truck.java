package vehicleExtension;

public class Truck extends Vehicle {


    public Truck(double fuel, double fuelConsumption, double tankCapacity) {
        super(fuel, fuelConsumption, tankCapacity);
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption + 1.6;
    }


    @Override
    public void refuel(Double liters) {
        double newValue = liters*0.95;
        if(liters<=0){
            System.out.println("Fuel must be a positive number");
        }else  if(newValue+this.getFuel()>this.tankCapacity){
            System.out.println("Cannot fit fuel in tank");
        }else{
            setFuel(newValue + this.getFuel());
        }



    }
}
