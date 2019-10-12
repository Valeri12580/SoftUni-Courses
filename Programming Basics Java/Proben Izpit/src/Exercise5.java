import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int startingPutnici=Integer.parseInt(scanner.nextLine());
        int numSpirki=Integer.parseInt(scanner.nextLine());
        int sum=startingPutnici;
        boolean proverka=false;

        for (int i = 1; i <=numSpirki; i++) {

            int slizashti=Integer.parseInt(scanner.nextLine());
            sum-=slizashti;
            int kachvashti=Integer.parseInt(scanner.nextLine());
            sum+=kachvashti;

            if (i%2==0 && proverka){
                sum-=2;
                proverka=false;
            }else{
                sum+=2;
                proverka=true;
            }

            
        }

            System.out.printf("The final number of passengers is : %d",sum);




    }
}
