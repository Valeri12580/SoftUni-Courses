import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int max=Integer.MIN_VALUE; //-2m
        int sum=0;
        for (int i = 0; i <n; i++) {
            int num=Integer.parseInt(scanner.nextLine());
            if (num>max){
                max=num;
            }
            sum+=num;

        }
        sum-=max;

        if (sum==max){
            System.out.println("Yes Sum = "+sum);
        }else{
            System.out.println("No Diff = "+Math.abs(sum-max) );
        }
    }
}
