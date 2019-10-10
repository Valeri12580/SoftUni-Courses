package shapes;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.setHeight(height);
        this.setWidth(width);
    }

    private void setHeight(Double height) {
        this.height = height;
    }

    private void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    @Override
    protected void calculatePerimeter() {
        setPerimeter(2*(this.height+this.width));

    }

    @Override
    protected void calculateArea() {
        setArea(height*width);

    }
}
