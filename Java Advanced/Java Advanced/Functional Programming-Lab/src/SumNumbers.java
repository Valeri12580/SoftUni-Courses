import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] numbers=scanner.nextLine().split(", ");
        Function<String,Integer> parse= n->Integer.parseInt(n);
        List<Integer>nums= Arrays.stream(numbers).map(parse).collect(Collectors.toList());
        int sum=0;

        System.out.println("Count = "+nums.size());
        System.out.println("Sum = "+nums.stream().reduce(0, (a, b) -> a + b));


    }
}
