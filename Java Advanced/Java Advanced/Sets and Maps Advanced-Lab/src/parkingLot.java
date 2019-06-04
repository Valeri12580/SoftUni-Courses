import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class parkingLot {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        Set<String>parkingLot=new HashSet<>();

        String input;

        while (!"END".equals(input=reader.readLine())){
            String[]information=input.split(", ");

            String command=information[0];
            String carNumber=information[1];

            if(command.equals("IN")){
                parkingLot.add(carNumber);

            }else{
                parkingLot.remove(carNumber);

            }
        }
        if(parkingLot.isEmpty()){
            System.out.println("Parking Lot is Empty");

        }

        parkingLot.forEach(System.out::println);

    }
}
