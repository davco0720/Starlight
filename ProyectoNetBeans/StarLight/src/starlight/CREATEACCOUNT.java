package starlight;

import java.awt.*;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D; //Esta clase sirve para poder redondear los Frames
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CREATEACCOUNT extends javax.swing.JFrame {

    //Crear una instancia de la clase Conexion que se llame conexion
    //Esta nos va a servir para utilizar la conexion con la base de datos
    Conexion conexion = new Conexion();
    //Crear una instancia de la clase Redimensionar que se llame redimensiones
    //Esta nos va a servir para poder redimensionar los iconos de cualquier componente
    Redimensionar redimensiones = new Redimensionar();

    public JPanel panelTransicion;
    private Timer timer;
    private float opacidad = 0f;

    public CREATEACCOUNT() {
        setUndecorated(true); // Eliminar la barra de títulos
        initComponents(); // Inicializar los componentes
        this.setResizable(false); // No permitir que la ventana se redimensione
        this.setSize(1024, 768); // Establecer el tamaño de la ventana
        this.setLocationRelativeTo(null); // Centrar la ventana

        //CAMBIAR EL ICONO A LA VENTANA
        ImageIcon icon = new ImageIcon("src/Recursos/Icono.png");
        this.setIconImage(icon.getImage());

        // Redondear las esquinas del JFrame
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 40, 40)); //setShape es un metodo de la clase importada y RoundRectangle es una clase predefinida de la clase geom

        //Paneldeinterfaz2.setOpaque(false); 
        txtUsername.setOpaque(false);
        txtPassword.setOpaque(false);
        txtConfirmPassword.setOpaque(false);
        txtEmail.setOpaque(false);
        apuntadores();

        //Hacer focusable el label, para que se pueda poner el focus en ese label
        lbl_crearcuenta.setFocusable(true);
        lbl_yatengo.setFocusable(true);

        //Usar la clase de Redimensionar para poder cambiar el tamaño de los iconos de los label y del boton
        //segun sea necesario
        redimensiones.setImageLabel(lbl_fondo, "src/Fondo/Fondo_CL.jpeg"); // Establecer la imagen del fondo
        redimensiones.setImageLabel(lbl_Regresar, "src/Recursos/Regresar.png");
        redimensiones.setImageLabel(lbl_panel, "src/Fondo/Panel2.png");
        redimensiones.setImageLabel(lbl_cerrar, "src/Recursos/Cerrar.png");
        redimensiones.setImageLabel(lbl_barra, "src/Recursos/BarraPanel.png");

        //lamar a ver los ojos
        Ojos();
        lbl_ver.setVisible(true);
        lbl_ver1.setVisible(true);
        lbl_ocultar.setVisible(false);
        lbl_ocultar1.setVisible(false);

        //Estblecer los carateres de contraseña
        txtPassword.setEchoChar('*');
        txtConfirmPassword.setEchoChar('*');

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
                            LogInto ingresar = new LogInto();
                            ingresar.setVisible(true);
                            break;

                        case 2:
                            cambiarVentana();
                            Login regresar = new Login();
                            regresar.setVisible(true);
                            break;

                        case 3:
                            cambiarVentana();

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

    //Método que establece imagenes a los ojos
    private void Ojos() {
        redimensiones.setImageLabel(lbl_ver, "src/Recursos/Ver.png");
        redimensiones.setImageLabel(lbl_ver1, "src/Recursos/Ver.png");
        redimensiones.setImageLabel(lbl_ocultar, "src/Recursos/Ocultar.png");
        redimensiones.setImageLabel(lbl_ocultar1, "src/Recursos/Ocultar.png");
    }

    //Método que establece imagenes a los apuntadores
    private void apuntadores() {
        redimensiones.setImageLabel(lbl_ApuntadorUsername, "src/Recursos/apuntador.png");
        redimensiones.setImageLabel(lbl_ApuntadorPassword, "src/Recursos/apuntador.png");
        redimensiones.setImageLabel(lbl_ApuntadorConfirm, "src/Recursos/apuntador.png");
        redimensiones.setImageLabel(lbl_ApuntadorEmail, "src/Recursos/apuntador.png");
        redimensiones.setImageLabel(lbl_ApuntadorButton, "src/Recursos/apuntador.png");
        redimensiones.setImageLabel(lbl_ApuntadorYa, "src/Recursos/apuntador.png");
        lbl_ApuntadorUsername.setVisible(false);
        lbl_ApuntadorPassword.setVisible(false);
        lbl_ApuntadorConfirm.setVisible(false);
        lbl_ApuntadorEmail.setVisible(false);
        lbl_ApuntadorButton.setVisible(false);
        lbl_ApuntadorYa.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panelinterfazmain = new javax.swing.JPanel();
        lbl_long = new javax.swing.JLabel();
        lbl_especial = new javax.swing.JLabel();
        lbl_num = new javax.swing.JLabel();
        lbl_min = new javax.swing.JLabel();
        lbl_mayus = new javax.swing.JLabel();
        lbl_cerrar = new javax.swing.JLabel();
        lbl_Regresar = new javax.swing.JLabel();
        lblCreateAccount = new javax.swing.JLabel();
        lbl_barra = new javax.swing.JLabel();
        Paneldeinterfaz2 = new javax.swing.JPanel();
        lbl_ApuntadorButton = new javax.swing.JLabel();
        lbl_ApuntadorPassword = new javax.swing.JLabel();
        lbl_ApuntadorConfirm = new javax.swing.JLabel();
        lbl_ApuntadorUsername = new javax.swing.JLabel();
        lbl_ApuntadorEmail = new javax.swing.JLabel();
        lbl_ApuntadorYa = new javax.swing.JLabel();
        SeparadorEmail = new javax.swing.JSeparator();
        SeparadorUsername = new javax.swing.JSeparator();
        SeparadorPassword = new javax.swing.JSeparator();
        SeparadorConfirm = new javax.swing.JSeparator();
        txtUsername = new javax.swing.JTextField();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblConfirmpassword = new javax.swing.JLabel();
        txtConfirmPassword = new javax.swing.JPasswordField();
        txtPassword = new javax.swing.JPasswordField();
        txtEmail = new javax.swing.JTextField();
        lbl_yatengo = new javax.swing.JLabel();
        lbl_crearcuenta = new javax.swing.JLabel();
        lblEmail1 = new javax.swing.JLabel();
        lbl_ver1 = new javax.swing.JLabel();
        lbl_ocultar1 = new javax.swing.JLabel();
        lbl_ver = new javax.swing.JLabel();
        lbl_ocultar = new javax.swing.JLabel();
        lbl_panel = new javax.swing.JLabel();
        lbl_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panelinterfazmain.setPreferredSize(new java.awt.Dimension(1024, 768));
        Panelinterfazmain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_long.setText("Longitud mínima (8)");
        Panelinterfazmain.add(lbl_long, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 570, -1, -1));

        lbl_especial.setText("Carácter especial");
        Panelinterfazmain.add(lbl_especial, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 570, -1, -1));

        lbl_num.setText("Número");
        Panelinterfazmain.add(lbl_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 570, -1, -1));

        lbl_min.setText("Minúscula");
        Panelinterfazmain.add(lbl_min, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 570, -1, -1));

        lbl_mayus.setText("Mayúscula");
        Panelinterfazmain.add(lbl_mayus, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 570, -1, -1));

        lbl_cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_cerrarMouseClicked(evt);
            }
        });
        Panelinterfazmain.add(lbl_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 20, 40, 40));

        lbl_Regresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_RegresarMouseClicked(evt);
            }
        });
        Panelinterfazmain.add(lbl_Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 60, 50));

        lblCreateAccount.setFont(new java.awt.Font("Pixel Operator HB 8", 1, 24)); // NOI18N
        lblCreateAccount.setForeground(new java.awt.Color(255, 255, 255));
        lblCreateAccount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCreateAccount.setText("CREAR CUENTA");
        Panelinterfazmain.add(lblCreateAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 100));
        Panelinterfazmain.add(lbl_barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(-480, 0, 1510, 770));

        Paneldeinterfaz2.setBackground(new java.awt.Color(51, 51, 51));
        Paneldeinterfaz2.setForeground(new java.awt.Color(153, 153, 153));
        Paneldeinterfaz2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Paneldeinterfaz2.add(lbl_ApuntadorButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 607, 30, 30));
        Paneldeinterfaz2.add(lbl_ApuntadorPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 20, 20));
        Paneldeinterfaz2.add(lbl_ApuntadorConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 20, 20));
        Paneldeinterfaz2.add(lbl_ApuntadorUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 228, 20, 20));
        Paneldeinterfaz2.add(lbl_ApuntadorEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 527, 20, 20));
        Paneldeinterfaz2.add(lbl_ApuntadorYa, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 675, 20, 20));

        SeparadorEmail.setBackground(new java.awt.Color(255, 255, 255));
        SeparadorEmail.setForeground(new java.awt.Color(255, 255, 255));
        Paneldeinterfaz2.add(SeparadorEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 550, 330, 10));

        SeparadorUsername.setBackground(new java.awt.Color(255, 255, 255));
        SeparadorUsername.setForeground(new java.awt.Color(255, 255, 255));
        Paneldeinterfaz2.add(SeparadorUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 330, 10));

        SeparadorPassword.setBackground(new java.awt.Color(255, 255, 255));
        SeparadorPassword.setForeground(new java.awt.Color(255, 255, 255));
        Paneldeinterfaz2.add(SeparadorPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 330, 10));

        SeparadorConfirm.setBackground(new java.awt.Color(255, 255, 255));
        SeparadorConfirm.setForeground(new java.awt.Color(255, 255, 255));
        Paneldeinterfaz2.add(SeparadorConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, 330, 10));

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
        Paneldeinterfaz2.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 330, -1));

        lblUsername.setFont(new java.awt.Font("Pixel Operator HB 8", 1, 14)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsername.setText("USUARIO");
        Paneldeinterfaz2.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 550, 20));

        lblPassword.setFont(new java.awt.Font("Pixel Operator HB 8", 1, 14)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPassword.setText("CONTRASEÑA");
        Paneldeinterfaz2.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 550, 20));

        lblConfirmpassword.setFont(new java.awt.Font("Pixel Operator HB 8", 1, 14)); // NOI18N
        lblConfirmpassword.setForeground(new java.awt.Color(255, 255, 255));
        lblConfirmpassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblConfirmpassword.setText("CONFIRMAR CONTRASEÑA");
        Paneldeinterfaz2.add(lblConfirmpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 550, 20));

        txtConfirmPassword.setFont(new java.awt.Font("Pixel Operator 8", 0, 12)); // NOI18N
        txtConfirmPassword.setForeground(new java.awt.Color(102, 102, 102));
        txtConfirmPassword.setText("ConfirmPassword");
        txtConfirmPassword.setBorder(null);
        txtConfirmPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtConfirmPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtConfirmPasswordFocusLost(evt);
            }
        });
        txtConfirmPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConfirmPasswordActionPerformed(evt);
            }
        });
        txtConfirmPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtConfirmPasswordKeyTyped(evt);
            }
        });
        Paneldeinterfaz2.add(txtConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 330, 20));

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
        Paneldeinterfaz2.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 330, 20));

        txtEmail.setFont(new java.awt.Font("Pixel Operator 8", 0, 12)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(102, 102, 102));
        txtEmail.setText("Email");
        txtEmail.setBorder(null);
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });
        Paneldeinterfaz2.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 530, 330, -1));

        lbl_yatengo.setFont(new java.awt.Font("Pixel Operator HB 8", 1, 14)); // NOI18N
        lbl_yatengo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_yatengo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_yatengo.setText("YA TENGO CUENTA");
        lbl_yatengo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lbl_yatengoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lbl_yatengoFocusLost(evt);
            }
        });
        lbl_yatengo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_yatengoMouseClicked(evt);
            }
        });
        lbl_yatengo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lbl_yatengoKeyPressed(evt);
            }
        });
        Paneldeinterfaz2.add(lbl_yatengo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 670, 270, 30));

        lbl_crearcuenta.setFont(new java.awt.Font("Pixel Operator HB 8", 1, 18)); // NOI18N
        lbl_crearcuenta.setForeground(new java.awt.Color(255, 255, 255));
        lbl_crearcuenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_crearcuenta.setText("CREAR");
        lbl_crearcuenta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lbl_crearcuentaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lbl_crearcuentaFocusLost(evt);
            }
        });
        lbl_crearcuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_crearcuentaMouseClicked(evt);
            }
        });
        lbl_crearcuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lbl_crearcuentaKeyPressed(evt);
            }
        });
        Paneldeinterfaz2.add(lbl_crearcuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 600, 120, 40));

        lblEmail1.setFont(new java.awt.Font("Pixel Operator HB 8", 1, 14)); // NOI18N
        lblEmail1.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEmail1.setText("CORREO ELECTRÓNICO");
        Paneldeinterfaz2.add(lblEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 550, -1));

        lbl_ver1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ver1MouseClicked(evt);
            }
        });
        Paneldeinterfaz2.add(lbl_ver1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, 30, 20));

        lbl_ocultar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ocultar1MouseClicked(evt);
            }
        });
        Paneldeinterfaz2.add(lbl_ocultar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, 30, 20));

        lbl_ver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_verMouseClicked(evt);
            }
        });
        Paneldeinterfaz2.add(lbl_ver, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 410, 30, 20));

        lbl_ocultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ocultarMouseClicked(evt);
            }
        });
        Paneldeinterfaz2.add(lbl_ocultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 410, 30, 20));
        Paneldeinterfaz2.add(lbl_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 770));

        Panelinterfazmain.add(Paneldeinterfaz2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 550, 770));
        Panelinterfazmain.add(lbl_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 770));

        getContentPane().add(Panelinterfazmain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1680, 1050));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static boolean verificarcontra(String contra) {

        //Verifdicacion de contrasena segura
        if (contra.length() < 8) {
            return true;
        }

        boolean mayuscula = false;
        boolean numero = false;
        boolean minuscula = false;
        boolean specialcaracter = false;

        for (char caracteres : contra.toCharArray()) {
            if (Character.isUpperCase(caracteres)) {
                mayuscula = true;

            } else if (Character.isLowerCase(caracteres)) {
                minuscula = true;

            } else if (Character.isDigit(caracteres)) {
                numero = true;
            } else {
                specialcaracter = true;
            }
        }

        return mayuscula && minuscula && numero && specialcaracter;
    }

    public boolean ValidarEmail(String email) {
        // Regex
        String emailRegex = "^(?![.-])[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*(?<![.-])@([a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?\\.)+[a-zA-Z]{2,}$";

        // CASE_INSENSITIVE sirve para evitar que distinga entre minúsculas y mayúsculas
        Pattern pat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        //Verificar el email del usuario para ver si coincide con el patrón (regex)
        Matcher mat = pat.matcher(email);
        //Retornar false or true
        //matches sirve para verificar que TODO el patrón coincida
        return mat.matches();
    }

    //Detectar cuándo el campo de texto gana y pierde el focus.
    private void txtUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusGained
        //El focus está en el TexField de Username
        //Hacer que el apuntador esté en esta linea
        lbl_ApuntadorUsername.setVisible(true);

        //Cambiar el color del separador a amarillo
        SeparadorUsername.setBackground(Color.YELLOW);
        SeparadorUsername.setForeground(Color.YELLOW);

        if (txtUsername.getText().equals("Username")) {
            //Cambiar el color a negro, para que haga el efecto de texto real
            txtUsername.setForeground(Color.WHITE);
            //Enviar el texto al textfield Username
            txtUsername.setText("");
        }
    }//GEN-LAST:event_txtUsernameFocusGained

    private void txtUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusLost
        //El focus NO está en el TexField de Username
        //Ocultar el apuntador
        lbl_ApuntadorUsername.setVisible(false);

        //Cambiar el color del separador a blanco
        SeparadorUsername.setBackground(Color.WHITE);
        SeparadorUsername.setForeground(Color.WHITE);

        if (txtUsername.getText().trim().isEmpty()) {

            //Cambiar el color a gris, para que haga el efecto de texto predefinido
            txtUsername.setForeground(new Color(102, 102, 102));
            //Enviar el texto al txtEmail
            txtUsername.setText("Username");
        }
    }//GEN-LAST:event_txtUsernameFocusLost

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        //El focus está en el txtEmail
        //Hacer que el apuntador esté en esta linea
        lbl_ApuntadorEmail.setVisible(true);

        //Cambiar el color del separador a amarillo
        SeparadorEmail.setBackground(Color.YELLOW);
        SeparadorEmail.setForeground(Color.YELLOW);

        if (txtEmail.getText().equals("Email")) {
            //Cambiar el color a negro, para que haga el efecto de texto real
            txtEmail.setForeground(Color.WHITE);
            //Enviar el texto al txtEmail
            txtEmail.setText("");
        }
    }//GEN-LAST:event_txtEmailFocusGained

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        //El focus NO está en el txtEmail
        //Ocultar el apuntador
        lbl_ApuntadorEmail.setVisible(false);

        //Cambiar el color del separador a blanco
        SeparadorEmail.setBackground(Color.WHITE);
        SeparadorEmail.setForeground(Color.WHITE);

        if (txtEmail.getText().isEmpty()) {
            //Cambiar el color a gris, para que haga el efecto de texto predefinido
            txtEmail.setForeground(new Color(102, 102, 102));
            //Enviar el texto al txtEmail
            txtEmail.setText("Email");
        }
    }//GEN-LAST:event_txtEmailFocusLost

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // Verificar si el usuario presiono enter en el textfield username
        // Establecer el foco en el siguiente JTextField
        txtPassword.requestFocus();
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // Verificar si el usuario presiono enter en el textfield Email
        crearcuenta();
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyPressed
        //BLOQUEAR EL TABULADOR DE TEXTFIELDS
        if (evt.getKeyChar() == evt.VK_TAB) {
            evt.consume();
        }
    }//GEN-LAST:event_txtEmailKeyPressed

    private void lbl_RegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_RegresarMouseClicked
        //Si el usuario da click al label de regresar
        iniciarTransicion(2);
    }//GEN-LAST:event_lbl_RegresarMouseClicked

    private void txtUsernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyTyped
        //El keyTyped sirve para poder escribir caracteres en un textfield, pero lo utilizaremos para
        // LIMITAR EL NUMERO DE CARACTERES DEL TEXTFIELD USERNAME DE CREAR CUENTA
        //Verificar que la longitud de caracteres del textfield no sea mayor a 15
        if (txtUsername.getText().length() >= 8) { // la verificación se realiza después de que el carácter ya se ha agregado al campo de texto
            evt.consume(); //Este metodo sirve para detener el evento keytyped, que permite escribiri en el textfield
            //MOSTRAR MENSAJE DE MAXIMO (15)
            Mensaje18 msj = new Mensaje18(this, true);
            msj.setVisible(true);
        }

        //BLOQUEAR LA BARRA ESPACIADORA DE TEXTFIELDS
        if (evt.getKeyChar() == ' ') {
            evt.consume();
        }

    }//GEN-LAST:event_txtUsernameKeyTyped

    private void crearcuenta() {
        // Creacion de cuenta en la BD
        Md5Encript Encript = new Md5Encript();
        try {
            String Username = txtUsername.getText();
            String Password = String.valueOf(txtPassword.getPassword());

            String ConfirmPass = String.valueOf(txtConfirmPassword.getPassword());
            String Email = txtEmail.getText();

            String QueryUser = "SELECT Username FROM Users WHERE BINARY Username = ?";
            //Preparar la consulta
            try (PreparedStatement statementUser = conexion.ConexionBD().prepareStatement(QueryUser)) {
                statementUser.setString(1, Username);

                //Verificar si devolvió algo la BD
                try (ResultSet resultadoUser = statementUser.executeQuery()) {
                    //Si devuelve algo significa que ese usuario ya existe en la BD, por lo tanto no se podrá insertar
                    if (resultadoUser.next()) {
                        //Mensaje de usuario ya existente
                        Mensaje1 msj = new Mensaje1(this, true);
                        msj.setVisible(true);
                    }

                }
            }

            String QueryEmail = "SELECT Email FROM Users WHERE BINARY Email=?";
            try (PreparedStatement statementEmail = conexion.ConexionBD().prepareStatement(QueryEmail)) {
                statementEmail.setString(1, Email);

                //Verificar si devolvió algo la BD
                try (ResultSet resultadoEmail = statementEmail.executeQuery()) {
                    //Si devuelev algo significa que ese Email ya está registrado, por lo tanto no se podrá insertar
                    if (resultadoEmail.next()) {
                        //mensaje del email ya esta asociado a otra cuenta
                        Mensaje2 msj = new Mensaje2(this, true);
                        msj.setVisible(true);
                        return;
                    }
                }
            }

            // Verificacion de datos para la creacion de la cuenta
            if (!Username.equals("Username") && !Password.equals("Password")
                    && !ConfirmPass.equals("Confirm Password") && !Email.equals("Email")) {
                if (verificarcontra(Password)) {
                    if (Password.equals(ConfirmPass)) {
                        if (ValidarEmail(Email)) {
                            String Query = "INSERT INTO Users (Username, Pass, Email) VALUES (?, ?, ?)";
                            Connection con = conexion.ConexionBD();
                            //statement sirve para preparar la query para interactuar con la base de datos
                            PreparedStatement statement = con.prepareStatement(Query);
                            //Los setstring sirven para poder manipular consultas parametrizadas
                            //E insertar datos en los signos de interregacion
                            statement.setString(1, Username);
                            statement.setString(2, Encript.ecnode(Password));
                            statement.setString(3, Email);

                            //Numero de filas afectadas por la consulta sql
                            int rowsAffected = statement.executeUpdate();

                            if (rowsAffected > 0) {
                                //MENSAJE DE USUARIO AGREGADO
                                Mensaje9 msj = new Mensaje9(this, true);
                                msj.setVisible(true);
                                this.dispose();
                                Login log = new Login();
                                log.setVisible(true);
                            } else {
                                //MENSAJE DE QUE NO SE PUDO AGREGAR EL USUARIO
                                Mensaje3 msj = new Mensaje3(this, true);
                                msj.setVisible(true);
                            }
                        } else {
                            //MENSAJE EMAIL INVALIDO
                            Mensaje4 msj = new Mensaje4(this, true);
                            msj.setVisible(true);
                        }
                    } else {
                        //mensaje de que las contraseñas no coinciden
                        Mensaje5 msj = new Mensaje5(this, true);
                        msj.setVisible(true);
                    }
                } else {
                    //mensaje dicviendo que tiene que tener una contraseña segura
                    Mensaje6 msj = new Mensaje6(this, true);
                    msj.setVisible(true);
                }
            } else {
                //MENSAJE DICIENDO QUE COMPLETE LOS CAMPOS
                Mensaje7 msj = new Mensaje7(this, true);
                msj.setVisible(true);
            }
        } catch (Exception e) {
            //MENSAJE QUE DICE QUE HA OCURRIDO UN ERROR INESPERADO
            Mensaje8 msj = new Mensaje8(this, true);
            msj.setVisible(true);
        }
    }


    private void lbl_crearcuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_crearcuentaMouseClicked
        crearcuenta();
    }//GEN-LAST:event_lbl_crearcuentaMouseClicked

    private void lbl_crearcuentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbl_crearcuentaKeyPressed
        // verificar si en el label dan enter
        if (evt.getKeyCode() == evt.VK_ENTER) {
            // Llamar a registro
            crearcuenta();
        }


    }//GEN-LAST:event_lbl_crearcuentaKeyPressed

    private void lbl_crearcuentaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbl_crearcuentaFocusGained
        // Mostrar el apuntador de campo
        lbl_ApuntadorButton.setVisible(true);
        lbl_crearcuenta.setForeground(new Color(255, 223, 0));
    }//GEN-LAST:event_lbl_crearcuentaFocusGained

    private void lbl_crearcuentaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbl_crearcuentaFocusLost
        //Ocultar el apuntador de campo
        lbl_ApuntadorButton.setVisible(false);
        lbl_crearcuenta.setForeground(Color.WHITE);
    }//GEN-LAST:event_lbl_crearcuentaFocusLost

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        //Si le dan enter al confirm password field
        txtConfirmPassword.requestFocus();
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtConfirmPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfirmPasswordActionPerformed
        // Si dan enter al password field
        txtEmail.requestFocus();
    }//GEN-LAST:event_txtConfirmPasswordActionPerformed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        //BLOQUEAR EL TABULADOR DE TEXTFIELDS
        if (evt.getKeyChar() == evt.VK_TAB) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
        // Si esta el focus en el textfield
        SeparadorPassword.setBackground(Color.YELLOW);
        SeparadorPassword.setForeground(Color.YELLOW);

        //Mostrar el apuntador
        lbl_ApuntadorPassword.setVisible(true);

        String pass = String.valueOf(txtPassword.getPassword());

        //PlaceHolder
        if (pass.equals("Password")) {
            txtPassword.setForeground(Color.WHITE);
            //Enviar el texto al textfield Username
            txtPassword.setText("");
        }


    }//GEN-LAST:event_txtPasswordFocusGained

    private void txtPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusLost
        // Si NO esta el focus en el textfield
        SeparadorPassword.setBackground(Color.WHITE);
        SeparadorPassword.setForeground(Color.WHITE);

        //Ocultar el apuntador
        lbl_ApuntadorPassword.setVisible(false);

        String contra = String.valueOf(txtPassword.getPassword());
        //PlaceHolder
        if (contra.isEmpty()) {
            //Cambiar el color a gris, para que haga el efecto de texto predefinido
            txtPassword.setForeground(new Color(102, 102, 102));
            //Enviar el texto al textfield Username
            txtPassword.setText("Password");
        }

    }//GEN-LAST:event_txtPasswordFocusLost

    private void txtConfirmPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtConfirmPasswordFocusLost
        //Si no está el focus en el textfield
        SeparadorConfirm.setBackground(Color.WHITE);
        SeparadorConfirm.setForeground(Color.WHITE);

        //Ocultar el apuntador
        lbl_ApuntadorConfirm.setVisible(false);

        String confirm = String.valueOf(txtConfirmPassword.getPassword());
        //PlaceHolde
        if (confirm.isEmpty()) {
            txtConfirmPassword.setText("ConfirmPassword");
            //Cambiar el color a gris, para que haga el efecto de texto predefinido
            txtConfirmPassword.setForeground(new Color(102, 102, 102));
        }

    }//GEN-LAST:event_txtConfirmPasswordFocusLost

    private void txtConfirmPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtConfirmPasswordFocusGained
        // Si está el focus en el textfield
        SeparadorConfirm.setBackground(Color.YELLOW);
        SeparadorConfirm.setForeground(Color.YELLOW);

        //Mostrar el apuntador
        lbl_ApuntadorConfirm.setVisible(true);

        String conf = String.valueOf(txtConfirmPassword.getPassword());
        //PlaceHolder
        if (conf.equals("ConfirmPassword")) {
            txtConfirmPassword.setText("");
            txtConfirmPassword.setForeground(Color.WHITE);
        }

    }//GEN-LAST:event_txtConfirmPasswordFocusGained

    private void lbl_verMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_verMouseClicked
        // El usuario dio clic en el ojo, eso significa que quiere ver su contraseña
        txtConfirmPassword.setEchoChar((char) 0);
        lbl_ver.setVisible(false);
        lbl_ocultar.setVisible(true);
    }//GEN-LAST:event_lbl_verMouseClicked

    private void lbl_ocultarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ocultarMouseClicked
        // El usuario dio clic en el ojo de ocultar
        txtConfirmPassword.setEchoChar('*');
        lbl_ocultar.setVisible(false);
        lbl_ver.setVisible(true);
    }//GEN-LAST:event_lbl_ocultarMouseClicked

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

    private void lbl_cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_cerrarMouseClicked
        //Cerrar aplicacion
        System.exit(0);
    }//GEN-LAST:event_lbl_cerrarMouseClicked

    private void txtConfirmPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConfirmPasswordKeyTyped
        //:
        if (txtConfirmPassword.getText().length() >= 25) { // la verificación se realiza después de que el carácter ya se ha agregado al campo de texto
            evt.consume(); //Este metodo sirve para detener el evento keytyped, que permite escribiri en el textfield
            //MOSTRAR MENSAJE DE MAXIMO DE CARACTERES (25)
            Mensaje16 msj = new Mensaje16(this, true);
            msj.setVisible(true);
        }

        //BLOQUEAR LA BARRA ESPACIADORA DE TEXTFIELDS
        if (evt.getKeyChar() == ' ') {
            evt.consume();
        }

    }//GEN-LAST:event_txtConfirmPasswordKeyTyped

    private void check() {
        String pass = String.valueOf(txtPassword.getPassword());

        boolean tieneMasDe8Caracteres = pass.length() > 6;
        boolean tieneMayuscula = false;
        boolean tieneMinuscula = false;
        boolean tieneNumero = false;
        boolean tieneEspecial = false;

        for (char caracteres : pass.toCharArray()) {
            //Verificacion de contrasena segura

            if (Character.isDigit(caracteres)) {
                tieneNumero = true;
            }

            if (!Character.isLetterOrDigit(caracteres)) {
                tieneEspecial = true;
            }

            if (Character.isUpperCase(caracteres)) {
                tieneMayuscula = true;
            }

            if (Character.isLowerCase(caracteres)) {
                tieneMinuscula = true;
            }

        }

        // Actualizar los colores 
        lbl_long.setForeground(tieneMasDe8Caracteres ? Color.GREEN : Color.RED);
        lbl_mayus.setForeground(tieneMayuscula ? Color.GREEN : Color.RED);
        lbl_min.setForeground(tieneMinuscula ? Color.GREEN : Color.RED);
        lbl_num.setForeground(tieneNumero ? Color.GREEN : Color.RED);
        lbl_especial.setForeground(tieneEspecial ? Color.GREEN : Color.RED);
    }

    private void txtPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyTyped
        // DESPLEGAR LA APPY 
        check();

        if (txtPassword.getText().length() >= 25) { // la verificación se realiza después de que el carácter ya se ha agregado al campo de texto
            evt.consume(); //Este metodo sirve para detener el evento keytyped, que permite escribiri en el textfield
            //MOSTRAR MENSAJE DE MAXIMO DE CARACTERES
            Mensaje16 msj = new Mensaje16(this, true);
            msj.setVisible(true);
        }

        //BLOQUEAR LA BARRA ESPACIADORA DE TEXTFIELDS
        if (evt.getKeyChar() == ' ') {
            evt.consume();
        }

        check();

    }//GEN-LAST:event_txtPasswordKeyTyped

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped
        //
        if (txtEmail.getText().length() >= 254) { // la verificación se realiza después de que el carácter ya se ha agregado al campo de texto
            evt.consume(); //Este metodo sirve para detener el evento keytyped, que permite escribiri en el textfield
            //MOSTRAR MENSAJE DE 254 CARACTERES
            Mensaje17 msj = new Mensaje17(this, true);
            msj.setVisible(true);
        }

        //BLOQUEAR LA BARRA ESPACIADORA DE TEXTFIELDS
        if (evt.getKeyChar() == ' ') {
            evt.consume();
        }


    }//GEN-LAST:event_txtEmailKeyTyped

    private void lbl_yatengoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbl_yatengoFocusGained
        // TODO add your handling code here:
        lbl_ApuntadorYa.setVisible(true);
        lbl_yatengo.setForeground(new Color(255, 223, 0));
    }//GEN-LAST:event_lbl_yatengoFocusGained

    private void lbl_yatengoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbl_yatengoFocusLost
        // TODO add your handling code here:
        lbl_ApuntadorYa.setVisible(false);
        lbl_yatengo.setForeground(Color.WHITE);
    }//GEN-LAST:event_lbl_yatengoFocusLost

    private void lbl_yatengoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_yatengoMouseClicked
        // TODO add your handling code here:
        iniciar();
    }//GEN-LAST:event_lbl_yatengoMouseClicked

    private void iniciar() {
        iniciarTransicion(1);
    }

    private void lbl_yatengoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbl_yatengoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            //Redirigir a iniciar sesion
            iniciar();
        }
    }//GEN-LAST:event_lbl_yatengoKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Paneldeinterfaz2;
    private javax.swing.JPanel Panelinterfazmain;
    private javax.swing.JSeparator SeparadorConfirm;
    private javax.swing.JSeparator SeparadorEmail;
    private javax.swing.JSeparator SeparadorPassword;
    private javax.swing.JSeparator SeparadorUsername;
    private javax.swing.JLabel lblConfirmpassword;
    private javax.swing.JLabel lblCreateAccount;
    private javax.swing.JLabel lblEmail1;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lbl_ApuntadorButton;
    private javax.swing.JLabel lbl_ApuntadorConfirm;
    private javax.swing.JLabel lbl_ApuntadorEmail;
    private javax.swing.JLabel lbl_ApuntadorPassword;
    private javax.swing.JLabel lbl_ApuntadorUsername;
    private javax.swing.JLabel lbl_ApuntadorYa;
    private javax.swing.JLabel lbl_Regresar;
    private javax.swing.JLabel lbl_barra;
    private javax.swing.JLabel lbl_cerrar;
    private javax.swing.JLabel lbl_crearcuenta;
    private javax.swing.JLabel lbl_especial;
    private javax.swing.JLabel lbl_fondo;
    private javax.swing.JLabel lbl_long;
    private javax.swing.JLabel lbl_mayus;
    private javax.swing.JLabel lbl_min;
    private javax.swing.JLabel lbl_num;
    private javax.swing.JLabel lbl_ocultar;
    private javax.swing.JLabel lbl_ocultar1;
    private javax.swing.JLabel lbl_panel;
    private javax.swing.JLabel lbl_ver;
    private javax.swing.JLabel lbl_ver1;
    private javax.swing.JLabel lbl_yatengo;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
