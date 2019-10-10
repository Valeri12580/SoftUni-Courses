import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int[] numbers= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String[] command=scanner.nextLine().split("\\s+");

        while(!command[0].equals("end")){
            switch (command[0]){
                case "exchange":
                    numbers=exchange(numbers,Integer.parseInt(command[1]));
                    break;


                case "min":
                    getMinIndex(numbers, command[1]);

                    break;

                case "max":
                    getMaxIndex(numbers, command[1]);
                    break;

                case "first":
                    firstCountElements(numbers,Integer.parseInt(command[1]),command[2]);
                    break;

                case "last":
                    lastCountElements(numbers,Integer.parseInt(command[1]),command[2]);
                    break;
            }
            command=scanner.nextLine().split("\\s+");


        }
        System.out.println(Arrays.toString(numbers));


    }

    private static void lastCountElements(int[] numbers, int count, String command) {
        int counter=1;
        if(count>=numbers.length && count<0){
            System.out.println("Invalid count");
            return;
        }
        int[]result=new int[count];
        switch (command){
            case "even":

                for (int i = numbers.length-1; 0<i; i--) {
                    if(numbers[i]%2==0){
                        result[counter]=numbers[i];
                        counter--;
                    }
                    if(counter<0){
                        break;
                    }

                }
                break;
            case "odd":
                for (int i = numbers.length-1; 0<i; i--) {
                    if(numbers[i]%2==1){
                        result[counter]=numbers[i];
                        counter--;
                    }
                    if(counter<0){
                        break;
                    }

                }
                break;
        }
        if (counter==1){
            System.out.println("[]");
        }else{
            System.out.println(Arrays.toString(result));
        }

    }

    private static void firstCountElements(int[] numbers, int count , String command) {
        int counter=0;
        if(count>=numbers.length || count<0){
            System.out.println("Invalid count");
            return;
        }
        int[]result=new int[count];
        switch (command){
            case "even":
                for (int i = 0; i <numbers.length; i++) {
                    if(numbers[i]%2==0){
                        result[i]=numbers[i];
                        counter++;
                    }
                    if(counter==count){
                        break;
                    }

                }
                break;
            case "odd":
               counter=0;
                for (int i = 0; i <numbers.length; i++) {
                    if(numbers[i]%2==1){
                        result[i]=numbers[i];
                        counter++;
                    }
                    if(counter==count){
                        break;
                    }

                }
                break;
        }
        if (counter==0){
            System.out.println("[]");
        }else {
            System.out.println(Arrays.toString(result));
        }


    }

    static int[] exchange(int[]numbers,int index){
        if(index>=numbers.length || index<0){
            System.out.println("Invalid index");
            return numbers;
        }
        int[]result=new int[numbers.length];
        int count =0;
        for (int i = index+1; i <numbers.length; i++) {
            result[count]=numbers[i];
            count++;

        }
        for (int i = 0; i <=index; i++) {
            result[count++]=numbers[i];

        }
        return result;


    }

    static void getMaxIndex(int[]numbers,String command){
        int max=Integer.MIN_VALUE;
        int index=-1;
        switch (command){
            case "even":
                for (int i = 0; i <numbers.length; i++) {
                    if (numbers[i]%2==0 && numbers[i]>=max){
                        max=numbers[i];
                        index=i;
                    }
                }
                break;

            case "odd":
                for (int i = 0; i <numbers.length; i++) {
                    if (numbers[i]%2==1 && numbers[i]>=max){
                        max=numbers[i];
                        index=i;
                    }
                }

                break;
        }
        if(index==-1){
            System.out.println("No matches");

        }else{
            System.out.println(index);
        }


    }

    static void getMinIndex(int[] numbers,String command){
        int min=Integer.MAX_VALUE;
        int index=-1;
        switch (command){
            case "even":
                for (int i = 0; i <numbers.length; i++) {
                    if (numbers[i]%2==0 && numbers[i]<=min){
                        min=numbers[i];
                        index=i;
                    }
                }
                break;

            case "odd":
                for (int i = 0; i <numbers.length; i++) {
                    if (numbers[i]%2==1 && numbers[i]<=min){
                        min=numbers[i];
                        index=i;
                    }
                }

                break;
        }
        if(index==-1){
            System.out.println("No matches");

        }else{
            System.out.println(index);
        }



    }
}
