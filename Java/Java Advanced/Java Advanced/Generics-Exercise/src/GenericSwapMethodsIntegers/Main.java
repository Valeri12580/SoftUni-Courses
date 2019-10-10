package GenericSwapMethodsIntegers;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));


        List<Box<Integer >>boxes=new ArrayList<>();

        int n =Integer.parseInt(reader.readLine());


        for (int i = 0; i <n ; i++) {
            String input=reader.readLine();
            Box<Integer>box=new Box<>(Integer.parseInt(input));
            boxes.add(box);
        }

        int[] command= Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        swapElements(boxes,command[0],command[1]);

        for (Box<Integer> box : boxes) {
            System.out.println(box.toString());

        }




    }

    private static <E >void swapElements(List<Box<E>> boxes, int firstIndex, int secondIndex) {
        Box<E> temp=boxes.get(firstIndex);
        boxes.set(firstIndex,boxes.get(secondIndex));
        boxes.set(secondIndex,temp);
    }
}
