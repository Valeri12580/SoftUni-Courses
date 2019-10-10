package CustomList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        CustomList<String> list = new CustomList<String>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String input = "";

        while (!"END".equals(input = reader.readLine())) {

            String[] inputToArray = input.split(" ");
            String command = inputToArray[0];
            switch (inputToArray.length) {

                case 1:
                    if (command.equals("Max")) {
                        System.out.println(list.getMax());
                    } else if (command.equals("Min")) {
                        System.out.println(list.getMin());
                    } else if (command.equals("Sort")) {
                        Sorter.sortirane(list);

                    } else {
                        list.print();
                    }

                    break;


                case 2:
                    if (command.equals("Add")) {
                        list.add(inputToArray[1]);
                    } else if (command.equals("Remove")) {
                        list.remove(Integer.parseInt(inputToArray[1]));
                    } else if (command.equals("Contains")) {
                        System.out.println(list.contains(inputToArray[1]));
                    } else {
                        System.out.println(list.countGreaterThan(inputToArray[1]));
                    }

                    break;


                case 3:
                    list.swap(Integer.parseInt(inputToArray[1]), Integer.parseInt(inputToArray[2]));

                    break;
            }

        }


    }
}
