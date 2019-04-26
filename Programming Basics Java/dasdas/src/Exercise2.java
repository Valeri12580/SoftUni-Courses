import java.util.Arrays;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());

        int[] myArray =new int[n];

        for (int index = 0; index <n; index++) {
            int numbers=Integer.parseInt(scanner.nextLine());

            myArray[index]=numbers;

        }

        System.out.println(Arrays.toString(myArray));

    }
}
