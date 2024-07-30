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

public class M3N2 extends JFrame implements ActionListener, KeyListener {
//JORDAN
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
    private int bossScore = 0;
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
    private Hitbox midhit2;
    private int midhit2x = 600;

    private BufferedImage extra1;
    private BufferedImage extra2;
    private BufferedImage extra3;
    private BufferedImage extra4;

    private BufferedImage imageSilencio;
    private int vidax = 10;
    private int score;
    private BufferedImage degradado;
    private int tiempoTranscurrido = 180000;

    private BufferedImage fondoImage;
    private BufferedImage personajeStatico;
    private int frameIndex4 = 0;
    private BufferedImage[] personajeStaticores;
    private int frameIndex5 = 0;
    private int frameindex6 = 0;

    private int frameindex10 = 0;
    private int frameindex11 = 0;
    private int frameindex12 = 0;
    private int frameindex13 = 0;
    private int frameindex14 = 0;
    private int frameindex55 = 0;
    private int frameIndex222=0;


    private BufferedImage[] runningAnimation;
    private BufferedImage[] runningAnimation2; //cambios de variables CHECHITA
    private Hitbox2[] runningAnimationHitboxes2; //chechitadraw

    private BufferedImage[] Attack; //cambios de variables 
    private Hitbox2[] AttackHit; 
    
        private BufferedImage[] Attack_Boss; //cambios de variables


    private BufferedImage[] Jumpanimation;
    private BufferedImage[] Jumpanimation2; //cambios de variables CHECHITA
    private BufferedImage[] gem;
    private BufferedImage[] coin;
    private BufferedImage[] coin2;
    private BufferedImage[] coin3;
    private BufferedImage[] coin4;

    
    private BufferedImage[] gem2;
     private Hitbox[] gemhit2;
     private int gemx2=2050;
    private double vidaenemigo=5;
    private BufferedImage[] Extra;

    private int Boss_Run = 2600;
    private int Runx = 2600;
    private Hitbox2[] Runhit;

    private int Boss_Run2 = 2600;
    private int Runx2 = 2600;
    private Hitbox2[] Runhit2;

    private BufferedImage sueloImage;
    private int fondoX = 0;
    private int suelox = 0;
    private int personajeX = 160;
    private int personajeY = 10;
    private Timer timer;
    private BufferedImage bufferImage;
    private int ANCHO_FRAME = 1024;
    private int ALTO_FRAME = 768;
    private int frameIndex = 0;
    private int frameIndex2 = 0;
    private int frameIndex3 = 0;

    private int frameIndex7 = 0;
    private int frameIndex28 = 0;

    private boolean jumping = false;
    private boolean falling = false;
    private int midFrame = 900;
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
    private Hitbox bloquehit14_0;

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

    int gemx = 2400;
    private Hitbox[] gemhit;

    int coinx = 150;
    private Hitbox[] coinet;

    int coinx2 = 1850;
    private Hitbox[] coinet2;

    int coinx3 = 510;
    private Hitbox[] coinet3;

    int coinx4 = 1205;
    private Hitbox[] coinet4;

    int Extrax = 2760;
    private Hitbox[] Extranet;

    private Hitbox obstaculohit1;
    private Hitbox obstaculohit0;
    private Hitbox obstaculohit3;
    private Hitbox obstaculohit5;
    private Hitbox obstaculohit6;
    private int bloquehitx = 0;
    private int bloquehitx2 = 0;
    private int bloquehitx3 = 180;
    private int bloquehitx4 = 0;

    int fadeOpacity = 0;
    boolean fading = false;

    private int bloquehitx2_0 = 250;
    private int bloquehitx2_1 = 250;
    private int bloquehitx2_2 = 470;
    private int bloquehitx2_3 = 250;

    private int bloquehitx3_0 = 580;
    private int bloquehitx3_1 = 580;
    private int bloquehitx3_2 = 800;
    private int bloquehitx3_3 = 580;

    private int bloquehitx4_0 = 360;
    private int bloquehitx4_1 = 360;
    private int bloquehitx4_2 = 795;
    private int bloquehitx4_3 = 360;

    private int bloquehitx5_0 = 235;
    private int bloquehitx5_1 = 235;
    private int bloquehitx5_2 = 290;
    private int bloquehitx5_3 = 235;

