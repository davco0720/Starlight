package starlight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.imageio.ImageIO;
import java.util.HashSet;
import java.util.Set;

public class M1N2 extends JFrame implements ActionListener, KeyListener {
    Conexion conexion = new Conexion();
    private String Dato;
    public int IDusuario;
    public int ScoreAnterior;
    public int ScoreNuevo;
    public String IDstring;
    public int ScoreTotal;
    public String ScoreTotalString;
    public String fecha;
    public String TiempoRestanteString;
    Date date = new Date();
    
    private int coinScore = 0;
    ReproducirMusica reproductor;
    private boolean pausa = false;
    private boolean silencio = false;
    private int botonX = 900;
    private int botonY = 10;
    private int botonWidth = 40; // ANCHO DEL BOTON
    private int botonHeight = 40; // ALTO DEL BOTON
    private boolean botonPressed = false;
    private BufferedImage imagePausa;
    private BufferedImage imageBarra1;
    private BufferedImage imageBarra2;
    private BufferedImage imageBarra3;
    private BufferedImage imageBarra4;
    private BufferedImage imageSilencio;
    private int vidax = 10;

    private int score;
    private BufferedImage degradado;
    private int tiempoTranscurrido = 180000;
    private int frameIndex4 = 0;
    private BufferedImage fondoImage;
    private BufferedImage personajeStatico;

    private int slimexRelativo = 1100;
    private int slimex = 1100;
    private Hitbox2[] slime2hit;
    private BufferedImage[] slime2;

    private int Zombie = 1100;
    private int Zombiex = 1100;
    private Hitbox2[] Zombiehit;
    private BufferedImage[] Zombie2;

    private BufferedImage[] personajeStaticores;
    private int frameIndex5 = 0;
    private BufferedImage[] runningAnimation;
    private BufferedImage[] runningAnimation2; //cambios de variables CHECHITA
    private Hitbox2[] runningAnimationHitboxes2; //chechitadraw
    private BufferedImage[] Jumpanimation;
    private BufferedImage[] Jumpanimation2; //cambios de variables CHECHITA
    private BufferedImage[] gem;
    private BufferedImage[] coin;
    private BufferedImage[] coin2;
    private BufferedImage[] coin3;
    private BufferedImage[] coin4;

    private BufferedImage sueloImage;
    private int fondoX = 0;
    private int suelox = 0;
    private int personajeX = 25;
    private int personajeY = 600;
    private Timer timer;
    private BufferedImage bufferImage;
    private int ANCHO_FRAME = 1024;
    private int ALTO_FRAME = 768;
    private int frameIndex = 0;
    private int frameIndex2 = 0;
    private int frameIndex3 = 0;
    private int frameindex6 = 0;
    
    private int frameindex10 = 0;
    private int frameindex11 = 0;
    private int frameindex12 = 0;
    private int frameindex13 = 0;

    private boolean jumping = false;
    private boolean falling = false;
    private int midFrame = 600;
    private Set<Integer> keysPressed = new HashSet<>();
    private Hitbox2 personajeHitbox;
    private Hitbox2[] personajeStaticoHitbox;
    private Hitbox2[] runningAnimationHitboxes;

    private Hitbox bloquehit;
    private Hitbox obstaculohit;
    private Hitbox bloquehit2_0;
    private Hitbox bloquehit3_0;
    private Hitbox bloquehit4_0;
    private Hitbox bloquehit5_0;
    private Hitbox bloquehit6_0;
    private Hitbox bloquehit7_0;
    private Hitbox bloquehit8_0;
    private Hitbox bloquehit9_0;
    private Hitbox bloquehit10_0;
    private Hitbox bloquehit11_0;
    private Hitbox bloquehit12_0;
    private Hitbox bloquehit13_0;

    private int jumpSpeed = 10;
    private int fallSpeed = 7;
    private BufferedImage obstaculo;

    private boolean movimientoDerecha = true;
    private int velocidadMovimiento = 5;

    private Hitbox bloquehit1;
    private Hitbox bloquehit2;
    private Hitbox bloquehit3;
    // Obstaculo_2
    private Hitbox bloquehit2_1;
    private Hitbox bloquehit2_2;
    private Hitbox bloquehit2_3;

    private Hitbox bloquehit3_1;
    private Hitbox bloquehit3_2;
    private Hitbox bloquehit3_3;

    private Hitbox bloquehit4_1;
    private Hitbox bloquehit4_2;
    private Hitbox bloquehit4_3;

    private Hitbox bloquehit5_1;
    private Hitbox bloquehit5_2;
    private Hitbox bloquehit5_3;

    private Hitbox bloquehit6_1;
    private Hitbox bloquehit6_2;
    private Hitbox bloquehit6_3;

    private Hitbox bloquehit7_1;
    private Hitbox bloquehit7_2;
    private Hitbox bloquehit7_3;

    private Hitbox bloquehit8_1;
    private Hitbox bloquehit8_2;
    private Hitbox bloquehit8_3;

    private Hitbox bloquehit9_1;
    private Hitbox bloquehit9_2;
    private Hitbox bloquehit9_3;

    private Hitbox bloquehit10_1;
    private Hitbox bloquehit10_2;
    private Hitbox bloquehit10_3;

    private Hitbox bloquehit11_1;
    private Hitbox bloquehit11_2;
    private Hitbox bloquehit11_3;

    private Hitbox bloquehit12_1;
    private Hitbox bloquehit12_2;
    private Hitbox bloquehit12_3;

    private Hitbox bloquehit13_1;
    private Hitbox bloquehit13_2;
    private Hitbox bloquehit13_3;

    int gemx = 2910;
    private Hitbox[] gemhit;

    int coinx = 1205;
    private Hitbox[] coinet;

    int coinx2 = 2175;
    private Hitbox[] coinet2;

    int coinx3 = 2695;
    private Hitbox[] coinet3;

    int coinx4 = 1005;
    private Hitbox[] coinet4;

    private Hitbox obstaculohit1;
    private Hitbox obstaculohit3;
    private int bloquehitx = 640;
    private int bloquehitx2 = 640;
    private int bloquehitx3 = 850;
    private int bloquehitx4 = 640;

    int fadeOpacity = 0;
    boolean fading = false;

    private int bloquehitx2_0 = 915;
    private int bloquehitx2_1 = 915;
    private int bloquehitx2_2 = 1120;
    private int bloquehitx2_3 = 915;

    private int bloquehitx3_0 = 1210;
    private int bloquehitx3_1 = 1210;
    private int bloquehitx3_2 = 1275;
    private int bloquehitx3_3 = 1210;

    private int bloquehitx4_0 = 1600;
    private int bloquehitx4_1 = 1600;
    private int bloquehitx4_2 = 1810;
    private int bloquehitx4_3 = 1600;

    private int bloquehitx5_0 = 1430;
    private int bloquehitx5_1 = 1430;
    private int bloquehitx5_2 = 1640;
    private int bloquehitx5_3 = 1430;

    private int bloquehitx6_0 = 1123;
    private int bloquehitx6_1 = 1123;
    private int bloquehitx6_2 = 1330;
    private int bloquehitx6_3 = 1123;

    private int bloquehitx7_0 = 1360;
    private int bloquehitx7_1 = 1360;
    private int bloquehitx7_2 = 1570;
    private int bloquehitx7_3 = 1360;

    private int bloquehitx8_0 = 2900;
    private int bloquehitx8_1 = 2900;
    private int bloquehitx8_2 = 3950;
    private int bloquehitx8_3 = 2900;

    private int bloquehitx9_0 = 1750;
    private int bloquehitx9_1 = 1750;
    private int bloquehitx9_2 = 1800;
    private int bloquehitx9_3 = 1750;

    private int bloquehitx10_0 = 1870;
    private int bloquehitx10_1 = 1870;
    private int bloquehitx10_2 = 2080;
    private int bloquehitx10_3 = 1870;

    private int bloquehitx11_0 = 2110;
    private int bloquehitx11_1 = 2110;
    private int bloquehitx11_2 = 2240;
    private int bloquehitx11_3 = 2110;

    private int bloquehitx12_0 = 2370;
    private int bloquehitx12_1 = 2370;
    private int bloquehitx12_2 = 2570;
    private int bloquehitx12_3 = 2370;

