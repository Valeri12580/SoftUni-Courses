import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[]numbers=new int [3];
        for (int i = 0; i <numbers.length; i++) {
            numbers[i]=Integer.parseInt(scanner.nextLine());
        }

        smallest(numbers);


    }

    static void smallest(int[]numbers){
        int min=Integer.MAX_VALUE;
        for (int i = 0; i <numbers.length; i++) {
            if (numbers[i]<min){
                min=numbers[i];
            }
        }
        System.out.println(min);

    }
}
