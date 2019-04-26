import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[]array= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String winner="";
        int max=Integer.MIN_VALUE;
        int counter=0;



        for (int i = 0; i <array.length; i++) {
            counter=0;
            for (int j = i; j <array.length; j++) {
                if (array[i]==array[j]){
                    counter++;

                }else{
                    break;
                }


                }
            if (counter>max){
                max=counter;
                winner=String.valueOf(array[i]);


            }



        }
        for (int i = 0; i <max; i++) {
            System.out.print(winner+" ");
        }


    }
}
