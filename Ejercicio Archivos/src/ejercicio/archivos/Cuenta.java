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
public class Cuenta {
    private int Id;
    private double credit;
    private Cliente owner;
    private  int indice=1;
    public Cuenta(Cliente owner) {
        this.credit = 0.0;
    this.Id=this.indice;
    this.indice++;
    this.owner=owner;
    }

    public Cliente getOwner() {
        return owner;
    }
    public void Consignar(double monto ){
    this.credit+=monto;
    
    }

    public int getId() {
        return Id;
    }
    public String NombreTitular(){
    return this.owner.getName();
    }

    public double getCredit() {
        return credit;
    }

}
