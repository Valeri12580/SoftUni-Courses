import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int numOne=Integer.parseInt(scanner.nextLine());
        int numTwo=Integer.parseInt(scanner.nextLine());
        int sumLeft=0;
        int sumRight=0;
        String result="";




        for (int i = numOne; i <=numTwo; i++) {

            int current=i;
            //10000
            int right=current%10;
            current/=10;
            int right2=current%10;
            current/=10;
            int center=current%10;
            current/=10;
            int left1=current%10;
            current/=10;
            int left2=current%10;
            current/=10;
            sumLeft=left1+left2;
            sumRight=right+right2;


            int counter=0;
            while(counter<=1) {
                if (sumLeft == sumRight) {
                    result += i + " ";
                    counter+=2;
                } else {
                    if (sumLeft > sumRight) {
                        sumRight += center;
                        counter++;
                    } else {
                        sumLeft += center;
                        counter++;
                    }

                }
            }



        }
        result=result.trim();
        System.out.print(result);


    }
}
