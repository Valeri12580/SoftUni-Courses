import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int budjet=Integer.parseInt(scanner.nextLine());
        int numPredmeti=Integer.parseInt(scanner.nextLine());

        int sum=0;


        for (int i = 0; i <numPredmeti; i++) {
            String predmet=scanner.nextLine();
            switch (predmet){
                case "hoodie":
                    sum+=30;
                    break;
                case "keychain":
                    sum+=4;
                    break;
                case "T-shirt":
                    sum+=20;
                    break;

                case "sticker":
                    sum+=1;
                    break;
                case "flag":
                    sum+=15;
                    break;
            }

            
        }
        int razlika=budjet-sum;


        if (budjet>=sum){
            System.out.printf("You bought %d items and left with %d lv.",numPredmeti,razlika);
        }else{
            System.out.printf("Not enough money, you need %d more lv.",Math.abs(razlika));
        }
    }
}
