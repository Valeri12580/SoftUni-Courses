import java.util.Scanner;

public class Exercise9 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int yearsLili=Integer.parseInt(scanner.nextLine());
        double priceperalnq=Double.parseDouble(scanner.nextLine());
        int priceToy=Integer.parseInt(scanner.nextLine());
        int bonus=0;
        double sum=0;

        for(int i=1;i<=yearsLili;i++){
            if (i%2==0){
                bonus+=10;
                sum+=bonus;
                sum-=1;
            }else{
                sum+=priceToy;
            }

        }

        double result=sum-priceperalnq;
        if(result>=0){
            System.out.printf("Yes! %.2f",result);
        }else{
            System.out.printf("No! %.2f",Math.abs(result));
        }
    }
}
