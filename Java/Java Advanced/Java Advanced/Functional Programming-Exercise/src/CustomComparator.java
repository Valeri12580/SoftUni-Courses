import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String[] numbersAsString= reader.readLine().split(" ");
        Integer[]numbers=new Integer[numbersAsString.length];
        for (int i = 0; i < numbersAsString.length; i++) {
            numbers[i]= Integer.valueOf(numbersAsString[i]);

        }

        Comparator<Integer> comparator=new Comparator<Integer>() {
            @Override
            public int compare(Integer f, Integer s) {
                int result;
                if(f%2==0 && s%2!=0){
                    result=-1;

                } else if (s%2==0 && f%2!=0) {
                    result=1;

                }else{
                    result=f-s;

                }
                return result;
            }
        };
        Arrays.sort(numbers,comparator);
        for (Integer number : numbers) {
            System.out.print(number+" ");

        }
    }
}
