import java.util.ArrayList;
import java.util.List;

public class Hair {
    private double bald;
    private boolean invisible;
    private List<HairColor> hairColor;

    public Hair(){
        hairColor = new ArrayList<>();
    }

    public void addHairColor(HairColor hc){
        hairColor.add(hc);
    }

    public double getBald() {
        return bald;
    }

    public void setBald(double bald) {
        this.bald = bald;
    }

    public boolean isInvisible() {
        return invisible;
    }

    public void setInvisible(boolean invisible) {
        this.invisible = invisible;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("bald:").append(bald).append('\n');
        sb.append("invisible:").append(invisible).append('\n');
        sb.append("hairColor:").append(hairColor.toString());
        return sb.toString();
    }
}
