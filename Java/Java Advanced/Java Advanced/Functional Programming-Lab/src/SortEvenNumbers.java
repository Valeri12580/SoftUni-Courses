import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        String[] numbers=reader.readLine().split(", ");


        List<String> chetni = Arrays.stream(numbers).map(e -> Integer.parseInt(e)).filter(e -> e % 2 == 0).map(e->String.valueOf(e)).collect(Collectors.toList());
        System.out.println(String.join(", ", chetni.toString()).replaceAll("[\\[\\]]",""));

        chetni=chetni.stream().map(Integer::parseInt).sorted(Integer::compare).map(String::valueOf).collect(Collectors.toList());
        System.out.println(String.join(", ", chetni.toString()).replaceAll("[\\[\\]]",""));
    }
}
