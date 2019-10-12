import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int finale=1;

        for (int i = 0; i <=n; i+=2) {
            System.out.println(finale);
            finale=finale*2*2;


        }
    }
}
