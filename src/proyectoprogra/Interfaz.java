/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoprogra;

import javax.swing.JFrame;

/**
 *
 * @author Edson Juarez
 */
public class Interfaz extends JFrame {

    /**
     *
     */
    

    public Interfaz() {
        Tablero tablero = new Tablero(1000, 650);
        this.setSize(1000, 650);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(tablero);
    }

}
