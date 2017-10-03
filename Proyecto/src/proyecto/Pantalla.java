/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author USUARIO
 */
public class Pantalla {
private final int ancho;
private final int alto;
public final int[] pixeles;
public Pantalla(final int ancho,final int alto){
this.ancho=ancho;
this.alto=alto;
this.pixeles=new int[ancho*alto];

}
 public void limpiar(){
 for(int i=0;i<pixeles.length;i++){
 pixeles[i]=0;
 }
 
 }
public void mostrar(final int compensacionx,final int compensaciony){
for(int y=0;y<alto;y++){
int posiciony=y+compensaciony;
if(posiciony<0||posiciony>=alto){
continue;
}
for(int x=0;x<ancho;x++){
int posicionx=x+compensacionx;
if(posicionx<0||posicionx>=ancho){
continue;
}

}
}
}
}
