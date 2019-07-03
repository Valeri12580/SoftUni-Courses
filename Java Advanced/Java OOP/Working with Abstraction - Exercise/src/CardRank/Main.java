package CardRank;



import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String input=scanner.nextLine();


        System.out.println("Card Ranks:");
        for (CardRank value : CardRank.values()) {
            System.out.printf("Ordinal value: %d;",value.ordinal());
            System.out.printf(" Name value: %s",value);
            System.out.println();

        }
    }
}
