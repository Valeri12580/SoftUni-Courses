import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int zakupenaHrana=Integer.parseInt(scanner.nextLine());
        int izqdenaHrana=Integer.parseInt(scanner.nextLine());
        int zakupenaHranaInKg=zakupenaHrana*1000;
        zakupenaHranaInKg-=izqdenaHrana;
        String command="0";

        while(!(command.equals("Adopted"))){
            int izqdenaHranaDve=Integer.parseInt(command);

            zakupenaHranaInKg-=izqdenaHranaDve;



            command=scanner.nextLine();
        }

        if (zakupenaHranaInKg>=0){
            System.out.printf("Food is enough! Leftovers: %d grams.",zakupenaHranaInKg);
        }else {
            System.out.printf("Food is not enough. You need %d grams more.",Math.abs(zakupenaHranaInKg));
        }
    }
}
