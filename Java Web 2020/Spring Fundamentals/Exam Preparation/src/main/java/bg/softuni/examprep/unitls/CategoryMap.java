package bg.softuni.examprep.unitls;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class CategoryMap {

    private static Map<String,String> imgPaths=new HashMap<>();

    static {
        imgPaths.put("FEMALE-DENIM","\\img\\FEMALE-DENIM.jpg");
        imgPaths.put("FEMALE-JACKET","\\img\\FEMALE-JACKET.jpg");
        imgPaths.put("FEMALE-SHIRT","\\img\\FEMALE-SHIRT.jpg");
        imgPaths.put("FEMALE-SHORTS","\\img\\FEMALE-SHORTS.jpg");
        imgPaths.put("MALE-DENIM","\\img\\FEMALE-DENIM.jpg");
        imgPaths.put("MALE-JACKET","\\img\\FEMALE-JACKET.jpg");
        imgPaths.put("MALE-SHIRT","\\img\\FEMALE-SHIRT.jpg");
        imgPaths.put("MALE-SHORTS","\\img\\FEMALE-SHORTS.jpg");
    }

    public static String getSpecificUrl(String url){
        return imgPaths.get(url);
    }
}
