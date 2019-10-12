import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfChars {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int sum=0;

        for (int i = 0; i <n; i++) {
            sum+=reader.readLine().charAt(0);


        }
        System.out.printf("The sum equals: %d",sum);

    }
}
