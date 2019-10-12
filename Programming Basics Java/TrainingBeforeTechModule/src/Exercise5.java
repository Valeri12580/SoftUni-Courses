import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double sumElectricity=0;
        double sumWater=0;
        double sumInternet=0;
        double sumAnother=0;
        double averageMoney=0;

        int razhodiMeseci=Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <razhodiMeseci; i++) {
            double priceElectricity=Double.parseDouble(scanner.nextLine());
             sumElectricity+=priceElectricity;
             sumWater+=20;
             sumInternet+=15;

             double plusProcents=(priceElectricity+20+15)+(0.20*(priceElectricity+20+15));
             sumAnother+=plusProcents;


            
        }
        averageMoney=sumElectricity+sumWater+sumInternet+sumAnother;

        System.out.printf("Electricity: %.2f lv%n",sumElectricity);
        System.out.printf("Water: %.2f lv%n",sumWater);
        System.out.printf("Internet: %.2f lv%n",sumInternet);
        System.out.printf("Other: %.2f lv%n",sumAnother);
        System.out.printf("Average: %.2f lv",averageMoney/razhodiMeseci);
    }
}
