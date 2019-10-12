import java.util.Scanner;

public class SwimmingRecord {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double recordinSeconds=Double.parseDouble(scanner.nextLine());
        double lengthMeter=Double.parseDouble(scanner.nextLine());
        double timeSeconds=Double.parseDouble(scanner.nextLine());
        double meturVreme=lengthMeter*timeSeconds;
        double zabavqneMetur=Math.floor(lengthMeter/15)*12.5;
        double obshtoZabavqne=(meturVreme+zabavqneMetur);
        if (obshtoZabavqne<recordinSeconds){
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.",obshtoZabavqne);

        }else{
            System.out.printf("No, he failed! He was %.2f seconds slower.",obshtoZabavqne-recordinSeconds);
        }












    }

}


