import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);



        int daysCounter=1;
        int meterCounter=5364;


        while(meterCounter<8848){
            String yesOrNo=scanner.nextLine();
            if (yesOrNo.equals("Yes")) {
                daysCounter++;

            }
            if (daysCounter>5){
                System.out.printf("Failed!%n");
                System.out.printf("%d",meterCounter);
                return;
            }
            if (yesOrNo.equals("END")){
                System.out.printf("Failed!%n");
                System.out.printf("%d",meterCounter);
                return;
            }
            int izkacheniMetri=Integer.parseInt(scanner.nextLine());



            meterCounter+=izkacheniMetri;



        }

        System.out.printf("Goal reached for %d days!",daysCounter);






    }

}
