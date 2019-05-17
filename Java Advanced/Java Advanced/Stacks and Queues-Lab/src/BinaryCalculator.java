import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;

public class BinaryCalculator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer>stack=new ArrayDeque<>();
        int n = Integer.parseInt(reader.readLine());


        while (n!=0){
            int ostatuk=n%2;
            n/=2;
            stack.push(ostatuk);

        }
        stack.forEach(System.out::print);


    }
}
