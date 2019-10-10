import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int priceforSinger=Integer.parseInt(scanner.nextLine());
        String command=scanner.nextLine();
        int sum=0;
        int sumpeople=0;

        while (!command.equalsIgnoreCase("The restaurant is full")){
            int numGuests=Integer.parseInt(command);

            if (numGuests<5){
                sum+=numGuests*100;

            }else if (numGuests>=5){
                sum+=numGuests*70;
            }
            sumpeople+=numGuests;

            command=scanner.nextLine();
        }

        if (priceforSinger<=sum){
            System.out.printf("You have %d guests and %d leva left.",sumpeople,sum-priceforSinger);
        }else {
            System.out.printf("You have %d guests and %d leva income, but no singer.",sumpeople,sum);
        }
    }
}
