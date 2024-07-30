
package starlight;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
public class Carga extends javax.swing.JFrame {

    Redimensionar redimensiones = new Redimensionar();
    private Timer timer; // Timer para controlar el cierre automático
    private int contadorSegundos = 0; // Contador de segundos
    
    public JPanel panelTransicion;
    private Timer timer2;
    private float opacidad = 0f;
    
    public Carga() {
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        //CAMBIAR EL ICONO A LA VENTANA
        ImageIcon icon = new ImageIcon("src/Recursos/Icono.png");
        this.setIconImage(icon.getImage());

        // Redondear las esquinas del JFrame
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 40, 40)); //setShape es un metodo de la clase importada y RoundRectangle es una clase predefinida de la clase geom
        redimensiones.setImageLabel(JCarga, "src/Fondo/Carga.gif");

        // Configurar el timer para cerrar la ventana después de 4 segundos (4000 milisegundos)
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contadorSegundos++;
                if (contadorSegundos >= 2) {
                    timer.stop(); // Detener el timer    
                    iniciarTransicion(1);
                }
            }
        });
        timer.start(); // Iniciar el timer
        // Crear el panel de transición
        panelTransicion = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setColor(new Color(0, 0, 0, (int) (opacidad * 255)));
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.dispose();
            }
        };
        
        panelTransicion.setOpaque(false);
        setGlassPane(panelTransicion);
        
        // Inicializar el temporizador para la transición
        timer2 = new Timer(50, null);

    }
    
    //Metodo para cerrar la aplicacion con transicion
    private void cerrarAplicacion() {
        SwingUtilities.invokeLater(() -> {
            dispose();
            System.exit(0);
        });
    }

    //metodod para cambiar de ventana con transicion
    private void cambiarVentana() {
        SwingUtilities.invokeLater(() -> {
            // Cerrar la ventana actual
            dispose();
        });
    }

    //Este metodo sirve para ejecutar el metodo necesario, por ejemplo, si queremos cerrar
    //o ccambia de ventana
    private void iniciarTransicion(int opcion) {
        opacidad = 0f;
        panelTransicion.setVisible(true);
        timer2.stop(); // Asegurarse de que no haya un timer activo
        timer2 = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opacidad += 0.05f;
                if (opacidad >= 1f) {
                    timer2.stop();
                    switch (opcion) {
                        case 1:
                            cambiarVentana();
                            Login ingresar = new Login();
                            ingresar.setVisible(true);
                            break;

                        case 2:
                            cerrarAplicacion();
                            break;

                        case 3:
                           

                            break;

                        case 5:
                            
                            break;
                    }
                }
                panelTransicion.repaint();
            }
        });
        timer2.start();
    }

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JCarga = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1024, 768));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JCarga, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JCarga, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Carga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Carga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Carga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Carga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Carga().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JCarga;
    // End of variables declaration//GEN-END:variables
}
