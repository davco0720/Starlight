package starlight;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Recover extends javax.swing.JFrame {

    public JPanel panelTransicion;
    private Timer timer;
    private float opacidad = 0f;

    Redimensionar redimensiones = new Redimensionar();
    private static String emailform = "dudasjbfd@gmail.com";
    private static String passemail = "gyzf lswd omop nxqb";
    String emailto;
    String subject;
    String content;

    private Properties mproperties;
    private Session mSession;
    private MimeMessage mcorreo;

    public Recover() {
        this.setUndecorated(true);
        initComponents();
        this.setSize(1024, 768);
        this.setLocationRelativeTo(null);

        redimensiones.setImageLabel(lbl_barra, "src/Recursos/BarraPanel.png");
        redimensiones.setImageLabel(lbl_foto, "src/Fondo/Fondo_CL.jpeg");
        redimensiones.setImageLabel(lbl_cerrar, "src/Recursos/Cerrar.png");
        redimensiones.setImageLabel(lbl_Regresar, "src/Recursos/Regresar.png"); //Establecer el boton de regresar a la pag anterior

        mproperties = new Properties();
        txtPass.setEnabled(false);
        btnactualizar.setEnabled(false);

        if (rootPaneCheckingEnabled) {
        }

        //CAMBIAR EL ICONO A LA VENTANA
        ImageIcon icon = new ImageIcon("src/Recursos/Icono.png");
        this.setIconImage(icon.getImage());

        // Redondear las esquinas del JFrame
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 40, 40)); //setShape es un metodo de la clase importada y RoundRectangle es una clase predefinida de la clase geom

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
        timer = new Timer(50, null);
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
        timer.stop(); // Asegurarse de que no haya un timer activo
        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opacidad += 0.05f;
                if (opacidad >= 1f) {
                    timer.stop();
                    switch (opcion) {
                        case 1:
                            cambiarVentana();
                            Login ingresar = new Login();
                            ingresar.setVisible(true);
                            break;

                        case 2:
                            cambiarVentana();
                            CREATEACCOUNT crearCuenta = new CREATEACCOUNT();
                            crearCuenta.setVisible(true);
                            break;

                        case 3:
                            cambiarVentana();
                            Recover recuperar = new Recover();
                            recuperar.setVisible(true);
                            break;

                        case 4:
                            //AQUÍ VA A ESTAR EL DE SUPERVIVENCIA
                            break;

                        case 5:
                            cerrarAplicacion();
                            break;
                    }
                }
                panelTransicion.repaint();
            }
        });
        timer.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_cerrar = new javax.swing.JLabel();
        lbl_Regresar = new javax.swing.JLabel();
        lblRecuperar = new javax.swing.JLabel();
        lbl_barra = new javax.swing.JLabel();
        Panel2 = new javax.swing.JPanel();
        txtEmail = new javax.swing.JTextField();
        label1 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        txtPass = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnactualizar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lbl_foto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_cerrarMouseClicked(evt);
            }
        });
        getContentPane().add(lbl_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 20, 40, 40));

        lbl_Regresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_RegresarMouseClicked(evt);
            }
        });
        getContentPane().add(lbl_Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 60, 50));

        lblRecuperar.setFont(new java.awt.Font("Pixel Operator HB 8", 1, 24)); // NOI18N
        lblRecuperar.setForeground(new java.awt.Color(255, 255, 255));
        lblRecuperar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRecuperar.setText("RECUPERAR CUENTA");
        getContentPane().add(lblRecuperar, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1050, 90));
        getContentPane().add(lbl_barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(-480, 0, 1510, 760));

        Panel2.setBackground(new java.awt.Color(0, 153, 153));
        Panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Panel2.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 275, 230, -1));

        label1.setText("Email:");
        Panel2.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 279, -1, -1));

        jToggleButton1.setText("Enviar correo ");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        Panel2.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 361, -1, -1));

        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });
        Panel2.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 455, 193, -1));

        jLabel1.setText("Nueva contrasena");
        Panel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 459, -1, -1));

        btnactualizar.setText("Actualizar contrase;a");
        Panel2.add(btnactualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 527, -1, -1));

        jButton1.setText("ENVAIRRRRRRR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        Panel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 361, 211, -1));

        getContentPane().add(Panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 540, 770));
        getContentPane().add(lbl_foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        Create_Email();
        Send_Email();
        //Aqui crea un if o algo asi para que compruebe si el email existe en la bd y si si existe ponele alli Create_Email y Send_Email luego metes ese if que cree
        String codeverif = JOptionPane.showInputDialog(null, "Introduce el codigo de verificacion:", "Codigo", JOptionPane.QUESTION_MESSAGE);
        if (content.equals(codeverif)) {
            txtPass.setEnabled(true);
            btnactualizar.setEnabled(true);
            txtEmail.setEnabled(false);
            jToggleButton1.setEnabled(false);
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassActionPerformed

    private void Create_Email() {
        emailto = txtEmail.getText().trim();
        subject = "COREO VERIFICACION";

        //vamos a crear la string aleatoria :)
        int longitud = 4;
        for (int i = 0; i <= longitud; i++) {
            int num = (int) ((Math.random() * (('z' - 'a') + 1)) + 'a');
            char letra = (char) num;
            content = content + letra;
        }
        mproperties.put("mail.smtp.host", "smtp.gmail.com");
        mproperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mproperties.setProperty("mail.smtp.starttls.enable", "true");
        mproperties.setProperty("mail.smtp.port", "587");
        mproperties.setProperty("mail.smtp.user", emailform);
        mproperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        mproperties.setProperty("mail.smtp.auth", "true");

        mSession = Session.getDefaultInstance(mproperties);

        mcorreo = new MimeMessage(mSession);

        try {
            mcorreo.setFrom(new InternetAddress(emailform));
            mcorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(emailto));
            mcorreo.setSubject(subject);
            mcorreo.setText(content, "ISO-8859-1", "html");
        } catch (AddressException ex) {
            Logger.getLogger(CREATEACCOUNT.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(CREATEACCOUNT.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void Send_Email() {

        Transport mTransport;
        try {
            mTransport = mSession.getTransport("smtp");
            mTransport.connect(emailform, passemail);
            mTransport.sendMessage(mcorreo, mcorreo.getRecipients(Message.RecipientType.TO));
            mTransport.close();

            JOptionPane.showMessageDialog(null, "COrreo Enviado");
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(CREATEACCOUNT.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(CREATEACCOUNT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Create_Email();
        Send_Email();
        //Aqui crea un if o algo asi para que compruebe si el email existe en la bd y si si existe ponele alli Create_Email y Send_Email luego metes ese if que cree
        String codeverif = JOptionPane.showInputDialog(null, "Introduce el codigo de verificacion:", "Codigo", JOptionPane.QUESTION_MESSAGE);
        if (content.equals(codeverif)) {
            txtPass.setEnabled(true);
            btnactualizar.setEnabled(true);
            txtEmail.setEnabled(false);
            jToggleButton1.setEnabled(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lbl_RegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_RegresarMouseClicked
        //Si el usuario da click al label de regresar
        iniciarTransicion(1);
    }//GEN-LAST:event_lbl_RegresarMouseClicked

    private void lbl_cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_cerrarMouseClicked
        //Cerrar aplicacion
        iniciarTransicion(5);
    }//GEN-LAST:event_lbl_cerrarMouseClicked

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
            java.util.logging.Logger.getLogger(Recover.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Recover.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Recover.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Recover.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Recover().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel2;
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel lblRecuperar;
    private javax.swing.JLabel lbl_Regresar;
    private javax.swing.JLabel lbl_barra;
    private javax.swing.JLabel lbl_cerrar;
    private javax.swing.JLabel lbl_foto;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtPass;
    // End of variables declaration//GEN-END:variables
}
