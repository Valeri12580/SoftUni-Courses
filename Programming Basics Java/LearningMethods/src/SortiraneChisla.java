import java.util.Arrays;
import java.util.Scanner;

public class SortiraneChisla {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Arrays.toString(getSorted(5,2,17,12)));


    }

    public static double[] getSorted(double... arrays) {
        for (int i = 0; i < arrays.length - 1; i++) {
            for (int j = i + 1; j < arrays.length; j++) {
                if (arrays[i] > arrays[j]) {
                    double temp = arrays[i];
                    arrays[i] = arrays[j];
                    arrays[j] = temp;
                }

            }

        }
        return arrays;


    }
}
