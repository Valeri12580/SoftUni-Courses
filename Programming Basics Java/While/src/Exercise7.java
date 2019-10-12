import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int vnoski=Integer.parseInt(scanner.nextLine());
        int vnoski2=0;
        double sbor=0;


        while(vnoski>vnoski2){
            Double suma=Double.parseDouble(scanner.nextLine());
            if(suma<=0){
                System.out.println("Invalid operation!");
                break;
            }
            System.out.printf("Increase: %.2f%n",suma);
            sbor+=suma;
            ++vnoski2;
        }

        System.out.printf("Total: %.2f",sbor);


    }


}
