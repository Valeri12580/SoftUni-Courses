import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String srokDogovor=scanner.nextLine();
        String typeDogovor=scanner.nextLine();
        String addedDesert=scanner.nextLine();
        int numMonths=Integer.parseInt(scanner.nextLine());
        boolean isTwo=false;

        double price=0;

        if (srokDogovor.equalsIgnoreCase("one")){
            switch (typeDogovor){
                case "Small":
                    price=9.98;
                    break;
                case "Middle":
                    price=18.99;
                    break;
                case "Large":
                    price=25.98;
                    break;
                case "ExtraLarge":
                    price=35.99;
                    break;

            }


        }else if (srokDogovor.equalsIgnoreCase("two")){
            isTwo=true;
            switch (typeDogovor){
                case "Small":
                    price=8.58;
                    break;
                case "Middle":
                    price=17.09;
                    break;
                case "Large":
                    price=23.59;
                    break;
                case "ExtraLarge":
                    price=31.79;
                    break;

            }

        }
        switch (addedDesert){
            case "yes":
                if (price<=10){
                    price+=5.50;
                }else if (price<=30){
                    price+=4.35;
                }else{
                    price+=3.85;
                }
        }
        price*=numMonths;
        if(isTwo){
            price=price-(price*3.75/100);
        }


        System.out.printf("%.2f lv.",price);

    }
}
