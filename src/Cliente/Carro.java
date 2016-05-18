/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;
import Servidor.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.Socket;
/**
 *
 * @author Estudiante
 */
public class Carro extends JPanel implements ActionListener, KeyListener{
    private Timer timer;
    private int x=0;
    private int y=0;
    
    public Carro(int x, int y){
       this.x= x;
       this.y= y;
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.red);
        g.fillOval(20+x, 110+y, 50, 50);
        g.setColor(Color.blue);
        g.fillOval(100+x, 110+y, 50, 50);
        g.setColor(Color.yellow);
        g.fillRect(10+x, 60+y, 150, 50);
        Polygon  poligono = new Polygon();
        poligono.addPoint(30+x,60+y);
        poligono.addPoint(60+x,30+y);
        poligono.addPoint(110+x,30+y);
        poligono.addPoint(140+x,60+y);
        g.drawPolygon(poligono);
        g.setColor(Color.RED);
        g.fillPolygon(poligono);
        g.setColor(Color.BLACK);
        g.drawRect(10+x, 30+y, 150, 120);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.x+=0;
        this.y+=0;
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_DOWN: y += 30; break;
            case KeyEvent.VK_UP: y -= 30; break;
            case KeyEvent.VK_LEFT: x -= 30; break;
            case KeyEvent.VK_RIGHT: x += 30; break;
          }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    public void mover(){
        x+=5;
    } 
    
    public Rectangle obtenerRectangulo(){
      return new Rectangle(10+x, 30+y, 150, 120);    
    }
    
    public void Server(int x, int y) throws IOException{
       Socket server= new Socket("localhost", 8000);
       
        
    }
}
