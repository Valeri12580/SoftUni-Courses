import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int sum=0;
        int num1=0;
        int num2=0;
        int num3=0;
        int n2=n;

        num3=n%10;
        n/=10;
        num2=n%10;
        n/=10;
        num1=n%10;
        n/=10;
        for (int i = 1; i <=num3; i++) {
            for (int j = 1; j <=num2; j++) {
                for (int k = 1; k <=num1; k++) {
                    sum=i*j*k;
                    if (sum<=n2){
                        System.out.printf("%d * %d * %d = %d;%n",i,j,k,sum);
                    }

                }

            }

        }



    }
}
