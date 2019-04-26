import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double money=Double.parseDouble(scanner.nextLine());
        double totalPrice=0;



        String command=scanner.nextLine();
        while (!command.equals("Game Time")){
            boolean isExpensive=false;
            switch (command){
                case "OutFall 4":
                    if (money-39.99>=0){
                        money-=39.99;
                        totalPrice+=39.99;
                        System.out.println("Bought OutFall 4");
                    }else{
                        isExpensive=true;
                    }
                    break;
                case "CS: OG":
                    if (money-15.99>=0){
                        money-=15.99;
                        totalPrice+=15.99;
                        System.out.println("Bought CS: OG");
                    }else{
                        isExpensive=true;
                    }

                    break;
                case "Zplinter Zell":
                    if (money-19.99>=0){
                        money-=19.99;
                        totalPrice+=19.99;
                        System.out.println("Bought Zplinter Zell");
                    }else{
                        isExpensive=true;
                    }

                    break;
                case "Honored 2":
                    if (money-59.99>=0){
                        money-=59.99;
                        totalPrice+=59.99;
                        System.out.println("Bought Honored 2");
                    }else{
                        isExpensive=true;
                    }
                    break;
                case "RoverWatch":
                    if (money-29.99>=0){
                        money-=29.99;
                        totalPrice+=29.99;
                        System.out.println("Bought RoverWatch");
                    }else{
                        isExpensive=true;
                    }

                    break;
                case "RoverWatch Origins Edition":
                    if (money-39.99>=0){
                        money-=39.99;
                        totalPrice+=39.99;
                        System.out.println("Bought RoverWatch Origins Edition");
                    }else{
                        isExpensive=true;
                    }
                    break;
                    default:
                        System.out.println("Not Found");
                        command=scanner.nextLine();
                        continue;


            }
            if (money<=0){
                System.out.println("Out of money!");
                return;
            }
            if (isExpensive){
                System.out.println("Too Expensive");
                command=scanner.nextLine();
                continue;
            }

            command=scanner.nextLine();

        }
        System.out.printf("Total spent: $%.2f. Remaining: $%.2f",totalPrice,money);

    }
}