    private int bloquehitx13_0 = 2590;
    private int bloquehitx13_1 = 2590;
    private int bloquehitx13_2 = 2805;
    private int bloquehitx13_3 = 2590;

    private double vidas = 3;
    private int obstaculox = 2245;
    private int obstaculox2 = 2100;
    private int obstaculox4 = 890; //Pincho_largo_1

    private int salto = 150;
    private boolean jumpKeyReleased = true;
    private int initialY;
    private Hitbox midhit2;
    private int midhit2x = 2450;

    public M1N2() {

        setSize(ANCHO_FRAME, ALTO_FRAME);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Jumpanimation = new BufferedImage[77];
        for (int i = 0; i < Jumpanimation.length; i++) {
            try {
                Jumpanimation[i] = ImageIO.read(new File("src/SALTO/" + (i + 1) + ".png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        Jumpanimation2 = new BufferedImage[77];
        for (int i = 0; i < Jumpanimation2.length; i++) {
            try {
                Jumpanimation2[i] = ImageIO.read(new File("src/Salta_reverse/" + (i + 1) + ".png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        try {
            personajeStatico = ImageIO.read(new File("src/PersonajePrincipal/1.png")); // ruta del personaje estático

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        reproductor = new ReproducirMusica("src/Musica/MusicaMundo1.mp3");

        try {
            imagePausa = ImageIO.read(new File("src/Recursos/btn_pausa.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            imageBarra1 = ImageIO.read(new File("src/Barra_Vida/1.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            imageBarra2 = ImageIO.read(new File("src/Barra_Vida/2.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            imageBarra3 = ImageIO.read(new File("src/Barra_Vida/3.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            imageBarra4 = ImageIO.read(new File("src/Barra_Vida/4.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            fondoImage = ImageIO.read(new File("src/Fondo/Nivel2_Mundo1.png")); // ruta del fondo
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            degradado = ImageIO.read(new File("src/Recursos/Degradado.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        personajeStaticores = new BufferedImage[40];
        for (int i = 0; i < personajeStaticores.length; i++) {
            try {
                personajeStaticores[i] = ImageIO.read(new File("src/Estatico/" + (i + 1) + ".png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        // Cargar la animación de correr
        runningAnimation = new BufferedImage[8];
        for (int i = 0; i < runningAnimation.length; i++) {
            try {
                runningAnimation[i] = ImageIO.read(new File("src/PersonajePrincipal/" + (i + 1) + ".png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        //CHECHITA
        runningAnimation2 = new BufferedImage[8];
        for (int i = 0; i < runningAnimation2.length; i++) {
            try {
                runningAnimation2[i] = ImageIO.read(new File("src/Run_reverse/" + (i + 1) + ".png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        try {
            imageBarra1 = ImageIO.read(new File("src/Barra_Vida/1.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            imageBarra2 = ImageIO.read(new File("src/Barra_Vida/2.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            imageBarra3 = ImageIO.read(new File("src/Barra_Vida/3.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            imageBarra4 = ImageIO.read(new File("src/Barra_Vida/4.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        gem = new BufferedImage[10];
        for (int i = 0; i < gem.length; i++) {
            try {
                gem[i] = ImageIO.read(new File("src/GEM/" + (i + 1) + ".png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        coin = new BufferedImage[7];
        for (int i = 0; i < coin.length; i++) {
            try {
                coin[i] = ImageIO.read(new File("src/Coin/" + (i + 1) + ".png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        coin2 = new BufferedImage[7];
        for (int i = 0; i < coin2.length; i++) {
            try {
                coin2[i] = ImageIO.read(new File("src/Coin/" + (i + 1) + ".png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        coin3 = new BufferedImage[7];
        for (int i = 0; i < coin3.length; i++) {
            try {
                coin3[i] = ImageIO.read(new File("src/Coin/" + (i + 1) + ".png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        coin4 = new BufferedImage[7];
        for (int i = 0; i < coin4.length; i++) {
            try {
                coin4[i] = ImageIO.read(new File("src/Coin/" + (i + 1) + ".png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        slime2 = new BufferedImage[8];
        for (int i = 0; i < slime2.length; i++) {
            try {
                slime2[i] = ImageIO.read(new File("src/Zombie/" + (i + 1) + ".png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        Zombie2 = new BufferedImage[8];
        for (int i = 0; i < Zombie2.length; i++) {
            try {
                Zombie2[i] = ImageIO.read(new File("src/Zombie/" + (i + 1) + ".png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        // Timer para el movimiento del fondo y la animación
        timer = new Timer(30, this); // Cambiado a 50 milisegundos para mayor rapidez en la animación
        timer.start(); // Iniciar el Timer para que el actionPerformed se ejecute
//        reproductor.iniciar();

        // Crear el BufferedImage para el doble búffer
        bufferImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);

        // Agregar el KeyListener al JFrame
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        // Crear la hitbox para el personaje estático
        personajeHitbox = new Hitbox2(personajeX, personajeY, 80, 80);

        bloquehit = new Hitbox(bloquehitx, 579, 210, 1);
        bloquehit1 = new Hitbox(bloquehitx2, 579, 1, 50);
        bloquehit2 = new Hitbox(bloquehitx3, 579, 1, 50);
        bloquehit3 = new Hitbox(bloquehitx4, 629, 210, 1);

        bloquehit2_0 = new Hitbox(bloquehitx2_0, 517, 205, 1);
        bloquehit2_1 = new Hitbox(bloquehitx2_1, 517, 1, 60);
        bloquehit2_2 = new Hitbox(bloquehitx2_2, 517, 1, 60);
        bloquehit2_3 = new Hitbox(bloquehitx2_3, 577, 205, 1);

        bloquehit3_0 = new Hitbox(bloquehitx3_0, 471, 65, 1);
        bloquehit3_1 = new Hitbox(bloquehitx3_1, 471, 1, 29);
        bloquehit3_2 = new Hitbox(bloquehitx3_2, 471, 1, 29);
        bloquehit3_3 = new Hitbox(bloquehitx3_3, 507, 65, 1);

        bloquehit4_0 = new Hitbox(bloquehitx4_0, 444, 210, 1);
        bloquehit4_1 = new Hitbox(bloquehitx4_1, 444, 1, 50);
        bloquehit4_2 = new Hitbox(bloquehitx4_2, 444, 1, 50);
        bloquehit4_3 = new Hitbox(bloquehitx4_3, 489, 210, 1);

        bloquehit5_0 = new Hitbox(bloquehitx5_0, 289, 210, 1);
        bloquehit5_1 = new Hitbox(bloquehitx5_1, 289, 1, 50);
        bloquehit5_2 = new Hitbox(bloquehitx5_2, 289, 1, 50);
        bloquehit5_3 = new Hitbox(bloquehitx5_3, 339, 210, 1);

        bloquehit6_0 = new Hitbox(bloquehitx6_0, 289, 210, 1);
        bloquehit6_1 = new Hitbox(bloquehitx6_1, 289, 1, 50);
        bloquehit6_2 = new Hitbox(bloquehitx6_2, 289, 1, 50);
        bloquehit6_3 = new Hitbox(bloquehitx6_3, 339, 210, 1);

        bloquehit7_0 = new Hitbox(bloquehitx7_0, 524, 210, 1);
        bloquehit7_1 = new Hitbox(bloquehitx7_1, 524, 1, 50);
        bloquehit7_2 = new Hitbox(bloquehitx7_2, 524, 1, 50);
        bloquehit7_3 = new Hitbox(bloquehitx7_3, 579, 210, 1);

        bloquehit8_0 = new Hitbox(bloquehitx8_0, 461, 150, 1);
        bloquehit8_1 = new Hitbox(bloquehitx8_1, 461, 1, 50);
        bloquehit8_2 = new Hitbox(bloquehitx8_2, 461, 1, 50);
        bloquehit8_3 = new Hitbox(bloquehitx8_3, 501, 150, 1);

        bloquehit9_0 = new Hitbox(bloquehitx9_0, 349, 55, 1);
        bloquehit9_1 = new Hitbox(bloquehitx9_1, 349, 1, 29);
        bloquehit9_2 = new Hitbox(bloquehitx9_2, 349, 1, 29);
        bloquehit9_3 = new Hitbox(bloquehitx9_3, 379, 55, 1);

        bloquehit10_0 = new Hitbox(bloquehitx10_0, 299, 210, 1);
        bloquehit10_1 = new Hitbox(bloquehitx10_1, 299, 1, 50);
        bloquehit10_2 = new Hitbox(bloquehitx10_2, 299, 1, 50);
        bloquehit10_3 = new Hitbox(bloquehitx10_3, 349, 210, 1);

        bloquehit11_0 = new Hitbox(bloquehitx11_0, 274, 130, 1);
        bloquehit11_1 = new Hitbox(bloquehitx11_1, 274, 1, 500);
        bloquehit11_2 = new Hitbox(bloquehitx11_2, 274, 1, 500);
        bloquehit11_3 = new Hitbox(bloquehitx11_3, 679, 130, 1);

        bloquehit12_0 = new Hitbox(bloquehitx12_0, 579, 205, 1);
        bloquehit12_1 = new Hitbox(bloquehitx12_1, 579, 1, 50);
        bloquehit12_2 = new Hitbox(bloquehitx12_2, 579, 1, 50);
        bloquehit12_3 = new Hitbox(bloquehitx12_3, 629, 205, 1);

        bloquehit13_0 = new Hitbox(bloquehitx13_0, 461, 210, 1);
        bloquehit13_1 = new Hitbox(bloquehitx13_1, 461, 1, 50);
        bloquehit13_2 = new Hitbox(bloquehitx13_2, 461, 1, 50);
        bloquehit13_3 = new Hitbox(bloquehitx13_3, 509, 210, 1);

        obstaculohit = new Hitbox(2245, 700, 1000, 1);
        obstaculohit1 = new Hitbox(817, 409, 1, 300);
        obstaculohit3 = new Hitbox(890, 649, 1150, 1);

        midhit2 = new Hitbox(midhit2x, 0, 1, 7000);
        // Crear hitboxes para la animación de correr
        runningAnimationHitboxes = new Hitbox2[runningAnimation.length];
        for (int i = 0; i < runningAnimationHitboxes.length; i++) {
            runningAnimationHitboxes[i] = new Hitbox2(personajeX, personajeY, 80, 80);
        }
        
        personajeStaticoHitbox = new Hitbox2[personajeStaticores.length];
        for (int i = 0; i < personajeStaticoHitbox.length; i++) {
            personajeStaticoHitbox[i] = new Hitbox2(personajeX, personajeY, 40, 80);
        }

        //CHECHITA
        runningAnimationHitboxes2 = new Hitbox2[runningAnimation2.length];
        for (int i = 0; i < runningAnimationHitboxes2.length; i++) {
            runningAnimationHitboxes2[i] = new Hitbox2(personajeX, personajeY, 80, 80);
        }

        gemhit = new Hitbox[gem.length];
        for (int i = 0; i < gemhit.length; i++) {
            gemhit[i] = new Hitbox(gemx, 400, 80, 80);
        }

        coinet = new Hitbox[coin.length];
        for (int i = 0; i < coinet.length; i++) {
            coinet[i] = new Hitbox(coinx, 280, 40, 65);
        }

        coinet2 = new Hitbox[coin2.length];
        for (int i = 0; i < coinet2.length; i++) {
            coinet2[i] = new Hitbox(coinx2, 610, 40, 65);
        }

        coinet3 = new Hitbox[coin3.length];
        for (int i = 0; i < coinet3.length; i++) {
            coinet3[i] = new Hitbox(coinx3, 610, 40, 65);
        }

        coinet4 = new Hitbox[coin4.length];
        for (int i = 0; i < coinet4.length; i++) {
            coinet4[i] = new Hitbox(coinx4, 610, 40, 65);
        }

        slime2hit = new Hitbox2[slime2.length];
        for (int i = 0; i < slime2hit.length; i++) {
            slime2hit[i] = new Hitbox2(slimex, 430, 77, 77);
        }

        Zombiehit = new Hitbox2[Zombie2.length];
        for (int i = 0; i < Zombiehit.length; i++) {
            Zombiehit[i] = new Hitbox2(Zombiex, 430, 77, 77);
        }
        
          //CESAR, este metodo sirve para poner pausa con esccaped
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    pausa = !pausa;
                    if (pausa) {
                        timer.stop();
                        reproductor.detener();
                    } else {
                        timer.start();
                        reproductor = new ReproducirMusica("src/Musica/MusicaMundo1.mp3");
                        reproductor.iniciar();
                    }
                }
            }
        });

        //Este metodo es para que el boton tenga un listener de mouse, del boton de pausa
        //CESAR
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getX() >= botonX && e.getX() <= botonX + botonWidth && e.getY() >= botonY && e.getY() <= botonY + botonHeight) {
                    botonPressed = true;
                    pausa = !pausa;
                    if (pausa) {
                        timer.stop();
                        //CESAR
                        reproductor.detener();
                    } else {
                        timer.start();
                        //CESAR
                        reproductor = new ReproducirMusica("src/Musica/MusicaMundo1.mp3");
                        reproductor.iniciar();
                    }
                }
            }

            //Este metodo es para cuando el mouse suelta el boton
            //CESAR
            @Override
            public void mouseReleased(MouseEvent e) {
                botonPressed = false;
            }
        });

        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);

        //CAMBIAR EL ICONO A LA VENTANA
        ImageIcon icon = new ImageIcon("src/Recursos/Icono.png");
        this.setIconImage(icon.getImage());
    }

    //CESAR, este metodo es para dibujar un cuadrado invisible que va a actuiar como boton, no es la imagen
    private void drawPausa(Graphics g) {
        g.setColor(new Color(255, 255, 255, 0));
        g.drawRect(botonX, botonY, botonWidth, botonHeight);
        g.drawString(pausa ? "Reanudar" : "Pausa", botonX, botonY + 20);
    }

    //Este metodo es para dibujar un cuadrado invisible que va a actuar como boton
    private void drawSilencio(Graphics g) {
        g.setColor(new Color(255, 255, 255, 0));
        g.drawRect(botonX, botonY, botonWidth, botonHeight);
    }

        
    //JORDAN, este metodo sire para mandar a llamar el nombre de la ventana anterior
    public void setNombre(String Nombre) {
        this.Dato = Nombre;
        System.out.println(Nombre);

        String Query = "SELECT ID_User FROM Users WHERE BINARY Username=?";
        try (PreparedStatement statement = conexion.ConexionBD().prepareStatement(Query)) {
            statement.setString(1, Dato);

            //Verificar si devolvió algo la BD
            try (ResultSet resultado = statement.executeQuery()) {
                //Si devuelve algo es por que si existe
                if (resultado.next()) {
                    IDusuario = resultado.getInt("ID_User");
                    System.out.println(IDusuario);
                    return;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //JORDAN, ESTE METODO SIRVE PARA IMPRIMIR EL NOMBRE DE USUARIO EN EL NIVEL 1
    public void drawNombre(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Pixel Operator 8 HB", Font.BOLD, 20));
        g.drawString(Dato, 810, 45);
    }

    private void insertar() {
        try {
            //Convertir el entero a string para poder insertar
            IDstring = String.valueOf(IDusuario);
            // Convertir el entero de score a string para poder insertar
            ScoreTotalString = String.valueOf(score + (vidas * 100)); // Agregar puntos por vidas restantes
            //Convertir la fecha a string
            fecha = String.valueOf(date);
            //Convertir el tiempo restante en String para insertar
            TiempoRestanteString = String.valueOf(tiempoTranscurrido / 1000);

            //COMPARAR SCORE EXISTENTE EN LA BD CON SCORE NORMAL, SI ES MAYOR SES ACTUALIZA
            String Query = "SELECT Puntaje FROM M1N2 WHERE BINARY ID_User=?";
            try (PreparedStatement statement = conexion.ConexionBD().prepareStatement(Query)) {
                statement.setString(1, IDstring);

                //Verificar si devolvió algo la BD
                try (ResultSet recordAnterior = statement.executeQuery()) {
                    //Si devuelev algo significa que ya tiene un record
                    if (recordAnterior.next()) {

                        //Si ya tiene un record debe de verficar que sea mayor el nuevo que el anterior
                        ScoreAnterior = recordAnterior.getInt("Puntaje");
                        System.out.println(ScoreAnterior);

                        int segundos = tiempoTranscurrido / 1000;
                        score = (segundos * 2) + coinScore;
                        ScoreNuevo = score;

                        //Parsear el score nuevo
                        String scoreNuevoString = String.valueOf(ScoreNuevo + (vidas * 100));

                        if (ScoreNuevo > ScoreAnterior) {
                            String QueryInsertar = "UPDATE M1N2 SET Puntaje=?, Fecha=?, Tiempo_Restante=? WHERE ID_User=?";
                            Connection con = conexion.ConexionBD();
                            //statement sirve para preparar la query para interactuar con la base de datos
                            PreparedStatement statementInsertar = con.prepareStatement(QueryInsertar);
                            //Los setstring sirven para poder manipular consultas parametrizadas
                            //E insertar datos en los signos de interregacion

                            statementInsertar.setString(1, scoreNuevoString);
                            statementInsertar.setString(2, fecha);
                            statementInsertar.setString(3, TiempoRestanteString + "s");
                            statementInsertar.setString(4, IDstring);

                            //Numero de filas afectadas por la consulta sql
                            int rowsAffected = statementInsertar.executeUpdate();

                            if (rowsAffected > 0) {
                            }
                        }
                        return;
                    } else {
                        //sI NO TIENE RECORD ANTERIOR, VA A INSERTAR EN LA BD
                        String QueryInsertar = "INSERT INTO M1N2 (ID_User, Puntaje, Fecha, Tiempo_Restante) VALUES (?,?, ?, ?)";
                        Connection con = conexion.ConexionBD();
                        //statement sirve para preparar la query para interactuar con la base de datos
                        PreparedStatement statementInsertar = con.prepareStatement(QueryInsertar);
                        //Los setstring sirven para poder manipular consultas parametrizadas
                        //E insertar datos en los signos de interregacion

                        statementInsertar.setString(1, IDstring);
                        statementInsertar.setString(2, ScoreTotalString);
                        statementInsertar.setString(3, fecha);
                        statementInsertar.setString(4, TiempoRestanteString + "s");

                        //Numero de filas afectadas por la consulta sql
                        int rowsAffected = statementInsertar.executeUpdate();

                        if (rowsAffected > 0) {
                        }
                    }
                }
            }

        } catch (SQLException ex) {
                System.out.println(ex);
        }
    }//FIN DE METODO DE INSERTAR

    
    @Override
    public void actionPerformed(ActionEvent e) {

        //CESAR
        if (!pausa) {
            personajeX = Math.min(Math.max(personajeX, 0), midFrame - personajeStatico.getWidth());

            slimexRelativo = Math.min(Math.max(slimexRelativo, 1100), 1300);
            if (jumping || falling) {
                frameIndex4++;
                if (frameIndex4 >= Jumpanimation.length) {
                    frameIndex4 = 0;
                }
            }

            // Verificar si slimexRelativo está en el límite izquierdo o derecho
            if (slimexRelativo == 1100) {
                // Si está en el límite izquierdo, cambiar la dirección hacia la derecha
                movimientoDerecha = true;
            } else if (slimexRelativo == 1300) {
                // Si está en el límite derecho, cambiar la dirección hacia la izquierda
                movimientoDerecha = false;
            }

            // Mover slimexRelativo automáticamente en la dirección correspondiente
            if (movimientoDerecha) {
                slimexRelativo += velocidadMovimiento; // Mover a la derecha
            } else {
                slimexRelativo -= velocidadMovimiento; // Mover a la izquierda
            }

            // Actualizar la posición de slimex basada en el desplazamiento del escenario
            slimex = slimexRelativo + fondoX;

            //Zombie 2        
            Zombie = Math.min(Math.max(Zombie, 2300), 2500);
            if (jumping || falling) {
                frameIndex4++;
                if (frameIndex4 >= Jumpanimation.length) {
                    frameIndex4 = 0;
                }
            }

            // Verificar si slimexRelativo está en el límite izquierdo o derecho
            if (Zombie == 2390) {
                // Si está en el límite izquierdo, cambiar la dirección hacia la derecha
                movimientoDerecha = true;
            } else if (Zombie == 2540) {
                // Si está en el límite derecho, cambiar la dirección hacia la izquierda
                movimientoDerecha = false;
            }

            // Mover slimexRelativo automáticamente en la dirección correspondiente
            if (movimientoDerecha) {
                Zombie += velocidadMovimiento; // Mover a la derecha
            } else {
                Zombie -= velocidadMovimiento; // Mover a la izquierda
            }

            // Actualizar la posición de slimex basada en el desplazamiento del escenario
            Zombiex = Zombie + fondoX;

            if (keysPressed.contains(KeyEvent.VK_D)) {
                // Si el personaje ha alcanzado el midFrame y no ha superado la posición límite de 1500 en el eje X
                if (personajeX + personajeStatico.getWidth() >= midFrame) {

                    if (midFrame < 1100) {
                        fondoX -= 5;

                        bloquehitx -= 5;
                        bloquehitx2_0 -= 5;
                        bloquehitx3_0 -= 5;
                        bloquehitx4_0 -= 5;
                        bloquehitx5_0 -= 5;
                        bloquehitx6_0 -= 5;
                        bloquehitx7_0 -= 5;
                        bloquehitx8_0 -= 5;
                        bloquehitx9_0 -= 5;
                        bloquehitx10_0 -= 5;
                        bloquehitx11_0 -= 5;
                        bloquehitx12_0 -= 5;
                        bloquehitx13_0 -= 5;
                        obstaculox -= 5;
                        obstaculox2 -= 5;
                        obstaculox4 -= 5;

                        bloquehitx2 -= 5;
                        bloquehitx3 -= 5;
                        bloquehitx4 -= 5;
                        bloquehit.setX(bloquehitx);
                        bloquehit1.setX(bloquehitx2);
                        bloquehit2.setX(bloquehitx3);
                        bloquehit3.setX(bloquehitx4);

                        bloquehitx2_1 -= 5;
                        bloquehitx2_2 -= 5;
                        bloquehitx2_3 -= 5;
                        bloquehit2_0.setX(bloquehitx2_0);
                        bloquehit2_1.setX(bloquehitx2_1);
                        bloquehit2_2.setX(bloquehitx2_2);
                        bloquehit2_3.setX(bloquehitx2_0);

                        bloquehitx3_1 -= 5;
                        bloquehitx3_2 -= 5;
                        bloquehitx3_3 -= 5;
                        bloquehit3_0.setX(bloquehitx3_0);
                        bloquehit3_1.setX(bloquehitx3_1);
                        bloquehit3_2.setX(bloquehitx3_2);
                        bloquehit3_3.setX(bloquehitx3_3);

                        bloquehitx4_1 -= 5;
                        bloquehitx4_2 -= 5;
                        bloquehitx4_3 -= 5;
                        bloquehit4_0.setX(bloquehitx4_0);
                        bloquehit4_1.setX(bloquehitx4_1);
                        bloquehit4_2.setX(bloquehitx4_2);
                        bloquehit4_3.setX(bloquehitx4_3);

                        bloquehitx5_1 -= 5;
                        bloquehitx5_2 -= 5;
                        bloquehitx2_3 -= 5;
                        bloquehit5_0.setX(bloquehitx5_0);
                        bloquehit5_1.setX(bloquehitx5_1);
                        bloquehit5_2.setX(bloquehitx5_2);
                        bloquehit5_3.setX(bloquehitx5_0);

                        bloquehitx6_1 -= 5;
                        bloquehitx6_2 -= 5;
                        bloquehitx6_3 -= 5;
                        bloquehit6_0.setX(bloquehitx6_0);
                        bloquehit6_1.setX(bloquehitx6_1);
                        bloquehit6_2.setX(bloquehitx6_2);
                        bloquehit6_3.setX(bloquehitx6_3);

                        bloquehitx7_1 -= 5;
                        bloquehitx7_2 -= 5;
                        bloquehitx7_3 -= 5;
                        bloquehit7_0.setX(bloquehitx7_0);
                        bloquehit7_1.setX(bloquehitx7_1);
                        bloquehit7_2.setX(bloquehitx7_2);
                        bloquehit7_3.setX(bloquehitx7_3);

                        bloquehitx8_1 -= 5;
                        bloquehitx8_2 -= 5;
                        bloquehitx8_3 -= 5;
                        bloquehit8_0.setX(bloquehitx8_0);
                        bloquehit8_1.setX(bloquehitx8_1);
                        bloquehit8_2.setX(bloquehitx8_2);
                        bloquehit8_3.setX(bloquehitx8_3);

                        bloquehitx9_1 -= 5;
                        bloquehitx9_2 -= 5;
                        bloquehitx9_3 -= 5;
                        bloquehit9_0.setX(bloquehitx9_0);
                        bloquehit9_1.setX(bloquehitx9_1);
                        bloquehit9_2.setX(bloquehitx9_2);
                        bloquehit9_3.setX(bloquehitx9_3);

                        bloquehitx10_1 -= 5;
                        bloquehitx10_2 -= 5;
                        bloquehitx10_3 -= 5;
                        bloquehit10_0.setX(bloquehitx10_0);
                        bloquehit10_1.setX(bloquehitx10_1);
                        bloquehit10_2.setX(bloquehitx10_2);
                        bloquehit10_3.setX(bloquehitx10_3);

                        bloquehitx11_1 -= 5;
                        bloquehitx11_2 -= 5;
                        bloquehitx11_3 -= 5;
                        bloquehit11_0.setX(bloquehitx11_0);
                        bloquehit11_1.setX(bloquehitx11_1);
                        bloquehit11_2.setX(bloquehitx11_2);
                        bloquehit11_3.setX(bloquehitx11_3);

                        bloquehitx12_1 -= 5;
                        bloquehitx12_2 -= 5;
                        bloquehitx12_3 -= 5;
                        bloquehit12_0.setX(bloquehitx12_0);
                        bloquehit12_1.setX(bloquehitx12_1);
                        bloquehit12_2.setX(bloquehitx12_2);
                        bloquehit12_3.setX(bloquehitx12_3);

                        bloquehitx13_1 -= 5;
                        bloquehitx13_2 -= 5;
                        bloquehitx13_3 -= 5;
                        bloquehit13_0.setX(bloquehitx13_0);
                        bloquehit13_1.setX(bloquehitx13_1);
                        bloquehit13_2.setX(bloquehitx13_2);
                        bloquehit13_3.setX(bloquehitx13_3);
                        midhit2x -= 5;
                        midhit2.setX(midhit2x);

                        gemx -= 5;
                        coinx -= 5;
                        coinx2 -= 5;
                        coinx3 -= 5;
                        coinx4 -= 5;

                    }

                }

            }

            // Actualizar la posición de las hitboxes del personaje y el obstáculo
            personajeHitbox.setX(personajeX);
            personajeHitbox.setY(personajeY);
            obstaculohit.setX(obstaculox);
            obstaculohit1.setX(obstaculox2);

            obstaculohit3.setX(obstaculox4);

            obstaculohit.setY(649);

            // Crear el doble búffer para el fondo
            Graphics gBuffer = bufferImage.getGraphics();
            gBuffer.drawImage(fondoImage, fondoX, 0, 3000, 768, this);

            drawBloque(gBuffer);

            boolean colision = false;
            boolean colisionb = false;

            if (keysPressed.contains(KeyEvent.VK_D)) {
                personajeX += 5; // Mover el personaje hacia la derecha
                if (runningAnimationHitboxes[frameIndex].intersects(midhit2)) {
                    midFrame = 1100; // Revertir el movimiento si hay colisión
                    colision = true;
                }
                if (runningAnimationHitboxes[frameIndex].intersects(bloquehit1) || runningAnimationHitboxes[frameIndex].intersects(bloquehit1) || runningAnimationHitboxes[frameIndex].intersects(bloquehit2_1) || runningAnimationHitboxes[frameIndex].intersects(bloquehit3_1) || runningAnimationHitboxes[frameIndex].intersects(bloquehit4_1) || runningAnimationHitboxes[frameIndex].intersects(bloquehit5_1) || runningAnimationHitboxes[frameIndex].intersects(bloquehit6_1) || runningAnimationHitboxes[frameIndex].intersects(bloquehit7_1) || runningAnimationHitboxes[frameIndex].intersects(bloquehit8_1) || runningAnimationHitboxes[frameIndex].intersects(bloquehit9_1) || runningAnimationHitboxes[frameIndex].intersects(bloquehit10_1) || runningAnimationHitboxes[frameIndex].intersects(bloquehit11_1) || runningAnimationHitboxes[frameIndex].intersects(bloquehit12_1) || runningAnimationHitboxes[frameIndex].intersects(bloquehit13_1)) {
                    personajeX -= 5; // Revertir el movimiento si hay colisión 
                    colision = true;
                }

                if (!jumping && !falling) { // Solo dibujar el personaje corriendo si no está en estado de salto ni caída

                    drawPersonaje(gBuffer);
                } else {
                    drawjump(gBuffer);
                }
            } else if (keysPressed.contains(KeyEvent.VK_A) && personajeX > 0) { // Solo mover a la izquierda si no está en el límite izquierdo
                personajeX -= 5; // Mover el personaje hacia la izquierda
                if (runningAnimationHitboxes[frameIndex].intersects(bloquehit2) || runningAnimationHitboxes[frameIndex].intersects(bloquehit2_2) || runningAnimationHitboxes[frameIndex].intersects(bloquehit3_2) || runningAnimationHitboxes[frameIndex].intersects(bloquehit4_2) || runningAnimationHitboxes[frameIndex].intersects(bloquehit5_2) || runningAnimationHitboxes[frameIndex].intersects(bloquehit6_2) || runningAnimationHitboxes[frameIndex].intersects(bloquehit7_2) || runningAnimationHitboxes[frameIndex].intersects(bloquehit8_2) || runningAnimationHitboxes[frameIndex].intersects(bloquehit9_2) || runningAnimationHitboxes[frameIndex].intersects(bloquehit10_2) || runningAnimationHitboxes[frameIndex].intersects(bloquehit11_2) || runningAnimationHitboxes[frameIndex].intersects(bloquehit12_2) || runningAnimationHitboxes[frameIndex].intersects(bloquehit13_2)) {
                    personajeX += 5; // Revertir el movimiento si hay colisión 
                    colision = true;
                }
                //NUEVO METODO
                if (!jumping && !falling) {
                    // Solo dibujar el personaje corriendo si no está en estado de salto ni caída
                    drawPersonaje2(gBuffer);
                } else {
                    drawjump2(gBuffer);
                }

            } else if (jumping || falling) {
                if (keysPressed.contains(KeyEvent.VK_A) || keysPressed.contains(KeyEvent.VK_LEFT) && personajeX > 0) {
                    personajeX -= 5;
                } else if (keysPressed.contains(KeyEvent.VK_D) || keysPressed.contains(KeyEvent.VK_RIGHT)) {
                    personajeX += 5;
                }
                drawjump(gBuffer);
            } // Manejo del estado estático
            else {
                if (frameIndex5 >= 0 && frameIndex5 < personajeStaticores.length) {
                    //pone a el personaje en su posicion actualizada
                    gBuffer.drawImage(personajeStaticores[frameIndex5], personajeX, personajeY, 44, 80, this);

                    // Va a ctualizando la posicion de la hitbox de correr
                    personajeStaticoHitbox[frameIndex].setX(personajeX);
                    personajeStaticoHitbox[frameIndex].setY(personajeY);

                    // Dibujar la hitbox
                    personajeStaticoHitbox[frameIndex].drawHitbox(gBuffer);
                }

                frameIndex5++;

                if (frameIndex5 >= personajeStaticores.length) {
                    frameIndex5 = 0;
                }

                if (!jumping && personajeHitbox.intersects(bloquehit3) || !jumping && personajeHitbox.intersects(bloquehit2_3) || !jumping && personajeHitbox.intersects(bloquehit3_3) || !jumping && personajeHitbox.intersects(bloquehit4_3) || !jumping && personajeHitbox.intersects(bloquehit5_3) || !jumping && personajeHitbox.intersects(bloquehit6_3) || !jumping && personajeHitbox.intersects(bloquehit7_3) || !jumping && personajeHitbox.intersects(bloquehit8_3) || !jumping && personajeHitbox.intersects(bloquehit9_3) || !jumping && personajeHitbox.intersects(bloquehit10_3) || !jumping && personajeHitbox.intersects(bloquehit11_3) || !jumping && personajeHitbox.intersects(bloquehit12_3) || !jumping && personajeHitbox.intersects(bloquehit13_3)) {
                    if (keysPressed.contains(KeyEvent.VK_W) && jumpKeyReleased) {
                        jumping = true; // Activar el salto
                        jumpKeyReleased = false; // Indicar que la tecla de salto no está liberada
                        initialY = personajeY; // Guardar la posición inicial del salto
                    }
                }

            }
            // Si el personaje está saltando, actualizar su posición vertical
            if (jumping) {

                personajeY -= jumpSpeed; // Usar la variable salto para modificar la posición vertical
                if (personajeY <= initialY - salto) { // Altura máxima del salto basada en la posición inicial
                    jumping = false;
                    falling = true;
                }
            } else if (falling || personajeY < 600) {
                boolean sobreBloque = personajeY + 80 >= bloquehit.getY()
                        && personajeY + 80 <= bloquehit.getY() + fallSpeed
                        && personajeX + 80 > bloquehit.getX()
                        && personajeX < bloquehit.getX() + bloquehit.getWidth();

                boolean sobreBloque2 = personajeY + 80 >= bloquehit2_0.getY()
                        && personajeY + 80 <= bloquehit2_0.getY() + fallSpeed
                        && personajeX + 80 > bloquehit2_0.getX()
                        && personajeX < bloquehit2_0.getX() + bloquehit2_0.getWidth();

                boolean sobreBloque3 = personajeY + 80 >= bloquehit3_0.getY()
                        && personajeY + 80 <= bloquehit3_0.getY() + fallSpeed
                        && personajeX + 80 > bloquehit3_0.getX()
                        && personajeX < bloquehit3_0.getX() + bloquehit3_0.getWidth();

                boolean sobreBloque4 = personajeY + 80 >= bloquehit4_0.getY()
                        && personajeY + 80 <= bloquehit4_0.getY() + fallSpeed
                        && personajeX + 80 > bloquehit4_0.getX()
                        && personajeX < bloquehit4_0.getX() + bloquehit4_0.getWidth();

                boolean sobreBloque5 = personajeY + 80 >= bloquehit5_0.getY()
                        && personajeY + 80 <= bloquehit5_0.getY() + fallSpeed
                        && personajeX + 80 > bloquehit5_0.getX()
                        && personajeX < bloquehit5_0.getX() + bloquehit5_0.getWidth();

                boolean sobreBloque6 = personajeY + 80 >= bloquehit6_0.getY()
                        && personajeY + 80 <= bloquehit6_0.getY() + fallSpeed
                        && personajeX + 80 > bloquehit6_0.getX()
                        && personajeX < bloquehit6_0.getX() + bloquehit6_0.getWidth();

                boolean sobreBloque7 = personajeY + 80 >= bloquehit7_0.getY()
                        && personajeY + 80 <= bloquehit7_0.getY() + fallSpeed
                        && personajeX + 80 > bloquehit7_0.getX()
                        && personajeX < bloquehit7_0.getX() + bloquehit7_0.getWidth();

                boolean sobreBloque8 = personajeY + 80 >= bloquehit8_0.getY()
                        && personajeY + 80 <= bloquehit8_0.getY() + fallSpeed
                        && personajeX + 80 > bloquehit8_0.getX()
                        && personajeX < bloquehit8_0.getX() + bloquehit8_0.getWidth();

                boolean sobreBloque9 = personajeY + 80 >= bloquehit9_0.getY()
                        && personajeY + 80 <= bloquehit9_0.getY() + fallSpeed
                        && personajeX + 80 > bloquehit9_0.getX()
                        && personajeX < bloquehit9_0.getX() + bloquehit9_0.getWidth();

                boolean sobreBloque10 = personajeY + 80 >= bloquehit10_0.getY()
                        && personajeY + 80 <= bloquehit10_0.getY() + fallSpeed
                        && personajeX + 80 > bloquehit10_0.getX()
                        && personajeX < bloquehit10_0.getX() + bloquehit10_0.getWidth();

                boolean sobreBloque11 = personajeY + 80 >= bloquehit11_0.getY()
                        && personajeY + 80 <= bloquehit11_0.getY() + fallSpeed
                        && personajeX + 80 > bloquehit11_0.getX()
                        && personajeX < bloquehit11_0.getX() + bloquehit11_0.getWidth();

                boolean sobreBloque12 = personajeY + 80 >= bloquehit12_0.getY()
                        && personajeY + 80 <= bloquehit12_0.getY() + fallSpeed
                        && personajeX + 80 > bloquehit12_0.getX()
                        && personajeX < bloquehit12_0.getX() + bloquehit12_0.getWidth();

                boolean sobreBloque13 = personajeY + 80 >= bloquehit13_0.getY()
                        && personajeY + 80 <= bloquehit13_0.getY() + fallSpeed
                        && personajeX + 80 > bloquehit13_0.getX()
                        && personajeX < bloquehit13_0.getX() + bloquehit13_0.getWidth();

                if (sobreBloque) {
                    personajeY = bloquehit.getY() - 80;

                    falling = false;
                } else if (sobreBloque2) {
                    personajeY = bloquehit2_0.getY() - 80;

                    falling = false;
                } else if (sobreBloque3) {
                    personajeY = bloquehit3_0.getY() - 80;

                    falling = false;

                } else if (sobreBloque4) {
                    personajeY = bloquehit4_0.getY() - 80;

                    falling = false;

                } else if (sobreBloque5) {
                    personajeY = bloquehit5_0.getY() - 80;

                    falling = false;

                } else if (sobreBloque6) {
                    personajeY = bloquehit6_0.getY() - 80;

                    falling = false;

                } else if (sobreBloque7) {
                    personajeY = bloquehit7_0.getY() - 80;

                    falling = false;

                } else if (sobreBloque8) {
                    personajeY = bloquehit8_0.getY() - 80;
                    midFrame = 1024;
                    falling = false;

                } else if (sobreBloque9) {
                    personajeY = bloquehit9_0.getY() - 80;

                    falling = false;

                } else if (sobreBloque10) {
                    personajeY = bloquehit10_0.getY() - 80;

                    falling = false;

                } else if (sobreBloque11) {
                    personajeY = bloquehit11_0.getY() - 80;

                    falling = false;

                } else if (sobreBloque12) {
                    personajeY = bloquehit12_0.getY() - 80;

                    falling = false;

                } else if (sobreBloque13) {
                    personajeY = bloquehit13_0.getY() - 80;

                    falling = false;

                } else {
                    personajeY += fallSpeed; // Caída
                    if (personajeY >= 600) { // Volver a la posición original
                        personajeY = 600;
                        falling = false; // Detener la caída
                    }
                }
            }

            // Verificar la colisión entre el personaje y el obstáculo
            boolean inmunidadActivada = false;
            long tiempoInicioInmunidad = 0;
            long duracionInmunidad = 3000; // 3 segundos en milisegundos

            if (personajeHitbox.intersects(obstaculohit) || personajeHitbox.intersects(obstaculohit1) || personajeHitbox.intersects(obstaculohit3) || personajeHitbox.intersects(slime2hit[frameIndex3]) || personajeHitbox.intersects(Zombiehit[frameindex6])) {
                if (!inmunidadActivada) {
                    // Restar una vida y mostrar el mensaje de vidas restantes
                    vidas -= 0.05;

                    System.out.println("Vidas restantes: " + vidas);
                    if (vidas <= 0.80) {
                        // Detener el juego si las vidas llegan a cero
                        timer.stop();
                        reproductor.detener();
                        //MOSTRAR UN MENSAJE DE PERSONAJE MUERTO
                        Mensaje13 msj = new Mensaje13(this, true);
                        msj.setVisible(true);
                        Login log = new Login();
                        log.setVisible(true);
                        this.dispose();
                    } else {
                        inmunidadActivada = true;
                        tiempoInicioInmunidad = System.currentTimeMillis();
                    }
                }
            }
            if (colision && colisionb) {
                // Revertir cualquier movimiento adicional si hay colisión con el bloque y obstáculo
                if (keysPressed.contains(KeyEvent.VK_D) || keysPressed.contains(KeyEvent.VK_RIGHT)) {
                    personajeX -= 1;

                }
            }

            // Verificar si se acabó el tiempo transcurrido
            if (tiempoTranscurrido <= 0) {
                // Detener el juego
                timer.stop();
                reproductor.detener();
                //MOSTRAR MENSAJE DE TIEMPO FINALIZADO
                Mensaje14 msj = new Mensaje14(this, true);
                msj.setVisible(true);
                this.dispose();
                Login log = new Login();
                log.setVisible(true);

            }

            if (personajeHitbox.intersects(gemhit[frameIndex2])) {
                timer.stop();
                reproductor.detener();
                fading = true;
                fadeOpacity = 0;
                repaint();
                //MENSAJE DE QUE PASÓ EL NIVEL 1
                Mensaje15 msj = new Mensaje15(this, true);
                msj.setVisible(true);
                reproductor.detener();
                insertar();
                M2N1 otro = new M2N1();
                otro.setNombre(Dato);
                otro.setVisible(true);
                this.dispose();
            }

            // Verificar si la inmunidad está activada y si han pasado los 3 segundos
            if (inmunidadActivada) {
                long tiempoActual = System.currentTimeMillis();
                if (tiempoActual - tiempoInicioInmunidad >= duracionInmunidad) {
                    // Desactivar la inmunidad después de 3 segundos
                    inmunidadActivada = false;
                }
            }
            tiempoTranscurrido -= 30;

            // Dibujar las vidas
            drawDegradado(gBuffer);
            drawTime(gBuffer);
            drawScore(gBuffer);
            drawGem(gBuffer);
            drawCoin(gBuffer);
            drawCoin2(gBuffer);
            drawCoin3(gBuffer);
            drawCoin4(gBuffer);
            drawSlime(gBuffer);
            drawPausa(gBuffer);
            drawSilencio(gBuffer);
            drawBotonP(gBuffer);
            drawvida(gBuffer);
            drawZombie(gBuffer);
            drawNombre(gBuffer);

            // Mostrar el doble búffer en la ventana
            Graphics g = getGraphics();
            g.drawImage(bufferImage, 0, 0, null);
        }
    }

    private void drawPersonaje(Graphics g) {

        // Verificar si el índice frameIndex está dentro del rango válido osea si esta del mismo tama;o del vector
        if (frameIndex >= 0 && frameIndex < runningAnimation.length) {
            //pone a el personaje en su posicion actualizada
            g.drawImage(runningAnimation[frameIndex], personajeX, personajeY, 80, 80, this);

            // Va a ctualizando la posicion de la hitbox de correr
            runningAnimationHitboxes[frameIndex].setX(personajeX);
            runningAnimationHitboxes[frameIndex].setY(personajeY);

            // Dibujar la hitbox
            runningAnimationHitboxes[frameIndex].drawHitbox(g);
        }

        frameIndex++;

        if (frameIndex >= runningAnimation.length) {
            frameIndex = 0;
        }

    }

    private void drawjump(Graphics g) {
        if (frameIndex4 >= 0 && frameIndex4 < Jumpanimation.length) {
            //pone a el personaje en su posicion actualizada
            g.drawImage(Jumpanimation[frameIndex4], personajeX, personajeY, 80, 80, this);

            // Va a ctualizando la posicion de la hitbox de correr
        }

        frameIndex4++;

        if (frameIndex4 >= Jumpanimation.length) {
            frameIndex4 = 0;
        }

        // Dibujar el fotograma actual de la animación de salto
    }

    //CHECHITA
    private void drawjump2(Graphics g) {
        if (frameIndex4 >= 0 && frameIndex4 < Jumpanimation2.length) {
            //pone a el personaje en su posicion actualizada
            g.drawImage(Jumpanimation2[frameIndex4], personajeX, personajeY, 80, 80, this);

            // Va a ctualizando la posicion de la hitbox de correr
        }

        frameIndex4++;

        if (frameIndex4 >= Jumpanimation2.length) {
            frameIndex4 = 0;
        }

    }

    private void drawGem(Graphics g) {
        if (frameIndex2 >= 0 && frameIndex2 < gem.length) {

            g.drawImage(gem[frameIndex2], gemx, 400, 38, 79, null);

            gemhit[frameIndex2].setX(gemx);
            gemhit[frameIndex2].setY(400);

            gemhit[frameIndex2].drawHitbox(g);

        }

        frameIndex2++;

        if (frameIndex2 >= gem.length) {
            frameIndex2 = 0;
        }

    }

    //chechita
    private void drawPersonaje2(Graphics g) {

        // Verificar si el índice frameIndex está dentro del rango válido osea si esta del mismo tama;o del vector
        if (frameIndex >= 0 && frameIndex < runningAnimation2.length) {
            //pone a el personaje en su posicion actualizada
            g.drawImage(runningAnimation2[frameIndex], personajeX, personajeY, 80, 80, this);

            // Va a ctualizando la posicion de la hitbox de correr
            runningAnimationHitboxes2[frameIndex].setX(personajeX);
            runningAnimationHitboxes2[frameIndex].setY(personajeY);

            // Dibujar la hitbox
            runningAnimationHitboxes2[frameIndex].drawHitbox(g);
        }

        frameIndex++;

        if (frameIndex >= runningAnimation2.length) {
            frameIndex = 0;
        }

    }

    private void drawCoin(Graphics g) {
        if (frameindex10 >= 0 && frameindex10 < coin.length && coin[frameindex10] != null) {
            coinet[frameindex10].setX(coinx);
            coinet[frameindex10].setY(200);
            coinet[frameindex10].drawHitbox(g);

            if (personajeHitbox.intersects(coinet[frameindex10])) {
                //CESAR
                // Agregar 15 puntos por 6 segundos == 90 puntos al puntaje cuando el usuario agarre esta moneda
                coinScore += 15;
                // Aqui se elimna la moneda si el personaje la toca
                coin[frameindex10] = null;
                System.out.println("1");
            } else {
                // Solo se muestra la moneda si el persoanje no a pasado sobre ella
                g.drawImage(coin[frameindex10], coinx, 200, 40, 65, null);
            }

            frameindex10++;

            if (frameindex10 >= coin.length) {
                frameindex10 = 0;
            }
        }
    }

    private void drawCoin2(Graphics g) {
        if (frameindex11 >= 0 && frameindex11 < coin2.length && coin2[frameindex11] != null) {
            coinet2[frameindex11].setX(coinx2);
            coinet2[frameindex11].setY(200);
            coinet2[frameindex11].drawHitbox(g);

            if (personajeHitbox.intersects(coinet2[frameindex11])) {
                //CESAR
                // Agregar 15 puntos por 6 segundos == 90 puntos al puntaje cuando el usuario agarre esta moneda
                coinScore += 15;
                // Aqui se elimna la moneda si el personaje la toca
                coin2[frameindex11] = null;
                System.out.println("1");
            } else {
                // Solo se muestra la moneda si el persoanje no a pasado sobre ella
                g.drawImage(coin2[frameindex11], coinx2, 200, 40, 65, null);
            }

            frameindex11++;

            if (frameindex11 >= coin2.length) {
                frameindex11 = 0;
            }
        }
    }

    private void drawCoin3(Graphics g) {
        if (frameindex12 >= 0 && frameindex12 < coin3.length && coin3[frameindex12] != null) {
            coinet3[frameindex12].setX(coinx3);
            coinet3[frameindex12].setY(355);
            coinet3[frameindex12].drawHitbox(g);

            if (personajeHitbox.intersects(coinet3[frameindex12])) {
                //CESAR
                // Agregar 15 puntos por 6 segundos == 90 puntos al puntaje cuando el usuario agarre esta moneda
                coinScore += 15;
                // Aqui se elimna la moneda si el personaje la toca
                coin3[frameindex12] = null;
                System.out.println("1");
            } else {
                // Solo se muestra la moneda si el persoanje no a pasado sobre ella
                g.drawImage(coin3[frameindex12], coinx3, 355, 40, 65, null);

            }

            frameindex12++;

            if (frameindex12 >= coin3.length) {
                frameindex12 = 0;
            }
        }
    }

    private void drawCoin4(Graphics g) {
        if (frameindex13 >= 0 && frameindex13 < coin4.length && coin4[frameindex13] != null) {
            coinet4[frameindex13].setX(coinx4);
            coinet4[frameindex13].setY(460);
            coinet4[frameindex13].drawHitbox(g);

            if (personajeHitbox.intersects(coinet4[frameindex13])) {
                //CESAR
                // Agregar 15 puntos por 6 segundos == 90 puntos al puntaje cuando el usuario agarre esta moneda
                coinScore += 15;
                // Aqui se elimna la moneda si el personaje la toca
                coin4[frameindex13] = null;
                System.out.println("1");
            } else {
                // Solo se muestra la moneda si el persoanje no a pasado sobre ella
                g.drawImage(coin4[frameindex13], coinx4, 460, 40, 65, null);

            }

            frameindex13++;

            if (frameindex13 >= coin4.length) {
                frameindex13 = 0;
            }
        }
    }

    //CESAR
    private void drawvida(Graphics g) {
        //Si es igual a 3 entonces la imgen de la barra de vida 3 se mostrara
        if (vidas == 3.00) {
            g.drawImage(imageBarra1, vidax, 10, 295, 47, this);
        } else {
            if (vidas < 3 && vidas > 1.99) {
                g.drawImage(imageBarra2, vidax, 10, 295, 47, this);
            } else {
                if (vidas < 2 && vidas > 0.99) {
                    g.drawImage(imageBarra3, vidax, 10, 295, 47, this);
                } else {
                    if (vidas < 0.99) {
                        g.drawImage(imageBarra4, vidax, 10, 295, 47, this);
                    }
                }
            }
        }
    }

    //CESAR, este metodo sirve para pintar el boton de pausa, esto solo es visual porque es una imagen
    private void drawBotonP(Graphics g) {
        g.drawImage(imagePausa, 920, 10, this);
    }

    private void drawSlime(Graphics g) {
        if (frameIndex3 >= 0 && frameIndex3 < slime2.length) {

            g.drawImage(slime2[frameIndex3], slimex, 215, 77, 77, null);

            slime2hit[frameIndex3].setX(slimex);
            slime2hit[frameIndex3].setY(215);

            slime2hit[frameIndex3].drawHitbox(g);

        }

        frameIndex3++;

        if (frameIndex3 >= slime2.length) {
            frameIndex3 = 0;
        }

    }

    private void drawZombie(Graphics g) {
        if (frameindex6 >= 0 && frameindex6 < Zombie2.length) {

            g.drawImage(Zombie2[frameindex6], Zombiex, 500, 77, 77, null);

            Zombiehit[frameindex6].setX(Zombiex);
            Zombiehit[frameindex6].setY(500);

            Zombiehit[frameindex6].drawHitbox(g);

        }

        frameindex6++;

        if (frameindex6 >= Zombie2.length) {
            frameindex6 = 0;
        }

    }

    private void drawBloque(Graphics g) {

        bloquehit2_0.drawHitbox(g);
        bloquehit2_1.drawHitbox(g);
        bloquehit2_2.drawHitbox(g);
        bloquehit2_3.drawHitbox(g);

        bloquehit3_0.drawHitbox(g);
        bloquehit3_1.drawHitbox(g);
        bloquehit3_2.drawHitbox(g);
        bloquehit3_3.drawHitbox(g);

        bloquehit4_0.drawHitbox(g);
        bloquehit4_1.drawHitbox(g);
        bloquehit4_2.drawHitbox(g);
        bloquehit4_3.drawHitbox(g);

        bloquehit5_0.drawHitbox(g);
        bloquehit5_1.drawHitbox(g);
        bloquehit5_2.drawHitbox(g);
        bloquehit5_3.drawHitbox(g);

        bloquehit6_0.drawHitbox(g);
        bloquehit6_1.drawHitbox(g);
        bloquehit6_2.drawHitbox(g);
        bloquehit6_3.drawHitbox(g);

        bloquehit7_0.drawHitbox(g);
        bloquehit7_1.drawHitbox(g);
        bloquehit7_2.drawHitbox(g);
        bloquehit7_3.drawHitbox(g);

        bloquehit8_0.drawHitbox(g);
        bloquehit8_1.drawHitbox(g);
        bloquehit8_2.drawHitbox(g);
        bloquehit8_3.drawHitbox(g);

        bloquehit9_0.drawHitbox(g);
        bloquehit9_1.drawHitbox(g);
        bloquehit9_2.drawHitbox(g);
        bloquehit9_3.drawHitbox(g);

        bloquehit10_0.drawHitbox(g);
        bloquehit10_1.drawHitbox(g);
        bloquehit10_2.drawHitbox(g);
        bloquehit10_3.drawHitbox(g);

        bloquehit11_0.drawHitbox(g);
        bloquehit11_1.drawHitbox(g);
        bloquehit11_2.drawHitbox(g);
        bloquehit11_3.drawHitbox(g);

        bloquehit12_0.drawHitbox(g);
        bloquehit12_1.drawHitbox(g);
        bloquehit12_2.drawHitbox(g);
        bloquehit12_3.drawHitbox(g);

        bloquehit13_0.drawHitbox(g);
        bloquehit13_1.drawHitbox(g);
        bloquehit13_2.drawHitbox(g);
        bloquehit13_3.drawHitbox(g);

        bloquehit.drawHitbox(g);
        bloquehit1.drawHitbox(g);
        bloquehit2.drawHitbox(g);
        bloquehit3.drawHitbox(g);
        obstaculohit.drawHitbox(g);

        obstaculohit1.drawHitbox(g);
        obstaculohit3.drawHitbox(g);

        midhit2.drawHitbox(g);

    }

    private void drawDegradado(Graphics g) {
        if (degradado != null) {
            g.drawImage(degradado, 0, 0, null);
        }
    }

    //Metodo a editar
    private void drawTime(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Pixel Operator 8 HB", Font.BOLD, 20));

        ///Convertir los miilisegundos a segundos
        int segundos = tiempoTranscurrido / 1000;
        //CESAR
        g.drawString("Tiempo restante: " + segundos + "s", 325, 45);
    }

    //CESAR
    private void drawScore(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Pixel Operator 8 HB", Font.BOLD, 20));

        ///Convertir los miilisegundos a segundos
        int segundos = tiempoTranscurrido / 1000;
        score = (segundos * 2) + coinScore; // Add coin score to the existing score formula
        g.drawString("Puntuación: " + score + "pts.", 560, 45);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (bufferImage != null) {
            // Dibujar el fondo desde el doble búffer
            g.drawImage(bufferImage, 0, 0, null);
        }
        if (fading) {
            fadeOpacity += 5;
            if (fadeOpacity > 255) {
                fadeOpacity = 255;
                fading = false;
            }
        }

        g.setColor(new Color(0, 0, 0, fadeOpacity));
        g.fillRect(0, 0, getWidth(), getHeight());

        // Dibujar el botón de pausa CESAR
        drawPausa(g);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        keysPressed.add(keyCode);

        // Verificar si el personaje no está saltando y está en el suelo o sobre el bloque para permitir el salto
        if (keyCode == KeyEvent.VK_W && !jumping && !falling && jumpKeyReleased) {
            jumping = true; // Activar el salto al presionar la tecla W si el personaje está en el suelo o sobre el bloque
            jumpKeyReleased = false;// Indicar que la tecla de salto no está liberada
            initialY = personajeY; // Guardar la posición inicial del salto

        } else if (keyCode == KeyEvent.VK_UP && !jumping && !falling && jumpKeyReleased) {
            jumping = true; // Activar el salto al presionar la tecla W si el personaje está en el suelo o sobre el bloque
            jumpKeyReleased = false;// Indicar que la tecla de salto no está liberada
            initialY = personajeY; // Guardar la posición inicial del salto
        }
    }

    @Override
    public void keyReleased(KeyEvent e
    ) {
        int keyCode = e.getKeyCode();
        keysPressed.remove(keyCode);

        // Verificar si la tecla de salto (W) fue soltada
        if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {
            jumpKeyReleased = true; // Indicar que la tecla de salto fue liberada
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            M1N1 frame = new M1N1();
            frame.setVisible(true);
        });
    }
}
