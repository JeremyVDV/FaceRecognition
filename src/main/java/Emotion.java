public class Emotion {
    private double anger;
    private double contempt;
    private double disgust;
    private double fear;
    private double happiness;
    private double neutral;
    private double sadness;
    private double surprise;

    public double getAnger() {
        return anger;
    }

    public void setAnger(double anger) {
        this.anger = anger;
    }

    public double getContempt() {
        return contempt;
    }

    public void setContempt(double contempt) {
        this.contempt = contempt;
    }

    public double getDisgust() {
        return disgust;
    }

    public void setDisgust(double disgust) {
        this.disgust = disgust;
    }

    public double getFear() {
        return fear;
    }

    public void setFear(double fear) {
        this.fear = fear;
    }

    public double getHappiness() {
        return happiness;
    }

    public void setHappiness(double happiness) {
        this.happiness = happiness;
    }

    public double getNeutral() {
        return neutral;
    }

    public void setNeutral(double neutral) {
        this.neutral = neutral;
    }

    public double getSadness() {
        return sadness;
    }

    public void setSadness(double sadness) {
        this.sadness = sadness;
    }

    public double getSurprise() {
        return surprise;
    }

    public void setSurprise(double surprise) {
        this.surprise = surprise;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("anger:").append(anger).append('\n');
        sb.append("contempt:").append(contempt).append('\n');
        sb.append("disgust:").append(disgust).append('\n');
        sb.append("fear:").append(fear).append('\n');
        sb.append("happiness:").append(happiness).append('\n');
        sb.append("neutral:").append(neutral).append('\n');
        sb.append("sadness:").append(sadness).append('\n');
        sb.append("surprise:").append(surprise);
        return sb.toString();
    }
}
