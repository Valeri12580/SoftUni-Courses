package PointRectangle;

public class Rectangle {
    private int bottomLeftX;
    private int bottomLeftY;
    private int topRightX;
    private int topRightY;

    public Rectangle(int bottomLeftX, int bottomLeftY, int topRightX, int topRightY) {
        this.bottomLeftX = bottomLeftX;
        this.bottomLeftY = bottomLeftY;
        this.topRightX = topRightX;
        this.topRightY = topRightY;
    }

    public int getBottomLeftX() {
        return bottomLeftX;
    }

    public int getBottomLeftY() {
        return bottomLeftY;
    }

    public int getTopRightX() {
        return topRightX;
    }

    public int getTopRightY() {
        return topRightY;
    }

    public boolean cointains(Point point){
        if((point.getCordinateX()>=getBottomLeftX()&& point.getCordinateX()<=getTopRightX()&&point.getCordinateY()>=getBottomLeftY() && point.getCordinateY()<=getTopRightY())){
            return true;
    }
        return false;
    }
}
