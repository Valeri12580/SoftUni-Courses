import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FillTheMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        String[] input=reader.readLine().split(", ");
        int size=Integer.parseInt(input[0]);
        char type=input[1].charAt(0);

        int[][]matrix=new int[size][size];

        int counter=1;

        if(type=='A'){
            aType(size, matrix, counter);
        }else {
            bType(size, matrix, counter);


        }
        for (int col = 0; col <size ;col++) {

            for (int row = 0; row <size ; row++) {
                System.out.print(matrix[col][row]+" ");
            }
            System.out.println();
        }



    }

    private static void bType(int size, int[][] matrix, int counter) {
        boolean isLast=false;
        for (int col = 0; col <size ;col++) {
            if(!isLast){
                for (int row = 0; row <size ; row++) {
                    matrix[row][col] = counter++;

                }
                isLast=true;
            }else{
                for (int row = size-1; row >=0 ; row--) {
                    matrix[row][col] = counter++;

                }
                isLast=false;
            }

        }
    }

    private static void aType(int size, int[][] matrix, int counter) {
        for (int col = 0; col <size ;col++) {

            for (int row = 0; row <size ; row++) {
                matrix[row][col]=counter++;
            }
        }
    }
}
