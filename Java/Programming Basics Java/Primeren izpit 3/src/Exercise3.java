import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int minutes=Integer.parseInt(scanner.nextLine());
        String playerName=scanner.nextLine();

        if (minutes==0){
            System.out.println("Match has just began!");
        }else if (minutes<45){
            System.out.println("First half time.");
            if (minutes>=1 && minutes<=10){
                System.out.printf("%s missed a penalty.%n",playerName);
                if (minutes%2==0){
                    System.out.printf("%s was injured after the penalty.",playerName);
                }
            }else if (minutes>10 && minutes<=35){
                System.out.printf("%s received yellow card.%n",playerName);
                if(minutes%2==1){
                    System.out.printf("%s got another yellow card.",playerName);
                }

            }else if (minutes>35 && minutes<45){
                System.out.printf("%s SCORED A GOAL !!!",playerName);

            }
        }else if ( minutes>=45){
            System.out.println("Second half time.");
            if (minutes>45 && minutes<=55){
                System.out.printf("%s got a freekick.%n",playerName);
                if (minutes%2==0){
                    System.out.printf("%s missed the freekick.",playerName);
                }
            }else if (minutes>55 && minutes<=80){
                System.out.printf("%s missed a shot from corner.%n",playerName);
                if (minutes%2==1){
                    System.out.printf("%s has been changed with another player.",playerName);
                }
            }else if (minutes>80 && minutes<=90){
                System.out.printf("%s SCORED A GOAL FROM PENALTY !!!",playerName);
            }
        }
    }
}
