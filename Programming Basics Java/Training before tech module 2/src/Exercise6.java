import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int budjet = Integer.parseInt(scanner.nextLine());
        String predmet =scanner.nextLine();


        while (!predmet.contains("Stop")) {
            int sum=0;

            for (int i = 0; i <predmet.length(); i++) {
                sum=sum+predmet.charAt(i);

            }
            budjet-=sum;
            if (budjet>=0){
                System.out.printf("Item successfully purchased!%n");

            }else{
                System.out.printf("Not enough money!");
                return;

            }

            predmet = scanner.nextLine();



        }
        System.out.printf("Money left: %d",budjet);

    }
}