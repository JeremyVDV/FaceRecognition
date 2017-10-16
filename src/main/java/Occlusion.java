public class Occlusion {
    private boolean foreheadOccluded;
    private boolean eyeOccluded;
    private boolean mouthOccluded;

    public boolean isForeheadOccluded() {
        return foreheadOccluded;
    }

    public void setForeheadOccluded(boolean foreheadOccluded) {
        this.foreheadOccluded = foreheadOccluded;
    }

    public boolean isEyeOccluded() {
        return eyeOccluded;
    }

    public void setEyeOccluded(boolean eyeOccluded) {
        this.eyeOccluded = eyeOccluded;
    }

    public boolean isMouthOccluded() {
        return mouthOccluded;
    }

    public void setMouthOccluded(boolean mouthOccluded) {
        this.mouthOccluded = mouthOccluded;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("foreheadOccluded:").append(foreheadOccluded).append(',');
        sb.append("eyeOccluded:").append(eyeOccluded).append(',');
        sb.append("mouthOccluded:").append(mouthOccluded);
        return sb.toString();
    }
}
