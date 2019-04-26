import java.util.Scanner;
public class Exercises {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n =Integer.parseInt(scanner.nextLine());
        int counter=0;
        int redove=1;


        while (redove<=n){
            counter+=redove;
            for (int coloni = 0; coloni < n; coloni++) {
                System.out.print(counter);
                counter++;

            }
            counter=0;
            redove++;
            System.out.println();
        }
    }
}
