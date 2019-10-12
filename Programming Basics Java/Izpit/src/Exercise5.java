import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int broiGrupi=Integer.parseInt(scanner.nextLine());
        int sum=0;
        double musala=0;
        double monblan=0;
        double kilimandjaro=0;
        double k2=0;
        double everest=0;

        for (int i = 0; i <broiGrupi; i++) {
            int broiHoraGrupa=Integer.parseInt(scanner.nextLine());
            sum+=broiHoraGrupa;
            if (broiHoraGrupa<=5){
                musala+=broiHoraGrupa;
            }else if (broiHoraGrupa>=6 && broiHoraGrupa <=12){
                monblan+=broiHoraGrupa;
            }else if (broiHoraGrupa>=13 && broiHoraGrupa<=25){
                kilimandjaro+=broiHoraGrupa;
            }else if (broiHoraGrupa>=26 && broiHoraGrupa<=40){
                k2+=broiHoraGrupa;
            }else{
                everest+=broiHoraGrupa;
            }

        }

        musala=musala/sum*100;
        monblan=monblan/sum*100;
        kilimandjaro=kilimandjaro/sum*100;
        k2=k2/sum*100;
        everest=everest/sum*100;

        System.out.printf("%.2f%% %n",musala);
        System.out.printf("%.2f%% %n",monblan);
        System.out.printf("%.2f%% %n",kilimandjaro);
        System.out.printf("%.2f%% %n",k2);
        System.out.printf("%.2f%% %n",everest);




    }
}
