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
public class Administrador extends Persona{
private ArrayList<Cliente>clients;

    public Administrador(String name,int Id) {
        super(name,Id);
  this.clients=new ArrayList<>();
    }
    public boolean addCliente(Cliente cliente){
    return this.clients.add(cliente);
    } 
}
    