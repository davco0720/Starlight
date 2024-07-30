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

public class Supervivencia extends JFrame implements ActionListener, KeyListener {

    private BufferedImage fondoImage;
    private BufferedImage personajeStatico;
    private BufferedImage personajeStatico2;
    private BufferedImage[] runningAnimation;
    private BufferedImage[] runningAnimation_reverse;
    private BufferedImage[] gem;
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
    private boolean jumping = false;
    private boolean falling = false;
    private int midFrame = 600;
    private Set<Integer> keysPressed = new HashSet<>();
    private Hitbox2 personajeHitbox;
    private Hitbox2 personajeStaticoHitbox;
    private Hitbox2[] runningAnimationHitboxes;
    private Hitbox2[] runningAnimationHitboxes_reverse;
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
    private Hitbox bloquehit15_0;

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

    private Hitbox bloquehit14_1;
    private Hitbox bloquehit14_2;
    private Hitbox bloquehit14_3;

    private Hitbox bloquehit15_1;
    private Hitbox bloquehit15_2;
    private Hitbox bloquehit15_3;

    int gemx = 2900;
    private Hitbox[] gemhit;

    private Hitbox obstaculohit1;
    private Hitbox obstaculohit3;
    private Hitbox obstaculohit5;
    private Hitbox obstaculohit6;
    private int bloquehitx = 395;
    private int bloquehitx2 = 395;
    private int bloquehitx3 = 620;
    private int bloquehitx4 = 395;

    int fadeOpacity = 0;
    boolean fading = false;

    private int bloquehitx2_0 = 650;
    private int bloquehitx2_1 = 650;
    private int bloquehitx2_2 = 980;
    private int bloquehitx2_3 = 650;

    private int bloquehitx3_0 = 922;
    private int bloquehitx3_1 = 922;
    private int bloquehitx3_2 = 1050;
    private int bloquehitx3_3 = 922;

    private int bloquehitx4_0 = 1070;
    private int bloquehitx4_1 = 1070;
    private int bloquehitx4_2 = 1400;
    private int bloquehitx4_3 = 1070;

    private int bloquehitx5_0 = 1100;
    private int bloquehitx5_1 = 1100;
    private int bloquehitx5_2 = 1435;
    private int bloquehitx5_3 = 1100;

    private int bloquehitx6_0 = 1105;
    private int bloquehitx6_1 = 1105;
    private int bloquehitx6_2 = 1165;
    private int bloquehitx6_3 = 1105;

    private int bloquehitx7_0 = 1440;
    private int bloquehitx7_1 = 1440;
    private int bloquehitx7_2 = 1660;
    private int bloquehitx7_3 = 1440;

    private int bloquehitx8_0 = 2555;
    private int bloquehitx8_1 = 2555;
    private int bloquehitx8_2 = 2610; //Este es el penultimo bloque
    private int bloquehitx8_3 = 2555;

    private int bloquehitx9_0 = 1710;
    private int bloquehitx9_1 = 1710;
    private int bloquehitx9_2 = 2040;
    private int bloquehitx9_3 = 1710;

    private int bloquehitx10_0 = 1725;
    private int bloquehitx10_1 = 1725;
    private int bloquehitx10_2 = 1940;
    private int bloquehitx10_3 = 1725;

    private int bloquehitx11_0 = 1510;
    private int bloquehitx11_1 = 1510;
    private int bloquehitx11_2 = 1570; //este es el bloque 8
    private int bloquehitx11_3 = 1510;

    private int bloquehitx12_0 = 1962;
    private int bloquehitx12_1 = 1962;
    private int bloquehitx12_2 = 2980;
    private int bloquehitx12_3 = 1962;

    private int bloquehitx13_0 = 2325;
    private int bloquehitx13_1 = 2325;
    private int bloquehitx13_2 = 2385;
    private int bloquehitx13_3 = 2325;

    private int bloquehitx14_0 = 1940;
    private int bloquehitx14_1 = 1940; //Este es el tunel
    private int bloquehitx14_2 = 2980;
    private int bloquehitx14_3 = 1940;

    private int bloquehitx15_0 = 2775;
    private int bloquehitx15_1 = 2775;
    private int bloquehitx15_2 = 2835;
    private int bloquehitx15_3 = 2775;

