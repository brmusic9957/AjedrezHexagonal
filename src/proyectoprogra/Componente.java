package proyectoprogra;

import javax.swing.JLabel;

public class Componente extends JLabel {

    public static int CELDA = 1;
    public static int PIEZA = 2;

    private int tipo;

    public Componente(int tipo, int size, int posx, int posy) {
        this.tipo = tipo;
        this.setBorder(null);
        this.setSize(size, size);
        this.setLocation(posx, posy);
        this.setVisible(true);
    }

    public int getTipo() {
        return tipo;
    }

}
