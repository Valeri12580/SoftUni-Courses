import System.HardwareComponents.HeavyHardware;
import System.HardwareComponents.PowerHardware;
import System.Interfaces.Hardware;
import System.Interfaces.Software;
import System.SoftwareComponents.ExpressSoftware;
import System.SoftwareComponents.LightSoftware;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Hardware> hardwareComponents = new LinkedHashMap<>();
        Map<String, Software> softwareComponents = new LinkedHashMap<>();

        String input = "";
        while (!"System Split".equals(input = reader.readLine())) {
            String[] inputToArray = input.split("[\\(, )]+");
            String command = inputToArray[0];
            switch (command) {
                case "RegisterPowerHardware":
                    Hardware powerHardware = new PowerHardware(inputToArray[1], Integer.parseInt(inputToArray[2]), Integer.parseInt(inputToArray[3]));
                    hardwareComponents.put(inputToArray[1], powerHardware);

                    break;

                case "RegisterHeavyHardware":
                    Hardware heavyHardware = new HeavyHardware(inputToArray[1], Integer.parseInt(inputToArray[2]), Integer.parseInt(inputToArray[3]));
                    hardwareComponents.put(inputToArray[1], heavyHardware);
                    break;

                case "RegisterExpressSoftware":
                    Software expressSoftware = new ExpressSoftware(inputToArray[2], Integer.parseInt(inputToArray[3]), Integer.parseInt(inputToArray[4]));
                    int freeCapacity = hardwareComponents.get(inputToArray[1]).getMaximumCapacity() - hardwareComponents.get(inputToArray[1]).getUsedCapacity();
                    int freeMemory = hardwareComponents.get(inputToArray[1]).getMaximumMemory() - hardwareComponents.get(inputToArray[1]).getUsedMemory();
                    if (checkForCapacity(Integer.parseInt(inputToArray[3]), freeCapacity) && checkForMemory(Integer.parseInt(inputToArray[4]),freeMemory)) {
                        hardwareComponents.get(inputToArray[1]).getPrograms().put(inputToArray[2],expressSoftware);
                        hardwareComponents.get(inputToArray[1]).setUsedCapacity(expressSoftware.getCapacityConsumption());
                        hardwareComponents.get(inputToArray[1]).setUsedMemory(expressSoftware.getMemoryConsumption());
                        softwareComponents.put(inputToArray[2],expressSoftware);
                    }



                    break;

                case "RegisterLightSoftware":
                   Software lightSoftware = new LightSoftware(inputToArray[2], Integer.parseInt(inputToArray[3]), Integer.parseInt(inputToArray[4]));
                    freeCapacity = hardwareComponents.get(inputToArray[1]).getMaximumCapacity() - hardwareComponents.get(inputToArray[1]).getUsedCapacity();
                    freeMemory = hardwareComponents.get(inputToArray[1]).getMaximumMemory() - hardwareComponents.get(inputToArray[1]).getUsedMemory();
                    if (checkForCapacity(Integer.parseInt(inputToArray[3]), freeCapacity) && checkForMemory(Integer.parseInt(inputToArray[4]),freeMemory)) {
                        hardwareComponents.get(inputToArray[1]).getPrograms().put(inputToArray[2],lightSoftware);
                        hardwareComponents.get(inputToArray[1]).setUsedCapacity(lightSoftware.getCapacityConsumption());
                        hardwareComponents.get(inputToArray[1]).setUsedMemory(lightSoftware.getMemoryConsumption());
                        softwareComponents.put(inputToArray[2],lightSoftware);
                    }


                    break;

                case "Analyze":
                    int totalOperationalMemoryInUse=0;
                    int maximumMemory=0;
                    int totalCapacityTaken=0;
                    int totalCapacity=0;
                    for (Map.Entry<String, Hardware> stringHardwareEntry : hardwareComponents.entrySet()) {
                        maximumMemory+=stringHardwareEntry.getValue().getMaximumMemory();
                        totalOperationalMemoryInUse+=stringHardwareEntry.getValue().getUsedMemory();
                        totalCapacityTaken+=stringHardwareEntry.getValue().getUsedCapacity();
                        totalCapacity+=stringHardwareEntry.getValue().getMaximumCapacity();
                    }

                    System.out.println(String.format("System Analysis\n" +
                            "Hardware Components: %d\n" +
                            "Software Components: %d\n" +
                            "Total Operational Memory: %d / %d\n" +
                            "Total Capacity Taken: %d / %d",hardwareComponents.size(),softwareComponents.size(),totalOperationalMemoryInUse,maximumMemory,totalCapacityTaken,totalCapacity));

                    break;

                case "ReleaseSoftwareComponent":

                    try {
                        Software softwareToRemove=hardwareComponents.get(inputToArray[1]).getPrograms().get(inputToArray[2]);

                        hardwareComponents.get(inputToArray[1]).setRemovedCapacity(softwareToRemove.getCapacityConsumption());
                        hardwareComponents.get(inputToArray[1]).setRemovedMemory(softwareToRemove.getMemoryConsumption());
                        hardwareComponents.get(inputToArray[1]).getPrograms().remove(inputToArray[2]);
                    }catch (NullPointerException ignored){

                    }

                    break;
            }
        }

        for (Map.Entry<String, Hardware> stringHardwareEntry : hardwareComponents.entrySet()) {
            System.out.println(String.format("Hardware component - %s",stringHardwareEntry.getKey()));

            System.out.println("Express Software Components - "+stringHardwareEntry.getValue().getPrograms().entrySet().stream().filter(e -> e.getValue() instanceof ExpressSoftware).count());
            System.out.println("Light Software Components - "+stringHardwareEntry.getValue().getPrograms().entrySet().stream().filter(e -> e.getValue() instanceof LightSoftware).count());
            int maximumMemory=stringHardwareEntry.getValue().getMaximumMemory();
            int totalOperationalMemoryInUse=stringHardwareEntry.getValue().getUsedMemory();
            int totalCapacityTaken=stringHardwareEntry.getValue().getUsedCapacity();
            int totalCapacity=stringHardwareEntry.getValue().getMaximumCapacity();
            System.out.println(String.format("Memory Usage: %d / %d",totalOperationalMemoryInUse,maximumMemory));
            System.out.println(String.format("Capacity Usage: %d / %d",totalCapacityTaken,totalCapacity));
            System.out.println("Type: "+stringHardwareEntry.getValue().getClass().getSimpleName());
            System.out.print("Software Components: ");
            int size=stringHardwareEntry.getValue().getPrograms().size();
            int count=0;
            for (Map.Entry<String, Software> stringSoftwareEntry : stringHardwareEntry.getValue().getPrograms().entrySet()) {
                count++;
                if(count<size){
                    System.out.print(stringSoftwareEntry.getValue().getName()+", ");
                }else{
                    System.out.print(stringSoftwareEntry.getValue().getName());
                }


            }


            System.out.println();
        }



        





    }

    public static boolean checkForCapacity(int softwareCapacity, int hardwareFreeCapacity) {
        return hardwareFreeCapacity >= softwareCapacity;


    }
    public static boolean checkForMemory(int softwareMemory, int hardwareFreeMemory) {
        return hardwareFreeMemory >= softwareMemory;


    }

}
