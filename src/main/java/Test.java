import java.awt.EventQueue;
import java.awt.event.*;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test extends JFrame {

    public Test() {
        initUI();
    }

    private void initUI() {

        JButton btn = new JButton("Button");
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                System.out.println("Je klikte op een button, gefeliciteerd!");
            }
        });

        createLayout(btn);

        setTitle("Tooltip");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createLayout(JComponent... arg) {

        JPanel pane = (JPanel) getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        pane.setToolTipText("Content pane");

        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
                .addGap(200)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
                .addGap(120)
        );

        pack();
    }

    public static void main(String[] args) throws Exception {

        WebcamHandler wh = new WebcamHandler();
        FaceRequester fr = new FaceRequester(
                "87c048759d514e94bec0826164a98187",
                "https://westcentralus.api.cognitive.microsoft.com/face/v1.0/detect"
        );
        // Valid until 1 november 2017
        System.out.println("OBAMA:");
        String jsonStr = fr.byFile("src\\main\\resources\\obama.jpg");
        System.out.println(jsonStr);
        Face obama = FaceParser.fromJson(jsonStr);
        System.out.println(obama);

        System.out.println("\nYOU:");
        jsonStr = fr.byBufferedImage(wh.getImage());
        System.out.println(jsonStr);
        Face you = FaceParser.fromJson(jsonStr);
        System.out.println(you);

//        EventQueue.invokeLater(() -> {
//            Test ex = new Test();
//            ex.setVisible(true);
//        });
    }
}
