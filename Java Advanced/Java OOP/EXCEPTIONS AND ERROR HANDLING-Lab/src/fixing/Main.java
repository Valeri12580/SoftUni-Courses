package fixing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        String[]weekdays={"Monday","Tuesday","Wednesday","Thursday","Friday"};
        try {
            for (int i = 0; i <weekdays.length; i++) {
                System.out.println(weekdays[i]);
            }
        }catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Invalid index length");
        }




    }
}
