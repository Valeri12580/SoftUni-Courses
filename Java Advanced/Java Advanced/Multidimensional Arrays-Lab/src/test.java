import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[][]test=new int[5][2];


        for (int[] ints : test) {
            System.out.println(Arrays.toString(ints));
        }

        System.out.println();

        int[][]secondtest={{532,2,3},{1532,237,523}};


        for (int[] ints : secondtest) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
        System.out.println(Arrays.toString(secondtest[0]));
        System.out.println();

        for (int i : secondtest[0]) {
            System.out.print(i+" ");

        }

        int n=secondtest[0][2];
    }
}
