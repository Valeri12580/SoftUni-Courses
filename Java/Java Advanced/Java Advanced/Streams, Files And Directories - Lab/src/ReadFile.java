import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        String path="C:\\Users\\Valer\\OneDrive\\Работен плот\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        try(FileInputStream fis=new FileInputStream(path)){
            int oneByte=fis.read();

            while (oneByte>=0){

                System.out.print(Integer.toBinaryString(oneByte)+" ");
                oneByte=fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
