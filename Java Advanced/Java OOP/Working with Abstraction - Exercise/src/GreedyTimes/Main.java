package GreedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long input = Long.parseLong(scanner.nextLine());
        String[] seif = scanner.nextLine().split("\\s+");

        var torba = new LinkedHashMap<String, LinkedHashMap<String, Long>>();
        long zlato = 0;
        long kamuni = 0;
        long mangizi = 0;

        for (int i = 0; i < seif.length; i += 2) {
            String name = seif[i];
            long numberOfTypes = Long.parseLong(seif[i + 1]);
    
            String type = "";

            if (name.length() == 3) {
                type = "Cash";
            } else if (name.toLowerCase().endsWith("gem")) {
                type = "Gem";
            } else if (name.toLowerCase().equals("gold")) {
                type = "Gold";
            }

            if (type.equals("")) {
                continue;
            } else if (input < torba.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + numberOfTypes) {
                continue;
            }

            switch (type) {
                case "Gem":
                    if (!torba.containsKey(type)) {
                        if (torba.containsKey("Gold")) {
                            if (numberOfTypes > torba.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (torba.get(type).values().stream().mapToLong(e -> e).sum() + numberOfTypes > torba.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!torba.containsKey(type)) {
                        if (torba.containsKey("Gem")) {
                            if (numberOfTypes > torba.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (torba.get(type).values().stream().mapToLong(e -> e).sum() + numberOfTypes > torba.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            if (!torba.containsKey(type)) {
                torba.put((type), new LinkedHashMap<String, Long>());
            }

            if (!torba.get(type).containsKey(name)) {
                torba.get(type).put(name, 0L);
            }


            torba.get(type).put(name, torba.get(type).get(name) + numberOfTypes);
            if (type.equals("Gold")) {
                zlato += numberOfTypes;
            } else if (type.equals("Gem")) {
                kamuni += numberOfTypes;
            } else if (type.equals("Cash")) {
                mangizi += numberOfTypes;
            }
        }

        for (var x : torba.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.println(String.format("<%s> $%s", x.getKey(), sumValues));

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }
}