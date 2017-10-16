import com.google.gson.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public interface FaceParser {

    public static Face fromJson(String jsonStr){
        JsonElement jsonElement = new Gson().fromJson(jsonStr, JsonElement.class);
        JsonArray jsonArray= (JsonArray) jsonElement;
        if (jsonArray.size()>0) {
            JsonObject root = (JsonObject) jsonArray.get(0);
            return new Gson().fromJson(root.toString(), Face.class);
        } else return new Face();
    }

//    public static FaceRectangle rectangleFromJson(JsonObject rectangle) {
//        FaceRectangle faceRectangle = new FaceRectangle();
//
//        faceRectangle.setTop(rectangle.get("top").getAsInt());
//        faceRectangle.setLeft(rectangle.get("left").getAsInt());
//        faceRectangle.setWidth(rectangle.get("width").getAsInt());
//        faceRectangle.setHeight(rectangle.get("height").getAsInt());
//        return faceRectangle;
//    }
//    public static FaceLandmarks landmarksFromJson(JsonObject landmarks){
//        FaceLandmarks faceLandmarks = new FaceLandmarks();
//        Iterator<Map.Entry<String,JsonElement>> iter = landmarks.entrySet().iterator();
//        while(iter.hasNext()){
//            Map.Entry<String,JsonElement> entry = iter.next();
//            //make Landmark
//            JsonObject landmarkJson = (JsonObject) entry.getValue();
//            double x = landmarkJson.getAsJsonPrimitive("x").getAsDouble();
//            double y = landmarkJson.getAsJsonPrimitive("y").getAsDouble();
//            FaceLandmark faceLandmark = new FaceLandmark();
//            faceLandmark.setLocation(x, y);
//            //set correct attribute
//            switch(entry.getKey()){
//                case "pupilLeft": faceLandmarks.setPupilLeft(faceLandmark); break;
//                case "pupilRight": faceLandmarks.setPupilRight(faceLandmark); break;
//                case "noseTip": faceLandmarks.setNoseTip(faceLandmark); break;
//                case "mouthLeft": faceLandmarks.setMouthLeft(faceLandmark); break;
//                case "mouthRight": faceLandmarks.setMouthRight(faceLandmark); break;
//                case "eyebrowLeftOuter": faceLandmarks.setEyebrowLeftOuter(faceLandmark); break;
//                case "eyebrowLeftInner": faceLandmarks.setEyebrowLeftInner(faceLandmark); break;
//                case "eyeLeftOuter": faceLandmarks.setEyeLeftOuter(faceLandmark); break;
//                case "eyeLeftTop": faceLandmarks.setEyeLeftTop(faceLandmark); break;
//                case "eyeLeftBottom": faceLandmarks.setEyeLeftBottom(faceLandmark); break;
//                case "eyeLeftInner": faceLandmarks.setEyeLeftInner(faceLandmark); break;
//                case "eyebrowRightInner": faceLandmarks.setEyebrowRightInner(faceLandmark); break;
//                case "eyebrowRightOuter": faceLandmarks.setEyebrowRightOuter(faceLandmark); break;
//                case "eyeRightInner": faceLandmarks.setEyeRightInner(faceLandmark); break;
//                case "eyeRightTop": faceLandmarks.setEyeRightTop(faceLandmark); break;
//                case "eyeRightBottom": faceLandmarks.setEyeRightBottom(faceLandmark); break;
//                case "eyeRightOuter": faceLandmarks.setEyeRightOuter(faceLandmark); break;
//                case "noseRootLeft": faceLandmarks.setNoseRootLeft(faceLandmark); break;
//                case "noseRootRight": faceLandmarks.setNoseRootRight(faceLandmark); break;
//                case "noseLeftAlarTop": faceLandmarks.setNoseLeftAlarTop(faceLandmark); break;
//                case "noseRightAlarTop": faceLandmarks.setNoseRightAlarTop(faceLandmark); break;
//                case "noseLeftAlarOutTip": faceLandmarks.setNoseLeftAlarOutTip(faceLandmark); break;
//                case "noseRightAlarOutTip": faceLandmarks.setNoseRightAlarOutTip(faceLandmark); break;
//                case "upperLipTop": faceLandmarks.setUpperLipTop(faceLandmark); break;
//                case "upperLipBottom": faceLandmarks.setUpperLipBottom(faceLandmark); break;
//                case "underLipTop": faceLandmarks.setUnderLipTop(faceLandmark); break;
//                case "underLipBottom": faceLandmarks.setUnderLipBottom(faceLandmark); break;
//                default: System.out.println("Got unknown landmark: " + entry.getKey());
//            }
//        }
//        return faceLandmarks;
//    }
//    public static FaceAttributes attributesFromJson(JsonObject attributes){
//        FaceAttributes faceAttributes = new FaceAttributes();
//
//        return faceAttributes;
//    }
//    public static Face fromXML(String xml){
//        System.out.println("XML input: ");
//        System.out.println(xml);
//        Face face = new Face();
//        try {
//            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder builder = factory.newDocumentBuilder();
//            Document document = builder.parse(xml);
//            document.getDocumentElement().normalize();
//            NodeList nodelist = document.getFirstChild().getChildNodes();
//            for (int i = 0; i<nodelist.getLength(); i++){
//                Node node = nodelist.item(i);
//                switch(node.getNodeName()){
//                    case "faceId": face.setFaceID(node.getNodeValue());break;
//                    case "faceRectangle": face.setRectangle(rectangleFromNode(node));break;
//                    case "faceAttributes": face.setFaceAttributes(attributesFromNode(node));break;
//                    case "faceLandmarks": face.setLandmarks(landmarksFromNode(node)); break;
//                    default: System.out.println("Got unknown node name: " + node.getNodeName());
//                }
//            }
//        } catch (ParserConfigurationException | IOException | SAXException ex) {
//            System.out.println(ex);;
//        }
//        return face;
//    }
//
//    public static FaceRectangle rectangleFromNode(Node rectangleNode){
//        FaceRectangle faceRectangle = new FaceRectangle();
//
//        NodeList rectangleNodeList = rectangleNode.getChildNodes();
//        for (int i = 0; i < rectangleNodeList.getLength(); i++) {
//            Node rectangleAttributeNode = rectangleNodeList.item(i);
//            switch (rectangleAttributeNode.getNodeName()){
//                case "top": faceRectangle.setTop(Integer.parseInt(rectangleAttributeNode.getNodeValue()));
//                case "left": faceRectangle.setLeft(Integer.parseInt(rectangleAttributeNode.getNodeValue()));
//                case "width": faceRectangle.setWidth(Integer.parseInt(rectangleAttributeNode.getNodeValue()));
//                case "heigth": faceRectangle.setHeight(Integer.parseInt(rectangleAttributeNode.getNodeValue()));
//                default: System.out.println("Got unknown rectangle attribute: " + rectangleAttributeNode.getNodeName());
//            }
//        }
//        return faceRectangle;
//    }
//    public static FaceLandmarks landmarksFromNode(Node landmarksNode){
//        FaceLandmarks faceLandmarks = new FaceLandmarks();
//
//        NodeList landmarks = landmarksNode.getChildNodes();
//        for (int i = 0; i< landmarks.getLength(); i++){
//            Node landmarkNode = landmarks.item(i);
//            double x = Double.parseDouble(landmarkNode.getFirstChild().getNodeValue());
//            double y = Double.parseDouble(landmarkNode.getLastChild().getNodeValue());
//            FaceLandmark faceLandmark = new FaceLandmark();
//            faceLandmark.setLocation(x,y);
//            switch(landmarkNode.getNodeName()){
//                case "pupilLeft": faceLandmarks.setPupilLeft(faceLandmark); break;
//                case "pupilRight": faceLandmarks.setPupilRight(faceLandmark); break;
//                case "noseTip": faceLandmarks.setNoseTip(faceLandmark); break;
//                case "mouthLeft": faceLandmarks.setMouthLeft(faceLandmark); break;
//                case "mouthRight": faceLandmarks.setMouthRight(faceLandmark); break;
//                case "eyebrowLeftOuter": faceLandmarks.setEyebrowLeftOuter(faceLandmark); break;
//                case "eyebrowLeftInner": faceLandmarks.setEyebrowLeftInner(faceLandmark); break;
//                case "eyeLeftOuter": faceLandmarks.setEyeLeftOuter(faceLandmark); break;
//                case "eyeLeftTop": faceLandmarks.setEyeLeftTop(faceLandmark); break;
//                case "eyeLeftBottom": faceLandmarks.setEyeLeftBottom(faceLandmark); break;
//                case "eyeLeftInner": faceLandmarks.setEyeLeftInner(faceLandmark); break;
//                case "eyebrowRightInner": faceLandmarks.setEyebrowRightInner(faceLandmark); break;
//                case "eyebrowRightOuter": faceLandmarks.setEyebrowRightOuter(faceLandmark); break;
//                case "eyeRightInner": faceLandmarks.setEyeRightInner(faceLandmark); break;
//                case "eyeRightTop": faceLandmarks.setEyeRightTop(faceLandmark); break;
//                case "eyeRightBottom": faceLandmarks.setEyeRightBottom(faceLandmark); break;
//                case "eyeRightOuter": faceLandmarks.setEyeRightOuter(faceLandmark); break;
//                case "noseRootLeft": faceLandmarks.setNoseRootLeft(faceLandmark); break;
//                case "noseRootRight": faceLandmarks.setNoseRootRight(faceLandmark); break;
//                case "noseLeftAlarTop": faceLandmarks.setNoseLeftAlarTop(faceLandmark); break;
//                case "noseRightAlarTop": faceLandmarks.setNoseRightAlarTop(faceLandmark); break;
//                case "noseLeftAlarOutTip": faceLandmarks.setNoseLeftAlarOutTip(faceLandmark); break;
//                case "noseRightAlarOutTip": faceLandmarks.setNoseRightAlarOutTip(faceLandmark); break;
//                case "upperLipTop": faceLandmarks.setUpperLipTop(faceLandmark); break;
//                case "upperLipBottom": faceLandmarks.setUpperLipBottom(faceLandmark); break;
//                case "underLipTop": faceLandmarks.setUnderLipTop(faceLandmark); break;
//                case "underLipBottom": faceLandmarks.setUnderLipBottom(faceLandmark); break;
//                default: System.out.println("Got unknown landmark node name: " + landmarkNode.getNodeName());
//            }
//        }
//        return faceLandmarks;
//    }
//    public static FaceAttributes attributesFromNode(Node attributesNode){
//        FaceAttributes faceAttributes = new FaceAttributes();
//
//        NodeList attributes = attributesNode.getChildNodes();
//        for (int i = 0; i< attributes.getLength(); i++){
//            Node attributeNode = attributes.item(i);
//            switch(attributeNode.getNodeName()){
//                case "hair": faceAttributes.setHair(hairFromNode(attributeNode)); break;
//                case "smile": faceAttributes.setSmile(Double.parseDouble(attributeNode.getNodeValue())); break;
//                case "headPose": faceAttributes.setHeadPose(headPoseFromNode(attributeNode)); break;
//                case "gender": faceAttributes.setGender(attributeNode.getNodeValue()); break;
//                case "age": faceAttributes.setAge(Double.parseDouble(attributeNode.getNodeValue())); break;
//                case "facialHair": faceAttributes.setFacialHair(facialFromNode(attributeNode)); break;
//                case "glasses": faceAttributes.setGlasses(attributeNode.getNodeValue()); break;
//                case "makeup": faceAttributes.setMakeup(makeupFromNode(attributeNode)); break;
//                case "emotion": faceAttributes.setEmotion(emotionFromNode(attributeNode)); break;
//                case "occlusion": faceAttributes.setOcclusion(occlusionFromNode(attributeNode)); ; break;
//                case "accessories": faceAttributes.addAccesories(accesoriesFromNode(attributeNode)); break;
//                case "blur": faceAttributes.setBlur(blurFromNode(attributeNode)); break;
//                case "exposure": faceAttributes.setExposure(exposureFromNode(attributeNode)); break;
//                case "noise": faceAttributes.setNoise(noiseFromNode(attributeNode)); break;
//                default: System.out.println("Got unknown attribute node name: " + attributeNode.getNodeName());
//            }
//        }
//        return faceAttributes;
//    }
//
//    public static Hair hairFromNode(Node hairNode){
//        Hair hair = new Hair();
//
//        NodeList hairNodeList = hairNode.getChildNodes();
//        for (int i=0; i < hairNodeList.getLength(); i++) {
//            Node hairAttribute = hairNodeList.item(i);
//            switch (hairAttribute.getNodeName()) {
//                case "bald":
//                    hair.setBald(Double.parseDouble(hairAttribute.getNodeValue()));
//                    break;
//                case "invisible":
//                    hair.setInvisible(Boolean.parseBoolean(hairAttribute.getNodeValue()));
//                    break;
//                case "hairColor": {
//                    NodeList hairColors = hairAttribute.getChildNodes();
//                    for (int j = 0; j < hairColors.getLength(); i++) {
//                        NodeList hairColorNodes = hairColors.item(j).getChildNodes();
//                        for (int k = 0; k < hairColorNodes.getLength(); k++) {
//                            Node hairColorNode = hairColorNodes.item(k);
//                            HairColor hairColor = new HairColor();
//                            switch (hairColorNode.getNodeName()) {
//                                case "color":
//                                    hairColor.setColor(hairColorNode.getNodeValue());
//                                    break;
//                                case "confidence":
//                                    hairColor.setConfidence(Double.parseDouble(hairColorNode.getNodeValue()));
//                                    break;
//                                default :
//                                    System.out.println("Got unknown hair color node attribute: " + hairColorNode.getNodeName());
//                            }
//                            hair.addHairColor(hairColor);
//                        }
//                    }
//                    break;
//                }
//                default : System.out.println("Got unknown hair atribute: " + hairAttribute.getNodeName());
//            }
//        }
//        return hair;
//    }
//    public static HeadPose headPoseFromNode(Node headPoseNode){
//        HeadPose headPose = new HeadPose();
//
//        NodeList headPoseNodeList = headPoseNode.getChildNodes();
//        for (int i=0; i < headPoseNodeList.getLength(); i++){
//            Node headPoseAttribute = headPoseNodeList.item(i);
//            switch (headPoseAttribute.getNodeName()){
//                case "pitch": headPose.setPitch(Double.parseDouble(headPoseAttribute.getNodeValue())); break;
//                case "roll": headPose.setRoll(Double.parseDouble(headPoseAttribute.getNodeValue())); break;
//                case "yaw": headPose.setYaw(Double.parseDouble(headPoseAttribute.getNodeValue())); break;
//                default: System.out.println("Got unknown head pose attribute: " + headPoseNode.getNodeName());
//            }
//        }
//        return headPose;
//    }
//    public static FacialHair facialFromNode(Node facialHairNode){
//        FacialHair facialHair = new FacialHair();
//
//        NodeList facialHairNodeList = facialHairNode.getChildNodes();
//        for (int i=0; i < facialHairNodeList.getLength(); i++){
//            Node facialHairAttribute = facialHairNodeList.item(i);
//            switch (facialHairAttribute.getNodeName()){
//                case "moustache": facialHair.setMoustache(Double.parseDouble(facialHairAttribute.getNodeValue())); break;
//                case "beard": facialHair.setBeard(Double.parseDouble(facialHairAttribute.getNodeValue())); break;
//                case "sideburns": facialHair.setSideburns(Double.parseDouble(facialHairAttribute.getNodeValue())); break;
//                default: System.out.println("Got unknown facial hair node name: " + facialHairAttribute.getNodeName());
//            }
//        }
//        return facialHair;
//    }
//    public static Makeup makeupFromNode(Node makeupNode){
//        Makeup makeup = new Makeup();
//
//        NodeList makeupNodeList = makeupNode.getChildNodes();
//        for (int i=0; i < makeupNodeList.getLength(); i++){
//            Node makeupAttribute = makeupNodeList.item(i);
//            switch (makeupAttribute.getNodeName()){
//                case "eyeMakeup": makeup.setEyeMakeup(Boolean.parseBoolean(makeupAttribute.getNodeValue())); break;
//                case "lipMakeup": makeup.setLipMakeup(Boolean.parseBoolean(makeupAttribute.getNodeValue())); break;
//                default: System.out.println("Got unknown make up node attribute: " + makeupAttribute.getNodeName());
//            }
//        }
//        return makeup;
//    }
//    public static Emotion emotionFromNode(Node emotionNode){
//        Emotion emotion = new Emotion();
//
//        NodeList emotionNodeList = emotionNode.getChildNodes();
//        for (int i=0; i < emotionNodeList.getLength(); i++){
//            Node emotionAttribute = emotionNodeList.item(i);
//            switch (emotionAttribute.getNodeName()){
//                case "anger": emotion.setAnger(Double.parseDouble(emotionAttribute.getNodeValue())); break;
//                case "contempt": emotion.setContempt(Double.parseDouble(emotionAttribute.getNodeValue())); break;
//                case "disgust": emotion.setDisgust(Double.parseDouble(emotionAttribute.getNodeValue())); break;
//                case "fear": emotion.setFear(Double.parseDouble(emotionAttribute.getNodeValue())); break;
//                case "happiness": emotion.setHappiness(Double.parseDouble(emotionAttribute.getNodeValue())); break;
//                case "neutral": emotion.setNeutral(Double.parseDouble(emotionAttribute.getNodeValue())); break;
//                case "sadness": emotion.setSadness(Double.parseDouble(emotionAttribute.getNodeValue())); break;
//                case "surprise": emotion.setSurprise(Double.parseDouble(emotionAttribute.getNodeValue())); break;
//                default: System.out.println("Got unknown emotion node attribute: " + emotionAttribute.getNodeName());
//            }
//        }
//        return emotion;
//    }
//    public static Occlusion occlusionFromNode(Node occlusionNode){
//        Occlusion occlusion = new Occlusion();
//
//        NodeList occlusionNodeList = occlusionNode.getChildNodes();
//        for (int i=0; i < occlusionNodeList.getLength(); i++){
//            Node occlusionAttribute = occlusionNodeList.item(i);
//            switch (occlusionAttribute.getNodeName()){
//                case "foreheadOccluded": occlusion.setForeheadOccluded(Boolean.parseBoolean(occlusionAttribute.getNodeValue()));
//                case "eyeOccluded": occlusion.setEyeOccluded(Boolean.parseBoolean(occlusionAttribute.getNodeValue()));
//                case "mouthOccluded": occlusion.setMouthOccluded(Boolean.parseBoolean(occlusionAttribute.getNodeValue()));
//                default: System.out.println("Got unknown occlusion node attribute: " + occlusionAttribute.getNodeName());
//            }
//        }
//        return occlusion;
//    }
//    public static List<Accessory> accesoriesFromNode(Node accesoriesNode){
//        ArrayList<Accessory> accessories = new ArrayList<>();
//
//        NodeList accessoriesNodeList = accesoriesNode.getChildNodes();
//        for (int i=0; i < accessoriesNodeList.getLength(); i++){
//            Node accessoryNode = accessoriesNodeList.item(i);
//            accessories.add(accessoryFromNode(accessoryNode));
//        }
//        return accessories;
//    }
//    public static Accessory accessoryFromNode(Node accessoryNode){
//        Accessory accessory = new Accessory();
//
//        NodeList accessoryNodeList = accessoryNode.getChildNodes();
//        for (int i = 0; i < accessoryNodeList.getLength(); i++) {
//            accessoryNode = accessoryNodeList.item(i);
//            switch (accessoryNode.getNodeName()){
//                case "type": accessory.setType(accessoryNode.getNodeValue()); break;
//                case "confidence": accessory.setConfidence(Double.parseDouble(accessoryNode.getNodeValue())); break;
//                default : System.out.println("Got unknown accesory node attribute: " + accessoryNode.getNodeName());
//            }
//        }
//        return accessory;
//    }
//    public static Blur blurFromNode(Node blurNode){
//        Blur blur = new Blur();
//
//        NodeList blurNodeList = blurNode.getChildNodes();
//        for (int i=0; i < blurNodeList.getLength(); i++){
//            Node blurAttribute = blurNodeList.item(i);
//            switch (blurAttribute.getNodeName()){
//                case "blurLevel": blur.setBlurLevel(blurAttribute.getNodeValue());
//                case "value": blur.setValue(Double.parseDouble(blurAttribute.getNodeValue()));
//                default: System.out.println("Got unknown blur node attribute: " + blurAttribute.getNodeName());
//            }
//        }
//        return blur;
//    }
//    public static Exposure exposureFromNode(Node exposureNode){
//        Exposure exposure = new Exposure();
//
//        NodeList exposureNodeList = exposureNode.getChildNodes();
//        for (int i=0; i < exposureNodeList.getLength(); i++){
//            Node exposureAttribute = exposureNodeList.item(i);
//            switch (exposureAttribute.getNodeName()){
//                case "exposureLevel": exposure.setExposureLevel(exposureAttribute.getNodeValue());
//                case "value": exposure.setValue(Double.parseDouble(exposureAttribute.getNodeValue()));
//                default: System.out.println("Got unknown exposure node attribute: " + exposureAttribute.getNodeName());
//            }
//        }
//        return exposure;
//    }
//    public static Noise noiseFromNode(Node noiseNode){
//        Noise noise = new Noise();
//
//        NodeList noiseNodeList = noiseNode.getChildNodes();
//        for (int i=0; i < noiseNodeList.getLength(); i++){
//            Node noiseAttribute = noiseNodeList.item(i);
//            switch (noiseAttribute.getNodeName()){
//                case "noiseLevel": noise.setNoiseLevel(noiseAttribute.getNodeValue());
//                case "value": noise.setValue(Double.parseDouble(noiseAttribute.getNodeValue()));
//                default: System.out.println("Got unknown noise node attribute: " + noiseAttribute.getNodeName());
//            }
//        }
//        return noise;
//    }
}
