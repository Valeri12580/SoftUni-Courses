package System.HardwareComponents;

import System.Interfaces.Hardware;

public class PowerHardware extends Hardware {
    public PowerHardware(String name,int maxCapacity,int maxMemory) {
        super(name);
        this.setMaximumCapacity(maxCapacity);
        this.setMaximumMemory(maxMemory);
    }

    @Override
    public void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity=maximumCapacity-(maximumCapacity*75/100);

    }

    @Override
    public void setMaximumMemory(int maximumMemory) {
        this.maximumMemory=maximumMemory+(maximumMemory*75/100);
    }
}
