import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        List<Integer>numbers= Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        String input="";

        while (!"end".equals(input=reader.readLine())){
            switch (input){
                case "add":
                    Function<List<Integer>,List<Integer>>add=number->number.stream().map(e->++e).collect(Collectors.toCollection(ArrayList::new));
                    numbers=add.apply(numbers);
                    break;

                case "multiply":
                    Function<List<Integer>,List<Integer>>multiply=number->number.stream().map(e->e*=2).collect(Collectors.toCollection(ArrayList::new));
                    numbers=multiply.apply(numbers);
                    break;

                case "subtract":
                    Function<List<Integer>,List<Integer>>subtract=number->number.stream().map(e->--e).collect(Collectors.toCollection(ArrayList::new));
                  numbers=subtract.apply(numbers);
                    break;

                case "print":
                    Consumer<List<Integer>>print=n-> n.forEach(e-> {
                        System.out.print(e+" ");
                        ;
                    });
                    print.accept(numbers);
                    System.out.println();
                    break;

            }

        }

    }
}
