public class Exposure {
    private String exposureLevel;
    private double value;

    public String getExposureLevel() {
        return exposureLevel;
    }

    public void setExposureLevel(String exposureLevel) {
        this.exposureLevel = exposureLevel;
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
        sb.append("exposureLevel:").append(exposureLevel).append(',');
        sb.append("value:").append(value);
        return sb.toString();
    }
}
