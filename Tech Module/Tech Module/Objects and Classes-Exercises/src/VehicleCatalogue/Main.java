package VehicleCatalogue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
       List<blabla> data=new ArrayList<>();
        String[]input=reader.readLine().split(" ");
        int countCars=0;
        int countTrucks=0;

        while (!input[0].equals("End")){

            switch (input[0]){
                case "car":
                    blabla car=new blabla("Car",input[1],input[2],Integer.parseInt(input[3]));
                    data.add(car);
                    countCars++;

                    break;

                case "truck":

                    blabla truck=new blabla("Truck",input[1],input[2],Integer.parseInt(input[3]));
                    data.add(truck);
                    countTrucks++;
                    break;

            }
            input=reader.readLine().split(" ");
        }

        String model=reader.readLine();

        while (!model.equals("Close the Catalogue")){
            String finalModel=model;

            data.stream().filter(v->v.getModel().equals(finalModel)).forEach(System.out::println);





            model=reader.readLine();
        }
        double averageCars=getAverageCars(data,countCars);
        double averageTrucks=getAverageTrucks(data,countTrucks);
        System.out.printf("Cars have average horsepower of: %.2f.%n",averageCars);
        System.out.printf("Trucks have average horsepower of: %.2f.",averageTrucks);

    }

    public static double getAverageCars(List<blabla>data,int counterCars){
        int sum=0;
        if( counterCars==0){
            return 0.0;
        }

        for (blabla cars:data) {
            String getType=cars.getType();
            if(getType.equals("Car")){
                sum+=cars.getHorsepower();
            }


        }
        double result=sum*1.0/counterCars;

        return result;
    }

    public static double getAverageTrucks(List<blabla>data,int counterTrucks){
        int sum=0;
       if( counterTrucks==0){
            return 0.0;
        }


        for (blabla cars:data) {
            String getType=cars.getType();
            if(getType.equals("Truck")){
                sum+=cars.getHorsepower();
            }


        }
        double result=sum*1.0/counterTrucks;

        return result;
    }

}
