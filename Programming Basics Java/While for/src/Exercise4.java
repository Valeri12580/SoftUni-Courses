import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numEtaji = Integer.parseInt(scanner.nextLine());
        int numStai = Integer.parseInt(scanner.nextLine());
        int first = 0;


        for (; first < numStai; first++) {
            System.out.printf("L%d%d ", numEtaji, first);

        }
            for (int i = numEtaji - 1; i > 0; i--) {
                System.out.println();

                for (int j = 0; j < numStai; j++) {
                    if (i % 2 == 0) {
                        System.out.printf("O%d%d ", i, j);

                    } else if (i % 2 == 1) {
                        System.out.printf("A%d%d ", i, j);
                    }


                }


            }


        }

    }


