import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double budjet=Double.parseDouble(scanner.nextLine());
        double price = 0;
        int counterBallons=0;
        int counterFlowers=0;
        int counterCandles=0;
        int counterRibbon=0;

        while (true){
            if (price>=budjet){
                System.out.println("All money is spent!");
                break;
            }
            String command=scanner.nextLine();
            if (command.equals("stop")){
                System.out.printf("Spend money: %.2f%n",price);
                System.out.printf("Money left: %.2f%n",budjet-price);
                break;
            }
            int num=Integer.parseInt(scanner.nextLine());
            switch (command){
                case "balloons":
                    price+=0.10*num;
                    counterBallons+=num;
                    break;
                case "flowers":
                    price+=1.5*num;
                    counterFlowers+=num;
                    break;
                case "candles":
                    price+=0.5*num;
                    counterCandles+=num;
                    break;
                case "ribbon":
                    price+=2*num;
                    counterRibbon+=num;
                    break;
            }

        }

        System.out.printf("Purchased decoration is %d balloons, %d m ribbon, %d flowers and %d candles.",counterBallons,counterRibbon,counterFlowers,counterCandles);


    }
}

