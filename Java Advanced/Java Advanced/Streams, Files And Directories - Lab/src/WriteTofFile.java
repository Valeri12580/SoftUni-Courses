import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteTofFile {
    public static void main(String[] args) {
        String pathInput="C:\\Users\\Valer\\OneDrive\\Работен плот\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOutput="C:\\Users\\Valer\\OneDrive\\Работен плот\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\WriteToFileOutput.txt";
        String result="";
        try(FileInputStream fis=new FileInputStream(pathInput)){
            FileOutputStream fos=new FileOutputStream(pathOutput);
            int oneByte=fis.read();

            while (oneByte>=0){
                if(oneByte!=','&&oneByte!='?'&&oneByte!='.'&& oneByte!='!'){
                    fos.write(oneByte);
                }
                oneByte=fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
