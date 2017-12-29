package proyectoprogra;

import java.awt.Point;

abstract class Pieza extends Componente {

    public static int BLANCAS = 0;
    public static int NEGRAS = 1;

    protected int bando;
    protected int x;
    protected int y;
    protected int movimiento;

    public Pieza(int bando, int posx, int posy, int x, int y) {
        super(PIEZA, 50, posx, posy);
        this.bando = bando;
        this.x = x;
        this.y = y;
    }

    public void nuevaPosicion(Point p) {
        this.setLocation(p.x + 7, p.y + 7);

    }

    public void imprimirPosicion() {
        System.out.println("Estoy seleccionando la pieza: " + x + ", " + y);
    }

    public int getBando() {
        return bando;
    }

    public void setBando(int bando) {
        this.bando = bando;
    }

    abstract boolean validarMovimiento(int newx, int newy);
    
    abstract void comio(int newX, int newyY);

}
