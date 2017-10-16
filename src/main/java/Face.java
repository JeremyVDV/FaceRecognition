public class Face {
    private String faceId;
    private FaceRectangle faceRectangle;
    private FaceLandmarks faceLandmarks;
    private FaceAttributes faceAttributes;


    public String getFaceID() {
        return faceId;
    }
    public void setFaceID(String faceId) {
        this.faceId = faceId;
    }
    public FaceRectangle getRectangle() {
        return faceRectangle;
    }
    public void setRectangle(FaceRectangle faceRectangle) {
        this.faceRectangle = faceRectangle;
    }
    public FaceLandmarks getLandmarks() {
        return faceLandmarks;
    }
    public void setLandmarks(FaceLandmarks faceLandmarks) {
        this.faceLandmarks = faceLandmarks;
    }
    public FaceAttributes getFaceAttributes() {
        return faceAttributes;
    }
    public void setFaceAttributes(FaceAttributes faceAttributes) {
        this.faceAttributes = faceAttributes;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("faceId:").append(faceId).append('\n');
        sb.append("faceRectangle:");
        if(faceRectangle !=null)sb.append(faceRectangle.toString());
        else sb.append("null");
        sb.append('\n');
        sb.append("faceLandmarks:");
        if(faceLandmarks !=null)sb.append(faceLandmarks.toString());
        else sb.append("null");
        sb.append('\n');
        sb.append("faceAttributes:");
        if(faceAttributes !=null)sb.append(faceAttributes.toString());
        else sb.append("null");
        return sb.toString();
    }
}
