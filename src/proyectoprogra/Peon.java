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

    private ArchivoPieza tablero;

    public Peon(int posx, int posy, int x, int y, int bando, ArchivoPieza tablero) {
        super(bando, posx, posy, x, y);
        if (bando == BLANCAS) {
            this.setIcon(new ImageIcon("src/Images/peon2.png"));
        } else {
            this.setIcon(new ImageIcon("src/Images/peon.png"));
        }
        this.tablero = tablero;
    }

    @Override
    boolean validarMovimiento(int newx, int newy) {

        if (bando == BLANCAS) {
            if (x == newx && y != newy && y > newy) { // Si mueve para arriba y solo en posicion Y
                if (movimiento == 0) {
                    if (y - newy < 5 || y - newy < 3) {
                        if (tablero.piezas[newy][newx] == null) {
                            tablero.piezas[newy][newx] = tablero.piezas[y][x];
                            tablero.piezas[y][x] = null;
                            movimiento++;
                            y = newy;
                            return true;
                        }
                        return false;
                    }
                }
                if (movimiento > 0) {
                    if (y - newy < 3) {
                        if (tablero.piezas[newy][newx] == null) {
                            tablero.piezas[newy][newx] = tablero.piezas[y][x];
                            tablero.piezas[y][x] = null;
                            movimiento++;
                            y = newy;
                            return true;
                        }
                    }
                }
            } else if (tablero.piezas[newy][newx] != null) {
                if (x - newx == 1 && y - newy == 1 || newx - x == 1 && y - newy == 1) {
                    tablero.eliminarPieza(newx, newy);
                    tablero.piezas[newy][newx] = tablero.piezas[y][x];
                    tablero.piezas[y][x] = null;
                    x = newx;
                    y = newy;
                    return true;
                }
            }

        }

        if (bando == NEGRAS) {
            if (x == newx && y != newy && y < newy) { // Si mueve para abajo y solo en posicion X
                if (movimiento == 0) {
                    if (newy - y < 5 || newy - y < 3) {
                        if (tablero.piezas[newy][newx] == null) {
                            tablero.piezas[newy][newx] = tablero.piezas[y][x];
                            tablero.piezas[y][x] = null;
                            movimiento++;
                            return true;
                        }

                    }
                    return false;
                }
                if (movimiento > 0) {
                    if (newy - y < 3) {
                        if (tablero.piezas[newy][newx] == null) {
                            tablero.piezas[newy][newx] = tablero.piezas[y][x];
                            tablero.piezas[y][x] = null;
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    @Override
    void comio(int newX, int newyY) {
        System.out.println(tablero.piezas[newX][newyY].getBando());

    }

}
