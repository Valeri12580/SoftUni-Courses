package HotelReservation;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);



        String[] input=scanner.nextLine().split(" ");
        double pricePerDay=Double.parseDouble(input[0]);
        int numberOfDays=Integer.parseInt(input[1]);
        String season=input[2].toUpperCase();
        String discount =input[3].toUpperCase();

       PriceCalculator calculator=new PriceCalculator(pricePerDay,numberOfDays,season,discount);
       calculator.printTotalSum();


    }
    public  void printTotalSum(){


        System.out.printf("%.2f");
    }



}

