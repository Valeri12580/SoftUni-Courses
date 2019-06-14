import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(reader.readLine());

        int[]numbers= Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Predicate<Integer>shoutPrint=num->{
            for (int i = 0; i <numbers.length ; i++) {
                if(num%numbers[i]!=0){
                    return false;

                }
            }
            return true;
        };

        for (int i = 1; i <= n; i++) {
            if (shoutPrint.test(i)) {

                System.out.print(i+" ");
            }
        }
    }
}
