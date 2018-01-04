package proyectoprogra;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Tablero extends JLayeredPane {

    public Tablero(int tamx, int tamy) {
        super();
        this.setSize(tamx, tamy);
        JPanel casillas = new JPanel(null);
        casillas.setBackground(Color.white);
        casillas.setSize(tamx, tamy);
        this.add(casillas, JLayeredPane.DEFAULT_LAYER);
        JPanel piezas = new JPanel(null);
        piezas.setOpaque(false);
        piezas.setSize(tamx, tamy);
        this.add(piezas, JLayeredPane.PALETTE_LAYER);
        Archivo arch = new Archivo(casillas);
        arch.leer();
        ArchivoPieza archpieza = new ArchivoPieza(piezas);
        archpieza.leer();
        EventosMouse em = new EventosMouse(casillas, piezas);
        this.addMouseListener(em);
        this.addMouseMotionListener(em);
    }

    private class EventosMouse extends MouseAdapter {

        private JPanel casillas;
        private JPanel piezas;

        private Pieza clickPieza;
        private int posAntX, posAntY;
        private int agarraAnchura;
        private int agarraAltura;
        private Point posicionAnterior;
        private int turno = 0;

        public EventosMouse(JPanel casillas, JPanel piezas) {
            this.casillas = casillas;
            this.piezas = piezas;
        }

        @Override
        public void mousePressed(MouseEvent me) {
            Component componente = piezas.getComponentAt(me.getPoint());
            if (componente != null && componente instanceof Pieza) {

                clickPieza = (Pieza) componente;
                posicionAnterior = clickPieza.getLocation();
                piezas.remove(clickPieza);
                piezas.revalidate();
                piezas.repaint();
                clickPieza.imprimirPosicion();
                posAntX = clickPieza.imprimirX();
                posAntY = clickPieza.imprimirY();
                agarraAnchura = clickPieza.getWidth() / 2;
                agarraAltura = clickPieza.getHeight() / 2;
                int x = me.getPoint().x - agarraAnchura;
                int y = me.getPoint().y - agarraAltura;
                clickPieza.setLocation(x, y);
                add(clickPieza, JLayeredPane.DRAG_LAYER);
                repaint();
            }
        }

        @Override
        public void mouseDragged(MouseEvent me) {
            if (clickPieza != null) {
                int x = me.getPoint().x - agarraAnchura;
                int y = me.getPoint().y - agarraAltura;
                clickPieza.setLocation(x, y);
                repaint();
            }
        }

        @Override
        public void mouseReleased(MouseEvent me) {

            if (clickPieza != null) {
                remove(clickPieza);
                boolean cambioPosicion = false;
                Component componente = casillas.getComponentAt(me.getPoint());
                if (componente != null) {
                    if (componente instanceof Celda) {
                        Celda celda = (Celda) componente;
                        if (turno == clickPieza.getBando()) {

                            if (clickPieza.validarMovimiento(celda.posX(), celda.posY())) {                                                                
                                clickPieza.nuevaPosicion(celda.getLocation());
                                //System.out.println("npos>"+celda.posX()+">"+celda.posY());
                                //System.out.println("npos>"+celda.getLocation());
                                cambioPosicion = true;
                                if (turno == 0) {
                                    turno = 1;
                                } else {
                                    turno = 0;
                                }
                            }

                        }

                        //clickPieza.nuevaPosicion(celda.getLocation());
                        //cambioPosicion = true;
                    }
                }
                if (!cambioPosicion) {
                    clickPieza.setLocation(posicionAnterior);
                }
                piezas.add(clickPieza);
                piezas.revalidate();
                clickPieza = null;
                repaint();
                for (int h = 0; ArchivoPieza.piezas.length > h; h++) {
                    for (int k = 0; ArchivoPieza.piezas[h].length > k; k++) {
                        if (ArchivoPieza.piezas[h][k] == null) {
                            System.out.print(",");
                        } else {
                            System.out.print("P");
                        }
                    }
                    System.out.println("");
                }
                System.out.println("------------------------------------------------");
            }

        }
    }

}
