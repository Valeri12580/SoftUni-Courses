import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n =Integer.parseInt(scanner.nextLine());
        int sum=0;
        for (int i = 0; i <n; i++) {
           int addLiters=Integer.parseInt(scanner.nextLine());
           if (addLiters+sum<=255){
               sum+=addLiters;

           }else{
               System.out.println("Insufficient capacity!");

           }


        }

        System.out.println(sum);
    }
}
