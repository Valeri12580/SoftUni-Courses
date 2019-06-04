import java.io.*;

public class CountCharacterTypes {
    public static void main(String[] args) {
        File file=new File("C:\\Users\\Valer\\OneDrive\\Работен плот\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        File fileOut=new File("C:\\Users\\Valer\\OneDrive\\Работен плот\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\zaTesta.txt");

        try {
            BufferedReader reader=new BufferedReader(new FileReader(file));
            PrintWriter writer=new PrintWriter(fileOut);
            int vowels=0;
            int consonants=0;
            int punctuation=0;
            String vow="aouei";
            String punc=".,!?";

            String line=reader.readLine();
            while (line!=null){

                for (char c : line.toCharArray()) {
                     if(punc.contains(c+"")){
                        punctuation++;

                    }else{
                        if(vow.contains(c+"")){
                            vowels++;
                        }else if(c!=' ') {
                            consonants++;
                        }
                    }

                }


                line=reader.readLine();
            }

            writer.printf("Vowels: %d%nConsonants: %d%nPunctuation: %d",vowels,consonants,punctuation);
            System.out.println();
            writer.close();






        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
