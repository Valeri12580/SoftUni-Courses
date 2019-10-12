import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumMatrixElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        int[]nums=Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int r=nums[0];
        int c=nums[1];

        int[][]numbers=new int[r][c];


        for (int rows = 0; rows<r; rows++) {
            int[]input= Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            numbers[rows]=input;


        }
        int sum=0;

        for (int rows = 0; rows <r; rows++) {
            for (int columns = 0; columns <numbers[rows].length; columns++) {
                sum+=numbers[rows][columns];
            }
        }
        System.out.println(r);
        System.out.println(c);
        System.out.println(sum);



    }
}
