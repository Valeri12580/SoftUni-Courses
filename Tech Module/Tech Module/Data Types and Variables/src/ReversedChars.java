import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReversedChars {
    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        char one=reader.readLine().charAt(0);
        char two =reader.readLine().charAt(0);
        char three=reader.readLine().charAt(0);

        System.out.println(three+" "+two+" "+one);

    }
}
