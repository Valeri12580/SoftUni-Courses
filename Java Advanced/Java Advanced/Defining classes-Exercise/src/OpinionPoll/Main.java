package OpinionPoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<Person>data=new ArrayList<>();


        for (int i = 0; i <n ; i++) {
            String[] input=reader.readLine().split(" ");

            String name=input[0];
            int age= Integer.parseInt(input[1]);

            Person person=new Person(name,age);
            data.add(person);


        }
        data.stream().filter(e->e.getAge()>30).sorted((p1,p2)-> p1.getName().compareTo(p2.getName())).forEach(e->{
            System.out.println(e.getName()+" - "+e.getAge());
        });

    }
}
