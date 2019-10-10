import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMinFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int[]numbers=Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();



        Function<int[],Integer>findMinNumber=number-> {

            int min=   Arrays.stream(number).min().getAsInt();
            return min;

        };
        System.out.println(findMinNumber.apply(numbers));

    }
}
