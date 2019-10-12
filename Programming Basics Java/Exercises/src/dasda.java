import java.util.Arrays;

public class dasda {


    public static void main(String[] args) {
        int[] myArray = {1, 2, 3, 4, 5};
        int length = myArray.length;
        int[] reverset = new int[length];

        for (int i = 0; i < length; i++) {
            reverset[length - i - 1] = myArray[i];

        }
        System.out.println(Arrays.toString(reverset));


    }
}