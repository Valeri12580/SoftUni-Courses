package System.SoftwareComponents;

import System.Interfaces.Software;

public class LightSoftware extends Software {
    public LightSoftware(String name,int capacityConsumption,int memoryConsumption) {
        super(name);
        setCapacityConsumption(capacityConsumption);
        setMemoryConsumption(memoryConsumption);
    }

    @Override
    public void setCapacityConsumption(int capacityConsumption) {
        this.capacityConsumption=capacityConsumption+(capacityConsumption*50/100);

    }

    @Override
    public void setMemoryConsumption(int memoryConsumption) {
        this.memoryConsumption=memoryConsumption-(memoryConsumption*50/100);

    }
}
