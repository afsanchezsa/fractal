/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author USUARIO
 */




 




public  class Lamina extends JPanel implements ActionListener{
private Rey rey;
private Timer timer;   
private final int DELAY=25;
int y=600;
int x=34;
public Lamina(){
 
 setBackground(new Color(88, 51, 255));   
     
 rey=new Rey();
        
 timer=new Timer(DELAY,this);
       timer.start();
       addKeyListener(new Teclado());
addKeyListener(new Teclado());       
   setFocusable(true);
    
}



public void paintComponent(Graphics g){
super.paintComponent(g);

Personaje enemigo1=new Personaje("enemigo1");
 

    
g.drawImage(rey.getSalto(), rey.getX(),rey.getY() , 100, 150, this);

g.drawLine(15, 30, 20, 49);



//g.drawImage(loadImage("C:\\Users\\USUARIO\\Desktop\\Imagenes juego\\personajes.png"), 23, 23, this);
  
        
}

    public Rey getRey() {
        return rey;
    }
private class Teclado implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
          
            if(e.getKeyCode()==KeyEvent.VK_SPACE){
            
               
            }
          
          
        }

        @Override
        public void keyPressed(KeyEvent e) {
             if(e.getKeyCode()==KeyEvent.VK_SPACE){
             //rey.saltar(1);
             rey.saltar(1);rey.saltar(2);rey.saltar(3);rey.saltar(4);rey.saltar(5);rey.saltar(6);
             }

        
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("solto");
        }

    
}

  



        
        

        @Override public void actionPerformed(ActionEvent e) {
          
            repaint();
        }
public static Image loadImage(String archivo){
    ImageIcon imagen=new ImageIcon(archivo);
    Image imagenfinal=imagen.getImage();
    return imagenfinal;
    
    }
}