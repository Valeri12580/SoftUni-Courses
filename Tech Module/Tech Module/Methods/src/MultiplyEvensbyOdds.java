import java.util.Scanner;

public class MultiplyEvensbyOdds {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());

        System.out.println(getResult(n));
    }

    private static int getResult(int n){

        return getSumOfEvenDigits(n)*getSumOfOddDigits(n);
    }

    private static int getSumOfEvenDigits(int n){
        String nString=n+"";
        int sum=0;
        for (int i = 0; i <nString.length(); i++) {
            int temp=n;
            temp%=10;
            n/=10;
            if (temp%2==0){
                sum+=temp;
            }
        }
        return sum;
    }

    private static int getSumOfOddDigits(int n){
        String nString=n+"";
        int sum=0;
        for (int i = 0; i <nString.length(); i++) {
            int temp=n;
            temp%=10;
            n/=10;
            if (temp%2!=0){
                sum+=temp;
            }
        }
        return sum;

    }


}
