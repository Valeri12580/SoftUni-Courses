package squareRoot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        String input=reader.readLine();
        try {
            int a = Integer.parseInt(input);
            System.out.println(a*a);
        }catch (NumberFormatException ex){
            System.out.println("Invalid number");
        }finally {
            System.out.println("Goodbye");
        }
    }
}
