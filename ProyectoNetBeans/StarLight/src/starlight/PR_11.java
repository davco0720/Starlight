package starlight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.HashSet;
import java.util.Set;

public class PR_11 extends JFrame implements ActionListener, KeyListener {

    //NUEVO CESAR
    //CESAR
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

    private BufferedImage fondoImage;
    private BufferedImage personajeStatico;
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

    private int frameIndex9 = 0;
    private int frameIndex8 = 0;
    private int frameIndex6 = 0;
    private int frameIndex7 = 0;

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
    private BufferedImage bloque;
    private BufferedImage bloque2;
    private int jumpSpeed = 10;
    private int fallSpeed = 7;
    private BufferedImage obstaculo;
    private int bloquex = 1760;
    private int bloquex2 = 2150;

    private int slimexRelativo = 1100;
    private boolean movimientoDerecha = true;
    private int velocidadMovimiento = 5;
    private int slimex = 1100;
    private int frameIndex4 = 0;
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

    int gemx = 2750;
    private Hitbox[] gemhit;

    int coinx = 328;
    private Hitbox[] coinet;

    int coinx2 = 845;
    private Hitbox[] coinet2;

    int coinx3 = 1165;
    private Hitbox[] coinet3;

    int coinx4 = 2230;
    private Hitbox[] coinet4;

    private Hitbox obstaculohit1;
    private Hitbox obstaculohit2;
    private Hitbox obstaculohit3;
    private Hitbox obstaculohit4;
    private Hitbox obstaculohit5;
    private Hitbox obstaculohit6;
    private Hitbox obstaculohit7;
    private int bloquehitx = 328;
    private int bloquehitx2 = 328;
    private int bloquehitx3 = 485;
    private int bloquehitx4 = 328;

    private Hitbox midhit2;
    private int midhit2x = 2450;

    int fadeOpacity = 0;
    boolean fading = false;

    private Hitbox[] slime2hit;
    private BufferedImage[] slime2;

    private int bloquehitx2_0 = 505;
    private int bloquehitx2_1 = 500;
    private int bloquehitx2_2 = 660;
    private int bloquehitx2_3 = 505;

    private int bloquehitx3_0 = 670;
    private int bloquehitx3_1 = 735;
    private int bloquehitx3_2 = 670;
    private int bloquehitx3_3 = 670;

    private int bloquehitx4_0 = 825;
    private int bloquehitx4_1 = 825;
    private int bloquehitx4_2 = 1400;
    private int bloquehitx4_3 = 825;

    private int bloquehitx5_0 = 883;
    private int bloquehitx5_1 = 883;
    private int bloquehitx5_2 = 1030;
    private int bloquehitx5_3 = 883;

    private int bloquehitx6_0 = 1123;
    private int bloquehitx6_1 = 1123;
    private int bloquehitx6_2 = 1260;
    private int bloquehitx6_3 = 1123;

    private int bloquehitx7_0 = 1400;
    private int bloquehitx7_1 = 1400;
    private int bloquehitx7_2 = 1580;
    private int bloquehitx7_3 = 1400;

    private int bloquehitx8_0 = 2550;
    private int bloquehitx8_1 = 2550;
    private int bloquehitx8_2 = 2995;
    private int bloquehitx8_3 = 2550;

    private int bloquehitx9_0 = 1760;
    private int bloquehitx9_1 = 1760;
    private int bloquehitx9_2 = 1900;
    private int bloquehitx9_3 = 1760;

    private int bloquehitx10_0 = 2150;
    private int bloquehitx10_1 = 2150;
    private int bloquehitx10_2 = 2290;
    private int bloquehitx10_3 = 2150;

    private double vidas = 3;
    private int obstaculox = 615;
    private int obstaculox2 = 817;
    private int obstaculox3 = 435;
    private int obstaculox4 = 490;
    private int obstaculox6 = 1410;
    private int obstaculox5 = 980;
    private int obstaculox7 = 900;
    private int obstaculox8 = 1590;
    private int salto = 150;
    private boolean jumpKeyReleased = true;
    private int initialY;

