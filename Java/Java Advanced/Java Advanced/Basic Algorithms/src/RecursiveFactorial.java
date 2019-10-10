import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n =Integer.parseInt(scanner.nextLine());
        System.out.println(getFactoriel(n, 1));

    }

    private static int getFactoriel(int n, int sum) {
        if(n==0){
            return sum;
        }else{
            sum*=n--;
        }
        return getFactoriel(n,sum);
    }
}
