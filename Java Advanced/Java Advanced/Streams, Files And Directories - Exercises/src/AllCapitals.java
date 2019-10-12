import java.io.*;

public class AllCapitals {
    public static void main(String[] args) {
        File file=new File("C:\\Users\\Valer\\OneDrive\\Работен плот\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        File fileOut=new File("C:\\\\Users\\\\Valer\\\\OneDrive\\\\Работен плот\\\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\zaTesta.txt");

        try {
            BufferedReader reader=new BufferedReader(new FileReader(file));
            PrintWriter writer=new PrintWriter(fileOut);

            String line=reader.readLine();

            while (line!=null){
                line=line.toUpperCase();
                writer.println(line);
                line=reader.readLine();
            }
            reader.close();
            writer.close();



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
