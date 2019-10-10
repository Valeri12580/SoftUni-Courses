import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ExerciseOne {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] chemicalLiquidsinput = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] physicalItems = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Deque<Integer> liquidsItemsQueue = new ArrayDeque<>();
        Deque<Integer> physicItemsStack = new ArrayDeque<>();
//
        Map<String, Integer> storedAdvancedItems = new TreeMap<>();
        storedAdvancedItems.putIfAbsent("Glass", 0);
        storedAdvancedItems.putIfAbsent("Aluminium", 0);
        storedAdvancedItems.putIfAbsent("Carbon fiber", 0);
        storedAdvancedItems.putIfAbsent("Lithium", 0);

        for (int i = 0; i < chemicalLiquidsinput.length; i++) {
            liquidsItemsQueue.add(chemicalLiquidsinput[i]);

        }

        for (int i = 0; i < physicalItems.length; i++) {
            physicItemsStack.push(physicalItems[i]);

        }



        while (!liquidsItemsQueue.isEmpty() && !physicItemsStack.isEmpty()) {
            int currentLiquid = liquidsItemsQueue.poll();
            int currentPhysic = physicItemsStack.pop();
            int sum = currentLiquid + currentPhysic;

            if (sum == 25) {

                storedAdvancedItems.put("Glass", storedAdvancedItems.get("Glass") + 1);


            } else if (sum == 50) {


                storedAdvancedItems.put("Aluminium", storedAdvancedItems.get("Aluminium") + 1);

            } else if (sum == 75) {


                storedAdvancedItems.put("Lithium", storedAdvancedItems.get("Lithium") + 1);


            } else if (sum == 100) {


                storedAdvancedItems.put("Carbon fiber", storedAdvancedItems.get("Carbon fiber") + 1);

            } else {

                currentPhysic += 3;
                physicItemsStack.push(currentPhysic);

            }

        }
        if (storedAdvancedItems.get("Glass")!=0 && storedAdvancedItems.get("Aluminium")!=0 && storedAdvancedItems.get("Lithium")!=0 &&
                storedAdvancedItems.get("Carbon fiber")!=0) {
            System.out.println("Wohoo! You succeeded in building the spaceship!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to build the spaceship.");
        }

        if (!liquidsItemsQueue.isEmpty()) {
            System.out.print("Liquids left: ");
            while (!liquidsItemsQueue.isEmpty()) {
                if (liquidsItemsQueue.size() == 1) {
                    System.out.printf("%d", liquidsItemsQueue.poll());
                    break;
                }
                System.out.printf("%d, ", liquidsItemsQueue.poll());
            }

        } else {
            System.out.println("Liquids left: none");
        }

        if (!physicItemsStack.isEmpty()) {
            System.out.print("Physical items left: ");
            while (!physicItemsStack.isEmpty()) {
                if (physicItemsStack.size() == 1) {
                    System.out.printf("%d", physicItemsStack.pop());
                    break;
                }
                System.out.printf("%d, ", physicItemsStack.pop());
            }

        } else {
            System.out.print("Physical items left: none");
        }
        System.out.println();


        System.out.printf("Aluminium: %d%n",storedAdvancedItems.get("Aluminium"));
        System.out.printf("Carbon fiber: %d%n",storedAdvancedItems.get("Carbon fiber"));
        System.out.printf("Glass: %d%n",storedAdvancedItems.get("Glass"));
        System.out.printf("Lithium: %d%n",storedAdvancedItems.get("Lithium"));





    }

}

