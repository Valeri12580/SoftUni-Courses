import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class EqualArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int []arrayOne=Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int []arrayTwo=Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum=0;
        for (int i = 0; i <arrayOne.length; i++) {
            if (arrayOne[i]!=arrayTwo[i]){

                System.out.printf("Arrays are not identical. Found difference at %d index.",i);
                return;
            }
            sum+=arrayOne[i];


        }
        System.out.println(String.format("Arrays are identical. Sum: %d",sum));


    }
}
