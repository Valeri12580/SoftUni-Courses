import java.util.Scanner;

public class PadawanEquipment_09 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double moneyIvan=Double.parseDouble(scanner.nextLine());
        int students=Integer.parseInt(scanner.nextLine());
        double priceLightsabers=Double.parseDouble(scanner.nextLine());
        double priceRobes=Double.parseDouble(scanner.nextLine());
        double priceBelts=Double.parseDouble(scanner.nextLine());

        int freeBelts=students/6;

        double priceAll=priceLightsabers*(Math.ceil(students+(students*0.10)))+priceRobes*students+priceBelts*(students-freeBelts);

        if (priceAll<=moneyIvan){
            System.out.println(String.format("The money is enough - it would cost %.2flv.",priceAll));
        }else{
            System.out.println(String.format("Ivan Cho will need %.2flv more.",priceAll-moneyIvan));
        }

    }
}
