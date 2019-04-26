import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int kolkoChastiProekt=Integer.parseInt(scanner.nextLine());
        double priceOneTochka=Double.parseDouble(scanner.nextLine());


        double price=0;


        for (int i = 1; i <=kolkoChastiProekt; i++) {
            int tochkiKonkretenEtap=Integer.parseInt(scanner.nextLine());
            if (i%2==0){
                tochkiKonkretenEtap*=2;
            }

            price+=tochkiKonkretenEtap*priceOneTochka;




        }

        System.out.printf("The project prize was %.2f lv.",price);
    }
}
