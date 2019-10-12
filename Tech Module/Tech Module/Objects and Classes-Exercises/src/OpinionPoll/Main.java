package OpinionPoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(reader.readLine());
        List<OpinionPoll>dataPersons=new ArrayList<OpinionPoll>();

        for (int i = 0; i <n ; i++) {
            String[]data=reader.readLine().split("\\s+");

            OpinionPoll person=new OpinionPoll(data[0],Integer.parseInt(data[1]));
            dataPersons.add(person);
        }

        dataPersons.stream().filter(person->person.getAge()>30).sorted(Comparator.comparing(p -> p.getName())).forEach(e-> System.out.println(e.toString()));

    }
}
