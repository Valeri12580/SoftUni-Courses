import java.util.Scanner;

public class Vacantion {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int number=Integer.parseInt(scanner.nextLine());
        String typeGroup=scanner.nextLine();
        String dayWeek=scanner.nextLine();
        System.out.printf("Total price: %.2f", gettingPrice(typeGroup, dayWeek, number));

    }

    public static double gettingPrice(String typeGroup,String dayWeek,int number){
        double price=0;
        double totalPrice=0;
        boolean isStudents=false;
        boolean isBusiness=false;
        boolean isRegular=false;
        switch (typeGroup){         //vzimane na grupa
            case "Students":
                switch (dayWeek){
                    case "Friday":
                        price=8.45;
                        break;
                    case "Saturday":
                        price=9.80;
                        break;
                    case "Sunday":
                        price=10.46;
                        break;
                }
                isStudents=true;
                break;
            case "Business":
                switch (dayWeek){
                    case "Friday":
                        price=10.90;
                        break;
                    case "Saturday":
                        price=15.60;
                        break;
                    case "Sunday":
                        price=16;
                        break;
                }
                isBusiness=true;
                break;
            case "Regular":
                switch (dayWeek){
                    case "Friday":
                        price=15;
                        break;
                    case "Saturday":
                        price=20;
                        break;
                    case "Sunday":
                        price=22.50;
                        break;
                }
                isRegular=true;
                break;
        }
        totalPrice=price*number;
        if (isStudents){
            if (number>=30) {
                totalPrice=totalPrice-(totalPrice*15/100);
            }
        } else if (isBusiness) {
            if (number>=100) {
                price*=10;
                totalPrice-=price;

            }
        }else{
            if (number>=10 && number<=20){
                totalPrice=totalPrice-(totalPrice*0.05);
            }
        }

        return totalPrice;
    }
}
