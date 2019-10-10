import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        String command=reader.readLine();

        while (!command.equals("end")){

            StringBuilder result=new StringBuilder();
            result.append(command);
            result.reverse();
            System.out.println(command+" = "+result);
            command=reader.readLine();



        }
    }
}
