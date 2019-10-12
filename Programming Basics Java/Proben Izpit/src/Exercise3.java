import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String type=scanner.nextLine();
        String restourant=scanner.nextLine();
        int portions=Integer.parseInt(scanner.nextLine());
        char poruchka=scanner.nextLine().charAt(0);
        double priceAll=0;
        double cenaDostavka=0;

        switch (restourant){
            case "Sushi Zone":
                switch (type){
                    case "sashimi":
                        priceAll=4.99;
                        break;
                    case "maki":
                        priceAll=5.29;
                        break;
                    case "uramaki":
                        priceAll=5.99;
                        break;
                    case "temaki":
                        priceAll=4.29;
                        break;
                }
                break;
            case "Sushi Time":
                switch (type){
                    case "sashimi":
                        priceAll=5.49;
                        break;
                    case "maki":
                        priceAll=4.69;
                        break;
                    case "uramaki":
                        priceAll=4.49;
                        break;
                    case "temaki":
                        priceAll=5.19;
                        break;
                }
                break;
            case "Sushi Bar":
                switch (type){
                    case "sashimi":
                        priceAll=5.25;
                        break;
                    case "maki":
                        priceAll=5.55;
                        break;
                    case "uramaki":
                        priceAll=6.25;
                        break;
                    case "temaki":
                        priceAll=4.75;
                        break;
                }
                break;
            case "Asian Pub":
                switch (type){
                    case "sashimi":
                        priceAll=4.50;
                        break;
                    case "maki":
                        priceAll=4.80;
                        break;
                    case "uramaki":
                        priceAll=5.50;
                        break;
                    case "temaki":
                        priceAll=5.50;
                        break;
                }
                break;
                default:
                    System.out.printf("%s is invalid restaurant!",restourant);
                    return;
        }
        priceAll*=portions;
        switch (poruchka){
            case 'Y':
                cenaDostavka=(priceAll*0.20);
                priceAll+=cenaDostavka;
        }

        System.out.printf("Total price: %.0f lv.",Math.ceil(priceAll));

    }
}
