import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int size=Integer.parseInt(scanner.nextLine());

        int[][]numbers=new int[size][size];

        for (int i = 0; i <size; i++) {
            for (int j = 0; j <1; j++) {
                int[]input= Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
                numbers[i]=input;


            }
            
        }
        int counter=0;
        while (counter<size){
            System.out.print(numbers[counter][counter]+"".join(""," "));
            counter++;
        }
        System.out.println();
        counter=size-1;


        int counter2=0;
        for (int rows = size-1; rows >=0 ; rows--) {

            for (int cols = 0; cols <1; cols++) {
                System.out.print(numbers[rows][counter2]+"".join(""," "));


            }
            counter2++;

        }
    }
}
