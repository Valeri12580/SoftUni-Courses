import java.util.Scanner;

public class Exercise8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int i=0;
        for (int j = 1; j <=n; j++) {
            boolean flour=false;
            boolean eggs=false;
            boolean sugar=false;
            while(true){
                String products=scanner.nextLine();
                if(products.equals("Bake!")){
                    if (flour==true && eggs==true && sugar==true){
                        System.out.printf("Baking batch number %d...%n",j);
                        break;
                    }else{
                        System.out.println("The batter should contain flour, eggs and sugar!");
                        continue;

                    }
                }else if(products.equals("flour")){
                    flour=true;
                }else if (products.equals("eggs")){
                    eggs=true;
                }else if (products.equals("sugar")){
                    sugar=true;
                }
            }

        }
    }
}
