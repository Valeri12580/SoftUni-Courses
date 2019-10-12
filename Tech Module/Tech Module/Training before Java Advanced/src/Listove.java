import java.util.HashMap;
import java.util.Map;

public class Listove {
    public static void main(String[] args) {

        Map<String,Integer>proba=new HashMap<>();


        proba.put("AtanasadQW",10);
        proba.put("Boris",8);
        proba.put("Valeri",10);


        proba.entrySet().stream().sorted((p1,p2)->{
            int comp=Integer.compare(p2.getValue(),p1.getValue());
            if(comp==0){
                comp=p2.getKey().compareTo(p1.getKey());
                return comp;

            }
            return comp;
        }).forEach(e-> System.out.println(String.format("%s->%d",e.getKey(),e.getValue())));
    }
}
