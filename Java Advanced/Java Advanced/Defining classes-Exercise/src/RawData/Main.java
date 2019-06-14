package RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Car>data=new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input=reader.readLine().split(" ");
            String model=input[0];
            int engineSpeed= Integer.parseInt(input[1]);
            int enginePower=Integer.parseInt(input[2]);
            int cargoWeight=Integer.parseInt(input[3]);
            String cargoType=input[4];
            double tire1Presure=Double.parseDouble(input[5]);
            int tire1Age=Integer.parseInt(input[6]);
            double tire2Presure=Double.parseDouble(input[7]);
            int tire2Age=Integer.parseInt(input[8]);
            double tire3Presure=Double.parseDouble(input[9]);
            int tire3Age=Integer.parseInt(input[10]);
            double tire4Presure=Double.parseDouble(input[11]);
            int tire4Age=Integer.parseInt(input[12]);

            Engine engine=new Engine(engineSpeed,enginePower);
            Cargo cargo=new Cargo(cargoWeight,cargoType);
            Tires tires=new Tires(tire1Presure,tire1Age,tire2Presure,tire2Age,tire3Presure,tire3Age,tire4Presure,tire4Age);

            Car car=new Car(model,engine,cargo,tires);
            data.add(car);




        }
        String command=reader.readLine();
        switch (command){
            case "fragile":
                data.stream().forEach(e->{
                    if(e.getCargo().getCargoType().equals("fragile")&&e.getTires().getTire1Presure()<1 || e.getTires().getTire2Presure()<1||e.getTires().getTire3Presure()<1||e.getTires().getTire4Presure()<1){
                        System.out.println(e.getModel());
                    }
                });

                break;


            case "flamable":
                data.stream().forEach(e->{
                    if(e.getEngine().getEnginePower()>250 && e.getCargo().getCargoType().equals("flamable")){
                        System.out.println(e.getModel());
                    }
                });

                break;
        }
    }
}
