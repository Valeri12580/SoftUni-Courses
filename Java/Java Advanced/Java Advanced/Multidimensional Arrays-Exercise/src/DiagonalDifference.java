import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int size=Integer.parseInt(scanner.nextLine());

        int[][]numbers=new int[size][size];
        int difference=0;
        int firstDiagonalSum=0;
        int secondDiagonalSum=0;

        for (int row = 0; row <size; row++) {
                int[]input= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                numbers[row]=input;
        }

        firstDiagonalSum=sumFirstDiagonal(numbers);

        secondDiagonalSum=sumSecondDiagonal(numbers);
        difference=Math.abs(firstDiagonalSum-secondDiagonalSum);
        System.out.println(difference);


    }

    public static int sumFirstDiagonal(int[][]numbers){
        int sum=0;
        int counter=0;
        for (int row = 0; row <numbers.length ; row++) {

                sum+=numbers[counter][counter];
                counter++;

        }
        return sum;

    }
    public static int sumSecondDiagonal(int[][]numbers){
        int sum=0;
            int row=0;
            for (int col = numbers[row].length-1; col>=0; col--) {
                sum+=numbers[row][col];
                row++;
            }


        return sum;

    }
}
