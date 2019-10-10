import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int bigger =Integer.MAX_VALUE;
        for(int num=0;num<n;num++){
            int bigger2=Integer.parseInt(scanner.nextLine());
            if(bigger>bigger2){
                bigger=bigger2;
            }

        }
        System.out.println(bigger);

    }
}
