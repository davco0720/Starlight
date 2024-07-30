package starlight;

import java.awt.geom.RoundRectangle2D;

public class Mensaje9 extends javax.swing.JDialog {
        Redimensionar redimensiones = new Redimensionar();
    public Mensaje9(java.awt.Frame parent, boolean modal) {
        
        super(parent, modal);
        this.setUndecorated(true);
        initComponents();
        this.setSize(358, 152); // Establecer el tamaño de la ventana
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        // Redondear las esquinas del JFrame
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 40, 40)); //setShape es un metodo de la clase importada y RoundRectangle es una clase predefinida de la clase geom
        
        //Hacer focusable el label, para que se pueda poner el focus en ese label
        btn_ok.setFocusable(true);
        btn_ok.setRequestFocusEnabled(true);
        
        try{
            redimensiones.setImageLabel(lbl_foto, "src/Mensajes/UsuarioAgregado.png");
        }catch(Exception e){
            
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_ok = new javax.swing.JLabel();
        lbl_foto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_ok.setFont(new java.awt.Font("Pixel Operator HB 8", 0, 14)); // NOI18N
        btn_ok.setForeground(new java.awt.Color(255, 255, 255));
        btn_ok.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_ok.setText("OK");
        btn_ok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_okMouseClicked(evt);
            }
        });
        btn_ok.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_okKeyPressed(evt);
            }
        });
        getContentPane().add(btn_ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 360, 30));
        getContentPane().add(lbl_foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 358, 152));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_okMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_okMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_okMouseClicked

    private void btn_okKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_okKeyPressed
        // verificar si en el label dan enter
        if (evt.getKeyCode() == evt.VK_ENTER) {
            // Llamar a registro
            this.dispose();
        }
    }//GEN-LAST:event_btn_okKeyPressed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Mensaje9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mensaje9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mensaje9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mensaje9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Mensaje9 dialog = new Mensaje9(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_ok;
    private javax.swing.JLabel lbl_foto;
    // End of variables declaration//GEN-END:variables
}
