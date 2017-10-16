public class HeadPose {
    private double pitch;
    private double roll;
    private double yaw;

    public double getPitch() {
        return pitch;
    }

    public void setPitch(double pitch) {
        this.pitch = pitch;
    }

    public double getRoll() {
        return roll;
    }

    public void setRoll(double roll) {
        this.roll = roll;
    }

    public double getYaw() {
        return yaw;
    }

    public void setYaw(double yaw) {
        this.yaw = yaw;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("pitch:").append(pitch).append(',');
        sb.append("roll:").append(roll).append(',');
        sb.append("yaw:").append(yaw);
        return sb.toString();
    }
}
