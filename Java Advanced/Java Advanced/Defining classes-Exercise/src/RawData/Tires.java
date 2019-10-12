package RawData;

public class Tires {
   private  double tire1Presure;
   private  int tire1Age;
   private  double tire2Presure;
   private  int tire2Age;
   private  double tire3Presure;
   private  int tire3Age;
   private  double tire4Presure;
   private  int tire4Age;

    public Tires(double tire1Presure, int tire1Age, double tire2Presure, int tire2Age, double tire3Presure, int tire3Age, double tire4Presure, int tire4Age) {
        this.tire1Presure = tire1Presure;
        this.tire1Age = tire1Age;
        this.tire2Presure = tire2Presure;
        this.tire2Age = tire2Age;
        this.tire3Presure = tire3Presure;
        this.tire3Age = tire3Age;
        this.tire4Presure = tire4Presure;
        this.tire4Age = tire4Age;
    }

    public double getTire1Presure() {
        return tire1Presure;
    }

    public int getTire1Age() {
        return tire1Age;
    }

    public double getTire2Presure() {
        return tire2Presure;
    }

    public int getTire2Age() {
        return tire2Age;
    }

    public double getTire3Presure() {
        return tire3Presure;
    }

    public int getTire3Age() {
        return tire3Age;
    }

    public double getTire4Presure() {
        return tire4Presure;
    }

    public int getTire4Age() {
        return tire4Age;
    }
}
