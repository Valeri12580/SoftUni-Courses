package vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String[] carInformation=reader.readLine().split(" ");
        Vehicle car=new Car(Double.parseDouble(carInformation[1]),Double.parseDouble(carInformation[2]));

        String[]truckInformation=reader.readLine().split(" ");

        Vehicle truck=new Truck(Double.parseDouble(truckInformation[1]),Double.parseDouble(truckInformation[2]));
        DecimalFormat df=new DecimalFormat("#.##");

        int n=Integer.parseInt(reader.readLine());

        for (int i = 0; i <n; i++) {
            String[] input=reader.readLine().split(" ");
            String command=input[0];
            String vehicleType=input[1];
            double value=Double.parseDouble(input[2]);

            switch (command){
                case "Drive":
                    if(vehicleType.equals("Car")){
                        if(value*car.fuelConsumption<=car.fuel){
                            System.out.printf("Car travelled %s km%n",df.format(value));
                            car.setFuel(car.getFuel()-(value*car.fuelConsumption));
                        }else{
                            System.out.println("Car needs refueling");
                        }
                    }else{
                        if(value*truck.fuelConsumption<=truck.getFuel()){
                            System.out.printf("Truck travelled %s km%n",df.format(value));
                            truck.setFuel(truck.getFuel()-value*truck.fuelConsumption);
                        }else{
                            System.out.println("Truck needs refueling");

                        }


                    }
                    break;



                case "Refuel":
                    if(vehicleType.equals("Car")){
                        car.refuel(value);

                    }else{
                        truck.refuel(value);

                    }

                    break;


            }


        }



        System.out.printf("Car: %.2f%n",car.getFuel());
        System.out.printf("Truck: %.2f",truck.getFuel());
    }
}
