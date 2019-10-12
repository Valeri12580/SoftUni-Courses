import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());
        long max=Long.MIN_VALUE;
        int[] result=new int[3];


        for (int i = 0; i <n; i++) {
            int snowBallSnow=Integer.parseInt(scanner.nextLine());
            int snowBallTime=Integer.parseInt(scanner.nextLine());
            int snowBallQuality=Integer.parseInt(scanner.nextLine());
            if(snowBallValue(snowBallSnow,snowBallTime,snowBallQuality)>max){
                max=snowBallValue(snowBallSnow,snowBallTime,snowBallQuality);
                result[0]=snowBallSnow;
                result[1]=snowBallTime;
                result[2]=snowBallQuality;
            }

        }
        System.out.printf("%d : %d = %d (%d)",result[0],result[1],max,result[2]);



    }


    public static long snowBallValue(int snowBallSnow,int snowBallTime,int snowballQuality){
        long result= (long) Math.pow((snowBallSnow/snowBallTime),snowballQuality);

        return result;

    }
}
