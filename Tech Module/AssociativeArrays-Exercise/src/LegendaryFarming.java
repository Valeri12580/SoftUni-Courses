import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class LegendaryFarming {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        Map<String,Integer>keyMaterials=new LinkedHashMap<>();
        keyMaterials.put("shards",0);
        keyMaterials.put("fragments",0);
        keyMaterials.put("motes",0);
        String winner="";
        boolean flag=false;


        Map<String,Integer>junk=new TreeMap<>();
        while (true) {
            String[]data=reader.readLine().split("\\s+");
            for (int i = 0; i <data.length; i+=2) {
                int q= Integer.parseInt(data[i]);
                String material=data[i+1].toLowerCase();

                if(!keyMaterials.containsKey(material)){
                    if(!junk.containsKey(material)){
                        junk.put(material,q);
                    }else{
                        junk.put(material,junk.get(material)+q);
                    }
                }else{
                    keyMaterials.put(material,keyMaterials.get(material)+q);
                    if(keyMaterials.get(material)>=250){
                        keyMaterials.put(material,keyMaterials.get(material)-250);
                        winner=material;
                        flag=true;
                        break;
                    }
                }

            }
            if(flag){
                break;
            }
        }
        if(winner.equals("shards")){
            System.out.println(String.format("%s obtained!","Shadowmourne"));

        }else if (winner.equals("fragments")){
            System.out.println(String.format("%s obtained!","Valanyr"));

        }else{
            System.out.println(String.format("%s obtained!","Dragonwrath"));
        }

        keyMaterials.entrySet().stream().sorted((e1,e2)->{
            int sort=Integer.compare(e2.getValue(),e1.getValue());

            if(sort==0){
                sort=e1.getKey().compareTo(e2.getKey());

            }
            return sort;

        }).forEach(e->{
            System.out.println(String.format("%s: %d",e.getKey(),e.getValue()));
        });

        junk.entrySet().forEach(e->{
            System.out.println(String.format("%s: %d",e.getKey(),e.getValue()));
        });



    }
}