    private int bloquehitx6_0 = 853;
    private int bloquehitx6_1 = 853;
    private int bloquehitx6_2 = 978;
    private int bloquehitx6_3 = 853;

    private int bloquehitx7_0 = 1130;
    private int bloquehitx7_1 = 1130;
    private int bloquehitx7_2 = 1350;
    private int bloquehitx7_3 = 1130;

    private int bloquehitx8_0 = 2780;
    private int bloquehitx8_1 = 1365;
    private int bloquehitx8_2 = 1590; //Este es el penultimo bloque
    private int bloquehitx8_3 = 1365;

    private int bloquehitx9_0 = 1365;
    private int bloquehitx9_1 = 1365;
    private int bloquehitx9_2 = 1590;
    private int bloquehitx9_3 = 1365;

    private int bloquehitx10_0 = 1535;
    private int bloquehitx10_1 = 1535;
    private int bloquehitx10_2 = 1590;
    private int bloquehitx10_3 = 1535;

    private int bloquehitx11_0 = 1625;
    private int bloquehitx11_1 = 1625;
    private int bloquehitx11_2 = 1680;
    private int bloquehitx11_3 = 1625;

    private int bloquehitx12_0 = 1720;
    private int bloquehitx12_1 = 1720;
    private int bloquehitx12_2 = 1775;
    private int bloquehitx12_3 = 1720;

    private int bloquehitx13_0 = 1805;
    private int bloquehitx13_1 = 1805;
    private int bloquehitx13_2 = 1935;
    private int bloquehitx13_3 = 1805;

    private int bloquehitx14_0 = 0;

    private double vidas = 3;
    private int obstaculox = 675;
    private int obstaculox1 = 2800;
    private int obstaculox2 = 0;
    private int obstaculox4 = 835; //Pincho_largo_1
    private int obstaculox5 = 25;
    private int obstaculox6 = 200;

    private int salto = 150;
    private boolean jumpKeyReleased = true;
    private int initialY;

