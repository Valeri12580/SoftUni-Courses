import java.util.Scanner;

public class TopInteger {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n =Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <n; i++) {
            if (isDivisible(i) && oddChecker(i)){
                System.out.println(i);
            }


        }
    }

    static boolean isDivisible(int i){

        if (getSum(i)%8==0){
            return  true;
        }
        return false;
    }

    static boolean oddChecker(int i){
            String fix=""+i;
        for (int j = 0; j <fix.length(); j++) {
            int sum=0;
            sum += i % 10;
            i /= 10;
            if(sum%2==1){
                return true;
            }

        }
        return false;

    }





    static int getSum(int i){
        int sum=0;
        String fix=""+i;
        for (int j = 0; j <fix.length(); j++) {
            sum += i % 10;
            i /= 10;

        }
        return sum;
    }
}
