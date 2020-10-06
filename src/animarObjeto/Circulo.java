package animarObjeto;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Circulo {
    // coordenadas
    private int coordenadaX, coordenadaY;

    // tamanio
    private int radio;

    // Instanciia de la clase color
    private Color color;

    // Sentido
    private int sentido;

    // Sentidos posibles
    private final int ARRIBA = 1;
    private final int DERECHA_ARRIBA = 2;
    private final int DERECHA = 3;
    private final int DERECHA_ABAJO = 4;
    private final int ABAJO = 5;
    private final int IZQUIERDA_ABAJO = 6;
    private final int IZQUIERDA = 7;
    private final int IZQUIERDA_ARRIBA = 8;

    // Velocidad
    private int velocidad;

    // Margenes de la ventana
    private int minimoX, minimoY, maximoX, maximoY;

    // Objeto random
    private Random random;

    public Circulo(int ancho, int alto, int radio, int velocidad) {
        // definir objeto random
        random = new Random();
        color = new Color(
            random.nextInt(255),
            random.nextInt(255),
            random.nextInt(255)
        );

        // definir coordenadas iniciales
        this.coordenadaX = random.nextInt(ancho - radio);
        this.coordenadaY = random.nextInt(alto - radio);

        // definir radio
        this.radio = radio;

        // definir sentido
        this.sentido = random.nextInt(8) + 1;

        // definir velocidad
        this.velocidad = velocidad;

        // definir coordinadas minimas
        this.minimoX = 0;
        this.minimoY = 0;

        // definir coordinadas maximas
        this.maximoX = ancho - radio;
        this.maximoY = alto  - radio;
    }

    public void dibujar(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillOval(
                coordenadaX,
                coordenadaY,
                radio, radio);
    }

    public void animar() {
        // siguientes coordenadas positivas
        int xPositiva = this.coordenadaX + velocidad;
        int yPositiva = this.coordenadaY + velocidad;

        // siguientes coordenadas negativas
        int xNegativa = this.coordenadaX - velocidad;
        int yNegativa = this.coordenadaY - velocidad;

        // Logica para determinar colisiones y sentido
        switch (sentido) {
            case ARRIBA:
                if (yNegativa > minimoY) {
                    this.coordenadaY = yNegativa;
                } else {
                    int sentidoTemporal = 1 + random.nextInt(3);
                    switch (sentidoTemporal) {
                        case 1:
                            sentidoTemporal = IZQUIERDA_ABAJO; break;
                        case 2:
                            sentidoTemporal = ABAJO; break;
                        case 3:
                            sentidoTemporal = DERECHA_ABAJO; break;
                    }
                }
                break;
            case DERECHA_ARRIBA:
                if (yNegativa > minimoY && xPositiva < maximoX) {
                    this.coordenadaX = xPositiva;
                    this.coordenadaY = yNegativa;
                } else {
                    int sentidoTemporal = 1 + random.nextInt(3);
                    switch (sentidoTemporal) {
                        case 1:
                            sentidoTemporal = IZQUIERDA; break;
                        case 2:
                            sentidoTemporal = IZQUIERDA_ABAJO; break;
                        case 3:
                            sentidoTemporal = ABAJO; break;
                    }
                }
                break;
            case DERECHA:
                if (xPositiva < maximoX) {
                    this.coordenadaX = xPositiva;
                } else {
                    int sentidoTemporal = 1 + random.nextInt(3);
                    switch (sentidoTemporal) {
                        case 1:
                            sentidoTemporal = IZQUIERDA_ARRIBA; break;
                        case 2:
                            sentidoTemporal = IZQUIERDA; break;
                        case 3:
                            sentidoTemporal = IZQUIERDA_ABAJO; break;
                    }
                }
                break;
            case DERECHA_ABAJO:
                if (xPositiva < maximoX && yPositiva < maximoY) {
                    this.coordenadaX = xPositiva;
                    this.coordenadaY = yPositiva;
                } else {
                    int sentidoTemporal = 1 + random.nextInt(3);
                    switch (sentidoTemporal) {
                        case 1:
                            sentidoTemporal = IZQUIERDA_ARRIBA; break;
                        case 2:
                            sentidoTemporal = IZQUIERDA; break;
                        case 3:
                            sentidoTemporal = ARRIBA; break;
                    }
                }
                break;
            case ABAJO:
                if (yPositiva < maximoY) {
                    this.coordenadaY = yPositiva;
                } else {
                    int sentidoTemporal = 1 + random.nextInt(3);
                    switch (sentidoTemporal) {
                        case 1:
                            sentidoTemporal = ARRIBA; break;
                        case 2:
                            sentidoTemporal = IZQUIERDA_ARRIBA; break;
                        case 3:
                            sentidoTemporal = DERECHA_ARRIBA; break;
                    }
                }
                break;
            case IZQUIERDA_ABAJO:
                if (yPositiva < maximoY && xNegativa > minimoX) {
                    this.coordenadaY = yPositiva;
                    this.coordenadaX = xNegativa;
                } else {
                    int sentidoTemporal = 1 + random.nextInt(3);
                    switch (sentidoTemporal) {
                        case 1:
                            sentidoTemporal = ARRIBA; break;
                        case 2:
                            sentidoTemporal = DERECHA_ARRIBA; break;
                        case 3:
                            sentidoTemporal = DERECHA; break;
                    }
                }
                break;
            case IZQUIERDA:
                if (xNegativa > minimoX) {
                    this.coordenadaX = xNegativa;
                } else {
                    int sentidoTemporal = 1 + random.nextInt(3);
                    switch (sentidoTemporal) {
                        case 1:
                            sentidoTemporal = DERECHA_ARRIBA; break;
                        case 2:
                            sentidoTemporal = DERECHA; break;
                        case 3:
                            sentidoTemporal = DERECHA_ABAJO; break;
                    }
                }
                break;
            case IZQUIERDA_ARRIBA:
                if (xNegativa > minimoX && yNegativa > minimoY) {
                    this.coordenadaY = yNegativa;
                    this.coordenadaX = xNegativa;
                } else {
                    int sentidoTemporal = 1 + random.nextInt(3);
                    switch (sentidoTemporal) {
                        case 1:
                            sentidoTemporal = DERECHA; break;
                        case 2:
                            sentidoTemporal = DERECHA_ABAJO; break;
                        case 3:
                            sentidoTemporal = ABAJO; break;
                    }
                }
                break;
        }
    }
}
