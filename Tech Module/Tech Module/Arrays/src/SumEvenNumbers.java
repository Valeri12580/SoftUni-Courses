import java.util.Scanner;

public class SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String[] input=scanner.nextLine().split(" ");

        int[] n=new int[input.length];
        int sum=0;


        for (int i = 0; i <input.length; i++) {
                n[i]=Integer.parseInt(input[i]);
                if (n[i]%2==0){
                    sum+=n[i];
                }


        }
        System.out.println(sum);


    }
}
