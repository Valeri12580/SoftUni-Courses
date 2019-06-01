import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximalSum {
    public static void main(String[] args) throws IOException {

        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));


        int []parameters= Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows=parameters[0];
        int columns=parameters[1];
        int sum=0;

        int[][]numbers=new int[rows][columns];


        for (int row = 0; row <numbers.length ; row++) {
                int[] input=Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                numbers[row]=input;

        }
        int maxSum=-1;
        int rowIndex=-1;
        int colIndex=-1;
        for (int row = 1; row <rows-1 ; row++) {
            for (int col = 1; col <columns-1 ; col++) {
                    int currentSum=getMatrixSum(numbers,row,col);
               if(currentSum>maxSum){
                   maxSum=currentSum;
                   rowIndex=row;
                   colIndex=col;
               }
            }
        }
        System.out.println("Sum = "+maxSum);
       printMatrixByGivenCell(numbers,rowIndex,colIndex);


    }

    private static void printMatrixByGivenCell(int[][] matrix,int rowIndex, int colIndex) {
        int beginRow=rowIndex-1;
        int beginCol=colIndex-1;
        for (int r = beginRow; r <beginRow+3; r++) {
            for (int c = beginCol; c <beginCol+3 ; c++) {
                System.out.print(matrix[r][c]+" ");
            }
            System.out.println();
            
        }
    }

    private static int getMatrixSum(int[][] numbers, int row, int col) {
        int sum=0;

        sum+=numbers[row][col];
        sum+=numbers[row-1][col];
        sum+=numbers[row+1][col];
        sum+=numbers[row][col-1];
        sum+=numbers[row][col+1];
        sum+=numbers[row-1][col-1];
        sum+=numbers[row+1][col+1];
        sum+=numbers[row+1][col-1];
        sum+=numbers[row-1][col+1];

        return sum;
    }
}
