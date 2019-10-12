import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num1=Integer.parseInt(scanner.nextLine());
        int num2=Integer.parseInt(scanner.nextLine());
        getMax(num1,num2);


    }

    public static void getMax(int num1,int num2){
        Scanner scanner=new Scanner(System.in);
        int max=0;
        while (true) {

            if (num1 > num2) {
                max = num1;
                System.out.println("The max number is:"+max);
                return;
            } else if (num2 > num1) {
                max = num2;
                System.out.println("The max number is:"+max);
                return;
            } else {
                System.out.println("The numbers are equal!Try again!");
                num1=Integer.parseInt(scanner.nextLine());
                num2=Integer.parseInt(scanner.nextLine());

            }
        }

    }
}
