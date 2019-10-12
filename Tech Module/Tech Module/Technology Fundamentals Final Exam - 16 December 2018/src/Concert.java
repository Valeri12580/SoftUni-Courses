import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Concert {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<String>> bandsInfo = new LinkedHashMap<>();
        Map<String, Integer> bandsTime = new HashMap<>();
        int totalTime=0;

        String command = "";

        while (!"start of concert".equals(command = reader.readLine())) {
            String[] commandToArray = command.split("; ");
            String[] membersOrTime = commandToArray[2].split(", ");

            if (commandToArray[0].equals("Add")) {
                if (!bandsInfo.containsKey(commandToArray[1])) {
                    bandsInfo.put(commandToArray[1], new ArrayList<>());
                    for (String member : membersOrTime) {
                        if (!bandsInfo.get(commandToArray[1]).contains(member)) {
                            bandsInfo.get(commandToArray[1]).add(member);
                        }


                    }


                } else {
                    for (String member : membersOrTime) {
                        if (!bandsInfo.get(commandToArray[1]).contains(member)) {
                            bandsInfo.get(commandToArray[1]).add(member);
                        }

                    }

                }

            }else {
                totalTime+=Integer.parseInt(membersOrTime[0]);
                if(!bandsTime.containsKey(commandToArray[1])){
                    bandsTime.put(commandToArray[1],Integer.parseInt(membersOrTime[0]));

                }else{
                    int oldTime=bandsTime.get(commandToArray[1]);
                    bandsTime.put(commandToArray[1],oldTime+Integer.parseInt(membersOrTime[0]));
                }
            }

        }
        String lastInput=reader.readLine();
        System.out.println("Total time: "+totalTime);
        bandsTime.entrySet().stream().sorted((p1,p2)->{
            int sorted=Integer.compare(p2.getValue(),p1.getValue());
            if(sorted==0){
                sorted=p1.getKey().compareTo(p2.getKey());
            }
            return sorted;

        }).forEach(e-> System.out.println(String.format("%s -> %d",e.getKey(),e.getValue())));

        System.out.println(lastInput);
        bandsInfo.get(lastInput).forEach(e->{
            System.out.println(String.format("=> %s",e));
        });




    }
}
