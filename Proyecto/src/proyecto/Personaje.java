/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author USUARIO
 */
public class Personaje {
    protected int x;
    protected int y;
    private BufferedImage ImagenGeneral;
    private HashMap<Integer,Image> ImagenesCorrer;
    private HashMap<Integer,Image>ImagenesSaltar;
    private Image ImagenEstatico;
  private Image Salto;
public Personaje(String nombre) {
int indice=0;
this.ImagenesCorrer=new HashMap<>();
this.ImagenesSaltar=new HashMap<>();
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
    
    
    
    
    public static Image loadImage(String archivo){
    ImageIcon imagen=new ImageIcon(archivo);
    Image imagenfinal=imagen.getImage();
    return imagenfinal;
    
    }
    
}
