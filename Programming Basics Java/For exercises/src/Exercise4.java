import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int diff = 0;
        int currentSum = 0;
        int previousSum = 0;
        int maxDiff = Integer.MIN_VALUE;


        for (int i = 0; i < n; i++) {
            int num1 = Integer.parseInt(scanner.nextLine());
            int num2 = Integer.parseInt(scanner.nextLine());

            previousSum = currentSum;
            currentSum = num1 + num2;
            diff = Math.abs(currentSum - previousSum);

            if (diff > maxDiff && previousSum != currentSum && i > 0) {


                maxDiff = diff;
            }


        }
        if(maxDiff==Integer.MIN_VALUE){
            System.out.println("Yes, value="+currentSum);
        }else{
            System.out.println("No, maxdiff="+maxDiff);
        }

    }


}

