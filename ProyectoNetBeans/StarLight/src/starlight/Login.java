package starlight;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D; //Clase necesaria para poder redondear las frames
import javax.swing.*;

public class Login extends javax.swing.JFrame {

    Redimensionar redimensiones = new Redimensionar();
    ReproducirMusica reproductor;

    public JPanel panelTransicion;
    private Timer timer;
    private float opacidad = 0f;

    public Login() {
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        //CAMBIAR EL ICONO A LA VENTANA
        ImageIcon icon = new ImageIcon("src/Recursos/Icono.png");
        this.setIconImage(icon.getImage());

        reproductor = new ReproducirMusica("src/Musica/MusicaPrincipal.mp3");

        // Redondear las esquinas del JFrame
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 40, 40)); //setShape es un metodo de la clase importada y RoundRectangle es una clase predefinida de la clase geom

        lbl_logInto.setOpaque(false); //Hacer invisible el lbl

        //Importar los componentes necesarios como música e imagenes redimensionadas
        redimensiones.setImageLabel(lbl_fondo, "src/Fondo/Fondo_vid (1).gif");
        redimensiones.setImageLabel(lbl_panel, "src/Fondo/PANEL.png");

        // Start playing music
        reproductor.iniciar();
        redimensiones.setImageLabel(lbl_cerrar, "src/Recursos/Cerrar.png");//label cerrar

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

        lbl_logInto.requestFocus();
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
                            LogInto ingresar = new LogInto();
                            ingresar.setVisible(true);
                            break;

                        case 2:
                            cambiarVentana();
                            CREATEACCOUNT crearCuenta = new CREATEACCOUNT();
                            crearCuenta.setVisible(true);
                            break;

                        case 3:
                            cambiarVentana();
                            PR_11 partida = new PR_11();
                            partida.setVisible(true);
                            break;

                        case 4:
                            //AQUÍ VA A ESTAR EL DE SUPERVIVENCIA
                            cambiarVentana();
                            Ayuda D = new Ayuda();
                            D.setVisible(true);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_CreateAccount = new javax.swing.JLabel();
        lbl_supervivencia = new javax.swing.JLabel();
        lbl_QuickPlay = new javax.swing.JLabel();
        lbl_logInto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbl_panel = new javax.swing.JLabel();
        lbl_cerrar = new javax.swing.JLabel();
        lbl_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_CreateAccount.setBackground(new java.awt.Color(255, 255, 255));
        lbl_CreateAccount.setFont(new java.awt.Font("Pixel Operator HB 8", 1, 18)); // NOI18N
        lbl_CreateAccount.setForeground(new java.awt.Color(255, 255, 255));
        lbl_CreateAccount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_CreateAccount.setText("CREAR CUENTA");
        lbl_CreateAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_CreateAccount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_CreateAccount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lbl_CreateAccountFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lbl_CreateAccountFocusLost(evt);
            }
        });
        lbl_CreateAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_CreateAccountMouseClicked(evt);
            }
        });
        lbl_CreateAccount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lbl_CreateAccountKeyPressed(evt);
            }
        });
        jPanel1.add(lbl_CreateAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 380, 320, 40));

        lbl_supervivencia.setBackground(new java.awt.Color(255, 255, 255));
        lbl_supervivencia.setFont(new java.awt.Font("Pixel Operator HB 8", 1, 18)); // NOI18N
        lbl_supervivencia.setForeground(new java.awt.Color(255, 255, 255));
        lbl_supervivencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_supervivencia.setText("AYUDA");
        lbl_supervivencia.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_supervivencia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_supervivencia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lbl_supervivenciaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lbl_supervivenciaFocusLost(evt);
            }
        });
        lbl_supervivencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_supervivenciaMouseClicked(evt);
            }
        });
        lbl_supervivencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lbl_supervivenciaKeyPressed(evt);
            }
        });
        jPanel1.add(lbl_supervivencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 520, 320, 40));

        lbl_QuickPlay.setBackground(new java.awt.Color(255, 255, 255));
        lbl_QuickPlay.setFont(new java.awt.Font("Pixel Operator HB 8", 1, 18)); // NOI18N
        lbl_QuickPlay.setForeground(new java.awt.Color(255, 255, 255));
        lbl_QuickPlay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_QuickPlay.setText("PARTIDA RAPIDA");
        lbl_QuickPlay.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_QuickPlay.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_QuickPlay.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lbl_QuickPlayFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lbl_QuickPlayFocusLost(evt);
            }
        });
        lbl_QuickPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_QuickPlayMouseClicked(evt);
            }
        });
        lbl_QuickPlay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lbl_QuickPlayKeyPressed(evt);
            }
        });
        jPanel1.add(lbl_QuickPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 450, 320, 40));

        lbl_logInto.setBackground(new java.awt.Color(255, 255, 255));
        lbl_logInto.setFont(new java.awt.Font("Pixel Operator HB 8", 1, 18)); // NOI18N
        lbl_logInto.setForeground(new java.awt.Color(255, 255, 255));
        lbl_logInto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_logInto.setText("INICIAR SESION");
        lbl_logInto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_logInto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_logInto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lbl_logIntoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lbl_logIntoFocusLost(evt);
            }
        });
        lbl_logInto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_logIntoMouseClicked(evt);
            }
        });
        lbl_logInto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lbl_logIntoKeyPressed(evt);
            }
        });
        jPanel1.add(lbl_logInto, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, 320, 40));

        jLabel1.setFont(new java.awt.Font("Pixel Operator HB 8", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BIENVENIDO");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 410, 90));

        lbl_panel.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.add(lbl_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 760));

        lbl_cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_cerrarMouseClicked(evt);
            }
        });
        jPanel1.add(lbl_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 30, 40, 40));

        lbl_fondo.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.add(lbl_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 760));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void lbl_logIntoMouseClicked(java.awt.event.MouseEvent evt) {                                         
        // ACCION AL PRESIONAR BOTON DE LOG INTO
        iniciarTransicion(1);
        reproductor.detener();
    }                                        

    private void lbl_CreateAccountMouseClicked(java.awt.event.MouseEvent evt) {                                               
        //ACCION AL PRESIONAR BOTON DE CREATE ACCOUNT
        iniciarTransicion(2);
        reproductor.detener();

    }                                              

    private void lbl_QuickPlayMouseClicked(java.awt.event.MouseEvent evt) {                                           
        // ACCION AL PRESIONAR BOTON DE PARTIDA RAPIDA
        iniciarTransicion(3);
        reproductor.detener();

    }                                          

    private void lbl_supervivenciaMouseClicked(java.awt.event.MouseEvent evt) {                                               
        // Aqui va a estar la animacion de supervivencia
        iniciarTransicion(4);
        reproductor.detener();
    }                                              

    private void lbl_cerrarMouseClicked(java.awt.event.MouseEvent evt) {                                        
        //Cerrar aplicacion
        iniciarTransicion(5);
    }                                       

    private void lbl_logIntoFocusGained(java.awt.event.FocusEvent evt) {                                        
        lbl_logInto.setForeground(Color.YELLOW);
    }                                       

    private void lbl_logIntoFocusLost(java.awt.event.FocusEvent evt) {                                      
        lbl_logInto.setForeground(Color.WHITE);
    }                                     

    private void lbl_CreateAccountFocusGained(java.awt.event.FocusEvent evt) {                                              
        lbl_CreateAccount.setForeground(Color.YELLOW);
    }                                             

    private void lbl_CreateAccountFocusLost(java.awt.event.FocusEvent evt) {                                            
        lbl_CreateAccount.setForeground(Color.WHITE);
    }                                           

    private void lbl_logIntoKeyPressed(java.awt.event.KeyEvent evt) {                                       
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_2) {
            lbl_CreateAccount.requestFocus();
        }

        if (evt.getKeyCode() == evt.VK_W) {
            iniciarTransicion(1);
            reproductor.detener();
        }
    }                                      

    private void lbl_CreateAccountKeyPressed(java.awt.event.KeyEvent evt) {                                             
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_2) {
            lbl_QuickPlay.requestFocus();
        }

        if (evt.getKeyCode() == evt.VK_W) {
            iniciarTransicion(2);
            reproductor.detener();
        }
    }                                            

    private void lbl_QuickPlayKeyPressed(java.awt.event.KeyEvent evt) {                                         
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_2) {
            lbl_supervivencia.requestFocus();
        }

        if (evt.getKeyCode() == evt.VK_W) {
            iniciarTransicion(3);
            reproductor.detener();
        }

    }                                        

    private void lbl_supervivenciaKeyPressed(java.awt.event.KeyEvent evt) {                                             
        if (evt.getKeyCode() == evt.VK_2) {
            lbl_logInto.requestFocus();
        }
        
        if (evt.getKeyCode() == evt.VK_W) {
            iniciarTransicion(3);
            reproductor.detener();
        }
    }                                            

    private void lbl_QuickPlayFocusGained(java.awt.event.FocusEvent evt) {                                          
        // TODO add your handling code here:
        lbl_QuickPlay.setForeground(Color.YELLOW);
    }                                         

    private void lbl_QuickPlayFocusLost(java.awt.event.FocusEvent evt) {                                        
        // TODO add your handling code here:
        lbl_QuickPlay.setForeground(Color.WHITE);
    }                                       

    private void lbl_supervivenciaFocusGained(java.awt.event.FocusEvent evt) {                                              
        // TODO add your handling code here:
        lbl_supervivencia.setForeground(Color.YELLOW);
    }                                             

    private void lbl_supervivenciaFocusLost(java.awt.event.FocusEvent evt) {                                            
        // TODO add your handling code here:
        lbl_supervivencia.setForeground(Color.WHITE);
    }                                           

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {                                   
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ESCAPE) {
            System.exit(0);
        }
    }                                  

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_CreateAccount;
    private javax.swing.JLabel lbl_QuickPlay;
    private javax.swing.JLabel lbl_cerrar;
    private javax.swing.JLabel lbl_fondo;
    private javax.swing.JLabel lbl_logInto;
    private javax.swing.JLabel lbl_panel;
    private javax.swing.JLabel lbl_supervivencia;
    // End of variables declaration                   
}
