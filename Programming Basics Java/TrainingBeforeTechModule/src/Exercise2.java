import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double cenaMominskoParti=Double.parseDouble(scanner.nextLine());
        int broiLubovniPoslaniq=Integer.parseInt(scanner.nextLine());
        int broiVosuchniRozi=Integer.parseInt(scanner.nextLine());
        int broiKluchodurjateli=Integer.parseInt(scanner.nextLine());
        int broiKarikaturi=Integer.parseInt(scanner.nextLine());
        int broiKusmetiIznenada=Integer.parseInt(scanner.nextLine());

        double sum=(broiLubovniPoslaniq*0.60)+(broiVosuchniRozi*7.20)+(broiKluchodurjateli*3.60)+(broiKarikaturi*18.20)+(broiKusmetiIznenada*22);
        int poruchaniArtikuli=broiLubovniPoslaniq+broiVosuchniRozi+broiKluchodurjateli+broiKarikaturi+broiKusmetiIznenada;

        if (poruchaniArtikuli>=25){
            sum=sum-(sum*35/100);
        }

        sum=sum-(sum*0.10);


        if (sum>=cenaMominskoParti){
            System.out.printf("Yes! %.2f lv left.",sum-cenaMominskoParti);
        }else{
            System.out.printf("Not enough money! %.2f lv needed.",cenaMominskoParti-sum);
        }
    }
}
