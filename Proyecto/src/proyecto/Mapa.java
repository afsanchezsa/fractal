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
public class Mapa {
private int ancho;
private int alto;
private int []cuadros;
public Mapa(int ancho, int alto){
        this.ancho=ancho;
        this.alto=alto;
        this.cuadros=new int [ancho*alto];
        generarMapa();

}
public Mapa(String ruta){
cargarmapa( ruta);



}
public void generarMapa(){};
public  void cargarmapa(String ruta){


}
public void actualizar(){}

}

