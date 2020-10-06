package animarObjeto;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JPanel {
    
    private JFrame ventana;
    private Container contenedor;
    
    // Arreglo de circulos
    private Circulo[] circulos;

    public Ventana() {
        // inicializar la ventana
        ventana = new JFrame("Animando Objetos");
        // definir tamaño a ventana
        ventana.setVisible(true);
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(500, 500);
        
        contenedor = ventana.getContentPane();
        contenedor.setSize(500, 500);
        // agregar la ventana en el contenedor
        contenedor.add(this, BorderLayout.CENTER);
        
        // Definir el arreglo de circulos
        int tamanio = 5;
        circulos = new Circulo[tamanio];
        
        //  Llenar el arreglo
        for (int i = 0; i < tamanio; i++) {
            circulos[i] = new Circulo(500, 500, 25, 10);
        }
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        for (Circulo circulo : circulos) {
            circulo.dibujar(g);
        }
    }
    
    public void animar() {
        while (ventana.isVisible()) {
            for (Circulo circulo : circulos) {
                circulo.animar();
            }
            
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
            }
            
            repaint();
        }
    }
}
