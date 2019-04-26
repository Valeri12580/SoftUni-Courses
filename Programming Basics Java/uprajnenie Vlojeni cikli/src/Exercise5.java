import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int numOne=Integer.parseInt(scanner.nextLine());
        int numTwo=Integer.parseInt(scanner.nextLine());


        for (int i = numOne; i <=numTwo; i++) {
            String current=String.valueOf(i);
            if(current.charAt(0)+current.charAt(2)+current.charAt(4)==current.charAt(1)+current.charAt(3)+current.charAt(5)){
                System.out.printf("%s ",current);

            }

        }

    }
}
