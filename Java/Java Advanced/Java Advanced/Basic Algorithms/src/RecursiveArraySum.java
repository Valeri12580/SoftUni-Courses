import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RecursiveArraySum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int[]array= Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int result=getSum(array,0,0);
        System.out.println(result);

    }

    public static int getSum(int[]array,int index,int sum){

        if(index==array.length){
            return  sum;
        }else{
            sum+=array[index++];

        }
        return getSum(array,index,sum);

    }
}
