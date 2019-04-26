import java.util.Scanner;

public class DaysOfMonths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Въведи 1-ви месец:");
        int month1 = Integer.parseInt(scanner.nextLine());
        System.out.print("Въведи 2-ри месец:");
        int month2 = Integer.parseInt(scanner.nextLine());
        System.out.println();

        int period = month2 - month1;
        if (period < 0) {
            period += 12;
        }

        System.out.printf("There is %d months period from %s to %s.",period,monthName(month1),monthName(month2));
    }

    public static String monthName(int numMonth) {
        String nameOfMonth = "";
        switch (numMonth) {
            case 1:
                nameOfMonth = "January";
                break;
            case 2:
                nameOfMonth = "February";
                break;
            case 3:
                nameOfMonth = "March";
                break;
            case 4:
                nameOfMonth = "April";
                break;
            case 5:
                nameOfMonth = "May";
                break;
            case 6:
                nameOfMonth = "June";
                break;
            case 7:
                nameOfMonth = "July";
                break;
            case 8:
                nameOfMonth = "August";
                break;
            case 9:
                nameOfMonth = "September";
                break;
            case 10:
                nameOfMonth = "October";
                break;
            case 11:
                nameOfMonth = "November";
                break;
            case 12:
                nameOfMonth = "December";
                break;
            default:
                System.out.println("Error");
        }

        return nameOfMonth;



    }

}


