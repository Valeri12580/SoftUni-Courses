import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number:");
        int n = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter array's length:");
        int numArray = Integer.parseInt(scanner.nextLine());
        checkNumber(gettingArray(numArray),n);
    }

    public static int[] gettingArray(int numArray) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[numArray];

        for (int i = 0; i < numArray; i++) {
            int numberInArray = Integer.parseInt(scanner.nextLine());
            array[i] = numberInArray;
        }
        return array;
    }

    public static void checkNumber(int[] array,int tursenoChislo) {
        int counter = 0;

        for (int i = 0; i < array.length; i++) {
            if (tursenoChislo== array[i]) {
                counter++;

            }

        }
        System.out.printf("The array contain the number (%d) %d times",tursenoChislo, counter);
    }
}
