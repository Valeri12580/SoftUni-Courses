import java.util.Scanner;

public class LowerOrUpper {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        char c=scanner.nextLine().charAt(0);

        char withBIG=Character.toUpperCase(c);



        if (c==withBIG){
            System.out.println("upper-case");

        }else{
            System.out.println("lower-case");
        }
    }
}
