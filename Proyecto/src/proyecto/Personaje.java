/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author USUARIO
 */
public class Personaje implements ActionListener {
    protected int x;
    protected int y;
    private static  final int VELOCIDAD=2;
    private double vx,vy;
    private BufferedImage ImagenGeneral;
    private HashMap<Integer,Image> ImagenesCorrer;
    private HashMap<Integer,Image>ImagenesSaltar;
    private Image ImagenEstatico;
  private Image Salto;
  private double t;
  //private Timer salto;
  private Thread salto;
  private Thread sonido;
public Personaje(String nombre) {
int indice=0;
this.ImagenesCorrer=new HashMap<>();
this.ImagenesSaltar=new HashMap<>();
this.salto=new Thread(new Salto(this));//new Timer(5000,this);
this.vx=10;
this.vy=2;
this.t=0;
this.sonido=new Thread(new Sonidos("song.wav"));
sonido.start();
try{

this.ImagenGeneral=ImageIO.read(new File("personajes.png"));

if(nombre.equalsIgnoreCase("rey")){
for(int i=0;i<7;i++,indice++,i++){
this.ImagenesSaltar.put(indice, ((BufferedImage)this.ImagenGeneral.getSubimage((i*32), 32, 32, 32)));
}
indice=0;
for(int i=11;i<17;i++,indice++,i++){
this.ImagenesCorrer.put(indice, ((BufferedImage)this.ImagenGeneral.getSubimage((i*32), 32, 32, 32)));
}
indice=0;
this.ImagenEstatico= (BufferedImage)this.ImagenGeneral.getSubimage(9, 32, 32, 32);

}else if(nombre.equalsIgnoreCase("enemigo1")){
for(int i=0;i<7;i++,indice++,i++){
this.ImagenesSaltar.put(indice, ((BufferedImage)this.ImagenGeneral.getSubimage((i*32), 0, 32, 32)));
}
indice=0;
for(int i=11;i<17;i++,indice++){
this.ImagenesCorrer.put(indice, ((BufferedImage)this.ImagenGeneral.getSubimage((i*32), 0, 32, 32)));
}
indice=0;
this.ImagenEstatico= (BufferedImage)this.ImagenGeneral.getSubimage((9), 0, 32, 32);




}else if(nombre.equalsIgnoreCase("enemigo2")){
for(int i=0;i<3;i++){
this.ImagenesCorrer.put(i,(BufferedImage)this.ImagenGeneral.getSubimage((i*32),64,32,32));

}

this.ImagenEstatico=(BufferedImage)this.ImagenGeneral.getSubimage(32, 62, 32, 32);


}
this.Salto=this.ImagenEstatico;





}catch(IOException e){
    System.out.println("no se encuentra");
}



}

    public BufferedImage getImagenGeneral() {
        return ImagenGeneral;
    }

    public Image getImagenEstatico() {
        return ImagenEstatico;
    }

    public HashMap<Integer, Image> getImagenesCorrer() {
        return ImagenesCorrer;
    }
    
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getSalto() {
        return Salto;
    }
    
    public void saltar(int imagen) {
    int indice=0;
    this.Salto=this.ImagenesSaltar.get(indice);
    if (indice>=this.ImagenesSaltar.size()){
    indice=0;
    };
    indice++;
        
    this.y-=20;
    }    
    public void salto(){
    this.salto.start();
 
     this.salto=null;
    this.salto=new Thread(new Salto(this));
    //this.salto.stop();
    ;
    }
    public void nosaltar(){
   
    
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    
    public static Image loadImage(String archivo){
    ImageIcon imagen=new ImageIcon(archivo);
    Image imagenfinal=imagen.getImage();
    return imagenfinal;
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
       if(e.getSource()==this.salto){
       if(this.y>100){
        this.vx=VELOCIDAD*Math.cos(Math.toRadians(70));
       this.vy=VELOCIDAD*Math.sin(Math.toRadians(70));
       this.x=(int)(this.x+(vx*t));
       this.y=(int)(this.y+ (vy*t)+((9.8*0.5)*t*t));
         t+=0.000001;
           
       }
       
      
       
       }
           
       
       
       
    }
    
}
