import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FaceRequester {
    // *****************************************************************************
    // ***                     Valid until 1 november 2017                       ***
    // *** Endpoint: https://westcentralus.api.cognitive.microsoft.com/face/v1.0 ***
    // ***                  Key 1: 87c048759d514e94bec0826164a98187              ***
    // ***                  Key 2: 0efd551a82a94ec1bd0fe00ed59d65d6              ***
    // *** Through Corneels Github account                                       ***
    // *****************************************************************************
    private final String USER_AGENT = "Mozilla/5.0";
    private final String subscriptionKey;
    private final String endPoint;
    private boolean returnFaceId = true;
    private boolean returnFaceLandmarks = true;
    private String returnFaceAttributes = "age,gender,headPose,smile,facialHair,glasses,emotion,hair,makeup,occlusion,accessories,blur,exposure,noise";

    public FaceRequester(String subscriptionKey, String endPoint){
        this.subscriptionKey = subscriptionKey;
        this.endPoint = endPoint;
    }

    private URL buildUrl() throws MalformedURLException {
        StringBuilder urlSb = new StringBuilder();
        urlSb.append(endPoint).append('?');
        urlSb.append("returnFaceId=").append(returnFaceId).append("&");
        urlSb.append("returnFaceLandmarks=").append(returnFaceLandmarks).append("&");
        urlSb.append("returnFaceAttributes=").append(returnFaceAttributes);
        return new URL(urlSb.toString());
    }

    private HttpURLConnection createConnection(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("User-Agent", USER_AGENT);
        connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        connection.setRequestProperty("Ocp-Apim-Subscription-Key", subscriptionKey);
        return connection;
    }

    public String byWebUrl(URL urlOfImage) throws Exception {
        return byWebUrl(urlOfImage.toString());
    }
    public String byWebUrl(String urlOfImage) throws Exception {
        String target = "{'url':'" + urlOfImage + "'}";
        return byJsonUrlString(target);
    }
    public String byJsonUrlString(String JsonUrlOfImage) throws Exception {

        URL url = buildUrl();
        HttpURLConnection connection = createConnection(url);
        connection.setRequestProperty("Content-Type", "application/json");

        // Send post request
        connection.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
        wr.writeBytes( JsonUrlOfImage );
        wr.flush();
        wr.close();

        int httpStatusCode = connection.getResponseCode();
        if (httpStatusCode != HttpURLConnection.HTTP_OK) {
            System.out.println("Http status code : " + httpStatusCode);
        }

        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    public String byFile(String pathToFile) throws Exception {
        return byFile(Paths.get(pathToFile));
    }
    public String byFile(Path pathToFile) throws Exception {

        URL url = buildUrl();
        HttpURLConnection connection = createConnection(url);
        connection.setRequestProperty("Content-Type", "application/octet-stream");

        // Send post request
        connection.setDoOutput(true);
        Files.copy(pathToFile, connection.getOutputStream());

        int httpStatusCode = connection.getResponseCode();
        if (httpStatusCode != HttpURLConnection.HTTP_OK) {
            System.out.println("Http status code : " + httpStatusCode);
        }

        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    public String byBufferedImage(BufferedImage input) throws Exception {

        URL url = buildUrl();
        HttpURLConnection connection = createConnection(url);
        connection.setRequestProperty("Content-Type", "application/octet-stream");

        // Send post request
        connection.setDoOutput(true);
        ImageIO.write(input, "PNG", connection.getOutputStream());

        int httpStatusCode = connection.getResponseCode();
        if (httpStatusCode != HttpURLConnection.HTTP_OK) {
            System.out.println("Http status code : " + httpStatusCode);
        }

        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    public boolean isReturnFaceId() {
        return returnFaceId;
    }
    public void setReturnFaceId(boolean returnFaceId) {
        this.returnFaceId = returnFaceId;
    }
    public boolean isReturnFaceLandmarks() {
        return returnFaceLandmarks;
    }
    public void setReturnFaceLandmarks(boolean returnFaceLandmarks) {
        this.returnFaceLandmarks = returnFaceLandmarks;
    }
    public String getReturnFaceAttributes() {
        return returnFaceAttributes;
    }
    public void setReturnFaceAttributes(String returnFaceAttributes) {
        this.returnFaceAttributes = returnFaceAttributes;
    }
}