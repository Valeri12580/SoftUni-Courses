import java.util.Scanner;
public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a=Integer.parseInt(scanner.nextLine());
        while(5>a||a>100){
            System.out.println("Invalid number");
            a=Integer.parseInt(scanner.nextLine());


        }
        System.out.println("The number is "+a);

    }
}
