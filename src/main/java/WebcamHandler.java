import com.github.sarxos.webcam.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WebcamHandler {
    private final Webcam webcam;

    public WebcamHandler() {
        webcam = Webcam.getDefault();
    }

    public void test() throws IOException {
        webcam.open();
        for(int i = 0; i<3 ; i++) {
            ImageIO.write(webcam.getImage(), "PNG", new File("hello-world"+i+".png"));
        }
    }

    public BufferedImage getImage(){
        webcam.open();
        return webcam.getImage();
    }



    public static void main(String... args) throws IOException {
        WebcamHandler wh = new WebcamHandler();
        wh.test();
        System.out.println("Is niet gecrashed");
    }
}
