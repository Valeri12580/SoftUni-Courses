import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String command=scanner.nextLine();
        int sum=0;
        boolean headTrick=false;
        int maxValue=Integer.MIN_VALUE;
        String winner="";


        while(!(command.equals("END"))){
            int goals=Integer.parseInt(scanner.nextLine());
            sum+=goals;

            if (sum>maxValue){
                maxValue=sum;
                winner=command;

            }
            if (sum>=3){
                headTrick=true;

            }
            if (sum>=10){
                break;
            }
            command=scanner.nextLine();
            sum=0;
        }

        System.out.printf("%s is the best player!%n",winner);
        if (headTrick){
            System.out.printf("He has scored %d goals and made a hat-trick !!!",maxValue);
        }else{
            System.out.printf("He has scored %d goals.",maxValue);
        }
    }
}
