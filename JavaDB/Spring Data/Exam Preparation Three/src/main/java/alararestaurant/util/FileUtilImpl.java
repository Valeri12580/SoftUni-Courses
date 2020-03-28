package alararestaurant.util;



import alararestaurant.util.interfaces.FileUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUtilImpl implements FileUtil {


    public String readContent(String path) throws IOException {
        StringBuilder sb = new StringBuilder();

        FileReader fileReader = new FileReader(path);
        BufferedReader reader = new BufferedReader(fileReader);

        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
