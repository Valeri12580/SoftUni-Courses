package TrafficLights;

public enum TrafficLights {
    RED(0),
    GREEN(1),
    YELLOW(2);
    private int value;


    TrafficLights(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
