import java.util.Scanner;

public class Exercise8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int volume = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int counterClick = 0;

        while (true) {
            String type = scanner.nextLine();
            if (volume > sum) {
                if (type.equals("Easy")) {
                    sum += 50;
                    counterClick += 1;
                } else if (type.equals("Medium")) {
                    sum += 100;
                    counterClick += 1;
                } else if (type.equals("Hard")) {
                    sum += 200;
                    counterClick += 1;

                }
            }
            if (volume == sum) {
                System.out.printf("The dispenser has been tapped %d times.", counterClick);
                break;
            }
             if(sum>volume){
                System.out.printf("%dml has been spilled.", sum - volume);
                break;
            }
        }
    }
}

