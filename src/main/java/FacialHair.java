public class FacialHair {
    private double moustache;
    private double beard;
    private double sideburns;

    public double getMoustache() {
        return moustache;
    }

    public void setMoustache(double moustache) {
        this.moustache = moustache;
    }

    public double getBeard() {
        return beard;
    }

    public void setBeard(double beard) {
        this.beard = beard;
    }

    public double getSideburns() {
        return sideburns;
    }

    public void setSideburns(double sideburns) {
        this.sideburns = sideburns;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("moustache:").append(moustache).append(',');
        sb.append("beard:").append(beard).append(',');
        sb.append("sideburns:").append(sideburns);
        return sb.toString();
    }
}
