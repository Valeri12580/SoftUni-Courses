import java.util.Scanner;

public class BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int hours=Integer.parseInt(scanner.nextLine());
        int minutes=Integer.parseInt(scanner.nextLine());

        int finalMinutes=minutes+30;

        if (finalMinutes>59){
            finalMinutes-=60;
            hours++;
            if (hours>23){
                hours=hours-24;
            }

        }
        System.out.printf("%02d:%02d",hours,finalMinutes);




    }
}
