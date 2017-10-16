public class FaceRectangle {

    private int top;
    private int left;
    private int width;
    private int height;

    public FaceRectangle() {
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("top:").append(top).append(',');
        sb.append("left:").append(left).append(',');
        sb.append("width:").append(width).append(',');
        sb.append("height:").append(height);
        return sb.toString();
    }
}
