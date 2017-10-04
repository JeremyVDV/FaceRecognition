import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FaceRequester {

    private final String USER_AGENT = "Mozilla/5.0";
    private final String subscriptionKey;
    private final String endPoint;
    private boolean returnFaceId = true;
    private boolean returnFaceLandmarks = true;
    private String returnFaceAttributes = "age,gender,headPose,smile,facialHair,glasses,emotion,hair,makeup,occlusion,accessories,blur,exposure,noise";

    public static void main(String[] args) throws Exception {
        // *****************************************************************************
        // ***                     Valid until 1 november 2017                       ***
        // *** Endpoint: https://westcentralus.api.cognitive.microsoft.com/face/v1.0 ***
        // ***                  Key 1: 87c048759d514e94bec0826164a98187              ***
        // ***                  Key 2: 0efd551a82a94ec1bd0fe00ed59d65d6              ***
        // *** Through Corneels Github account                                       ***
        // *****************************************************************************
        FaceRequester requester = new FaceRequester(
                "87c048759d514e94bec0826164a98187",
                "https://westcentralus.api.cognitive.microsoft.com/face/v1.0/detect"
        );
        //String exampleMicrosoft = requester.byString(
        //        "{'url':'https://upload.wikimedia.org/wikipedia/commons/c/c3/RH_Louise_Lillian_Gish.jpg'}"
        //);
        String obamaResults = requester.byFile("D:\\data\\CEI22232\\Documents\\gitProjects\\src\\main\\resources\\obama.jpg");
        System.out.println(obamaResults);
    }

    public FaceRequester(String subscriptionKey, String endPoint){
        this.subscriptionKey = subscriptionKey;
        this.endPoint = endPoint;
    }

    private URL buildUrl() throws MalformedURLException {
        StringBuffer urlSb = new StringBuffer();
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

    private String byString(String request) throws Exception {

        URL url = buildUrl();
        HttpURLConnection connection = createConnection(url);
        connection.setRequestProperty("Content-Type", "application/json");

        // Send post request
        connection.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
        wr.writeBytes( request );
        wr.flush();
        wr.close();

        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            System.out.println("Response Code : " + responseCode);
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

    private String byFile(String pathToFile) throws Exception {

        URL url = buildUrl();
        HttpURLConnection connection = createConnection(url);
        connection.setRequestProperty("Content-Type", "application/octet-stream");

        // Send post request
        connection.setDoOutput(true);
        Path path = Paths.get(pathToFile);
        Files.copy(path, connection.getOutputStream());

        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            System.out.println("Response Code : " + responseCode);
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
}