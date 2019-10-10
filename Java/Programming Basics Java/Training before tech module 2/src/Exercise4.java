import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String command=scanner.nextLine();
        int counterKids=0;
        int counterAdults=0;
        double priceToys=5;
        double priceSweaters=15;
        while(!command.contains("Christmas")){
            int age=Integer.parseInt(command);


            if (age<=16){
                counterKids++;


            }else{
                counterAdults++;

            }
            command=scanner.nextLine();

        }

        priceToys*=counterKids;
        priceSweaters*=counterAdults;

        System.out.printf("Number of adults: %d\n",counterAdults);
        System.out.printf("Number of kids: %d\n",counterKids);
        System.out.printf("Money for toys: %.0f\n",priceToys);
        System.out.printf("Money for sweaters: %.0f\n",priceSweaters);



    }
}
