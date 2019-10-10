import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        String[]names=reader.readLine().split(" ");

        Consumer<String>print=name-> System.out.println(name);


        Arrays.stream(names).forEach(print);
    }
}
