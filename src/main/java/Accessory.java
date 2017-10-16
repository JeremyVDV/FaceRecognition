public class Accessory {
    private String type;
    private double confidence;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        sb.append("type:").append(type).append(',');
        sb.append("confidence:").append(confidence);
        return sb.toString();
    }
}
