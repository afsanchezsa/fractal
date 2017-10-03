/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.Image;
import java.util.HashMap;
import javax.swing.ImageIcon;

/**
 *
 * @author USUARIO
 */
public class HojaSprite {
    private HashMap<Integer, Image>sprites;
    public HojaSprite(){
    this.sprites=new HashMap<>();
    String ruta;
    
    for(int i=1;i<9;i++){
    ruta=Integer.toString(i);
    this.sprites.put(i,loadImage(ruta+".png"));
    }
    
    }
    public Image loadImage(String ruta){
    ImageIcon img=new ImageIcon(ruta);
    Image imagen=img.getImage();
    return imagen;
    }
}
