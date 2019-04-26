import java.util.*;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<String>input= Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        input.subList(0,2).clear();
        System.out.println(input);


    }
}
