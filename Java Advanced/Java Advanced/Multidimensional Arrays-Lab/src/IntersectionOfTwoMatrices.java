import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(reader.readLine());
        int columns = Integer.parseInt(reader.readLine());

        String[][] a = new String[rows][columns];
        for (int i = 0; i < rows; i++) {
            String[] input = reader.readLine().split(" ");
            a[i] = input;
        }
        String[][] b = new String[rows][columns];
        for (int i = 0; i < rows; i++) {
            String[] input = reader.readLine().split(" ");
            b[i] = input;
        }

        String[][] c = new String[rows][columns];

        for (int row = 0; row <rows; row++) {
            for (int col = 0; col <columns; col++) {
                if(a[row][col].equals(b[row][col])){
                    c[row][col]=a[row][col];
                }else{
                    c[row][col]="*";
                }

            }
        }

        for (String[] strings : c) {
            for (int i = 0; i < strings.length; i++) {
                System.out.print(strings[i]+" ");
            }
            System.out.println();

        }






    }


}
