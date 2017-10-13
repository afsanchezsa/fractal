/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class Salto  implements Runnable{
private Personaje Bola;
private final double  VELOCIDAD=10;
private final double Angulo=80;
private double vy,vx;
int  posx;
int posy;
int x;
int y;
   double t;
public Salto(Personaje uno){
this.Bola=uno;
t=0;
}

    
    @Override
    public void run() {
        for(int i=0;i<153;i++){
        //this.Bola.aumentary(); 
     
           x=Bola.getX();
           y=Bola.getY();
           vx=VELOCIDAD*Math.cos(Math.toRadians(Angulo));
           vy=VELOCIDAD*Math.sin(Math.toRadians(Angulo));
          //vx=10;
          //vy=-30;
          posx=(int)(this.x+vx*t);
           posy=(int)(this.y-vy*t+((5.0)*t*t));
           Bola.setX(posx);
           Bola.setY(posy);
           t+=0.02;
           try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                System.out.println("eroor");
            }
        }
       
        
        
        
    }
    
}
