import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(reader.readLine());
        List<Car>data=new ArrayList<>();



        for (int i = 0; i <n ; i++) {



            String[]input=reader.readLine().split(" ");
            String make=input[0];
            if (input.length > 1) {
                String model = input[1];
                int horsePowers = Integer.parseInt(input[2]);
                Car currentCar=new Car(make,model,horsePowers);
                data.add(currentCar);
            }else{
                Car currentCar=new Car(make);
                Car.type="nishto";
                data.add(currentCar);

            }








        }

        data.forEach(e->{
            System.out.println("static: "+Car.type);
            System.out.println(String.format("The car is: %s %s - %d HP.",e.getMake(),e.getModel(),e.getHorsePower()));
        });

    }
}
