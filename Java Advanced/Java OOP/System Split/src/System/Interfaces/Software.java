package System.Interfaces;

public abstract class Software {
    protected String name;
    protected int capacityConsumption;
    protected int memoryConsumption;

    public Software(String name) {
        this.name = name;
    }

    public  abstract  void setCapacityConsumption(int capacityConsumption) ;

    public abstract void setMemoryConsumption(int memoryConsumption);

    public String getName() {
        return name;
    }

    public int getCapacityConsumption() {
        return capacityConsumption;
    }

    public int getMemoryConsumption() {
        return memoryConsumption;
    }
}
