package starlight;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Inicio extends javax.swing.JFrame {

    Redimensionar redimensiones = new Redimensionar();
    private Timer timer; // Timer para controlar el cierre automático
    private int contadorSegundos = 0; // Contador de segundos

    public Inicio() {
        this.setUndecorated(true);
        this.setSize(1024,768);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        //CAMBIAR EL ICONO A LA VENTANA
        ImageIcon icon = new ImageIcon("src/Recursos/Icono.png");
        this.setIconImage(icon.getImage());

        // Redondear las esquinas del JFrame
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 40, 40)); //setShape es un metodo de la clase importada y RoundRectangle es una clase predefinida de la clase geom
        redimensiones.setImageLabel(JInicio, "src/Fondo/In.gif");

        redimensiones.setImageLabel(tri, "src/Recursos/triangulo.png");
        // Configurar el timer para cerrar la ventana después de 4 segundos (4000 milisegundos)
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contadorSegundos++;
                if (contadorSegundos >= 12) {
                    timer.stop(); // Detener el timer
                    dispose(); // Cerrar la ventana
                    Carga progress = new Carga();
                    progress.setVisible(true);
                }
            }
        });
        timer.start(); // Iniciar el timer
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tri = new javax.swing.JLabel();
        JInicio1 = new javax.swing.JLabel();
        JInicio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tri.setFont(new java.awt.Font("Pixel Operator HB 8", 0, 18)); // NOI18N
        jPanel1.add(tri, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 690, 40, 40));

        JInicio1.setFont(new java.awt.Font("Pixel Operator HB 8", 0, 18)); // NOI18N
        JInicio1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JInicio1.setText("Presiona        para omitir");
        jPanel1.add(JInicio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 690, 570, 40));
        jPanel1.add(JInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(-9, -8, 1040, 780));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>                        

    private void formKeyPressed(java.awt.event.KeyEvent evt) {                                
        if (evt.getKeyCode() == evt.VK_1) {
           timer.stop(); // Detener el timer
            this.dispose(); // Cerrar la ventana
            Carga progress = new Carga();
            progress.setVisible(true);
        }
    }                               

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel JInicio;
    private javax.swing.JLabel JInicio1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel tri;
    // End of variables declaration                   
}