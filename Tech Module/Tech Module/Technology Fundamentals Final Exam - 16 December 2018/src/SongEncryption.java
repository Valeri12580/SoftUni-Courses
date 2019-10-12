import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SongEncryption {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));


        String command="";

        while (!"end".equals(command=reader.readLine())) {
            String[]input=command.split("[:]");
            String artist=input[0];
            String song=input[1];

            Pattern patternForArtist=Pattern.compile("^[A-Z][a-z ']+$");
            Matcher matcherForArtist=patternForArtist.matcher(artist);
            Pattern patternForSong=Pattern.compile("^[A-Z ]+$");
            Matcher matcherForSong=patternForSong.matcher(song);

            if(!(matcherForArtist.find()&& matcherForSong.find())){
                System.out.println("Invalid input!");
                continue;
            }

            int key=artist.length();
            StringBuilder crypted= new StringBuilder();
            for (int i = 0; i <1; i++) {
                for (int j = 0; j <command.indexOf(":"); j++) {
                    char currentChar=command.charAt(j);
                    if(String.valueOf(currentChar).equals(" ")||String.valueOf(currentChar).equals("'")){
                        if(String.valueOf(currentChar).equals(" ")){
                            crypted.append(" ");
                        }else{
                            crypted.append("'");
                        }

                        continue;

                    }
                    if (!(currentChar+key>122)) {
                        crypted.append(String.valueOf(Character.toChars(currentChar + key)));
                    }else{
                        int tempKey=currentChar+key-122;
                        crypted.append(String.valueOf(Character.toChars('a' + tempKey - 1)));
                    }
                }
                crypted.append("@");
                for (int j = command.indexOf(":")+1; j <command.length(); j++) {
                    char currentChar=command.charAt(j);
                    if(String.valueOf(currentChar).equals(" ")||String.valueOf(currentChar).equals("'")){
                        if(String.valueOf(currentChar).equals(" ")){
                            crypted.append(" ");
                        }else{
                            crypted.append("'");
                        }

                        continue;

                    }
                    if (!(currentChar+key>90)) {
                        crypted.append(String.valueOf(Character.toChars(currentChar + key)));
                    }else{
                        int tempKey=currentChar+key-90;


                        crypted.append(String.valueOf(Character.toChars('A' + tempKey - 1)));
                    }

                }
                System.out.println(String.format("Successful encryption: %s", crypted.toString()));


            }
        }
    }
}
