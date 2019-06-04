import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) {
        String pathInput="C:\\Users\\Valer\\OneDrive\\Работен плот\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOutput="C:\\Users\\Valer\\OneDrive\\Работен плот\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\CopyBytes.txt";


        try(FileInputStream fis = new FileInputStream(pathInput)) {
            FileOutputStream fos=new FileOutputStream(pathOutput);

            int byteInput=fis.read();

            while (byteInput>=0){
                if(byteInput==32|| byteInput==10){
                    fos.write(byteInput);


                }else{
                    String byteAsText=String.valueOf(byteInput);
                    for (int i = 0; i <byteAsText.length(); i++) {
                        int symbol=byteAsText.charAt(i);
                        fos.write(symbol);

                    }
                }
                byteInput=fis.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
