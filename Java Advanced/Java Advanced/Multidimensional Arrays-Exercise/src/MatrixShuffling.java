import javax.management.ObjectName;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MatrixShuffling {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        int[]parameters= Arrays.stream(reader.readLine().split(" ")).mapToInt(e-> Integer.parseInt(e)).toArray();
        String[][]matrix=new String[parameters[0]][parameters[1]];


        for (int row = 0; row <matrix.length; row++) {
            matrix[row]=reader.readLine().split(" ");

        }

        String command="";

        while (!"END".equals(command=reader.readLine())){
            String[] convertedToArray=command.split("\\s+");
            String operation=convertedToArray[0];

            if((!operation.equals("swap"))|| convertedToArray.length != 5){
                System.out.println("Invalid input!");
            }else{
                int row1=Integer.parseInt(convertedToArray[1]);
                int col1=Integer.parseInt(convertedToArray[2]);
                int row2=Integer.parseInt(convertedToArray[3]);
                int col2=Integer.parseInt(convertedToArray[4]);
                if(row1>matrix.length||col1>matrix.length||row2>matrix.length||col2>matrix.length){
                    System.out.println("Invalid input!");

                    continue;
                }
                String tempForRow1AndCol1=matrix[row1][col1];

                matrix[row1][col1]=matrix[row2][col2];
                matrix[row2][col2]=tempForRow1AndCol1;

                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j <matrix[i].length; j++) {
                        System.out.print(matrix[i][j]+" ");
                    }
                    System.out.println();
                }



            }

        }


    }
}
