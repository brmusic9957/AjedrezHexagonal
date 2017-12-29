/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoprogra;

import javax.swing.ImageIcon;

/**
 *
 * @author Bruce
 */
public class Celda extends Componente {

    private int x;
    private int y;

    public Celda(int posx, int posy, int x, int y, int color) {
        super(CELDA, 64, posx, posy);
        switch (color) {
            case 1:
                this.setIcon(new ImageIcon("src/Images/a1.png"));
                break;
            case 2:
                this.setIcon(new ImageIcon("src/Images/a2.png"));
                break;
            default:
                this.setIcon(new ImageIcon("src/Images/a3.png"));
        }
        this.x = x;
        this.y = y;
    }

    public int posX() {
        return x;
    }

    public int posY() {
        return y;
    }
    
     public void imprimirPosicion() {
        System.out.println("Estoy seleccionando la pieza: " + x + ", " + y);
    }

}
