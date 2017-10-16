public class HairColor {
    private String color;
    private double confidence;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("color:").append(color).append(',');
        sb.append("confidence:").append(confidence);
        return sb.toString();
    }
}
