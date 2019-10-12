import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input=scanner.nextLine();

        List<String>input2=Arrays.stream(input.split(" ")).collect(Collectors.toList());
        List<Double>numbers=new ArrayList<>();
        for (int i = 0; i <input2.size(); i++) {
            numbers.add(Double.parseDouble(input2.get(i)));

        }


        for (int i=0; i <numbers.size()-1; i++) {
            Double firstNum=numbers.get(i);
            Double lastNum=numbers.get(numbers.size()-1);

           numbers.set(i,firstNum+lastNum);
           numbers.remove(numbers.size()-1);


            
        }
        formatting(numbers);


    }

    static void formatting(List<Double>numbers){
        DecimalFormat df=new DecimalFormat("#.##");

        for (Double num:numbers
             ) {
            System.out.print(df.format(num)+" ");
        }

    }

}
