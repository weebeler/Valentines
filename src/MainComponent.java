import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MainComponent extends JPanel implements ActionListener {
    Timer timer;
    int delay = 15;
    ArrayList<Heart> hearts = new ArrayList();

    public MainComponent() {
        int centerx = 600;
        int centery = 400;
        int width = 200;
        int height = 100;
        boolean direction = true;

        for(int i = 1; i < 4; ++i) {
            double offset = 0.25D + (double)i / 2.0D;

            for(int j = 1; j <= 40; j += 2) {
                double angle = 3.141592653589793D * ((double)j / 20.0D);
                this.hearts.add(new Heart(0, 0, centerx, centery, width, height, angle, offset, this.genRandomColor(), direction));
            }

            direction = !direction;
        }

        this.timer = new Timer(this.delay, this);
        this.timer.start();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Iterator iterator = this.hearts.iterator();

        while(iterator.hasNext()) {
            Heart h = (Heart)iterator.next();
            h.draw((Graphics2D)g);
        }

        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.RED);
        g2.setFont(new Font("Arial", 1, 24));
        g2.drawString("Will you be my", 520, 400);
        g2.drawString("Valentine?", 550, 435);
    }

    public void actionPerformed(ActionEvent e) {
        Iterator iterator = this.hearts.iterator();

        while(iterator.hasNext()) {
            Heart h = (Heart)iterator.next();
            h.move();
        }

        this.repaint();
    }

    public Color genRandomColor() {
        Random random = new Random();
        int index = random.nextInt(5);
        Color color;
        switch(index) {
            case 0:
                color = Color.RED;
                break;
            case 1:
                color = Color.ORANGE;
                break;
            case 2:
                color = Color.GREEN;
                break;
            case 3:
                color = Color.BLUE;
                break;
            case 4:
                color = Color.MAGENTA;
                break;
            default:
                color = Color.PINK;
        }

        return color;
    }
}