import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CondenseArrayToNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        String[] arrayString=reader.readLine().split(" ");

        int []arrayInt= Arrays.stream(arrayString).mapToInt(e->Integer.parseInt(e)).toArray();


        while(arrayInt.length>1){

            int[] condensed=new int[arrayInt.length-1];
            for (int j = 0; j <arrayInt.length-1; j++) {

                    condensed[j]=arrayInt[j]+arrayInt[j+1];

            }
            arrayInt=condensed;






        }
        System.out.println(arrayInt[0]);


    }
}
