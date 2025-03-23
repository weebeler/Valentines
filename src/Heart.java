import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;
import java.util.Iterator;

public class Heart {
    int x;
    int y;
    int centerX;
    int centerY;
    int ovalWidth;
    int ovalHeight;
    double angle;
    double offset;
    Color color;
    boolean direction;
    ArrayList<Rectangle2D> objects = new ArrayList();

    public Heart(int x, int y, int centerX, int centerY, int ovalWidth, int ovalHeight, double angle, double offset, Color color, boolean direction) {
        this.x = x;
        this.y = y;
        this.centerX = centerX;
        this.centerY = centerY;
        this.ovalWidth = ovalWidth;
        this.ovalHeight = ovalHeight;
        this.angle = angle;
        this.color = color;
        this.offset = offset;
        this.direction = direction;
    }

    public void draw(Graphics2D g) {
        this.objects.clear();
        g.setColor(this.color);
        this.objects.add(new Double((double)(this.x + 2), (double)(this.y + 15), 6.0D, 5.0D));
        this.objects.add(new Double((double)this.x, (double)(this.y + 10), 10.0D, 5.0D));
        this.objects.add(new Double((double)(this.x - 3), (double)(this.y + 5), 16.0D, 5.0D));
        this.objects.add(new Double((double)(this.x - 7), (double)this.y, 24.0D, 5.0D));
        this.objects.add(new Double((double)(this.x - 11), (double)(this.y - 5), 32.0D, 5.0D));
        this.objects.add(new Double((double)(this.x - 9), (double)(this.y - 10), 12.0D, 5.0D));
        this.objects.add(new Double((double)(this.x + 7), (double)(this.y - 10), 12.0D, 5.0D));
        Iterator var2 = this.objects.iterator();

        while(var2.hasNext()) {
            Rectangle2D r = (Rectangle2D)var2.next();
            g.fill(r);
        }

    }

    public void move() {
        this.x = (int)((double)this.centerX + (double)this.ovalWidth * Math.cos(this.angle) * this.offset);
        this.y = (int)((double)this.centerY + (double)this.ovalHeight * Math.sin(this.angle) * this.offset);
        if (this.direction) {
            this.angle += 0.05D;
        } else {
            this.angle -= 0.05D;
        }

        if (this.angle > 6.283185307179586D) {
            this.angle -= 6.283185307179586D;
        }

    }
}
    