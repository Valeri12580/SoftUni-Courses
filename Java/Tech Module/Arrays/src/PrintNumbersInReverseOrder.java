import java.util.Scanner;

public class PrintNumbersInReverseOrder {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);


        int length=Integer.parseInt(scanner.nextLine());

        int [] array=new int[length];

        for (int i = 0; i <length; i++) {
            array[i]=Integer.parseInt(scanner.nextLine());


        }

        for (int i = length-1; i >=0 ; i--) {
            System.out.print(array[i]+" ");

        }
    }
}
