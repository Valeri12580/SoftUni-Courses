package GenericCountMethodDoubles;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        List<Box<Double>> boxes=new ArrayList<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i <n ; i++) {
            String input=reader.readLine();
            Box<Double>box=new Box<>();
            box.setData(Double.parseDouble(input));

            boxes.add(box);

        }

        Double comparingElement= Double.valueOf(reader.readLine());
        getCount(boxes,comparingElement);


    }

    private static<E extends Comparable<E>> void getCount(List<Box<E>> boxes, E comparingElement) {

        int count=0;
        for (Box<E> box : boxes) {
            if(box.getData().compareTo(comparingElement)>0){
                count++;
            }

        }
        System.out.println(count);

    }
}
