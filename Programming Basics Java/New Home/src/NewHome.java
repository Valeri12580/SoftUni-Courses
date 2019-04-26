import java.util.Scanner;

public class NewHome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type=scanner.nextLine();
        int numberFlowers=Integer.parseInt(scanner.nextLine());
        int budjet=Integer.parseInt(scanner.nextLine());
        double price=numberFlowers;
        double finale=0;
        switch(type){
            case "Roses":
                price*=5;
                break;
            case "Dahlias":
                price*=3.80;
                break;
            case "Tulips":
                price*=2.80;
                break;
            case "Narcissus":
                price*=3;
                break;
            case "Gladiolus":
                price*=2.50;
                break;
        }
        if (type.equals("Roses") && numberFlowers>80){
            price=price-(price*0.10);
        }else if (type.equals("Dahlias") && numberFlowers>90){
            price=price-(price*0.15);
        }else if (type.equals("Tulips") && numberFlowers>80){
            price=price-(price*0.15);
        }else if (type.equals("Narcissus") && numberFlowers<120){
            price=price+(price*0.15);
        }else if(type.equals("Gladiolus") && numberFlowers<80){
            price=price+(price*0.20);
        }


        if(budjet>=price){
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.",numberFlowers,type,budjet-price);
        }else if(price>budjet){
            System.out.printf("Not enough money, you need %.2f leva more.",price-budjet);
        }


    }
}
