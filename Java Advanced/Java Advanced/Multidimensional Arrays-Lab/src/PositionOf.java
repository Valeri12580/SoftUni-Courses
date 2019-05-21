import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PositionOf {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] parameters = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] numbers = new int[parameters[0]][1];

        for (int i = 0; i < parameters[0]; i++) {
            int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            numbers[i] = input;
        }
        int n = Integer.parseInt(reader.readLine());
      boolean isFounded=false;
        for (int rows = 0; rows < parameters[0]; rows++) {
            for (int column = 0; column <numbers[rows].length; column++) {

                if(numbers[rows][column]==n){
                    isFounded=true;
                    System.out.println(rows+" "+column);
                }
            }
        }

        if(!isFounded){
            System.out.println("not found");
        }
    }
}
