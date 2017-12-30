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

public class Rey extends Pieza {

	public Rey(int posx, int posy, int x, int y, int bando) {
    	super(bando, posx, posy, x, y);
    	if (bando == BLANCAS) {
    		this.setIcon(new ImageIcon("src/Images/Rey2.png"));
    	} else {
    		this.setIcon(new ImageIcon("src/Images/Rey.png"));
    	}
    }

	@Override
	boolean validarMovimiento(int newx, int newy, int oldX, int oldY) {

		return false;
	}

    @Override
    void comio(int newX, int newyY) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
