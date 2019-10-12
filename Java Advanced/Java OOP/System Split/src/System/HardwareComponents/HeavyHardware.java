package System.HardwareComponents;

import System.Interfaces.Hardware;

public class HeavyHardware extends Hardware {
    public HeavyHardware(String name,int maxCapacity,int maxMemory) {
        super(name);
        this.setMaximumCapacity(maxCapacity);
        this.setMaximumMemory(maxMemory);

    }

    @Override
    public void setMaximumCapacity(int maximumCapacity) {
            this.maximumCapacity=maximumCapacity*2;
    }

    @Override
    public void setMaximumMemory(int maximumMemory) {
        this.maximumMemory=maximumMemory-(maximumMemory*25/100);

    }
}
