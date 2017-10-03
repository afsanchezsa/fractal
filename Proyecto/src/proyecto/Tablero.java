/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author USUARIO
 */
public class Tablero extends JFrame {
    Lamina lamina;
    public Tablero(){
setVisible(true);
setBounds(28,30,400,400);
lamina =new Lamina();
    add(lamina);
  addKeyListener(new T());
setFocusable(true);
  
  setDefaultCloseOperation(EXIT_ON_CLOSE);

}
  class T extends KeyAdapter{
public void keyPressed(KeyEvent e){
if(e.getKeyCode()==KeyEvent.VK_SPACE){
    System.out.println("saltando");
lamina.getRey().saltar(1);
}

}

}
}
