import java.awt.geom.Point2D;

public class FaceLandmark extends Point2D{
    private double x;
    private double y;

    public void setX(double x){
        this.x  = x;
    }
    public void setY(double y){
        this.y = y;
    }
    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("x:").append(x).append(',').append("y:").append(y);
        return sb.toString();
    }
}
