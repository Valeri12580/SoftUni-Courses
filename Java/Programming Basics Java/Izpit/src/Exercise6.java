import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int kluch = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int proizvedenie = 0;
        boolean isNo=true;

        for (int a = 1; a <= 30; a++) {
            for (int b = 1; b <= 30; b++) {
                for (int c = 1; c <= 30; c++) {
                    sum = a + b + c;
                    proizvedenie = a * b * c;
                    if (a < b && b < c) {
                        if (sum == kluch) {
                            System.out.printf("%d + %d + %d = %d%n", a, b, c, sum);
                            isNo=false;
                        }
                    }
                    if (a > b && b > c) {
                        if (proizvedenie == kluch) {
                            System.out.printf("%d * %d * %d = %d%n", a, b, c, proizvedenie);
                            isNo=false;
                        }


                    }

                }


            }

        }

        if(isNo){
            System.out.println("No!");
        }
    }
}