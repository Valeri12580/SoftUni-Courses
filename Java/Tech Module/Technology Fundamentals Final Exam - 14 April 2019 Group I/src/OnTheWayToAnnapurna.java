import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OnTheWayToAnnapurna {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<String>>result=new HashMap<>();
        String command="";

        while(!"END".equals(command=reader.readLine())){

            String[]commandToArray=command.split("->");
            String normalCommand=commandToArray[0];
            String store=commandToArray[1];
            if (normalCommand.equals("Remove")){
                if (result.containsKey(store)) {
                    result.remove(store);

                }
                continue;

            }
            String[]items=commandToArray[2].split(",");

            int lengthOfItems=items.length;

            if(normalCommand.equals("Add")&&lengthOfItems==1){
                result.putIfAbsent(store,new ArrayList<>());
                result.get(store).add(items[0]);
            }else{
                result.putIfAbsent(store,new ArrayList<>());
                for (String item:items) {
                    result.get(store).add(item);
                }
            }

        }

        System.out.println("Stores list:");
        result.entrySet().stream().sorted((p1,p2)->{
            int comp=Integer.compare(p2.getValue().size(),p1.getValue().size());
            if(comp==0){
                comp=p2.getKey().compareTo(p1.getKey());
            }
            return comp;
        }).forEach(e->{
            System.out.println(String.format("%s",e.getKey()));
            for (String item:e.getValue()) {
                System.out.println(String.format("<<%s>>",item));

            }
        });


    }
}
