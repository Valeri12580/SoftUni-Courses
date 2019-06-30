package ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Person>data=new ArrayList<>();

        String input="";
        while (!"END".equals(input=scanner.nextLine())){
            String []inputToArray=input.split("\\s+");

            Person person=new Person(inputToArray[0],Integer.parseInt(inputToArray[1]),inputToArray[2]);

            data.add(person);

        }
        int personNumber=Integer.parseInt(scanner.nextLine())-1;
        Person person=data.get(personNumber);
        int equalsPeople=1;
        int notequalsPeople=0;
        int totalNumberOfPeople=data.size();
        for (int i=0;i<personNumber;i++) {
            Person datum=data.get(i);
            if(datum.getName().compareTo(person.getName())==0&&Integer.compare(datum.getAge(),person.getAge())==0 &&
            datum.getTown().compareTo(person.getTown())==0){
                equalsPeople++;
            }else{
                notequalsPeople++;
            }
        }
        for (int i = personNumber+1; i <data.size(); i++) {
            Person datum=data.get(i);
            if(datum.getName().compareTo(person.getName())==0&&Integer.compare(datum.getAge(),person.getAge())==0 &&
                    datum.getTown().compareTo(person.getTown())==0){
                equalsPeople++;
            }else{
                notequalsPeople++;
            }
        }
        if(equalsPeople==1){
            System.out.println("No matches");
        }else{
            System.out.printf("%d %d %d",equalsPeople,notequalsPeople,totalNumberOfPeople);
        }


    }

}
