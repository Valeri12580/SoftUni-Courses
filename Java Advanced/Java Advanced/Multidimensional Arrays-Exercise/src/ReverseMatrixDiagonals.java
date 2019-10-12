import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        int []parameters= Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayList<ArrayList<Integer>>matrix=new ArrayList<>();
        int rows=parameters[0];
        int columns=parameters[1];


        for (int r = 0; r <rows; r++) {
            ArrayList<Integer>dataForMatrix=new ArrayList<>();
            
            int[] input=Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int n = 0; n <input.length; n++) {
                dataForMatrix.add(input[n]);
            }
           matrix.add(dataForMatrix);
        }


        int row=rows-1;
        int col=columns-1;
        while (row>=0){
            int r=row;
            int c=col;
            while (c<columns && r>=0){
                System.out.print(matrix.get(r--).get(c++)+" ");

            }
            System.out.println();
            col--;
            if(col==-1){
                col=0;
                row--;
            }
        }



    }


}
