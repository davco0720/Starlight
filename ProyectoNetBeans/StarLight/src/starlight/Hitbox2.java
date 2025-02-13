package starlight;

import java.awt.*;

public class Hitbox2 extends Hitbox {

    public Hitbox2(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public boolean intersects(Hitbox other) {
        return this.x < other.x + other.width
                && this.x + this.width > other.x
                && this.y < other.y + other.height
                && this.y + this.height > other.y;
    }

    @Override
    public void drawHitbox(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(new Color(0, 255, 0, 0));

        int centerX = x + width / 2;
        int centerY = y + height / 2;

        //Va a agarrar y la haead size va a ser dividida por cuatro para que ocupe la cuarta parte de la hitbox
        int headSize = width / 4;
        //viene y con draw oval va a dibujar el ovalor dentro de la caja (hitbox) y luego va a agarrar el centerx y va a ser la operacion que va a ser que calcule
        //la cordenada de la de la parte superuior que contiene el ovalo para centrarlo horizontalmente
        g2d.drawOval(centerX - headSize / 2, y, headSize, headSize);

        //va a hacer una operacion para que calcule la ubicacion de la cabeza y justo de bajo de la cabeza antes de los pies por eso hace una suma oara calcular
        //la ubicacion de por de bajo de la cabeza y resta para saber mas o menos la zona de los pies
        g2d.drawLine(centerX, y + headSize, centerX, y + height - headSize);

        //lo mismo aca hacemos unas operaciones para que dibuje centrado los brazos
        g2d.drawLine(centerX - width / 2, centerY, centerX + width / 2, centerY);

        //vamos con los pies va a calcular justo donde termina el cuerpo y los va a dezplasar ya sea en la izquierda o derecha
        g2d.drawLine(centerX, y + height - headSize, centerX - width / 4, y + height);
        g2d.drawLine(centerX, y + height - headSize, centerX + width / 4, y + height);

        g2d.dispose();
    }
}