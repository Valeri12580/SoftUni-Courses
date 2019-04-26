import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=Integer.parseInt(scanner.nextLine());
        System.out.println(lastNumName(num));


    }

    public static String lastNumName(int num){
        num%=10;

        String whatToReturn="";
        switch (num){
            case 0:
                whatToReturn="Zero.";
                break;
            case 1:
                whatToReturn="One.";
                break;
            case 2:
                whatToReturn="Two.";
                break;
            case 3:
                whatToReturn="Three.";
                break;
            case 4:
                whatToReturn="Four.";
                break;
            case 5:
                whatToReturn="Five.";
                break;
            case 6:
                whatToReturn="Six.";
                break;
            case 7:
                whatToReturn="Seven.";
                break;
            case 8:
                whatToReturn="Eight.";
                break;
            case 9:
                whatToReturn="Nine.";
                break;

        }

        return whatToReturn;


    }
}
