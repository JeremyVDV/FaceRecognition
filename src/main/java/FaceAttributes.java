import java.util.ArrayList;
import java.util.List;

public class FaceAttributes {
    private Hair hair;
    private double smile;
    private HeadPose headPose;
    private String gender;
    private double age;
    private FacialHair facialHair;
    private String glasses;
    private Makeup makeup;
    private Emotion emotion;
    private Occlusion occlusion;
    private List<Accessory> accesories;
    private Blur blur;
    private Exposure exposure;
    private Noise noise;

    public FaceAttributes() {
        accesories = new ArrayList<>();
    }

    public void addAccesory(Accessory accessory){
        accesories.add(accessory);
    }

    public void addAccesories(List<Accessory> accessories){
        for (Accessory accessory : accesories)
            this.accesories.add(accessory);
    }

    public Hair getHair() {
        return hair;
    }

    public void setHair(Hair hair) {
        this.hair = hair;
    }

    public double getSmile() {
        return smile;
    }

    public void setSmile(double smile) {
        this.smile = smile;
    }

    public HeadPose getHeadPose() {
        return headPose;
    }

    public void setHeadPose(HeadPose headPose) {
        this.headPose = headPose;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public FacialHair getFacialHair() {
        return facialHair;
    }

    public void setFacialHair(FacialHair facialHair) {
        this.facialHair = facialHair;
    }

    public String getGlasses() {
        return glasses;
    }

    public void setGlasses(String glasses) {
        this.glasses = glasses;
    }

    public Makeup getMakeup() {
        return makeup;
    }

    public void setMakeup(Makeup makeup) {
        this.makeup = makeup;
    }

    public Emotion getEmotion() {
        return emotion;
    }

    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }

    public Occlusion getOcclusion() {
        return occlusion;
    }

    public void setOcclusion(Occlusion occlusion) {
        this.occlusion = occlusion;
    }

    public Blur getBlur() {
        return blur;
    }

    public void setBlur(Blur blur) {
        this.blur = blur;
    }

    public Exposure getExposure() {
        return exposure;
    }

    public void setExposure(Exposure exposure) {
        this.exposure = exposure;
    }

    public Noise getNoise() {
        return noise;
    }

    public void setNoise(Noise noise) {
        this.noise = noise;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("hair:").append(hair.toString()).append('\n');
        sb.append("smile:").append(smile).append('\n');
        sb.append("headPose:").append(headPose.toString()).append('\n');
        sb.append("gender:").append(gender).append('\n');
        sb.append("age:").append(age).append('\n');
        sb.append("facialHair:").append(facialHair.toString()).append('\n');
        sb.append("glasses:").append(glasses).append('\n');
        sb.append("makeup:").append(makeup.toString()).append('\n');
        sb.append("emotion:").append(emotion.toString()).append('\n');
        sb.append("occlusion:").append(occlusion.toString()).append('\n');
        sb.append("accesories:").append(accesories.toString()).append('\n');
        sb.append("blur:").append(blur.toString()).append('\n');
        sb.append("exposure:").append(exposure.toString()).append('\n');
        sb.append("noise:").append(noise.toString());
        return sb.toString();
    }
}
