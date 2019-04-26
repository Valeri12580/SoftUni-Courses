import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String fruit=scanner.nextLine();
        String size=scanner.nextLine();
        int numPoruchki=Integer.parseInt(scanner.nextLine());

        double result=cena(fruit,size);
        result*=numPoruchki;

        if (result>=400 && result<=1000) {
            result = result - (result * 0.15);

        }
        double endResullt=result>1000?result-(result*0.50):result;

        System.out.printf("%.2f lv.",endResullt);





    }

    public static double cena(String fruit,String size ){
        double price=0;

        switch (size){
            case "small":
                switch (fruit){
                    case "Watermelon":
                        price=56;
                        break;
                    case "Mango":
                        price=36.66;
                        break;
                    case "Pineapple":
                        price=42.10;
                        break;
                    case "Raspberry":
                        price=20;
                        break;
                }
                price*=2;
                break;
            case "big":
                switch (fruit){
                    case "Watermelon":
                        price=28.70;
                        break;
                    case "Mango":
                        price=19.60;
                        break;
                    case "Pineapple":
                        price=24.80;
                        break;
                    case "Raspberry":
                        price=15.20;
                        break;
                }
                price*=5;
                break;
        }

        return price;
    }
}
