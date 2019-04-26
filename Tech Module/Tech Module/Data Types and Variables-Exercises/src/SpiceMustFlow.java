import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpiceMustFlow {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int startingYield = Integer.parseInt(reader.readLine());

        int totalYield = 0;
        int counterDays = 0;

        while (startingYield >= 100) {
            totalYield += startingYield;
            if (totalYield >= 26) {
                totalYield -= 26;
            } else {
                totalYield -= totalYield;

            }

            startingYield -= 10;
            counterDays++;


        }
        if (totalYield >= 26) {
            totalYield -= 26;
        } else {
            totalYield -= totalYield;

        }
        System.out.println(counterDays);
        System.out.println(totalYield);
    }
}
