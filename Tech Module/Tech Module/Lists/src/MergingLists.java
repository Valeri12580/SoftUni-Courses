import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MergingLists {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        String[]first=reader.readLine().split(" ");
        String[]second=reader.readLine().split(" ");

        List<Integer>listOne=new ArrayList<>();
        List<Integer>listTwo=new ArrayList<>();

        for (int i = 0; i <first.length; i++) {
            listOne.add(Integer.parseInt(first[i]));

        }
        for (int i = 0; i <second.length; i++) {
            listTwo.add(Integer.parseInt(second[i]));
        }

        List<Integer>result=new ArrayList<>();


        for (int i = 0; i <Math.max(listOne.size(),listTwo.size()); i++) {
            if(i<listOne.size()){
                result.add(listOne.get(i));
            }

            if(i<listTwo.size()){
                result.add(listTwo.get(i));

            }



        }

        for (int num:result
        ) {
            System.out.print(num+" ");
        }


    }
}
