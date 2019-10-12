import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FinalQuest {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        List<String> input = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());

        String[]command=reader.readLine().split("\\s+");

        while (!command[0].equals("Stop")){
            switch (command[0]){
                case "Delete":
                        int index=Integer.parseInt(command[1]);
                        if(index+1<input.size() && index+1>=0){
                            input.remove(index+1);

                        }

                    break;

                case "Swap":
                        String wordOne=command[1];
                        String wordTwo=command[2];

                        boolean wordOneIsExist=input.contains(wordOne);
                        boolean wordTwoIsExist=input.contains(wordTwo);
                        if(wordOneIsExist && wordTwoIsExist){
                            Collections.swap(input,input.indexOf(wordOne),input.indexOf(wordTwo));
                        }

                    break;


                case "Put":
                    String word=command[1];
                    int indexPut=Integer.parseInt(command[2]);
                    if((indexPut-1)>=0 && indexPut-1<=input.size()){
                        input.add(indexPut-1,word);
                    }


                    break;
                case "Sort":
                    input=input.stream().sorted((p1,p2) -> p2.compareTo(p1)).collect(Collectors.toList());

                    break;
                case "Replace":
                        String firstWord=command[1];
                        String secondWord=command[2];
                        int indexofSecondWord=input.indexOf(secondWord);
                        if(input.contains(secondWord)){
                            input.set(indexofSecondWord,firstWord);
                        }
                    break;
            }

            command=reader.readLine().split(" ");


        }
        System.out.println(input.toString().replaceAll("[\\[\\],]",""));
    }
}
