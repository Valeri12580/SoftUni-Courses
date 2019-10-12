import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int numGuests=Integer.parseInt(scanner.nextLine());
        int numGifts=Integer.parseInt(scanner.nextLine());
        double money=0;
        double elUredi=0;
        double vaucheri=0;
        double drugi=0;
        double gostikoitosadalipodaruci=0;

        for (int i = 0; i <numGifts; i++) {
            String typeOfGift=scanner.nextLine();
            switch (typeOfGift){
                case "A":
                    money++;
                    break;
                case "B":
                    elUredi++;
                    break;
                case "V":
                    vaucheri++;
                    break;
                case "G":
                    drugi++;
                    break;

            }

        }

        money=money/numGifts*100;
        elUredi=elUredi/numGifts*100;
        vaucheri=vaucheri/numGifts*100;
        drugi=drugi/numGifts*100;
        gostikoitosadalipodaruci=(double)numGifts/numGuests*100;

        System.out.printf("%.2f%%%n",money);
        System.out.printf("%.2f%%%n",elUredi);
        System.out.printf("%.2f%%%n",vaucheri);
        System.out.printf("%.2f%%%n",drugi);
        System.out.printf("%.2f%%%n",gostikoitosadalipodaruci);


    }
}
