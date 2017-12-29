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
 * @author Bruce
 */
public class Archivo {
    
    private int x;
    
    private int y;
    
    private JPanel inter;
    Celda[][] celdas = new Celda[11][21];
    
    public Archivo(JPanel interfaz) {
        inter = interfaz;
    }

    public Celda[][] leer() {
        
        File file;
        FileReader filer;
        try {
            file = new File("src/csv/TableroAjedrez.csv");
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
                    if (arch[i].equalsIgnoreCase("2")) {
                        x = 250 + (posX * 45);
                        y = 20 + (posY * 25);

                        celdas[posX][posY] = new Celda(x, y, posX, posY, 2);
                        inter.add(celdas[posX][posY]);
                        //inter.add(new Celda(x, y, posX, posY, 2));
                        //System.out.println("X:" + posX + " Y:" + posY + " " + arch[i]);

                    }
                    if (arch[i].equalsIgnoreCase("1")) {
                        x = 250 + (posX * 45);
                        y = 20 + (posY * 25);
                        celdas[posX][posY] = new Celda(x, y, posX, posY, 1);
                        inter.add(celdas[posX][posY]);
                        //inter.add(new Celda(x, y, posX, posY, 1));
                        //System.out.println("X:" + posX + " Y:" + posY + " " + arch[i]);
                    }
                    if (arch[i].equalsIgnoreCase("3")) {
                        x = 250 + (posX * 45);
                        y = 20 + (posY * 25);
                        celdas[posX][posY] = new Celda(x, y, posX, posY, 3);
                        inter.add(celdas[posX][posY]);
                        //inter.add(new Celda(x, y, posX, posY, 3));
                        //System.out.println("X:" + posX + " Y:" + posY + " " + arch[i]);

                    }
                    posX++;
                }
                posY++;
                l = l + aux + "\n";
            }
            br.close();
            filer.close();

            return celdas;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
