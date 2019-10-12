import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SeizeTheFire {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("#+");
        List<Integer> result = new ArrayList<>();


        int water = Integer.parseInt(reader.readLine());
        int totalFire = 0;

        double effort = 0;

        for (int i = 0; i < input.length; i++) {
            String[] currentInput = input[i].split(" = ");
            String typeOfFire = currentInput[0];
            int level = Integer.parseInt(currentInput[1]);
            if(water<0){
                break;
            }
            switch (typeOfFire) {
                case "High":
                    if (level >= 81 && level <= 125) {
                        if (water -level< 0) {

                        } else {
                            water -= level;
                            effort += (level * 0.25);
                            totalFire += level;
                            result.add(level);
                        }

                    }
                    break;

                case "Medium":
                    if (level >= 51 && level <= 80) {
                        if (water -level < 0) {

                        } else {
                            water -= level;
                            effort += (level * 0.25);
                            totalFire += level;
                            result.add(level);
                        }

                    }
                    break;

                case "Low":
                    if (level >= 1 && level <= 50) {
                        if (water - level < 0) {

                        } else {
                            water -= level;
                            effort += (level * 0.25);
                            totalFire += level;
                            result.add(level);
                        }
                    }

                    break;


            }


        }
        System.out.println("Cells: ");
        for (int i = 0; i < result.size(); i++) {
            System.out.printf(" - %d%n", result.get(i));

        }
        System.out.println(String.format("Effort: %.2f", effort));
        System.out.println(String.format("Total Fire: %d", totalFire));


    }

}
