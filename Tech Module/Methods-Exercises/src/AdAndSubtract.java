import java.util.Scanner;

public class AdAndSubtract {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[]numbers=new int[3];

        for (int i = 0; i <numbers.length; i++) {
            numbers[i]=Integer.parseInt(scanner.nextLine());


        }

        int sum=getSum(numbers[0],numbers[1]);

        System.out.println(subtract(sum, numbers[2]));


    }

    static int getSum(int one,int two){

        return one+two;
    }

    static int subtract(int sum,int number){

        return sum-number;
    }
}
