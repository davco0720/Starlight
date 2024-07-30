package starlight;

import java.awt.*;

public class Hitbox {

    protected int x, y, width, height;

    public Hitbox(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void drawHitbox(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(new Color(0, 255, 0, 50)); // Color verde semi-transparente
        g2d.fillRect(x, y, width, height);
        g2d.dispose();
    }

    public boolean intersects(Hitbox other) {
        return this.x < other.x + other.width
                && this.x + this.width > other.x
                && this.y < other.y + other.height
                && this.y + this.height > other.y;
    }
}