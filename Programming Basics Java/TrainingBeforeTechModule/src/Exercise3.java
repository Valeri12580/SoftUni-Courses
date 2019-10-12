import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double budjet=Double.parseDouble(scanner.nextLine());
        String izbranGrad=scanner.nextLine();
        int broiNoshtuvki=Integer.parseInt(scanner.nextLine());

        double price=0;


        switch (izbranGrad){
            case "Cairo":
                price=(500*broiNoshtuvki)+600;
                break;
            case "Paris":
                price=(300*broiNoshtuvki)+350;
                break;
            case "Lima":
                price=(800*broiNoshtuvki)+850;
                break;
            case "New York":
                price=(600*broiNoshtuvki)+650;

                break;
            case "Tokyo":
                price=(700*broiNoshtuvki)+700;
                break;
        }


        if (broiNoshtuvki>=1 && broiNoshtuvki<=4){
            switch (izbranGrad){
                case "Cairo":
                case "New York":
                    price=price-(price*0.03);
                    break;
            }
        }else if (broiNoshtuvki>=5 && broiNoshtuvki<=9){
            switch (izbranGrad){
                case "Cairo":
                case "New York":
                    price=price-(price*0.05);
                    break;
                case "Paris":
                    price=price-(price*0.07);
                    break;
            }

        }else if (broiNoshtuvki>=10 && broiNoshtuvki<=24){
            switch (izbranGrad){
                case "Cairo":
                    price=price-(price*0.10);
                    break;
                case "Paris":
                case "New York":
                case "Tokyo":
                    price=price-(price*0.12);
                    break;

            }
        }else if (broiNoshtuvki>=25 && broiNoshtuvki<=49){
            switch (izbranGrad){
                case "Tokyo":
                case "Cairo":
                    price=price-(price*0.17);
                    break;
                case "New York":
                case "Lima":
                    price=price-(price*0.19);
                    break;
                case "Paris":
                    price=price-(price*0.22);
                    break;
            }
        }else {
            price=price-(price*0.30);
        }

        double diff=budjet-price;

        if (diff>=0){
            System.out.printf("Yes! You have %.2f leva left.",diff);
        }else {
            System.out.printf("Not enough money! You need %.2f leva.",Math.abs(diff));
        }
    }
}
