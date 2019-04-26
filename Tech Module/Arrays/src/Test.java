import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int []array1={1,2,3,4,5};
        int[]array2={6,7,8};

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));

        array2=array1;
        System.out.println(Arrays.toString(array2));
    }
}
