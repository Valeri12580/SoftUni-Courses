import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if (array.length <= 1) {
            System.out.println("0");
            return;
        }

        for (int i = 0; i < array.length; i++) {

            int sumLeft = 0;
            int sumRight = 0;
            for (int left = i-1; left >=0; left--) {
                sumLeft+=array[left];

            }
            for (int right = i+1; right <array.length; right++) {
                sumRight+=array[right];

            }

            if (sumLeft==sumRight){
                System.out.println(i);
                return;
            }



        }
        System.out.println("no");






    }
}
