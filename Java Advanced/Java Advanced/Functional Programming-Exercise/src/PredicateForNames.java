import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());

        String[] names=scanner.nextLine().split(" ");

        Predicate<String>isPassing=name->name.length()<=n?true:false;

        Arrays.stream(names).filter(isPassing).forEach(e-> System.out.println(e));
    }
}
