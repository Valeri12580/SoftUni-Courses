import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int pokePowerN=Integer.parseInt(scanner.nextLine());
        int distanceM=Integer.parseInt(scanner.nextLine());
        int exhaustionFactorY =Integer.parseInt(scanner.nextLine());
        int counter=0;
        int originalValueofN=pokePowerN;

        while(pokePowerN>=distanceM){
            pokePowerN-=distanceM;
            counter++;

            if (pokePowerN==(originalValueofN*0.50)) {
                if (0<exhaustionFactorY){
                    pokePowerN/=exhaustionFactorY;
                }

            }

        }

        System.out.println(pokePowerN);
        System.out.println(counter);
    }
}
