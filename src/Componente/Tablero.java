/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componente;

import Componente.Circulo;
import Componente.Carro;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Usuario9
 */
public class Tablero extends JPanel implements ActionListener, KeyListener{
    private Timer timer; 
    private ArrayList<Circulo> circulo;
    private Carro personajePrincipal;
    private int puntaje = 0;
    public Tablero(){
      this.setFocusable(true);
      this.addKeyListener(this);
      this.personajePrincipal = new Carro(100,200);
      
      this.circulo = new ArrayList<Circulo>();
      this.circulo.add(new Circulo(20,20));
      this.circulo.add(new Circulo(100,80));
      this.circulo.add(new Circulo(80,120));
      this.timer = new Timer(20, this);
      this.timer.start();
    }
    protected void paintComponent(Graphics g) {
         super.paintComponent(g);
         for(Circulo c: this.circulo)
            c.dibujar(g);
         
         this.personajePrincipal.paintComponent(g);
         g.drawString("Puntaje " + puntaje, 40, 40);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        validarColisiones();
        for(Circulo c: this.circulo)
            c.mover();
            repaint();
        
    }
     
    
    public void validarColisiones(){
        Rectangle recPersonaje= this.personajePrincipal.obtenerRectangulo();
        ArrayList<Circulo> copia = (ArrayList<Circulo>) this.circulo.clone();
        for(Circulo c : circulo){
           Rectangle RecCir = c.obtenerRectangulo();
           if(recPersonaje.intersects(RecCir)){
               copia.remove(c);
               this.puntaje++;
           }
           this.circulo=copia;   
           
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
     
    }

    @Override
    public void keyPressed(KeyEvent e) {
       this.personajePrincipal.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }
}
