import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CompareMatrices {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] parameters = Arrays.stream(reader.readLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int[][] arrayOne = new int[parameters[0]][parameters[1]];

        for (int i = 0; i < parameters[0]; i++) {
            int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
            arrayOne[i] = numbers;


        }

        parameters = Arrays.stream(reader.readLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int[][] arrayTwo = new int[parameters[0]][parameters[1]];

        for (int i = 0; i < parameters[0]; i++) {
            int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
            arrayTwo[i] = numbers;


        }
        if(isEqual(arrayOne,arrayTwo)){
            System.out.println("equal");
        }else{
            System.out.println("not equal");
        }


    }

    public static boolean isEqual(int[][] arrayOne, int[][] arrayTwo) {
        boolean isEqual = false;

        if (arrayOne.length != arrayTwo.length) {
            return isEqual;

        }
        for (int row = 0; row <arrayOne.length; row++) {
            if(arrayOne[row].length!=arrayTwo[row].length){
                return isEqual;

            }
            for (int col = 0; col <arrayOne[row].length ; col++) {
                if(arrayOne[row][col]!=arrayTwo[row][col]){
                    return isEqual;
                }
            }

        }
        return true;
    }
}
