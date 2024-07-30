package starlight;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.geom.RoundRectangle2D; //Esta clase sirve para poder redondear los frame
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogInto extends javax.swing.JFrame {

    public JPanel panelTransicion;
    private Timer timer;
    private float opacidad = 0f;

    Conexion conectar = new Conexion();
    Redimensionar redimensiones = new Redimensionar();

    public LogInto() {
        this.setUndecorated(true);
        initComponents();
        this.setSize(1024, 768);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        //CAMBIAR EL ICONO A LA VENTANA
        ImageIcon icon = new ImageIcon("src/Recursos/Icono.png");
        this.setIconImage(icon.getImage());

        // Redondear las esquinas del JFrame
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 40, 40)); //setShape es un metodo de la clase importada y RoundRectangle es una clase predefinida de la clase geom

        lbl_notengo.setFocusable(true);
        lbl_iniciar.setFocusable(true); //HACER QUE SEA FOCUSABLE, O SEA QUE SE PUEDA PONER EL FOCUS EN ÉL
        txtUsername.setOpaque(false); //Hacer invisible el txt
        txtPassword.setOpaque(false); //Hacer invisible el txt

        //Establecer los fondos
        redimensiones.setImageLabel(lbl_fondo, "src/Fondo/Fondo_CL.jpeg");
        redimensiones.setImageLabel(lbl_barra, "src/Recursos/BarraPanel.png");

        //Inicializar los componentes que utilizaremos, como apuntadores, ojos para contraseñas e imagenes redimensionadas
        apuntadores();
        Ojos();
        lbl_ocultar1.setVisible(false);
        redimensiones.setImageLabel(lbl_cerrar, "src/Recursos/Cerrar.png");
        redimensiones.setImageLabel(lbl_color, "src/Fondo/Panel2.png");
        redimensiones.setImageLabel(lbl_Regresar, "src/Recursos/Regresar.png"); //Establecer el boton de regresar a la pag anterior

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
                            //Aqui va ir el de supervivencia

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

    private void Ojos() {
        redimensiones.setImageLabel(lbl_ver1, "src/Recursos/Ver.png");
        redimensiones.setImageLabel(lbl_ocultar1, "src/Recursos/Ocultar.png");
    }

    private void apuntadores() {
        redimensiones.setImageLabel(lbl_ApuntadorUsername, "src/Recursos/apuntador.png");
        redimensiones.setImageLabel(lbl_ApuntadorPassword, "src/Recursos/apuntador.png");
        redimensiones.setImageLabel(lbl_ApuntadorButton, "src/Recursos/apuntador.png");
        redimensiones.setImageLabel(lbl_apuntadorRecuperar, "src/Recursos/apuntador.png");
        redimensiones.setImageLabel(lbl_ApuntadorNotengo, "src/Recursos/apuntador.png");
        lbl_ApuntadorUsername.setVisible(false);
        lbl_ApuntadorPassword.setVisible(false);
        lbl_ApuntadorButton.setVisible(false);
        lbl_apuntadorRecuperar.setVisible(false);
        lbl_ApuntadorNotengo.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_cerrar = new javax.swing.JLabel();
        lbl_Regresar = new javax.swing.JLabel();
        lblCreateAccount = new javax.swing.JLabel();
        lbl_barra = new javax.swing.JLabel();
        panel_botones = new javax.swing.JPanel();
        lbl_apuntadorRecuperar = new javax.swing.JLabel();
        lbl_ApuntadorPassword = new javax.swing.JLabel();
        lbl_ApuntadorUsername = new javax.swing.JLabel();
        lbl_ApuntadorNotengo = new javax.swing.JLabel();
        lbl_ApuntadorRecover = new javax.swing.JLabel();
        lbl_ApuntadorButton = new javax.swing.JLabel();
        SeparadorUsername = new javax.swing.JSeparator();
        SeparadorPassword = new javax.swing.JSeparator();
        txtUsername = new javax.swing.JTextField();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lbl_iniciar = new javax.swing.JLabel();
        lbl_notengo = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lbl_ocultar1 = new javax.swing.JLabel();
        lbl_ver1 = new javax.swing.JLabel();
        lbl_color = new javax.swing.JLabel();
        lbl_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_cerrarMouseClicked(evt);
            }
        });
        jPanel1.add(lbl_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 20, 40, 40));

        lbl_Regresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_RegresarMouseClicked(evt);
            }
        });
        jPanel1.add(lbl_Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 60, 50));

        lblCreateAccount.setFont(new java.awt.Font("Pixel Operator HB 8", 1, 24)); // NOI18N
        lblCreateAccount.setForeground(new java.awt.Color(255, 255, 255));
        lblCreateAccount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCreateAccount.setText("INICIAR SESION");
        jPanel1.add(lblCreateAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1050, 90));
        jPanel1.add(lbl_barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(-480, 0, 1510, 760));

        panel_botones.setBackground(new java.awt.Color(0, 51, 102));
        panel_botones.setForeground(new java.awt.Color(204, 204, 204));
        panel_botones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel_botones.add(lbl_apuntadorRecuperar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 642, 20, 20));
        panel_botones.add(lbl_ApuntadorPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, 20, 20));
        panel_botones.add(lbl_ApuntadorUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 20, 20));
        panel_botones.add(lbl_ApuntadorNotengo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 675, 20, 20));
        panel_botones.add(lbl_ApuntadorRecover, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 630, 20, 20));
        panel_botones.add(lbl_ApuntadorButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 580, 30, 30));

        SeparadorUsername.setBackground(new java.awt.Color(255, 255, 255));
        SeparadorUsername.setForeground(new java.awt.Color(255, 255, 255));
        panel_botones.add(SeparadorUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 330, 10));

        SeparadorPassword.setBackground(new java.awt.Color(255, 255, 255));
        SeparadorPassword.setForeground(new java.awt.Color(255, 255, 255));
        panel_botones.add(SeparadorPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 480, 330, 10));

        txtUsername.setFont(new java.awt.Font("Pixel Operator 8", 0, 12)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(102, 102, 102));
        txtUsername.setText("Username");
        txtUsername.setBorder(null);
        txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsernameFocusLost(evt);
            }
        });
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsernameKeyTyped(evt);
            }
        });
        panel_botones.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 330, -1));

        lblUsername.setFont(new java.awt.Font("Pixel Operator HB 8", 1, 14)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsername.setText("USUARIO");
        panel_botones.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 550, -1));

        lblPassword.setFont(new java.awt.Font("Pixel Operator HB 8", 1, 14)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPassword.setText("CONTRASEÑA");
        panel_botones.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 550, -1));

        lbl_iniciar.setFont(new java.awt.Font("Pixel Operator HB 8", 0, 24)); // NOI18N
        lbl_iniciar.setForeground(new java.awt.Color(255, 255, 255));
        lbl_iniciar.setText("IR");
        lbl_iniciar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lbl_iniciarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lbl_iniciarFocusLost(evt);
            }
        });
        lbl_iniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_iniciarMouseClicked(evt);
            }
        });
        lbl_iniciar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lbl_iniciarKeyPressed(evt);
            }
        });
        panel_botones.add(lbl_iniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 580, 50, 30));

        lbl_notengo.setFont(new java.awt.Font("Pixel Operator HB 8", 0, 12)); // NOI18N
        lbl_notengo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_notengo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_notengo.setText("¿NO TIENES CUENTA?");
        lbl_notengo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lbl_notengoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lbl_notengoFocusLost(evt);
            }
        });
        lbl_notengo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_notengoMouseClicked(evt);
            }
        });
        lbl_notengo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lbl_notengoKeyPressed(evt);
            }
        });
        panel_botones.add(lbl_notengo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 680, 230, 20));
        lbl_notengo.getAccessibleContext().setAccessibleName("");

        txtPassword.setFont(new java.awt.Font("Pixel Operator 8", 0, 12)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(102, 102, 102));
        txtPassword.setText("Password");
        txtPassword.setBorder(null);
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPasswordFocusLost(evt);
            }
        });
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPasswordKeyTyped(evt);
            }
        });
        panel_botones.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, 330, 20));

        lbl_ocultar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ocultar1MouseClicked(evt);
            }
        });
        panel_botones.add(lbl_ocultar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 450, 30, 20));

        lbl_ver1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ver1MouseClicked(evt);
            }
        });
        panel_botones.add(lbl_ver1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 450, 30, 20));
        panel_botones.add(lbl_color, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 780));

        jPanel1.add(panel_botones, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 550, 780));
        jPanel1.add(lbl_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 780));

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
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_ver1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ver1MouseClicked
        // El usuario dio clic en el ojo, eso significa que quiere ver su contraseña
        txtPassword.setEchoChar((char) 0);
        lbl_ver1.setVisible(false);
        lbl_ocultar1.setVisible(true);
    }//GEN-LAST:event_lbl_ver1MouseClicked

    private void lbl_ocultar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ocultar1MouseClicked
        // El usuario dio clic en el ojo de ocultar
        txtPassword.setEchoChar('*');
        lbl_ocultar1.setVisible(false);
        lbl_ver1.setVisible(true);
    }//GEN-LAST:event_lbl_ocultar1MouseClicked

    private void txtPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyTyped
        //BLOQUEAR LA BARRA ESPACIADORA DE TEXTFIELDS
        if (evt.getKeyChar() == ' ') {
            evt.consume();
        }

        if (txtPassword.getText().length() >= 25) { // la verificación se realiza después de que el carácter ya se ha agregado al campo de texto
            evt.consume(); //Este metodo sirve para detener el evento keytyped, que permite escribiri en el textfield
            //MOSTRAR MENSAJE DE MAXIMO 25
            Mensaje16 msj = new Mensaje16(this, true);
            msj.setVisible(true);
        }
    }//GEN-LAST:event_txtPasswordKeyTyped

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        // Verificar si el usuario presiona tabulador
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_TAB) {
            lbl_iniciar.requestFocus();
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        //Si el usuario presiona ENTER, simular como si dio clic en el boton de iniciar sesion
        iniciar();
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusLost
        // Si el focus ya no está en el textfield de password
        lbl_ApuntadorPassword.setVisible(false);
        //Cambiar el color del separador
        SeparadorPassword.setBackground(Color.WHITE);
        SeparadorPassword.setForeground(Color.WHITE);

        String pass = String.valueOf(txtPassword.getPassword());
        if (pass.isEmpty()) {
            txtPassword.setText("Password");
            //Cambiar el color a gris, para que haga el efecto de texto predefinido
            txtPassword.setForeground(new Color(102, 102, 102));
            //Enviar el texto al textfield Username
            txtPassword.setText("Password");
        }
    }//GEN-LAST:event_txtPasswordFocusLost

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
        // Si el focus está en el textfield de password
        lbl_ApuntadorPassword.setVisible(true);
        //Cambiar el color del separador
        SeparadorPassword.setBackground(Color.YELLOW);
        SeparadorPassword.setForeground(Color.YELLOW);

        // Obtener la conraseña
        String password = String.valueOf(txtPassword.getPassword());

        // Si la contraseña dice Password, limpiar el textfield
        if (password.equals("Password")) {
            txtPassword.setText("");
            txtPassword.setForeground(Color.WHITE);
            //Enviar el texto al textfield Username
            txtPassword.setText("");
        }
    }//GEN-LAST:event_txtPasswordFocusGained

    private void lbl_iniciarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbl_iniciarKeyPressed
        // Verificar si el usuario presiona ENTER
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            iniciar();
        }
    }//GEN-LAST:event_lbl_iniciarKeyPressed

    private void lbl_iniciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_iniciarMouseClicked
        iniciar();
    }//GEN-LAST:event_lbl_iniciarMouseClicked

    private void lbl_iniciarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbl_iniciarFocusLost
        // OCULTAR EL APUNTADOR DEL BOTON
        lbl_ApuntadorButton.setVisible(false);
        lbl_iniciar.setForeground(Color.WHITE);
    }//GEN-LAST:event_lbl_iniciarFocusLost

    private void lbl_iniciarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbl_iniciarFocusGained
        // MOSTRAR EL APUNTADOR DE BOTON
        lbl_ApuntadorButton.setVisible(true);
        lbl_iniciar.setForeground(new Color(255, 223, 0));
    }//GEN-LAST:event_lbl_iniciarFocusGained

    private void txtUsernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyTyped
        //BLOQUEAR LA BARRA ESPACIADORA DE TEXTFIELDS
        if (evt.getKeyChar() == ' ') {
            evt.consume();
        }

        // LIMITAR EL NUMERO DE CARACTERES DEL TEXTFIELD USERNAME DE CREAR CUENTA
        //Verificar que la longitud de caracteres del textfield no sea mayor a 15
        if (txtUsername.getText().length() >= 8) { // la verificación se realiza después de que el carácter ya se ha agregado al campo de texto
            evt.consume(); //Este metodo sirve para detener el evento keytyped, que permite escribiri en el textfield
            Mensaje18 msj = new Mensaje18(this, true);
            msj.setVisible(true);
        }
    }//GEN-LAST:event_txtUsernameKeyTyped

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        //Este metodo verifica si el usuario ha presionado la tecla ENTER en el txtUsername
        //Colocar el focus al txtPassword
        txtPassword.requestFocus();
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusLost
        //El focus NO está en el TexField de Username
        //Ocultar el apuntador
        lbl_ApuntadorUsername.setVisible(false);

        //Cambiar el color del separador a blanco
        SeparadorUsername.setBackground(Color.WHITE);
        SeparadorUsername.setForeground(Color.WHITE);

        if (txtUsername.getText().isEmpty()) {
            //Cambiar el color a gris, para que haga el efecto de texto predefinido
            txtUsername.setForeground(new Color(102, 102, 102));
            //Enviar el texto al textfield Username
            txtUsername.setText("Username");
        }
    }//GEN-LAST:event_txtUsernameFocusLost

    private void txtUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusGained
        //El focus está en el TexField de Username
        //Mostrar el apuntador
        lbl_ApuntadorUsername.setVisible(true);

        //Cambiar el color del separador a AMARILLO
        SeparadorUsername.setBackground(Color.YELLOW);
        SeparadorUsername.setForeground(Color.YELLOW);

        if (txtUsername.getText().equals("Username")) {
            //Cambiar el color a negro, para que haga el efecto de texto real
            txtUsername.setForeground(Color.WHITE);
            //Enviar el texto al textfield Username
            txtUsername.setText("");
        }
    }//GEN-LAST:event_txtUsernameFocusGained

    private void lbl_RegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_RegresarMouseClicked
        //Si el usuario da click al label de regresar
        iniciarTransicion(1);
    }//GEN-LAST:event_lbl_RegresarMouseClicked

    private void lbl_cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_cerrarMouseClicked
        //Cerrar aplicacion
        iniciarTransicion(5);
    }//GEN-LAST:event_lbl_cerrarMouseClicked

    private void recuperar() {
        iniciarTransicion(3);
    }

    private void lbl_notengoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbl_notengoFocusGained
        lbl_ApuntadorNotengo.setVisible(true);
        lbl_notengo.setForeground(new Color(255, 223, 0));
    }//GEN-LAST:event_lbl_notengoFocusGained

    private void lbl_notengoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbl_notengoFocusLost
        lbl_ApuntadorNotengo.setVisible(false);
        lbl_notengo.setForeground(Color.WHITE);
    }//GEN-LAST:event_lbl_notengoFocusLost

    private void lbl_notengoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_notengoMouseClicked
        crearcuenta();
    }//GEN-LAST:event_lbl_notengoMouseClicked

    private void crearcuenta() {
        iniciarTransicion(2);
    }

    private void lbl_notengoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbl_notengoKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            crearcuenta();
        }
    }//GEN-LAST:event_lbl_notengoKeyPressed

    private void iniciar() {
        // BOTON QUE REDIRIGE AL ESCENARIO1 - MUNDO1
        try {
            String usuario = txtUsername.getText();
            // ValueOf convierte los valores de contraseña a string, letras
            String password = String.valueOf(txtPassword.getPassword());
            Md5Encript encript = new Md5Encript();

            //Verifcar que los dos campos no estén vacios
            if (!usuario.equals("Username") && !usuario.trim().isEmpty() && !password.equals("Password") && !password.trim().isEmpty()) {
                //Armar la consulta para workbrench
                String queryverificar = "SELECT * FROM Users WHERE BINARY Username=?";
                //Ejecutar la consulta para seleccionar los datos
                try (PreparedStatement statementVerificar = conectar.ConexionBD().prepareStatement(queryverificar)) {
                    //Insertar el nombre de usuario en la consulta parametrizada
                    statementVerificar.setString(1, usuario);

                    // Verificar si regresa algún resultado la BD
                    try (ResultSet resultadoExistente = statementVerificar.executeQuery()) {
                        //Si regresa algo el resulSet, entonces el usuario existe
                        if (resultadoExistente.next()) {
                            //verificar que la contraseña esté correcta con el usuario
                            //Armar la consulta para workbrench
                            String query = "SELECT * FROM Users WHERE BINARY Username=? AND BINARY Pass=?";
                            //Preparar la consulta para interactuar con la BD
                            try (PreparedStatement statement = conectar.ConexionBD().prepareStatement(query)) {
                                //Insertar los datos de usuario y de contraseña de la consulta para buscar en la BD
                                statement.setString(1, usuario);
                                statement.setString(2, encript.ecnode(password));

                                //Verificar si la base de datos devuelve algo
                                try (ResultSet resultado = statement.executeQuery()) {
                                    // Si el resultSet regresa algo quiere decir que si existe en la BD, 
                                    //quiere decir que si existe ese usuario con esa contraseña
                                    if (resultado.next()) {
                                        //Instanciar la clase de escenario 1
                                        M1N1 esc1 = new M1N1();
                                                                                //Ocultar esta ventana
                                        this.dispose();
                                        
//ESTO SIRVE PARA MANDAR A LLAMAR LA VARIABLE EN EL OTRO FRAME CHECHITA
                                          esc1.setNombre(txtUsername.getText());
                                          
                                         
                                        //Cambiar de ventana para iniciar a jugar
                                      
                                        esc1.setVisible(true);
                                        //Mostrar un mensaje de bienvenida al usuario
                                        Mensaje10 msj = new Mensaje10(this, true);
                                        msj.setVisible(true);
                                    } else {
                                        // MENSAJE DE CONTRASEÑA INCORRECTA
                                        Mensaje11 msj = new Mensaje11(this, true);
                                        msj.setVisible(true);
                                    }
                                }
                            }
                        } else {
                            //MESNAJE DE USUARIO INEXISTENTE
                            Mensaje12 m = new Mensaje12(this, true);
                            m.setVisible(true);
                        }

                    }
                }

            } else {
                ///Mostrar un mensaje si los campos están vacios
                Mensaje7 msj = new Mensaje7(this, true);
                msj.setVisible(true);
            }
        } catch (SQLException e) {
            //Si ocurre algún error inesperado, mostrar un mensaje
            Mensaje8 msj = new Mensaje8(this, true);
            msj.setVisible(true);
        }

    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LogInto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogInto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogInto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogInto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogInto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator SeparadorPassword;
    private javax.swing.JSeparator SeparadorUsername;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCreateAccount;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lbl_ApuntadorButton;
    private javax.swing.JLabel lbl_ApuntadorNotengo;
    private javax.swing.JLabel lbl_ApuntadorPassword;
    private javax.swing.JLabel lbl_ApuntadorRecover;
    private javax.swing.JLabel lbl_ApuntadorUsername;
    private javax.swing.JLabel lbl_Regresar;
    private javax.swing.JLabel lbl_apuntadorRecuperar;
    private javax.swing.JLabel lbl_barra;
    private javax.swing.JLabel lbl_cerrar;
    private javax.swing.JLabel lbl_color;
    private javax.swing.JLabel lbl_fondo;
    private javax.swing.JLabel lbl_iniciar;
    private javax.swing.JLabel lbl_notengo;
    private javax.swing.JLabel lbl_ocultar1;
    private javax.swing.JLabel lbl_ver1;
    private javax.swing.JPanel panel_botones;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
