package enterNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        int start=0;
        int end=0;
        while (true){
            try {
                start=Integer.parseInt(reader.readLine());
                end=Integer.parseInt(reader.readLine());
                if(start <0 || end<=0){
                    throw  new IllegalArgumentException("The number cannot be negative!");
                }
                printNumbers(start,end);
                return;
            }catch (NumberFormatException ex){
                System.out.println("Enter number");

            }catch (IllegalArgumentException exArgument){
                System.out.println(exArgument.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

    private static void printNumbers(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.println(i);
        }
    }


}
