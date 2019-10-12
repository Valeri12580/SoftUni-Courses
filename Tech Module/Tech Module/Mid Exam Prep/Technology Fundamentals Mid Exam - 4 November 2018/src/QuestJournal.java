import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuestJournal {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        List<String>journal= Arrays.stream(reader.readLine().split(", ")).collect(Collectors.toList());

        String input="";

        while (!"Retire!".equals(input=reader.readLine())){
            String[] command=input.split(" - ");
            boolean isExists=journal.contains(command[1]);
            switch (command[0]){
                case "Start":
                    isExists=journal.contains(command[1]);
                    if(isExists){
                        continue;
                    }else{
                        journal.add(command[1]);
                    }

                    break;

                case "Complete":
                   isExists=journal.contains(command[1]);
                   if(isExists) {
                       journal.remove(command[1]);
                   }else{
                       continue;
                   }

                    break;

                case "Side Quest":
                    String[]inputforSide=command[1].split(":");
                    int indexof=journal.indexOf(inputforSide[0]);
                    boolean isExitSide=journal.contains(inputforSide[1]);
                    if(indexof!=-1 && !isExitSide){
                        journal.add(indexof+1,inputforSide[1]);
                    }else{

                    }



                    break;

                case "Renew":
                    if(isExists){
                        int index=journal.indexOf(command[1]);
                        journal.add(journal.get(index));
                        journal.remove(index);
                    }

                    break;

            }




        }

        System.out.println(journal.toString().replaceAll("[\\[\\]]",""));
    }
}
