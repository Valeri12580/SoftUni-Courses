import java.util.Scanner;

public class validTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Въведи час:");
        int hour = Integer.parseInt(scanner.nextLine());
        System.out.print("Въведи минути:");
        int minutes = Integer.parseInt(scanner.nextLine());

        if (isValidHour(hour)&& isValidMinutes(minutes)){
            System.out.printf("The time is %d:%d now.",hour,minutes);
        }else{
            System.out.println("Incorrect time!");
        }



    }
    public static boolean isValidHour ( int hour){
        boolean result=hour>=0 && hour<24;
        return  result;
    }
    public static boolean isValidMinutes ( int minutes){
        boolean result=minutes>=0 && minutes<=59;
        return  result;
    }


}
