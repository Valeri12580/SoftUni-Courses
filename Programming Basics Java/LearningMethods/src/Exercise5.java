import java.util.Arrays;
import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter array's length:");
        int length=Integer.parseInt(scanner.nextLine());
        System.out.print("Enter number's index:");
        int index=Integer.parseInt(scanner.nextLine());

        int[] myArray=gettingArray(length);
        result(myArray,index);






    }
    private static int[]gettingArray(int length){
        Scanner scanner=new Scanner(System.in);
        int[] array=new int[length];
        for (int i = 0; i <length; i++) {
            array[i]=Integer.parseInt(scanner.nextLine());

        }
        return array;

    }

    public static void result(int[]myArray,int index){
        if (index==0){
            if (myArray[index] > myArray[index+1]) {
                System.out.printf("Index е по-голямо от дясното число.");
            }else {
                System.out.println("Index е по-малко от дясното число.");
            }
            return;
        }else if (index==myArray.length-1){
            if(myArray[index]>myArray[index-1]){
                System.out.println("Index е по-голямо от лявото число.");
            }else {
                System.out.println("Index е по-малко от лявото число.");
            }

            return;
        }


        if(myArray[index]>myArray[index-1]){
            System.out.println("Index е по-голямо от лявото число.");
        }else {
            System.out.println("Index е по-малко от лявото число.");
        }
        if (myArray[index] > myArray[index+1]) {
            System.out.printf("Index е по-голямо от дясното число.");
        }else {
            System.out.println("Index е по-малко от дясното число.");
        }



    }
}
