import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int num=0;

        int sum=0;
        for(int couter=1;n>=couter;couter++){
            num=Integer.parseInt(scanner.nextLine());
            sum+=num;


        }
        System.out.println(sum);

    }
}
