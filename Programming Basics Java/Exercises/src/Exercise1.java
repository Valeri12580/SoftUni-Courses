import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <n; i++) {
            if (!(i%3==0) && !(i%7==0)){
                System.out.println(i);
            }

        }
    }
}
