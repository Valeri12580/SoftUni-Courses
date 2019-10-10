package classBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setHeight(height);
        setWidth(width);
    }



    private void setLength(double length) {
        validation("Length",length);
        this.length = length;
    }


    private void setWidth(double width) {
        validation("Width",width);
        this.width = width;
    }



    private void setHeight(double height) {
        validation("Height",height);
        this.height = height;
    }

    private void validation(String name,double parameter){
        if (parameter<=0){
            throw new IllegalArgumentException(name+" cannot be zero or negative.");
        }
    }
    public double calculateSurfaceArea (){
        double result=2*this.length*this.width+2*this.length*this.height+2*this.width*this.height;
        return result;

    }

    public double  calculateLateralSurfaceArea (){
        double result=2*this.length*this.height+2*this.width*this.height;
        return result;
    }
    public double calculateVolume (){
        double result=this.height*this.width*this.length;
        return result;
    }
}
