/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoprogra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JPanel;

/**
 *
 * @author Dash
 */
public class ArchivoPieza {

    private int x;
    private int y;    
    private JPanel inter;    
    public Pieza[][] piezas = new Pieza[21][11];
            
    public ArchivoPieza(JPanel interfaz) {
        inter = interfaz;
    }
   

    public Pieza[][] leer() {

        File file;
        FileReader filer;
        try {
            file = new File("src/csv/Piezas.csv");
            filer = new FileReader(file);
            BufferedReader br = new BufferedReader(filer);
            String l = "";
            String aux = "";
            int posX = 0;
            int posY = 0;
            
            
            while ((aux = br.readLine()) != null) {
                
                String[] arch = aux.split(",");

                posX = 0;
                for (int i = 0; i < arch.length; i++) {

                    // Piezas Negras
                    if (arch[i].equalsIgnoreCase("P")) {
                        x = 257 + (posX * 45);
                        y = 25 + (posY * 25);
                        piezas[posY][posX] = new Peon(x, y, posX, posY, Pieza.NEGRAS, this);
                        inter.add(piezas[posY][posX]);
                        
                        //System.out.println("X:" + posX + " Y:" + posY + " " + arch[i]);

                    }

                    if (arch[i].equalsIgnoreCase("A")) {
                        x = 257 + (posX * 45);
                        y = 25 + (posY * 25);

                        inter.add(new Alfil(x, y, posX, posY, Pieza.NEGRAS));

                    }
                    if (arch[i].equalsIgnoreCase("K")) {
                        x = 257 + (posX * 45);
                        y = 25 + (posY * 25);
                        inter.add(new Rey(x, y, posX, posY, Pieza.NEGRAS));

                    }
                    if (arch[i].equalsIgnoreCase("Q")) {
                        x = 257 + (posX * 45);
                        y = 25 + (posY * 25);
                        inter.add(new Reina(x, y, posX, posY, Pieza.NEGRAS));

                    }
                    if (arch[i].equalsIgnoreCase("T")) {
                        x = 257 + (posX * 45);
                        y = 25 + (posY * 25);
                        inter.add(new Torre(x, y, posX, posY, Pieza.NEGRAS));

                    }
                    if (arch[i].equalsIgnoreCase("C")) {
                        x = 257 + (posX * 45);
                        y = 25 + (posY * 25);
                        inter.add(new Caballo(x, y, posX, posY, Pieza.NEGRAS));
                    }

                    //Piezas Blancas
                    if (arch[i].equalsIgnoreCase("P1")) {
                        x = 257 + (posX * 45);
                        y = 25 + (posY * 25);
                        piezas[posY][posX] = new Peon(x, y, posX, posY, Pieza.BLANCAS, this);
                        inter.add(piezas[posY][posX]);

                    }
                    if (arch[i].equalsIgnoreCase("A1")) {
                        x = 257 + (posX * 45);
                        y = 25 + (posY * 25);
                        inter.add(new Alfil(x, y, posX, posY, Pieza.BLANCAS));

                    }
                    if (arch[i].equalsIgnoreCase("K1")) {
                        x = 257 + (posX * 45);
                        y = 25 + (posY * 25);
                        inter.add(new Rey(x, y, posX, posY, Pieza.BLANCAS));

                    }
                    if (arch[i].equalsIgnoreCase("Q1")) {
                        x = 257 + (posX * 45);
                        y = 25 + (posY * 25);
                        inter.add(new Reina(x, y, posX, posY, Pieza.BLANCAS));

                    }
                    if (arch[i].equalsIgnoreCase("T1")) {
                        x = 257 + (posX * 45);
                        y = 25 + (posY * 25);
                        inter.add(new Torre(x, y, posX, posY, Pieza.BLANCAS));

                    }
                    if (arch[i].equalsIgnoreCase("C1")) {
                        x = 257 + (posX * 45);
                        y = 25 + (posY * 25);
                        inter.add(new Caballo(x, y, posX, posY, Pieza.BLANCAS));
                    }
                    posX++;
                }
                posY++;                         
                l = l + aux + "\n";
            }
            br.close();
            filer.close();            
            return piezas;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public void eliminarPieza(int x, int y){
        inter.remove(piezas[y][x]);
        System.out.println("Borro esa mierda :D");
        inter.revalidate();
        inter.repaint();
    }
}
