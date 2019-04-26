import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command=scanner.nextLine();
        int sum=0;
        String lastName=" ";
        int maxValue=Integer.MIN_VALUE;


        while(!command.equals("STOP")){
            for (int i=0;i<command.length();i++){
                char charSymbol=command.charAt(i);
                sum+=(int)charSymbol;
                if (sum>maxValue){
                    maxValue=sum;
                    lastName=command;

                }

            }
            command=scanner.nextLine();
            sum=0;

        }

        System.out.printf("Winner is %s - %d!",lastName,maxValue);

    }
}