    public PR_11() {
        setSize(ANCHO_FRAME, ALTO_FRAME);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
            degradado = ImageIO.read(new File("src/Recursos/Degradado.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            fondoImage = ImageIO.read(new File("src/Fondo/Nivel1_1.png")); // ruta del fondo
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            bloque = ImageIO.read(new File("src/Fondo/Peldaño.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            bloque2 = ImageIO.read(new File("src/Fondo/Peldaño.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            personajeStatico = ImageIO.read(new File("src/PersonajePrincipal/1.png")); // ruta del personaje estático

        } catch (IOException ex) {
            ex.printStackTrace();
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

        slime2 = new BufferedImage[7];
        for (int i = 0; i < slime2.length; i++) {
            try {
                slime2[i] = ImageIO.read(new File("src/Enemigos/" + (i + 1) + ".png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        // Timer para el movimiento del fondo y la animación
        timer = new Timer(30, this); // Cambiado a 50 milisegundos para mayor rapidez en la animación
        timer.start(); // Iniciar el Timer para que el actionPerformed se ejecute
        //CESAR
        reproductor.iniciar();

        // Crear el BufferedImage para el doble búffer
        bufferImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);

        // Agregar el KeyListener al JFrame
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        // Crear la hitbox para el personaje estático
        personajeHitbox = new Hitbox2(personajeX, personajeY, 80, 80);

        bloquehit = new Hitbox(bloquehitx, 615, 155, 1);
        bloquehit1 = new Hitbox(bloquehitx2, 618, 1, 25);
        bloquehit2 = new Hitbox(bloquehitx3, 618, 1, 25);
        bloquehit3 = new Hitbox(bloquehitx4, 643, 155, 1);

        bloquehit2_0 = new Hitbox(bloquehitx2_0, 568, 155, 1);
        bloquehit2_1 = new Hitbox(bloquehitx2_1, 568, 1, 29);
        bloquehit2_2 = new Hitbox(bloquehitx2_2, 568, 1, 29);
        bloquehit2_3 = new Hitbox(bloquehitx2_3, 596, 155, 1);

        bloquehit3_0 = new Hitbox(bloquehitx3_0, 528, 65, 1);
        bloquehit3_1 = new Hitbox(bloquehitx3_1, 528, 1, 29);
        bloquehit3_2 = new Hitbox(bloquehitx3_2, 528, 1, 29);
        bloquehit3_3 = new Hitbox(bloquehitx3_3, 558, 65, 1);

        bloquehit4_0 = new Hitbox(bloquehitx4_0, 505, 575, 1);
        bloquehit4_1 = new Hitbox(bloquehitx4_1, 505, 1, 160);
        bloquehit4_2 = new Hitbox(bloquehitx4_2, 505, 1, 160);
        bloquehit4_3 = new Hitbox(bloquehitx4_3, 670, 575, 1);

        bloquehit5_0 = new Hitbox(bloquehitx5_0, 275, 150, 1);
        bloquehit5_1 = new Hitbox(bloquehitx5_1, 275, 1, 29);
        bloquehit5_2 = new Hitbox(bloquehitx5_2, 275, 1, 29);
        bloquehit5_3 = new Hitbox(bloquehitx5_3, 305, 150, 1);

        bloquehit6_0 = new Hitbox(bloquehitx6_0, 370, 140, 1);
        bloquehit6_1 = new Hitbox(bloquehitx6_1, 370, 1, 29);
        bloquehit6_2 = new Hitbox(bloquehitx6_2, 370, 1, 29);
        bloquehit6_3 = new Hitbox(bloquehitx6_3, 400, 140, 1);

        bloquehit7_0 = new Hitbox(bloquehitx7_0, 563, 180, 1);
        bloquehit7_1 = new Hitbox(bloquehitx7_1, 563, 1, 105);
        bloquehit7_2 = new Hitbox(bloquehitx7_2, 563, 1, 105);
        bloquehit7_3 = new Hitbox(bloquehitx7_3, 670, 180, 1);

        bloquehit8_0 = new Hitbox(bloquehitx8_0, 512, 440, 1);
        bloquehit8_1 = new Hitbox(bloquehitx8_1, 512, 1, 160);
        bloquehit8_2 = new Hitbox(bloquehitx8_2, 512, 1, 160);
        bloquehit8_3 = new Hitbox(bloquehitx8_3, 670, 440, 1);

        bloquehit9_0 = new Hitbox(bloquehitx9_0, 500, 140, 1);
        bloquehit9_1 = new Hitbox(bloquehitx9_1, 500, 1, 29);
        bloquehit9_2 = new Hitbox(bloquehitx9_2, 500, 1, 29);
        bloquehit9_3 = new Hitbox(bloquehitx9_3, 530, 140, 1);

        bloquehit10_0 = new Hitbox(bloquehitx10_0, 500, 140, 1);
        bloquehit10_1 = new Hitbox(bloquehitx10_1, 500, 1, 29);
        bloquehit10_2 = new Hitbox(bloquehitx10_2, 500, 1, 29);
        bloquehit10_3 = new Hitbox(bloquehitx10_3, 530, 140, 1);

        obstaculohit = new Hitbox(300, 655, 40, 1);
        obstaculohit1 = new Hitbox(817, 515, 1, 43);
        obstaculohit2 = new Hitbox(435, 606, 43, 1);
        obstaculohit3 = new Hitbox(490, 660, 320, 1);
        obstaculohit4 = new Hitbox(980, 250, 43, 1);
        obstaculohit5 = new Hitbox(1410, 530, 86, 1);
        obstaculohit6 = new Hitbox(900, 490, 60, 1);
        obstaculohit7 = new Hitbox(1590, 640, 1000, 1);

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
            coinet[i] = new Hitbox(coinx, 610, 40, 65);
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

        slime2hit = new Hitbox[slime2.length];
        for (int i = 0; i < slime2hit.length; i++) {
            slime2hit[i] = new Hitbox(slimex, 430, 80, 40);
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

        this.setLocationRelativeTo(null);
        this.setResizable(false);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        //CESAR 
        if (!pausa) {

            personajeX = Math.min(Math.max(personajeX, 0), midFrame - personajeStatico.getWidth());
            personajeY = Math.min(Math.max(personajeY, 0), getHeight() - personajeStatico.getHeight());
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

            if (keysPressed.contains(KeyEvent.VK_D) || keysPressed.contains(KeyEvent.VK_RIGHT)) {
                // Si el personaje ha alcanzado el midFrame y no ha superado la posición límite de 1500 en el eje X
                if (personajeX + personajeStatico.getWidth() >= midFrame) {

                    if (midFrame < 1024) {
                        fondoX -= 5;

                        bloquex -= 5;
                        bloquex2 -= 5;

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
                        obstaculox -= 5;
                        obstaculox2 -= 5;
                        obstaculox3 -= 5;
                        obstaculox4 -= 5;
                        obstaculox5 -= 5;
                        obstaculox6 -= 5;
                        obstaculox7 -= 5;
                        obstaculox8 -= 5;

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
            obstaculohit2.setX(obstaculox3);
            obstaculohit3.setX(obstaculox4);
            obstaculohit4.setX(obstaculox5);
            obstaculohit5.setX(obstaculox6);
            obstaculohit6.setX(obstaculox7);
            obstaculohit7.setX(obstaculox8);
            obstaculohit.setY(560);

            // Crear el doble búffer para el fondo
            Graphics gBuffer = bufferImage.getGraphics();
            gBuffer.drawImage(fondoImage, fondoX, 0, 3000, 768, this);

            drawBloque(gBuffer);

            boolean colision = false;

// Manejo del movimiento hacia la derecha
            if (keysPressed.contains(KeyEvent.VK_D) || keysPressed.contains(KeyEvent.VK_RIGHT)) {
                personajeX += 5; // Mover el personaje hacia la derecha
                if (runningAnimationHitboxes[frameIndex].intersects(midhit2)) {
                    midFrame = 1024; // Revertir el movimiento si hay colisión
                    colision = true;
                }
                if (runningAnimationHitboxes[frameIndex].intersects(bloquehit1) || runningAnimationHitboxes[frameIndex].intersects(bloquehit2_1) || runningAnimationHitboxes[frameIndex].intersects(bloquehit3_1) || runningAnimationHitboxes[frameIndex].intersects(bloquehit4_1) || runningAnimationHitboxes[frameIndex].intersects(bloquehit5_1) || runningAnimationHitboxes[frameIndex].intersects(bloquehit6_1) || runningAnimationHitboxes[frameIndex].intersects(bloquehit7_1) || runningAnimationHitboxes[frameIndex].intersects(bloquehit8_1) || runningAnimationHitboxes[frameIndex].intersects(bloquehit9_1) || runningAnimationHitboxes[frameIndex].intersects(bloquehit10_1)) {
                    personajeX -= 5; // Revertir el movimiento si hay colisión
                    colision = true;
                }
                //METODO NUEVO
                if (!jumping && !falling) { // Solo dibujar el personaje corriendo si no está en estado de salto ni caída

                    drawPersonaje(gBuffer);
                } else {
                    drawjump(gBuffer);
                }

            } // Manejo del movimiento hacia la izquierda
            else if (keysPressed.contains(KeyEvent.VK_A) || keysPressed.contains(KeyEvent.VK_LEFT) && personajeX > 0) { // Solo mover a la izquierda si no está en el límite izquierdo
                personajeX -= 5; // Mover el personaje hacia la izquierda
                if (runningAnimationHitboxes[frameIndex].intersects(bloquehit2) || runningAnimationHitboxes[frameIndex].intersects(bloquehit2_2) || runningAnimationHitboxes[frameIndex].intersects(bloquehit3_2) || runningAnimationHitboxes[frameIndex].intersects(bloquehit4_2) || runningAnimationHitboxes[frameIndex].intersects(bloquehit5_2) || runningAnimationHitboxes[frameIndex].intersects(bloquehit6_2) || runningAnimationHitboxes[frameIndex].intersects(bloquehit7_2) || runningAnimationHitboxes[frameIndex].intersects(bloquehit8_2) || runningAnimationHitboxes[frameIndex].intersects(bloquehit9_2) || runningAnimationHitboxes[frameIndex].intersects(bloquehit10_2)) {
                    personajeX += 5; // Revertir el movimiento si hay colisión
                    colision = true;
                }
                //NUEVO METODO
                if (!jumping && !falling) {
                    // Solo dibujar el personaje corriendo si no está en estado de salto ni caída
                    drawPersonaje2(gBuffer);//chechita
                } else {
                    drawjump2(gBuffer); //chechita
                }

            } // Manejo del salto y caída
            else if (jumping || falling) {
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

                if (personajeHitbox.intersects(bloquehit3) || personajeHitbox.intersects(bloquehit2_3) || personajeHitbox.intersects(bloquehit3_3) || personajeHitbox.intersects(bloquehit4_3) || personajeHitbox.intersects(bloquehit5_3) || personajeHitbox.intersects(bloquehit6_3) || personajeHitbox.intersects(bloquehit7_3) || personajeHitbox.intersects(bloquehit8_3) || personajeHitbox.intersects(bloquehit9_3) || personajeHitbox.intersects(bloquehit10_3)) {
                    if (keysPressed.contains(KeyEvent.VK_W) || keysPressed.contains(KeyEvent.VK_UP) && jumpKeyReleased) {
                        jumping = true; // Activar el salto
                        jumpKeyReleased = false; // Indicar que la tecla de salto no está liberada
                        initialY = personajeY; // Guardar la posición inicial del salto
                    }
                }
            }

            // Si el personaje está saltando, actualizar su posición vertical
            if (jumping) {

                personajeY -= jumpSpeed;
                // Usar la variable salto para modificar la posición vertical
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

                if (sobreBloque) {
                    personajeY = bloquehit.getY() - 80;

                    falling = false;
                    frameIndex4 = 0;
                } else if (sobreBloque2) {
                    personajeY = bloquehit2_0.getY() - 80;

                    falling = false;
                    frameIndex4 = 0;
                } else if (sobreBloque3) {
                    personajeY = bloquehit3_0.getY() - 80;

                    falling = false;
                    frameIndex4 = 0;
                } else if (sobreBloque4) {
                    personajeY = bloquehit4_0.getY() - 80;

                    falling = false;
                    frameIndex4 = 0;
                } else if (sobreBloque5) {
                    personajeY = bloquehit5_0.getY() - 80;

                    falling = false;
                    frameIndex4 = 0;
                } else if (sobreBloque6) {
                    personajeY = bloquehit6_0.getY() - 80;

                    falling = false;
                    frameIndex4 = 0;
                } else if (sobreBloque7) {
                    personajeY = bloquehit7_0.getY() - 80;

                    falling = false;
                    frameIndex4 = 0;
                } else if (sobreBloque8) {
                    personajeY = bloquehit8_0.getY() - 80;
                    midFrame = 1024;
                    falling = false;
                    frameIndex4 = 0;
                } else if (sobreBloque9) {
                    personajeY = bloquehit9_0.getY() - 80;

                    falling = false;
                    frameIndex4 = 0;
                } else if (sobreBloque10) {
                    personajeY = bloquehit10_0.getY() - 80;

                    falling = false;
                    frameIndex4 = 0;
                } else {
                    personajeY += fallSpeed; // Caída
                    if (personajeY >= 600) { // Volver a la posición original
                        personajeY = 600;
                        falling = false; // Detener la caída
                        frameIndex4 = 0;
                    }
                }
            }

            // Verificar la colisión entre el personaje y el obstáculo
            boolean inmunidadActivada = false;
            long tiempoInicioInmunidad = 0;
            long duracionInmunidad = 3000; // 3 segundos en milisegundos

            if (personajeHitbox.intersects(obstaculohit) || personajeHitbox.intersects(obstaculohit1) || personajeHitbox.intersects(obstaculohit2) || personajeHitbox.intersects(obstaculohit3) || personajeHitbox.intersects(obstaculohit4) || personajeHitbox.intersects(obstaculohit5) || personajeHitbox.intersects(obstaculohit6) || personajeHitbox.intersects(obstaculohit7) || personajeHitbox.intersects(slime2hit[frameIndex3])) {
                if (!inmunidadActivada) {
                    // Restar una vida y mostrar el mensaje de vidas restantes
                    vidas -= 0.05;

                    System.out.println("Vidas restantes: " + vidas);
                    if (vidas <= 0.80) {
                        // Detener el juego si las vidas llegan a cero
                        timer.stop();
                        //CESAR
                        reproductor.detener();
                        //MOSTRAR UN MENSAJE DE PERSONAJE MUERTO
                        Mensaje13 msj = new Mensaje13(this, true);
                        msj.setVisible(true);
                        PERDER p = new PERDER();
                        p.setVisible(true);
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
                PERDER p = new PERDER();
                p.setVisible(true);

            }

            if (personajeHitbox.intersects(gemhit[frameIndex2])) {
                timer.stop();
                fading = true;
                fadeOpacity = 0;
                repaint();
                //MENSAJE DE QUE PASÓ EL NIVEL 1
                Mensaje15 msj = new Mensaje15(this, true);
                msj.setVisible(true);
                //Cesar
                reproductor.detener();
                PR_12 n2 = new PR_12();
                n2.setVisible(true);
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

            // Mostrar el doble búffer en la ventana
            Graphics g = getGraphics();
            g.drawImage(bufferImage, 0, 0, null);

        }
        //FIN CESAR
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

    private void drawCoin(Graphics g) {
        if (frameIndex9 >= 0 && frameIndex9 < coin.length && coin[frameIndex9] != null) {
            coinet[frameIndex9].setX(coinx);
            coinet[frameIndex9].setY(550);
            coinet[frameIndex9].drawHitbox(g);

            if (personajeHitbox.intersects(coinet[frameIndex9])) {
                //CESAR
                // Agregar 15 puntos por 6 segundos == 90 puntos al puntaje cuando el usuario agarre esta moneda
                coinScore += 15;
                // Aqui se elimna la moneda si el personaje la toca
                coin[frameIndex9] = null;

            } else {
                // Solo se muestra la moneda si el persoanje no a pasado sobre ella
                g.drawImage(coin[frameIndex9], coinx, 550, 40, 65, null);
            }

            frameIndex9++;

            if (frameIndex9 >= coin.length) {
                frameIndex9 = 0;
            }
        }
    }

    private void drawCoin2(Graphics g) {
        if (frameIndex8 >= 0 && frameIndex8 < coin2.length && coin2[frameIndex8] != null) {
            coinet2[frameIndex8].setX(coinx2);
            coinet2[frameIndex8].setY(440);
            coinet2[frameIndex8].drawHitbox(g);

            if (personajeHitbox.intersects(coinet2[frameIndex8])) {
                //CESAR
                // Agregar 15 puntos por 6 segundos == 90 puntos al puntaje cuando el usuario agarre esta moneda
                coinScore += 15;
                // Aqui se elimna la moneda si el personaje la toca
                coin2[frameIndex8] = null;
            } else {
                // Solo se muestra la moneda si el persoanje no a pasado sobre ella
                g.drawImage(coin2[frameIndex8], coinx2, 440, 40, 65, null);
            }

            frameIndex8++;

            if (frameIndex8 >= coin2.length) {
                frameIndex8 = 0;
            }
        }
    }

    private void drawCoin3(Graphics g) {
        if (frameIndex6 >= 0 && frameIndex6 < coin3.length && coin3[frameIndex6] != null) {
            coinet3[frameIndex6].setX(coinx3);
            coinet3[frameIndex6].setY(295);
            coinet3[frameIndex6].drawHitbox(g);

            if (personajeHitbox.intersects(coinet3[frameIndex6])) {
                //CESAR
                // Agregar 15 puntos por 6 segundos == 90 puntos al puntaje cuando el usuario agarre esta moneda
                coinScore += 15;
                // Aqui se elimna la moneda si el personaje la toca
                coin3[frameIndex6] = null;
            } else {
                // Solo se muestra la moneda si el persoanje no a pasado sobre ella
                g.drawImage(coin3[frameIndex6], coinx3, 295, 40, 65, null);
            }

            frameIndex6++;

            if (frameIndex6 >= coin3.length) {
                frameIndex6 = 0;
            }
        }
    }

    private void drawCoin4(Graphics g) {
        if (frameIndex7 >= 0 && frameIndex7 < coin4.length && coin4[frameIndex7] != null) {
            coinet4[frameIndex7].setX(coinx4);
            coinet4[frameIndex7].setY(450);
            coinet4[frameIndex7].drawHitbox(g);

            if (personajeHitbox.intersects(coinet4[frameIndex7])) {
                //CESAR
                // Agregar 15 puntos por 6 segundos == 90 puntos al puntaje cuando el usuario agarre esta moneda
                coinScore += 15;
                // Aqui se elimna la moneda si el personaje la toca
                coin4[frameIndex7] = null;
            } else {
                // Solo se muestra la moneda si el persoanje no a pasado sobre ella
                g.drawImage(coin4[frameIndex7], coinx4, 450, 40, 65, null);
            }

            frameIndex7++;

            if (frameIndex7 >= coin4.length) {
                frameIndex7 = 0;
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

    private void drawSlime(Graphics g) {
        if (frameIndex3 >= 0 && frameIndex3 < slime2.length) {

            g.drawImage(slime2[frameIndex3], slimex, 470, 80, 40, null);

            slime2hit[frameIndex3].setX(slimex);
            slime2hit[frameIndex3].setY(470);

            slime2hit[frameIndex3].drawHitbox(g);

        }

        frameIndex3++;

        if (frameIndex3 >= slime2.length) {
            frameIndex3 = 0;
        }

    }

    //CESAR, este metodo sirve para pintar el boton de pausa, esto solo es visual porque es una imagen
    private void drawBotonP(Graphics g) {
        g.drawImage(imagePausa, 900, 10, this);

    }

    private void drawBloque(Graphics g) {

        g.drawImage(bloque, bloquex, 500, 142, 32, this);
        g.drawImage(bloque2, bloquex2, 500, 142, 32, this);

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

        bloquehit.drawHitbox(g);
        bloquehit1.drawHitbox(g);
        bloquehit2.drawHitbox(g);
        bloquehit3.drawHitbox(g);
        obstaculohit.drawHitbox(g);

        obstaculohit1.drawHitbox(g);
        obstaculohit2.drawHitbox(g);
        obstaculohit3.drawHitbox(g);
        obstaculohit4.drawHitbox(g);
        obstaculohit5.drawHitbox(g);
        obstaculohit6.drawHitbox(g);
        obstaculohit7.drawHitbox(g);

        midhit2.drawHitbox(g);

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
