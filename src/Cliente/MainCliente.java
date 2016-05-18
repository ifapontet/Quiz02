/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Servidor.*;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Estudiante
 */
public class MainCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {               
        JFrame frame = new JFrame();
        frame.setTitle("Servidor");
        frame.setSize(new Dimension(500,500));
        frame.add(new Tablero());//adicionando el panel
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
