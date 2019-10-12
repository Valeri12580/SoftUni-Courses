import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int smallest=Integer.MAX_VALUE;
        int bigger=Integer.MIN_VALUE;
        while(true){
            String input=scanner.nextLine();
            if (input.equalsIgnoreCase("END")) {
                break;
            }
            int num=Integer.parseInt(input);
            if(num<smallest){
                smallest=num;
            }
            if (num>bigger){
                bigger=num;
            }
        }

        System.out.println("Max number: "+bigger);
        System.out.println("Min number: "+smallest);

    }
}
