import java.util.Scanner;

public class MultiplicationTable2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int number=Integer.parseInt(scanner.nextLine());
        int multiplier=Integer.parseInt(scanner.nextLine());



        for (int i = multiplier; i <=10; i++) {

                System.out.printf("%d X %d = %d%n",number,i,i*number);





        }
        if (multiplier > 10) {
            System.out.printf("%d X %d = %d%n",number,multiplier,multiplier*number);
        }
    }
}
