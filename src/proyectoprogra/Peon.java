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
public class Peon extends Pieza {
    private Pieza[][] piezaTemp = new Pieza[11][21];
    
    public Peon(int posx, int posy, int x, int y, int bando) {
        super(bando, posx, posy, x, y);        
        if (bando == BLANCAS) {
            this.setIcon(new ImageIcon("src/Images/peon2.png"));
        } else {
            this.setIcon(new ImageIcon("src/Images/peon.png"));
        }
    }

    @Override
    boolean validarMovimiento(int newx, int newy) {

        if (bando == BLANCAS) {
            if (x == newx && y != newy && y > newy) {
                if (movimiento == 0) {
                    if (y - newy < 5 || y - newy < 3) {
                        super.y = newy;
                        movimiento++;
                        //comio(1, 16);
                        return true;
                    }
                }
                if (movimiento > 0) {
                    if (y - newy < 3) {
                        super.y = newy;

                        return true;
                    }
                }
            }

        }

        if (bando == NEGRAS) {

            if (x == newx) {
                return true;

            }

        }

        return false;
    }

    @Override
    void comio(int newX, int newyY) {
        System.out.println(ArchivoPieza.piezas[newX][newyY].getBando());
       
        
    }

}
