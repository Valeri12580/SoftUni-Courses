import java.util.Scanner;

public class Zavurshvane2 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String name=scanner.nextLine();
        double averageUspeh=0;
        int level=1;
        while(level<=12){
            double ocenka=Double.parseDouble(scanner.nextLine());
            if(ocenka>=4){
                averageUspeh+=ocenka;
                ++level;

            }else if (ocenka<=2){


                System.out.printf("%s has been excluded at %d grade",name,level);
                break;

            }
        }
        averageUspeh/=12;

        if (level==13){
            System.out.printf("%s graduated. Average grade: %.2f",name,averageUspeh);
        }
    }
}