    private int vidas = 1;
    private int obstaculox = 680;
    private int obstaculox2 = 1075;
    private int obstaculox4 = 1945; //Pincho_largo_1
    private int obstaculox5 = 2410;
    private int obstaculox6 = 2635;

    private int tiempoTranscurrido = 0;
    private int salto = 150;
    private boolean jumpKeyReleased = true;
    private int initialY;

    public Supervivencia() {

        setSize(ANCHO_FRAME, ALTO_FRAME);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            fondoImage = ImageIO.read(new File("src/Recursos/Fondo.jpg")); // ruta del fondo
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            personajeStatico = ImageIO.read(new File("src/PersonajePrincipal/1.png")); // ruta del personaje estático
            personajeStaticoHitbox = new Hitbox2(personajeX, personajeY, 80, 80);
        } catch (IOException ex) {
            ex.printStackTrace();
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

        runningAnimation_reverse = new BufferedImage[8];
        for (int i = 0; i < runningAnimation_reverse.length; i++) {
            try {
                runningAnimation_reverse[i] = ImageIO.read(new File("src/PersonajePrincipal/Run_reverse/" + (i + 1) + ".png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        gem = new BufferedImage[7];
        for (int i = 0; i < gem.length; i++) {
            try {
                gem[i] = ImageIO.read(new File("src/GEM/" + (i + 1) + ".png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        // Timer para el movimiento del fondo y la animación
        timer = new Timer(30, this); // Cambiado a 50 milisegundos para mayor rapidez en la animación
        timer.start(); // Iniciar el Timer para que el actionPerformed se ejecute

        // Crear el BufferedImage para el doble búffer
        bufferImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);

        // Agregar el KeyListener al JFrame
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        // Crear la hitbox para el personaje estático
        personajeHitbox = new Hitbox2(personajeX, personajeY, 80, 80);

        bloquehit = new Hitbox(bloquehitx, 620, 225, 1);
        bloquehit1 = new Hitbox(bloquehitx2, 620, 1, 50);
        bloquehit2 = new Hitbox(bloquehitx3, 620, 1, 50);
        bloquehit3 = new Hitbox(bloquehitx4, 670, 225, 1);

        bloquehit2_0 = new Hitbox(bloquehitx2_0, 555, 330, 1);
        bloquehit2_1 = new Hitbox(bloquehitx2_1, 555, 1, 50);
        bloquehit2_2 = new Hitbox(bloquehitx2_2, 555, 1, 50);
        bloquehit2_3 = new Hitbox(bloquehitx2_3, 605, 330, 1);

        bloquehit3_0 = new Hitbox(bloquehitx3_0, 0, 130, 1);
        bloquehit3_1 = new Hitbox(bloquehitx3_1, 0, 1, 366);
        bloquehit3_2 = new Hitbox(bloquehitx3_2, 0, 1, 366);
        bloquehit3_3 = new Hitbox(bloquehitx3_3, 365, 130, 1);

        bloquehit4_0 = new Hitbox(bloquehitx4_0, 555, 330, 1);
        bloquehit4_1 = new Hitbox(bloquehitx4_1, 555, 1, 50);
        bloquehit4_2 = new Hitbox(bloquehitx4_2, 555, 1, 50);
        bloquehit4_3 = new Hitbox(bloquehitx4_3, 605, 330, 1);

        bloquehit5_0 = new Hitbox(bloquehitx5_0, 240, 335, 1);
        bloquehit5_1 = new Hitbox(bloquehitx5_1, 240, 1, 50);
        bloquehit5_2 = new Hitbox(bloquehitx5_2, 240, 1, 50);
        bloquehit5_3 = new Hitbox(bloquehitx5_3, 290, 335, 1);

        bloquehit6_0 = new Hitbox(bloquehitx6_0, 130, 60, 1);
        bloquehit6_1 = new Hitbox(bloquehitx6_1, 130, 1, 50);
        bloquehit6_2 = new Hitbox(bloquehitx6_2, 130, 1, 50);
        bloquehit6_3 = new Hitbox(bloquehitx6_3, 180, 60, 1);

        bloquehit7_0 = new Hitbox(bloquehitx7_0, 445, 220, 1);
        bloquehit7_1 = new Hitbox(bloquehitx7_1, 445, 1, 50);
        bloquehit7_2 = new Hitbox(bloquehitx7_2, 445, 1, 50);
        bloquehit7_3 = new Hitbox(bloquehitx7_3, 495, 220, 1);

        bloquehit8_0 = new Hitbox(bloquehitx8_0, 540, 60, 1);
        bloquehit8_1 = new Hitbox(bloquehitx8_1, 540, 1, 50);
        bloquehit8_2 = new Hitbox(bloquehitx8_2, 540, 1, 50); //Penultimi Bloque
        bloquehit8_3 = new Hitbox(bloquehitx8_3, 590, 60, 1);

        bloquehit9_0 = new Hitbox(bloquehitx9_0, 550, 335, 1);
        bloquehit9_1 = new Hitbox(bloquehitx9_1, 550, 1, 50);
        bloquehit9_2 = new Hitbox(bloquehitx9_2, 550, 1, 50);
        bloquehit9_3 = new Hitbox(bloquehitx9_3, 600, 335, 1);

        bloquehit10_0 = new Hitbox(bloquehitx10_0, 285, 220, 1);
        bloquehit10_1 = new Hitbox(bloquehitx10_1, 285, 1, 50);
        bloquehit10_2 = new Hitbox(bloquehitx10_2, 285, 1, 50);
        bloquehit10_3 = new Hitbox(bloquehitx10_3, 335, 220, 1);

        bloquehit11_0 = new Hitbox(bloquehitx11_0, 245, 60, 1);
        bloquehit11_1 = new Hitbox(bloquehitx11_1, 245, 1, 50); //Bloque 8
        bloquehit11_2 = new Hitbox(bloquehitx11_2, 245, 1, 50);
        bloquehit11_3 = new Hitbox(bloquehitx11_3, 295, 60, 1);

        bloquehit12_0 = new Hitbox(bloquehitx12_0, 0, 1038, 1);
        bloquehit12_1 = new Hitbox(bloquehitx12_1, 0, 1, 386);
        bloquehit12_2 = new Hitbox(bloquehitx12_2, 0, 1, 386);
        bloquehit12_3 = new Hitbox(bloquehitx12_3, 384, 1038, 1);

        bloquehit13_0 = new Hitbox(bloquehitx13_0, 540, 60, 1);
        bloquehit13_1 = new Hitbox(bloquehitx13_1, 540, 1, 50);
        bloquehit13_2 = new Hitbox(bloquehitx13_2, 540, 1, 50);
        bloquehit13_3 = new Hitbox(bloquehitx13_3, 590, 60, 1);

        bloquehit14_0 = new Hitbox(bloquehitx14_0, 605, 1062, 1);
        bloquehit14_1 = new Hitbox(bloquehitx14_1, 605, 1, 116); //tunel
        bloquehit14_2 = new Hitbox(bloquehitx14_2, 605, 1, 116);
        bloquehit14_3 = new Hitbox(bloquehitx14_3, 712, 1062, 1);

        bloquehit15_0 = new Hitbox(bloquehitx15_0, 540, 60, 1);
        bloquehit15_1 = new Hitbox(bloquehitx15_1, 540, 1, 50);
        bloquehit15_2 = new Hitbox(bloquehitx15_2, 540, 1, 50);
        bloquehit15_3 = new Hitbox(bloquehitx15_3, 590, 60, 1);

        obstaculohit = new Hitbox(2245, 436, 1145, 1);
        obstaculohit1 = new Hitbox(430, 0, 1, 350);
        obstaculohit3 = new Hitbox(435, 70, 1, 195);
        obstaculohit5 = new Hitbox(575, 575, 122, 1);
        obstaculohit6 = new Hitbox(575, 575, 122, 1);

        // Crear hitboxes para la animación de correr
        runningAnimationHitboxes = new Hitbox2[runningAnimation.length];
        for (int i = 0; i < runningAnimationHitboxes.length; i++) {
            runningAnimationHitboxes[i] = new Hitbox2(personajeX, personajeY, 80, 80);
        }

        runningAnimationHitboxes_reverse = new Hitbox2[runningAnimation_reverse.length];
        for (int i = 0; i < runningAnimationHitboxes_reverse.length; i++) {
            runningAnimationHitboxes_reverse[i] = new Hitbox2(personajeX, personajeY, 80, 80);
        }
        gemhit = new Hitbox[gem.length];
        for (int i = 0; i < gemhit.length; i++) {
            gemhit[i] = new Hitbox(gemx, 590, 80, 80);
        }
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        personajeX = Math.min(Math.max(personajeX, 0), midFrame - personajeStatico.getWidth());
        personajeY = Math.min(Math.max(personajeY, 0), getHeight() - personajeStatico.getHeight());

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
                    bloquehitx15_0 -= 5;
                    obstaculox -= 5;
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

                    bloquehitx14_1 -= 5;
                    bloquehitx14_2 -= 5;
                    bloquehitx14_3 -= 5;
                    bloquehit14_0.setX(bloquehitx14_0);
                    bloquehit14_1.setX(bloquehitx14_1);
                    bloquehit14_2.setX(bloquehitx14_2);
                    bloquehit14_3.setX(bloquehitx14_3);

                    bloquehitx15_1 -= 5;
                    bloquehitx15_2 -= 5;
                    bloquehitx15_3 -= 5;
                    bloquehit15_0.setX(bloquehitx15_0);
                    bloquehit15_1.setX(bloquehitx15_1);
                    bloquehit15_2.setX(bloquehitx15_2);
                    bloquehit15_3.setX(bloquehitx15_3);

                    gemx -= 5;

                }

            }

        }

        // Actualizar la posición de las hitboxes del personaje y el obstáculo
        personajeHitbox.setX(personajeX);
        personajeHitbox.setY(personajeY);
        obstaculohit.setX(obstaculox);
        obstaculohit1.setX(obstaculox2);

        obstaculohit3.setX(obstaculox4);
        obstaculohit5.setX(obstaculox5);
        obstaculohit6.setX(obstaculox6);

        obstaculohit.setY(649);

        // Crear el doble búffer para el fondo
        Graphics gBuffer = bufferImage.getGraphics();
        gBuffer.drawImage(fondoImage, fondoX, 0, 3000, 768, this);

        drawBloque(gBuffer);

        boolean colision = false;
        if (keysPressed.contains(KeyEvent.VK_D)) {
            personajeX += 5; // Mover el personaje hacia la derecha
            if (runningAnimationHitboxes[frameIndex].intersects(bloquehit1) || runningAnimationHitboxes_reverse[frameIndex].intersects(bloquehit1) || runningAnimationHitboxes[frameIndex].intersects(bloquehit2_1) || runningAnimationHitboxes[frameIndex].intersects(bloquehit3_1) || runningAnimationHitboxes[frameIndex].intersects(bloquehit4_1) || runningAnimationHitboxes[frameIndex].intersects(bloquehit5_1) || runningAnimationHitboxes[frameIndex].intersects(bloquehit6_1) || runningAnimationHitboxes[frameIndex].intersects(bloquehit7_1) || runningAnimationHitboxes[frameIndex].intersects(bloquehit8_1) || runningAnimationHitboxes[frameIndex].intersects(bloquehit9_1) || runningAnimationHitboxes[frameIndex].intersects(bloquehit10_1) || runningAnimationHitboxes[frameIndex].intersects(bloquehit11_1) || runningAnimationHitboxes[frameIndex].intersects(bloquehit12_1) || runningAnimationHitboxes[frameIndex].intersects(bloquehit13_1) || runningAnimationHitboxes[frameIndex].intersects(bloquehit14_1) || runningAnimationHitboxes[frameIndex].intersects(bloquehit15_1)) {
                personajeX -= 5; // Revertir el movimiento si hay colisión 
                colision = true;
            }

            drawPersonaje(gBuffer);
        } else if (keysPressed.contains(KeyEvent.VK_A) && personajeX > 0) { // Solo mover a la izquierda si no está en el límite izquierdo
            personajeX -= 5; // Mover el personaje hacia la izquierda
            if (runningAnimationHitboxes[frameIndex].intersects(bloquehit2) || runningAnimationHitboxes[frameIndex].intersects(bloquehit2_2) || runningAnimationHitboxes[frameIndex].intersects(bloquehit3_2) || runningAnimationHitboxes[frameIndex].intersects(bloquehit4_2) || runningAnimationHitboxes[frameIndex].intersects(bloquehit5_2) || runningAnimationHitboxes[frameIndex].intersects(bloquehit6_2) || runningAnimationHitboxes[frameIndex].intersects(bloquehit7_2) || runningAnimationHitboxes[frameIndex].intersects(bloquehit8_2) || runningAnimationHitboxes[frameIndex].intersects(bloquehit9_2) || runningAnimationHitboxes[frameIndex].intersects(bloquehit10_2) || runningAnimationHitboxes[frameIndex].intersects(bloquehit11_2) || runningAnimationHitboxes[frameIndex].intersects(bloquehit12_2) || runningAnimationHitboxes[frameIndex].intersects(bloquehit13_2) || runningAnimationHitboxes[frameIndex].intersects(bloquehit14_2) || runningAnimationHitboxes[frameIndex].intersects(bloquehit15_2)) {
                personajeX += 5; // Revertir el movimiento si hay colisión 
                colision = true;
            }
            drawPersonaje(gBuffer);
        } else {
            gBuffer.drawImage(personajeStatico, personajeX, personajeY, 80, 80, this);
            gBuffer.drawImage(personajeStatico2, personajeX, personajeY, 80, 80, this);
            personajeStaticoHitbox.setX(personajeX);
            personajeStaticoHitbox.setY(personajeY);
            personajeStaticoHitbox.drawHitbox(gBuffer);

            if (!jumping && personajeHitbox.intersects(bloquehit3) || !jumping && personajeHitbox.intersects(bloquehit2_3) || !jumping && personajeHitbox.intersects(bloquehit3_3) || !jumping && personajeHitbox.intersects(bloquehit4_3) || !jumping && personajeHitbox.intersects(bloquehit5_3) || !jumping && personajeHitbox.intersects(bloquehit6_3) || !jumping && personajeHitbox.intersects(bloquehit7_3) || !jumping && personajeHitbox.intersects(bloquehit8_3) || !jumping && personajeHitbox.intersects(bloquehit9_3) || !jumping && personajeHitbox.intersects(bloquehit10_3) || !jumping && personajeHitbox.intersects(bloquehit11_3) || !jumping && personajeHitbox.intersects(bloquehit12_3) || !jumping && personajeHitbox.intersects(bloquehit13_3) || !jumping && personajeHitbox.intersects(bloquehit14_3) || !jumping && personajeHitbox.intersects(bloquehit15_3)) {
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

            boolean sobreBloque14 = personajeY + 80 >= bloquehit14_0.getY()
                    && personajeY + 80 <= bloquehit14_0.getY() + fallSpeed
                    && personajeX + 80 > bloquehit14_0.getX()
                    && personajeX < bloquehit14_0.getX() + bloquehit14_0.getWidth();

            boolean sobreBloque15 = personajeY + 80 >= bloquehit15_0.getY()
                    && personajeY + 80 <= bloquehit15_0.getY() + fallSpeed
                    && personajeX + 80 > bloquehit15_0.getX()
                    && personajeX < bloquehit15_0.getX() + bloquehit15_0.getWidth();

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

            } else if (sobreBloque15) {
                personajeY = bloquehit15_0.getY() - 80;

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

        if (personajeHitbox.intersects(obstaculohit) || personajeHitbox.intersects(obstaculohit1) || personajeHitbox.intersects(obstaculohit3) || personajeHitbox.intersects(obstaculohit5) || personajeHitbox.intersects(obstaculohit6)) {
            if (!inmunidadActivada) {
                // Restar una vida y mostrar el mensaje de vidas restantes
                vidas--;
                System.out.println("Vidas restantes: " + vidas);
                if (vidas <= 0) {
                    // Detener el juego si las vidas llegan a cero
                    timer.stop();
                    JOptionPane.showMessageDialog(this, "El personaje ha muerto");
                    Login log = new Login();
                    log.setVisible(true);
                    this.dispose();
                } else {
                    // Activar la inmunidad temporal y guardar el tiempo de inicio
                    inmunidadActivada = true;
                    tiempoInicioInmunidad = System.currentTimeMillis();
                }
            }
        }

        if (personajeHitbox.intersects(gemhit[frameIndex2])) {
            timer.stop();
            fading = true;
            fadeOpacity = 0;
            repaint();
            JOptionPane.showMessageDialog(null, "A PASADO EL NIVEL 1");
        }

        // Verificar si la inmunidad está activada y si han pasado los 3 segundos
        if (inmunidadActivada) {
            long tiempoActual = System.currentTimeMillis();
            if (tiempoActual - tiempoInicioInmunidad >= duracionInmunidad) {
                // Desactivar la inmunidad después de 3 segundos
                inmunidadActivada = false;
            }
        }
        tiempoTranscurrido += 30;

        // Dibujar las vidas
        drawLives(gBuffer);
        drawTime(gBuffer);
        drawGem(gBuffer);

        // Mostrar el doble búffer en la ventana
        Graphics g = getGraphics();
        g.drawImage(bufferImage, 0, 0, null);

    }

    private void drawPersonaje(Graphics g) {
        // Verificar si el índice frameIndex está dentro del rango válido osea si esta del mismo tama;o del vector
        if (frameIndex >= 0 && frameIndex < runningAnimation.length || frameIndex < runningAnimation_reverse.length) {
            //pone a el personaje en su posicion actualizada
            g.drawImage(runningAnimation[frameIndex], personajeX, personajeY, 80, 80, this);
            g.drawImage(runningAnimation_reverse[frameIndex], personajeX, personajeY, 80, 80, this);

            // Va a ctualizando la posicion de la hitbox de correr
            runningAnimationHitboxes[frameIndex].setX(personajeX);
            runningAnimationHitboxes[frameIndex].setY(personajeY);

            runningAnimationHitboxes_reverse[frameIndex].setX(personajeX);
            runningAnimationHitboxes_reverse[frameIndex].setY(personajeY);

            // Dibujar la hitbox
            runningAnimationHitboxes[frameIndex].drawHitbox(g);
            runningAnimationHitboxes_reverse[frameIndex].drawHitbox(g);
        }

        frameIndex++;

        if (frameIndex >= runningAnimation.length || frameIndex >= runningAnimation_reverse.length) {
            frameIndex = 0;
        }

    }

    private void drawGem(Graphics g) {
        if (frameIndex2 >= 0 && frameIndex2 < gem.length) {

            g.drawImage(gem[frameIndex2], gemx, 500, 80, 80, null);

            gemhit[frameIndex2].setX(gemx);
            gemhit[frameIndex2].setY(500);

            gemhit[frameIndex2].drawHitbox(g);

        }

        frameIndex2++;

        if (frameIndex2 >= gem.length) {
            frameIndex2 = 0;
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
        bloquehit14_1.drawHitbox(g);
        bloquehit14_2.drawHitbox(g);
        bloquehit14_3.drawHitbox(g);

        bloquehit15_0.drawHitbox(g);
        bloquehit15_1.drawHitbox(g);
        bloquehit15_2.drawHitbox(g);
        bloquehit15_3.drawHitbox(g);

        bloquehit.drawHitbox(g);
        bloquehit1.drawHitbox(g);
        bloquehit2.drawHitbox(g);
        bloquehit3.drawHitbox(g);
        obstaculohit.drawHitbox(g);

        obstaculohit1.drawHitbox(g);
        obstaculohit3.drawHitbox(g);
        obstaculohit5.drawHitbox(g);
        obstaculohit6.drawHitbox(g);

    }

    private void drawLives(Graphics g) {
        // Configurar el color y la fuente del texto
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        // Dibujar el texto de las vidas en la esquina superior izquierda
        g.drawString("Vidas: " + vidas, 20, 50);
    }

    private void drawTime(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));

        // Conversion de tiempo transcurrido a segundos
        int segundos = tiempoTranscurrido / 1000;
        g.drawString("Tiempo: " + segundos + "s", 20, 80); // Ajusta la posición según sea necesario
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
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        keysPressed.add(keyCode);

        // Verificar si el personaje no está saltando y está en el suelo o sobre el bloque para permitir el salto
        if (keyCode == KeyEvent.VK_W && !jumping && !falling && jumpKeyReleased) {
            jumping = true; // Activar el salto al presionar la tecla W si el personaje está en el suelo o sobre el bloque
            jumpKeyReleased = false; // Indicar que la tecla de salto no está liberada
            initialY = personajeY; // Guardar la posición inicial del salto
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        keysPressed.remove(keyCode);

        // Verificar si la tecla de salto (W) fue soltada
        if (keyCode == KeyEvent.VK_W) {
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
