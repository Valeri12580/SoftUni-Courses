import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) throws IOException {

        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        int[] input= Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n=Integer.parseInt(reader.readLine());
        List<Integer>numbers=new ArrayList<>();

        for (int i : input) {
            numbers.add(i);
        }

        Collections.reverse(numbers);
        Predicate<Integer>removing=e->e%n!=0;


        numbers.stream().filter(removing).forEach(e-> System.out.print(e+" "));



    }
}
