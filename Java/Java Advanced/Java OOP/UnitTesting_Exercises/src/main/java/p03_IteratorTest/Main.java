package p03_IteratorTest;

import javax.naming.OperationNotSupportedException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException, OperationNotSupportedException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        String[] input= reader.readLine().split(" ");


        ListIterator ls=new ListIterator(Arrays.copyOfRange(input,1,input.length));



        while (!"END".equals(input=reader.readLine().split(" "))){
            switch (input[0]){
                case "HasNext":
                    System.out.println(ls.hasNext());
                    break;
                case "Print":
                    System.out.println(ls.print());
                    break;

                case "Move":
                    System.out.println(ls.move());
                    break;
            }
        }
    }
}
