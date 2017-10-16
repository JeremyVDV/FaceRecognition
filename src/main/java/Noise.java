public class Noise {
    private String noiseLevel;
    private double value;

    public String getNoiseLevel() {
        return noiseLevel;
    }

    public void setNoiseLevel(String noiseLevel) {
        this.noiseLevel = noiseLevel;
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
        sb.append("noiseLevel:").append(noiseLevel).append(',');
        sb.append("value:").append(value);
        return sb.toString();
    }
}
