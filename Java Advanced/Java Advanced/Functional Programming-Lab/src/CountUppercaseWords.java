import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);


        String[] text=scanner.nextLine().split(" ");

        Predicate<String>isUppercase=s->s.charAt(0)==s.toUpperCase().charAt(0);


        List<String>result= Arrays.stream(text).filter(isUppercase).collect(Collectors.toList());
        System.out.println(result.size());
        for (String s : result) {
            System.out.println(s);
        }
    }
}
