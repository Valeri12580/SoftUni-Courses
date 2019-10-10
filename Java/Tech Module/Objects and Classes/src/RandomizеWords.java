import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RandomizеWords {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Random rnd=new Random();
        List<String>input= Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        while(!input.isEmpty()){
           int rndIndex=rnd.nextInt(input.size());
            System.out.println(input.get(rndIndex));
            input.remove(rndIndex);
        }

    }
}
