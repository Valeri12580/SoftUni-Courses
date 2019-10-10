import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n =Integer.parseInt(scanner.nextLine());
        String n2=String.valueOf(n);
        int sum=0;



        for (int i = 0; i <n2.length() ; i++) {

            sum+=Character.getNumericValue(n2.charAt(i));


        }
        System.out.println(sum);



    }
}
