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

    int posX = 0;
    int posY = 0;

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
    boolean validarMovimiento(int newx, int newy, int oldX, int oldY) {

        if (bando == BLANCAS) {
            if (x == newx && y != newy && y > newy) {
                if (movimiento == 0) {
                    if (y - newy < 5 || y - newy < 3) {
                        if (ArchivoPieza.piezas[newy][newx] == null) {
                            ArchivoPieza.piezas[oldY][oldX] = null;
                            x = 257 + (posX * 45);
                            y = 25 + (posY * 25);
                            ArchivoPieza.piezas[newy][newx] = new Peon(x, y, newx, newy, Pieza.BLANCAS);
                            super.y = newy;
                            movimiento++;
                            System.out.println(newx + " " + newy + " " + oldX + " " + oldY);
                            return true;
                        }
                        return false;
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
