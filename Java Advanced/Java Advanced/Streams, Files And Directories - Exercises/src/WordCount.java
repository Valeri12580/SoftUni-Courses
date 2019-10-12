import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) {
        File file=new File("C:\\Users\\Valer\\OneDrive\\Работен плот\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt");
        File fileOut=new File("C:\\Users\\Valer\\OneDrive\\Работен плот\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\zaTesta.txt");
        Map<String,Integer>data=new LinkedHashMap<>();

        try {
            BufferedReader reader=new BufferedReader(new FileReader(file));
            PrintWriter writer=new PrintWriter(fileOut);
            String line=reader.readLine();
            while (line!=null){
                String[] lineToArray=line.split(" ");
                for (int i = 0; i <lineToArray.length ; i++) {
                    data.putIfAbsent(lineToArray[i],0);
                    data.put(lineToArray[i],data.get(lineToArray[i])+1);
                }

                line=reader.readLine();

            }

            data.entrySet().stream().sorted((p1,p2)->Integer.compare(p2.getValue(),p1.getValue())).forEach(e->{
                writer.printf("%s - %d%n",e.getKey(),e.getValue());
            });


            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
