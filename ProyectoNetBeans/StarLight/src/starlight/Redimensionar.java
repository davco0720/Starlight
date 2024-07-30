package starlight;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Redimensionar {

    public static Icon setImageLabel(JLabel labelname, String ruta) {
        ImageIcon image = new ImageIcon(ruta);
        Icon icon = new ImageIcon(
                image.getImage().getScaledInstance(labelname.getWidth(), labelname.getHeight(), Image.SCALE_DEFAULT));
        labelname.setIcon(icon);
        return icon;
    }
}
