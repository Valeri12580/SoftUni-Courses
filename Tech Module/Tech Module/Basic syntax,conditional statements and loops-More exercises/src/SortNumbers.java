

import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());
        int previous = 0;


        int[] array = new int[3];

        array[0] = num1;
        array[1] = num2;
        array[2] = num3;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] < array[j + 1]) {
                    previous = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = previous;

                }


            }


        }
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
    }
}
