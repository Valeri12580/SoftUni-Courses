import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        double neededSum=Double.parseDouble(scanner.nextLine());
        int fantasticBooks=Integer.parseInt(scanner.nextLine());
        int horrorBooks=Integer.parseInt(scanner.nextLine());
        int romanticBooks=Integer.parseInt(scanner.nextLine());

        double sumFantasticBooks=fantasticBooks*14.90;
        double sumHorrorBooks=horrorBooks*9.80;
        double sumRomanticBooks=romanticBooks*4.30;

        double sumAll=sumFantasticBooks+sumHorrorBooks+sumRomanticBooks;
        sumAll-=(sumAll*0.20);

        if (sumAll>=neededSum){
            double ostanaliPari=sumAll-neededSum;
            double vuznagrajdenie=Math.floor(ostanaliPari*0.10);
            sumAll-=vuznagrajdenie;
            System.out.printf("%.2f leva donated.%n",sumAll);
            System.out.printf("Sellers will receive %.0f leva.",vuznagrajdenie);


        }else{
            System.out.printf("%.2f money needed.",neededSum-sumAll);
        }


    }
}
