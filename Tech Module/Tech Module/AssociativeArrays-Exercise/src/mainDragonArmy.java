import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class mainDragonArmy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        Map<String, Map<String, List<DragonArmy>>> result = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");
            String type = input[0];
            String name = input[1];
            String damage = input[2];
            String health = input[3];
            String armor = input[4];
            int damageToInt = 0;
            int healthToInt = 0;
            int armorToInt = 0;


            result.putIfAbsent(type, new TreeMap<>());


            if (!damage.equals("null")) {
                damageToInt = Integer.parseInt(input[2]);

            } else {
                damageToInt = 45;

            }
            if (!health.equals("null")) {
                healthToInt = Integer.parseInt(input[3]);
            } else {
                healthToInt = 250;
            }
            if (!armor.equals("null")) {
                armorToInt = Integer.parseInt(input[4]);
            } else {
                armorToInt = 10;
            }

            DragonArmy currentDragon = new DragonArmy(damageToInt, healthToInt, armorToInt);
            result.get(type).put(name, new ArrayList<>());
            if (result.get(type).containsKey(name)) {
                result.get(type).get(name).clear();
                result.get(type).get(name).add(currentDragon);
            } else {
                result.get(type).get(name).add(currentDragon);
            }

        }


        for (Map.Entry<String, Map<String, List<DragonArmy>>> firstMap : result.entrySet()) {
            double averageDamage = 0;
            double averageHealth = 0;
            double averageArmor = 0;
            int count = 0;
            String currentType = "";
            count = firstMap.getValue().size();
            currentType = firstMap.getKey();
            for (Map.Entry<String, List<DragonArmy>> secondMap : firstMap.getValue().entrySet()) {
                averageDamage += secondMap.getValue().get(0).getDamage();
                averageHealth += secondMap.getValue().get(0).getHealth();
                averageArmor += secondMap.getValue().get(0).getArmor();

            }
            averageDamage /= count;
            averageHealth /= count;
            averageArmor /= count;
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", currentType, averageDamage, averageHealth, averageArmor);
            firstMap.getValue().entrySet().forEach(j -> {

                String name = j.getKey();
                int damage = j.getValue().get(0).getDamage();
                int health = j.getValue().get(0).getHealth();
                int armor = j.getValue().get(0).getArmor();
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", name, damage, health, armor
                );

            });


        }


    }

    public static class DragonArmy {
        private int damage = 0;
        private int health = 0;
        private int armor = 0;

        public DragonArmy(int damage, int health, int armor) {
            this.damage = damage;
            this.health = health;
            this.armor = armor;
        }


        public int getDamage() {
            return damage;
        }

        public void setDamage(int damage) {
            this.damage = damage;
        }

        public int getHealth() {
            return health;
        }

        public void setHealth(int health) {
            this.health = health;
        }

        public int getArmor() {
            return armor;
        }

        public void setArmor(int armor) {
            this.armor = armor;
        }
    }


}


