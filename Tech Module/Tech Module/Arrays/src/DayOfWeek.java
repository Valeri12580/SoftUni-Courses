import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());

        String[] day={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};

        if (n>7 || n<=0){
            System.out.println("Invalid day!");
        }else{
            System.out.println(day[n-1]);
        }

    }
}
