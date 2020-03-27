package hiberspring.util.interfaces;

import java.io.IOException;

public interface GsonUtil {
    <T> void saveJSONtoFile(String fileName, T item) throws IOException;
}
