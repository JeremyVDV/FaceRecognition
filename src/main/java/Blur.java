public class Blur {
    private String blurLevel;
    private double value;

    public String getBlurLevel() {
        return blurLevel;
    }

    public void setBlurLevel(String blurLevel) {
        this.blurLevel = blurLevel;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("blurLevel:").append(blurLevel).append(',');
        sb.append("value:").append(value);
        return sb.toString();
    }
}
