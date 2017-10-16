public class Makeup {
    private boolean eyeMakeup;
    private boolean lipMakeup;

    public boolean isEyeMakeup() {
        return eyeMakeup;
    }

    public void setEyeMakeup(boolean eyeMakeup) {
        this.eyeMakeup = eyeMakeup;
    }

    public boolean isLipMakeup() {
        return lipMakeup;
    }

    public void setLipMakeup(boolean lipMakeup) {
        this.lipMakeup = lipMakeup;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("eyeMakeup:").append(eyeMakeup).append(',');
        sb.append("lipMakeup:").append(lipMakeup);
        return sb.toString();
    }
}
