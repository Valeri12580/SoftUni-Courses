import java.util.Scanner;

public class LodkaRibolov {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int budjet=Integer.parseInt(scanner.nextLine());
        String season=scanner.nextLine();
        int numberFishers=Integer.parseInt(scanner.nextLine());
        double naem=0;
        double finale=0;
        switch(season){
            case "Spring":
                naem=3000;
                break;
            case "Summer":
            case "Autumn":
                naem=4200;
                break;

            case "Winter":
                naem=2600;
                break;

        }
        if (numberFishers<=6){
            naem=naem-(naem*0.10);
        }else if (numberFishers>7 && numberFishers<=11){
            naem=naem-(naem*0.15);
        }else if (numberFishers>=12){
            naem=naem-(naem*0.25);
        }
        if (numberFishers%2==0 && !(season.equals("Autumn"))){
            naem=naem-(naem*0.05);
        }
        finale=Math.abs(budjet-naem);
        if (budjet>=naem){
            System.out.printf("Yes! You have %.2f leva left.",finale);
        }else if (naem>budjet) {
            System.out.printf("Not enough money! You need %.2f leva.",finale);
        }

    }
}
