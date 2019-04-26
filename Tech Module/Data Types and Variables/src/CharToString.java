import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CharToString {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        char one=reader.readLine().charAt(0);
        char two =reader.readLine().charAt(0);
        char three=reader.readLine().charAt(0);

        String full=(String.valueOf(one)+String.valueOf(two)+String.valueOf(three));
        System.out.println(full);


    }

}
