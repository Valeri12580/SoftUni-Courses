import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SantaList {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        List<String>kids= Arrays.stream(reader.readLine().split("&")).collect(Collectors.toList());

        String[]command=reader.readLine().split(" ");

        while (!command[0].equals("Finished!")){
            String firstPosition=command[0];
            String kidName=command[1];
            boolean isExist=kids.contains(kidName);
            switch (firstPosition){
                case "Bad":
                    if(!isExist){
                        kids.add(0,kidName);
                    }


                    break;

                case "Good":
                    if(isExist){
                        kids.remove(kidName);

                    }

                    break;

                case "Rename":
                    String newName=command[2];

                    if(isExist){
                        kids.add(kids.indexOf(kidName),newName);
                        kids.remove(kidName);
                    }
                    break;


                case "Rearrange":
                    if(isExist){
                        kids.remove(kidName);
                        kids.add(kidName);
                    }

                    break;

            }
            command=reader.readLine().split(" ");
        }
        System.out.println(kids.toString().replaceAll("[\\[\\]]",""));
    }
}
