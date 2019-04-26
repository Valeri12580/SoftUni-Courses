import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String team=scanner.nextLine();
        String typeSouvenirs=scanner.nextLine();
        int numSouvenirs=Integer.parseInt(scanner.nextLine());
        double price=0;



        if (!(team.equals("Argentina") || team.equals("Brazil") || team.equals("Croatia") || team.equals("Denmark"))){
            System.out.println("Invalid country!");
            return;
        }else if (!(typeSouvenirs.equals("flags")||typeSouvenirs.equals("caps")||typeSouvenirs.equals("posters")||typeSouvenirs.equals("stickers"))){
            System.out.println("Invalid stock!");
            return;
        }else if (team.equals("Argentina")){
            switch (typeSouvenirs){
                case "flags":
                    price+=3.25;
                    break;
                case "caps":
                    price+=7.20;
                    break;
                case "posters":
                    price+=5.10;
                    break;
                case "stickers":
                    price+=1.25;
                    break;
            }

        }else if (team.equals("Brazil")){
            switch (typeSouvenirs){
                case "flags":
                    price+=4.20;
                    break;
                case "caps":
                    price+=8.50;
                    break;
                case "posters":
                    price+=5.35;
                    break;
                case "stickers":
                    price+=1.20;
                    break;
            }
        }else if (team.equals("Croatia")){
            switch (typeSouvenirs){
                case "flags":
                    price+=2.75;
                    break;
                case "caps":
                    price+=6.90;
                    break;
                case "posters":
                    price+=4.95;
                    break;
                case "stickers":
                    price+=1.10;
                    break;
            }
        }else if (team.equals("Denmark")){
            switch (typeSouvenirs){
                case "flags":
                    price+=3.10;
                    break;
                case "caps":
                    price+=6.50;
                    break;
                case "posters":
                    price+=4.80;
                    break;
                case "stickers":
                    price+=0.90;
                    break;
            }
        }
        price*=numSouvenirs;
        System.out.printf("Pepi bought %d %s of %s for %.2f lv.",numSouvenirs,typeSouvenirs,team,price);


    }
}
