import java.text.DecimalFormat;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);


        String product=scanner.nextLine();
        int quanity=Integer.parseInt(scanner.nextLine());


        gettingResult(product,quanity);


    }
    private  static  void gettingResult(String product,int quanity){
        double result=0;
        switch (product){
            case "coffee":
                result=1.50;
                break;
            case "water":
                result=1.;
                break;
            case "coke":
                result=1.40;
                break;
            case "snacks":
                result=2.00;
                break;
        }
        result*=quanity;
        System.out.println(String.format("%.2f",result));
    }
}
