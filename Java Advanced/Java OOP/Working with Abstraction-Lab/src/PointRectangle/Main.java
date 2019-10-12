package PointRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner (System.in);

        int[]num= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Rectangle rectangle=new Rectangle(num[0],num[1],num[2],num[3]);

        int n=Integer.parseInt(scanner.nextLine());

        while (n-->0){
            int[]num2= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Point point=new Point(num2[0],num2[1]);
            System.out.println(rectangle.cointains(point));
        }


    }
}
