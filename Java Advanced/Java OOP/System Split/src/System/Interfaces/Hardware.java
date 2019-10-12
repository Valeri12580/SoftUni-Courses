package System.Interfaces;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract  class Hardware {

    protected String name;
    protected int maximumCapacity;
    protected int usedCapacity;
    protected int maximumMemory;
    protected int usedMemory;
    protected Map<String,Software> programs;

    public Hardware(String name) {
        this.name = name;
        usedCapacity=0;
        usedMemory=0;
        programs=new LinkedHashMap<>();
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    public int getUsedCapacity() {
        return usedCapacity;
    }

    public int getMaximumMemory() {
        return maximumMemory;
    }

    public int getUsedMemory() {
        return usedMemory;
    }


    public void setUsedCapacity(int value) {
        this.usedCapacity = this.usedCapacity+value;
    }

    public void setRemovedMemory(int value) {
        this.usedMemory = this.usedMemory-value;
    }
    public void setRemovedCapacity(int value) {
        this.usedCapacity = this.usedCapacity-value;
    }

    public void setUsedMemory(int value) {
        this.usedMemory = this.usedMemory+value;
    }

    public Map<String, Software> getPrograms() {
        return programs;
    }


    public abstract  void setMaximumCapacity(int maximumCapacity);


    public abstract void setMaximumMemory(int maximumMemory) ;
}
