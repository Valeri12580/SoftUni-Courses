package System.SoftwareComponents;

import System.Interfaces.Software;

public class ExpressSoftware extends Software {
    public ExpressSoftware(String name, int capacityConsumption, int memoryConsumption) {
        super(name);
        setCapacityConsumption(capacityConsumption);
        setMemoryConsumption(memoryConsumption);
    }

    @Override
    public void setCapacityConsumption(int capacityConsumption) {
        this.capacityConsumption = capacityConsumption;
    }

    @Override
    public void setMemoryConsumption(int memoryConsumption) {
        this.memoryConsumption = memoryConsumption * 2;
    }
}