    public M3N2() {

        setSize(ANCHO_FRAME, ALTO_FRAME);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            fondoImage = ImageIO.read(new File("src/Fondo/Nivel2_Mundo3.png")); // ruta del fondo
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //CESAR
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
            extra1 = ImageIO.read(new File("src/Vidas_Extra/1.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            extra2 = ImageIO.read(new File("src/Vidas_Extra/2.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            extra3 = ImageIO.read(new File("src/Vidas_Extra/3.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            extra4 = ImageIO.read(new File("src/Vidas_Extra/4.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Attack_Boss = new BufferedImage[11];
        for (int i = 0; i < Attack_Boss.length; i++) {
            try {
                Attack_Boss[i] = ImageIO.read(new File("src/Attack_Boss/" + (i + 1) + ".png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        try {
            degradado = ImageIO.read(new File("src/Recursos/Degradado.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            personajeStatico = ImageIO.read(new File("src/PersonajePrincipal/1.png")); // ruta del personaje estático

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

        Attack = new BufferedImage[12];
        for (int i = 0; i < Attack.length; i++) {
            try {
                Attack[i] = ImageIO.read(new File("src/golpe/" + (i + 1) + ".png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        Jumpanimation = new BufferedImage[77];
        for (int i = 0; i < Jumpanimation.length; i++) {
            try {
                Jumpanimation[i] = ImageIO.read(new File("src/SALTO/" + (i + 1) + ".png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        //CHECHITA
        Jumpanimation2 = new BufferedImage[77];
        for (int i = 0; i < Jumpanimation2.length; i++) {
            try {
                Jumpanimation2[i] = ImageIO.read(new File("src/Salta_reverse/" + (i + 1) + ".png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        gem = new BufferedImage[10];
        for (int i = 0; i < gem.length; i++) {
            try {
                gem[i] = ImageIO.read(new File("src/Gema2/" + (i + 1) + ".png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        gem2 = new BufferedImage[10];
        for (int i = 0; i < gem2.length; i++) {
            try {
                gem2[i] = ImageIO.read(new File("src/Gema2/" + (i + 1) + ".png"));
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

        Extra = new BufferedImage[20];
        for (int i = 0; i < Extra.length; i++) {
            try {
                Extra[i] = ImageIO.read(new File("src/Potenciador/" + (i + 1) + ".png"));
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

        bloquehit = new Hitbox(bloquehitx, 100, 180, 1);
        bloquehit1 = new Hitbox(bloquehitx2, 100, 1, 365);
        bloquehit2 = new Hitbox(bloquehitx3, 100, 1, 365);
        bloquehit3 = new Hitbox(bloquehitx4, 460, 180, 1);

        bloquehit2_0 = new Hitbox(bloquehitx2_0, 150, 220, 1);
        bloquehit2_1 = new Hitbox(bloquehitx2_1, 150, 1, 50);
        bloquehit2_2 = new Hitbox(bloquehitx2_2, 150, 1, 50);
        bloquehit2_3 = new Hitbox(bloquehitx2_3, 200, 220, 1);

        bloquehit3_0 = new Hitbox(bloquehitx3_0, 150, 220, 1);
        bloquehit3_1 = new Hitbox(bloquehitx3_1, 150, 1, 50);
        bloquehit3_2 = new Hitbox(bloquehitx3_2, 150, 1, 50);
        bloquehit3_3 = new Hitbox(bloquehitx3_3, 200, 220, 1);

        bloquehit4_0 = new Hitbox(bloquehitx4_0, 405, 435, 1);
        bloquehit4_1 = new Hitbox(bloquehitx4_1, 405, 1, 50);
        bloquehit4_2 = new Hitbox(bloquehitx4_2, 405, 1, 50);
        bloquehit4_3 = new Hitbox(bloquehitx4_3, 455, 435, 1);

        bloquehit5_0 = new Hitbox(bloquehitx5_0, 540, 60, 1);
        bloquehit5_1 = new Hitbox(bloquehitx5_1, 540, 1, 50);
        bloquehit5_2 = new Hitbox(bloquehitx5_2, 540, 1, 50);
        bloquehit5_3 = new Hitbox(bloquehitx5_3, 590, 60, 1);

        bloquehit6_0 = new Hitbox(bloquehitx6_0, 0, 60, 1);
        bloquehit6_1 = new Hitbox(bloquehitx6_1, 0, 1, 565);
        bloquehit6_2 = new Hitbox(bloquehitx6_2, 310, 1, 255);
        bloquehit6_3 = new Hitbox(bloquehitx6_3, 565, 130, 1);

        bloquehit7_0 = new Hitbox(bloquehitx7_0, 580, 220, 1);
        bloquehit7_1 = new Hitbox(bloquehitx7_1, 580, 1, 50);
        bloquehit7_2 = new Hitbox(bloquehitx7_2, 580, 1, 50);
        bloquehit7_3 = new Hitbox(bloquehitx7_3, 630, 220, 1);

        bloquehit8_0 = new Hitbox(bloquehitx8_0, 670, 1055, 1);
        bloquehit8_1 = new Hitbox(bloquehitx8_1, 585, 1, 50);
        bloquehit8_2 = new Hitbox(bloquehitx8_2, 585, 1, 50); //Penultimi Bloque
        bloquehit8_3 = new Hitbox(bloquehitx8_3, 535, 220, 1);

        bloquehit9_0 = new Hitbox(bloquehitx9_0, 485, 220, 1);
        bloquehit9_1 = new Hitbox(bloquehitx9_1, 485, 1, 50);
        bloquehit9_2 = new Hitbox(bloquehitx9_2, 485, 1, 50);
        bloquehit9_3 = new Hitbox(bloquehitx9_3, 535, 220, 1);

        bloquehit10_0 = new Hitbox(bloquehitx10_0, 420, 60, 1);
        bloquehit10_1 = new Hitbox(bloquehitx10_1, 420, 1, 50);
        bloquehit10_2 = new Hitbox(bloquehitx10_2, 420, 1, 50);
        bloquehit10_3 = new Hitbox(bloquehitx10_3, 470, 60, 1);

        bloquehit11_0 = new Hitbox(bloquehitx11_0, 375, 55, 1);
        bloquehit11_1 = new Hitbox(bloquehitx11_1, 375, 1, 50);
        bloquehit11_2 = new Hitbox(bloquehitx11_2, 375, 1, 50);
        bloquehit11_3 = new Hitbox(bloquehitx11_3, 425, 55, 1);

        bloquehit12_0 = new Hitbox(bloquehitx12_0, 342, 55, 1);
        bloquehit12_1 = new Hitbox(bloquehitx12_1, 342, 1, 50);
        bloquehit12_2 = new Hitbox(bloquehitx12_2, 342, 1, 50);
        bloquehit12_3 = new Hitbox(bloquehitx12_3, 390, 55, 1);

        bloquehit13_0 = new Hitbox(bloquehitx13_0, 295, 130, 1);
        bloquehit13_1 = new Hitbox(bloquehitx13_1, 295, 1, 410);
        bloquehit13_2 = new Hitbox(bloquehitx13_2, 295, 1, 410);
        bloquehit13_3 = new Hitbox(bloquehitx13_3, 705, 130, 1);

        bloquehit14_0 = new Hitbox(bloquehitx14_0, 0, 220, 1);

        midhit2 = new Hitbox(midhit2x, 800, 400, 7000);

        obstaculohit = new Hitbox(2245, 375, 125, 1);
        obstaculohit0 = new Hitbox(obstaculox1, 375, 1, 70000);
        obstaculohit1 = new Hitbox(430, 645, 250, 1);
        obstaculohit3 = new Hitbox(435, 0, 1, 310);
        obstaculohit5 = new Hitbox(575, 505, 1, 120);
        obstaculohit6 = new Hitbox(575, 195, 1, 250);

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

        AttackHit = new Hitbox2[Attack.length];
        for (int i = 0; i < AttackHit.length; i++) {
            AttackHit[i] = new Hitbox2(personajeX, personajeY, 80, 80);
        }

        gemhit = new Hitbox[gem.length];
        for (int i = 0; i < gemhit.length; i++) {
            gemhit[i] = new Hitbox(gemx, 400, 38, 79);
        }

         gemhit2 = new Hitbox[gem2.length];
        for (int i = 0; i < gemhit2.length; i++) {
            gemhit2[i] = new Hitbox(gemx2, 500, 20, 40);
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

        Runhit = new Hitbox2[Attack_Boss.length];
        for (int i = 0; i < Runhit.length; i++) {
            Runhit[i] = new Hitbox2(Runx, 410, 166, 122);
        }

        Runhit2 = new Hitbox2[Attack_Boss.length];
        for (int i = 0; i < Runhit2.length; i++) {
            Runhit2[i] = new Hitbox2(Runx2, 410, 166, 122);
        }


        Extranet = new Hitbox[Extra.length];
        for (int i = 0; i < Extranet.length; i++) {
            Extranet[i] = new Hitbox(Extrax, 610, 68, 80);
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
            String Query = "SELECT Puntaje FROM M3N2 WHERE BINARY ID_User=?";
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
                        score = (segundos * 2) + bossScore;
                        ScoreNuevo = score;

                        //Parsear el score nuevo
                        String scoreNuevoString = String.valueOf(ScoreNuevo + (vidas * 100));

                        if (ScoreNuevo > ScoreAnterior) {
                            String QueryInsertar = "UPDATE M3N2 SET Puntaje=?, Fecha=?, Tiempo_Restante=? WHERE ID_User=?";
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
                        String QueryInsertar = "INSERT INTO M3N2 (ID_User, Puntaje, Fecha, Tiempo_Restante) VALUES (?,?, ?, ?)";
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
        Graphics gBuffer = bufferImage.getGraphics();
        Boss_Run2 = Math.min(Math.max(Boss_Run2, 2100), 2600);
        if (jumping || falling) {
            frameIndex4++;
            if (frameIndex4 >= Jumpanimation.length) {
                frameIndex4 = 0;
            }
        }

        // Verificar si slimexRelativo está en el límite izquierdo o derecho
        if (Boss_Run2 == 2100) {
            // Si está en el límite izquierdo, cambiar la dirección hacia la derecha
            movimientoDerecha = true;
       drawAttack_Boss(gBuffer);
        } else if (Boss_Run2 == 2600) {
            // Si está en el límite derecho, cambiar la dirección hacia la izquierda
            movimientoDerecha = false;
        
        }

        // Mover slimexRelativo automáticamente en la dirección correspondiente
        if (movimientoDerecha) {
            Boss_Run2 += velocidadMovimiento; // Mover a la derecha
        drawAttack_Boss(gBuffer);
        } else {
            Boss_Run2 -= velocidadMovimiento; // Mover a la izquierda
            drawAttack_Boss(gBuffer);
        }

        // Actualizar la posición de slimex basada en el desplazamiento del escenario
      
        Runx2 = Boss_Run2 + fondoX;


        //CESAR 
        if (!pausa) {
            personajeX = Math.min(Math.max(personajeX, 0), midFrame - personajeStatico.getWidth());

            if (keysPressed.contains(KeyEvent.VK_D)) {
                // Si el personaje ha alcanzado el midFrame y no ha superado la posición límite de 1500 en el eje X
                if (personajeX + personajeStatico.getWidth() >= midFrame) {

                    if (midFrame < 1024) {
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
                        bloquehitx14_0 -= 5;

                        midhit2x -= 5;
                        midhit2.setX(midhit2x);

                        obstaculox -= 5;
                        obstaculox1 -= 5;
                        obstaculox2 -= 5;
                        obstaculox4 -= 5;
                        obstaculox5 -= 5;
                        obstaculox6 -= 5;

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

                        bloquehit14_0.setX(bloquehitx14_0);

                        gemx -= 5;
                        gemx2-=5;
                        coinx -= 5;
                        coinx2 -= 5;
                        coinx3 -= 5;
                        coinx4 -= 5;
                        Extrax -= 5;

                    }

                }

            }

            // Actualizar la posición de las hitboxes del personaje y el obstáculo
            personajeHitbox.setX(personajeX);
            personajeHitbox.setY(personajeY);
            obstaculohit.setX(obstaculox);
            obstaculohit0.setX(obstaculox1);
            obstaculohit1.setX(obstaculox2);

            obstaculohit3.setX(obstaculox4);
            obstaculohit5.setX(obstaculox5);
            obstaculohit6.setX(obstaculox6);

            obstaculohit.setY(380);

            // Crear el doble búffer para el fondo
            gBuffer.drawImage(fondoImage, fondoX, 0, 3000, 768, this);

            drawBloque(gBuffer);

            boolean colision = false;
            boolean colisionb = false;
            if (keysPressed.contains(KeyEvent.VK_D)) {
                personajeX += 5; // Mover el personaje hacia la derecha
                if (runningAnimationHitboxes[frameIndex].intersects(obstaculohit0)) {
                    midFrame = 1024; // Revertir el movimiento si hay colisión
                    colision = true;
                }// Mover el personaje hacia la derecha
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
                if (!jumping && !falling) { // Solo dibujar el personaje corriendo si no está en estado de salto ni caída

                    drawPersonaje2(gBuffer);
                } else {
                    drawjump2(gBuffer);
                }
            } else if (keysPressed.contains(KeyEvent.VK_E)) { // Solo mover a la izquierda si no está en el límite izquierdo

                //AQUI PONER
                drawGolpe(gBuffer);

            } else {
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
            
            if (AttackHit[frameIndex28].intersects(gemhit2[frameIndex222])) {
               
               gemx2=Runx2;  
               vidaenemigo-=0.10;
                System.out.println(vidaenemigo+"restantes");
                bossScore += 100;
            }
            if (vidaenemigo <= 0.80) {
                Runx2=15000;
                gemx2=15000;
                drawGem(gBuffer);
                
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

                boolean sobreBloque14 = personajeY + 80 >= bloquehit14_0.getY()
                        && personajeY + 80 <= bloquehit14_0.getY() + fallSpeed
                        && personajeX + 80 > bloquehit14_0.getX()
                        && personajeX < bloquehit14_0.getX() + bloquehit14_0.getWidth();

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

                } else if (sobreBloque14) {
                    personajeY = bloquehit14_0.getY() - 80;

                    falling = false;

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

            if (personajeHitbox.intersects(obstaculohit) || personajeHitbox.intersects(obstaculohit1) || personajeHitbox.intersects(obstaculohit3) || personajeHitbox.intersects(obstaculohit5) || personajeHitbox.intersects(obstaculohit6) || personajeHitbox.intersects(Runhit2[frameIndex7])) {
                if (!inmunidadActivada) {
                    // Restar una vida y mostrar el mensaje de vidas restantes
                    vidas -= 0.05;

                    System.out.println("Vidas restantes: " + vidas);
                    if (vidas <= 0.80) {
                        // Detener el juego si las vidas llegan a cero
                        timer.stop();
                        reproductor.detener();
                        //MOSTRAR MENSAJE DE TIEMPO FINALIZADO
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

            
            // Verificar si se acabó el tiempo transcurrido
            if (tiempoTranscurrido <= 0) {
                // Detener el juego
                timer.stop();
                //cesar
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
                JOptionPane.showMessageDialog(null, "Felicidades a terminado el juego");
                Ganar ga = new Ganar();
                insertar();
                ga.setVisible(true);
                this.dispose();
                fading = true;
                fadeOpacity = 0;
                repaint();
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

            /// Dibujar las vidas
            drawDegradado(gBuffer);
            drawTime(gBuffer);
            drawScore(gBuffer);
             drawGem2(gBuffer);
            drawCoin(gBuffer);
            drawCoin2(gBuffer);
            drawCoin3(gBuffer);
            drawCoin4(gBuffer);
            drawPausa(gBuffer);
            drawSilencio(gBuffer);
            drawBotonP(gBuffer);
            drawvida(gBuffer);
            drawExtra(gBuffer);
            drawAttack_Boss(gBuffer);

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
    
    private void drawGem2(Graphics g) {
        if (frameIndex222 >= 0 && frameIndex222 < gem2.length) {

            g.drawImage(gem2[frameIndex222], gemx2, 500, 20, 40, null);

            gemhit2[frameIndex222].setX(gemx2);
            gemhit2[frameIndex222].setY(500);

            gemhit2[frameIndex222].drawHitbox(g);

        }

        frameIndex222++;

        if (frameIndex222 >= gem2.length) {
            frameIndex222 = 0;
        }

    }

    private void drawCoin(Graphics g) {
        if (frameindex10 >= 0 && frameindex10 < coin.length && coin[frameindex10] != null) {
            coinet[frameindex10].setX(coinx);
            coinet[frameindex10].setY(520);
            coinet[frameindex10].drawHitbox(g);

            if (personajeHitbox.intersects(coinet[frameindex10])) {
                // Agregar 15 puntos por 6 segundos == 90 puntos al puntaje cuando el usuario agarre esta moneda
                coinScore += 15;
                // Aqui se elimna la moneda si el personaje la toca
                coin[frameindex10] = null;
                System.out.println("1");
            } else {
                // Solo se muestra la moneda si el persoanje no a pasado sobre ella
                g.drawImage(coin[frameindex10], coinx, 520, 40, 65, null);
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
            coinet2[frameindex11].setY(205);
            coinet2[frameindex11].drawHitbox(g);

            if (personajeHitbox.intersects(coinet2[frameindex11])) {
                // Agregar 15 puntos por 6 segundos == 90 puntos al puntaje cuando el usuario agarre esta moneda
                coinScore += 15;
                // Aqui se elimna la moneda si el personaje la toca
                coin2[frameindex11] = null;
                System.out.println("1");
            } else {
                // Solo se muestra la moneda si el persoanje no a pasado sobre ella
                g.drawImage(coin2[frameindex11], coinx2, 205, 40, 65, null);
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
            coinet3[frameindex12].setY(200);
            coinet3[frameindex12].drawHitbox(g);

            if (personajeHitbox.intersects(coinet3[frameindex12])) {
                // Agregar 15 puntos por 6 segundos == 90 puntos al puntaje cuando el usuario agarre esta moneda
                coinScore += 15;
                // Aqui se elimna la moneda si el personaje la toca
                coin3[frameindex12] = null;
                System.out.println("1");
            } else {
                // Solo se muestra la moneda si el persoanje no a pasado sobre ella
                g.drawImage(coin3[frameindex12], coinx3, 200, 40, 65, null);

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
            coinet4[frameindex13].setY(500);
            coinet4[frameindex13].drawHitbox(g);

            if (personajeHitbox.intersects(coinet4[frameindex13])) {
                // Agregar 15 puntos por 6 segundos == 90 puntos al puntaje cuando el usuario agarre esta moneda
                coinScore += 15;
                // Aqui se elimna la moneda si el personaje la toca
                coin4[frameindex13] = null;
                System.out.println("1");
            } else {
                // Solo se muestra la moneda si el persoanje no a pasado sobre ella
                g.drawImage(coin4[frameindex13], coinx4, 500, 40, 65, null);

            }

            frameindex13++;

            if (frameindex13 >= coin4.length) {
                frameindex13 = 0;
            }
        }
    }

    private void drawExtra(Graphics g) {
        if (frameindex14 >= 0 && frameindex14 < Extra.length && Extra[frameindex14] != null) {
            Extranet[frameindex14].setX(Extrax);
            Extranet[frameindex14].setY(550);
            Extranet[frameindex14].drawHitbox(g);

            if (personajeHitbox.intersects(Extranet[frameindex14])) {

                // Aqui se elimna la moneda si el personaje la toca
                Extra[frameindex14] = null;
                System.out.println("1");
                vidas += 0.16;
            } else {
                // Solo se muestra la moneda si el persoanje no a pasado sobre ella
                g.drawImage(Extra[frameindex14], Extrax, 550, 68, 80, null);

            }

            frameindex14++;

            if (frameindex14 >= Extra.length) {
                frameindex14 = 0;
            }
        }
    }

    private void drawAttack_Boss(Graphics g) {

        // Verificar si el índice frameIndex está dentro del rango válido osea si esta del mismo tama;o del vector
        if (frameindex55 >= 0 && frameindex55 < Attack_Boss.length) {
            //pone a el personaje en su posicion actualizada
            g.drawImage(Attack_Boss[frameindex55], Runx2, 500, 172, 178, this);

           
            

            Runhit2[frameindex55].setX(Runx2);
            Runhit2[frameindex55].setY(570);

            Runhit2[frameindex55].drawHitbox(g);
           
        }

        frameindex55++;

        if (frameindex55 >= Attack_Boss.length) {
            frameindex55 = 0;
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

    private void drawGolpe(Graphics g) {

        // Verificar si el índice frameIndex está dentro del rango válido osea si esta del mismo tama;o del vector
        if (frameIndex28 >= 0 && frameIndex28 < Attack.length) {
            //pone a el personaje en su posicion actualizada
            g.drawImage(Attack[frameIndex28], personajeX, personajeY, 80, 80, this);

            // Va a ctualizando la posicion de la hitbox de correr
            AttackHit[frameIndex28].setX(personajeX);
            AttackHit[frameIndex28].setY(personajeY);

            // Dibujar la hitbox
            AttackHit[frameIndex28].drawHitbox(g);
        }

        frameIndex28++;

        if (frameIndex28 >= Attack.length) {
            frameIndex28 = 0;
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

        bloquehit14_0.drawHitbox(g);

        bloquehit.drawHitbox(g);
        bloquehit1.drawHitbox(g);
        bloquehit2.drawHitbox(g);
        bloquehit3.drawHitbox(g);
        obstaculohit.drawHitbox(g);
        obstaculohit0.drawHitbox(g);

        obstaculohit1.drawHitbox(g);
        obstaculohit3.drawHitbox(g);
        obstaculohit5.drawHitbox(g);
        obstaculohit6.drawHitbox(g);

        midhit2.drawHitbox(g);

    }
//CESAR

    private void drawvida(Graphics g) {
        //Vidax Extras
        if (vidas >= 6) {
            g.drawImage(extra1, vidax, 10, 295, 47, this);
        } else {

            if (vidas < 6 && vidas > 4.99) {
                g.drawImage(extra2, vidax, 10, 295, 47, this);
            } else {

                if (vidas < 5 && vidas > 3.99) {
                    g.drawImage(extra3, vidax, 10, 295, 47, this);
                } else {

                    if (vidas < 4 && vidas > 2.99) {
                        g.drawImage(extra4, vidax, 10, 295, 47, this);
                    } else {
                        //Si es igual a 3 entonces la imgen de la barra de vida 3 se mostrara
                        //Vidas normales
                        if (vidas < 3.00 && vidas > 2.50) {
                            g.drawImage(imageBarra1, vidax, 10, 295, 47, this);
                        } else {
                            if (vidas < 2.49 && vidas > 1.99) {
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
                }
            }
        }
    }

    //CESAR, este metodo sirve para pintar el boton de pausa, esto solo es visual porque es una imagen
    private void drawBotonP(Graphics g) {
        g.drawImage(imagePausa, 900, 10, this);

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

    private void drawDegradado(Graphics g) {
        if (degradado != null) {
            g.drawImage(degradado, 0, 0, null);
        }
    }

    //CESAR
    private void drawScore(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Pixel Operator 8 HB", Font.BOLD, 20));

        ///Convertir los miilisegundos a segundos
        int segundos = tiempoTranscurrido / 1000;
        score = (segundos * 2) + coinScore; 
        score = (segundos * 2) + bossScore; 
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

}
