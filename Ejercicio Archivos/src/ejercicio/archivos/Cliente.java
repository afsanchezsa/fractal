/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.archivos;

import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class Cliente extends Persona{
private ArrayList<Cuenta>accounts;
private Administrador manager;

    public Cliente(String nombre,Administrador manager,int Id) {
    super(nombre,Id);
    this.accounts=new ArrayList<>();
    this.manager=manager;
    }
  public boolean addCuenta(Cuenta cuenta){
 
      return this.accounts.add(cuenta);
  
  }  
    public String NombreManager(){
    return this.manager.getName();
    }
}
