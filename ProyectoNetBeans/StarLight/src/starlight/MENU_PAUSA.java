package starlight;

import javax.swing.*;
import java.awt.*;

public class MENU_PAUSA extends JDialog {

    private JButton reanudarButton, reiniciarButton, salirButton;

    public MENU_PAUSA() {
        setLayout(new GridLayout(3, 1));
        setTitle("Juego Pausado");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        reanudarButton = new JButton("Reanudar");
        reiniciarButton = new JButton("Reiniciar");
        salirButton = new JButton("Salir");

        reanudarButton.addActionListener(e -> {
            setVisible(false);
            // Código para reanudar el juego
        });

        reiniciarButton.addActionListener(e -> {
            setVisible(false);
            // Código para reiniciar el juego
        });

        salirButton.addActionListener(e -> {
            setVisible(false);
            System.exit(0);
        });

        add(reanudarButton);
        add(reiniciarButton);
        add(salirButton);
    }

}
