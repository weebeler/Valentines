import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("For REDACTED");
        MainComponent panel = new MainComponent();
        frame.add(panel);
        frame.setSize(1200, 1000);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
        File path = new File("D:\\Knocks Me Off My Feet.wav");

        try {
            AudioInputStream stream = AudioSystem.getAudioInputStream(path);
            Clip clip = AudioSystem.getClip();
            clip.open(stream);
            clip.start();
        } catch (Exception var6) {
            var6.printStackTrace();
        }

    }
}