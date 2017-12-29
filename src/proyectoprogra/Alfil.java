/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoprogra;

import javax.swing.ImageIcon;

/**
 *
 * @author Dash
 */
public class Alfil extends Pieza {

    public Alfil(int posx, int posy, int x, int y, int bando) {
        super(bando, posx, posy, x, y);
        if (bando == BLANCAS) {
            this.setIcon(new ImageIcon("src/Images/Alfil2.png"));
        } else {
            this.setIcon(new ImageIcon("src/Images/Alfil.png"));
        }

    }

    @Override
    boolean validarMovimiento(int newx, int newy) {
        if (bando == BLANCAS) {
            if (y == newy) {
                return true;
            }
        } else {
            if (y == newy) {
                return true;
            }
        }
        return false;
    }

    @Override
    void comio(int newX, int newyY) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
