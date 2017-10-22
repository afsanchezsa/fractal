/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.archivos;

/**
 *
 * @author USUARIO
 */
public abstract class Persona {
   private int Id;
    private String name;

    public Persona(String name, int Id) {
        this.name = name;
    this.Id=Id;
    }
   public int getId(){
   return this.Id;
   }
   public String getName(){
   return this.name;
   
   }
}
