
import java.util.Scanner;

public class EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
       String [] input=scanner.nextLine().split(" ");

       int []arrayInt=new int[input.length];

        for (int i = 0; i <input.length; i++) {
            arrayInt[i]=Integer.parseInt(input[i]);

        }
        int evenSum=0;
        int oddSum=0;

        for (int number:arrayInt) {
            if (number%2==1){
                oddSum+=number;
            }else{
                evenSum+=number;
            }


        }

        System.out.println(evenSum-oddSum);



    }

}
