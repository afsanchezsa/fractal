/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class Banco {
    private String name;
    private ArrayList<Cuenta>accounts;
    private ArrayList <Administrador>managers;
    private ArrayList<Cliente>clients;

    public Banco(String name) {
        this.name = name;
    this.accounts=new ArrayList<>();
    this.clients=new ArrayList<>();
    this.managers=new ArrayList<>();
     
    }

    public ArrayList<Cliente> getClients() {
        return clients;
    }
    public void consignar( int Idcliente, double monto) throws FileNotFoundException{
    ArrayList<String>lineas=new ArrayList<>();
    Scanner entrada;
String linea;    
    for(Cuenta c:this.accounts){
    if(c.getOwner().getId()==Idcliente){
    c.Consignar(monto);
    File Carpeta=new File("Transaccion");
    if(Carpeta.isDirectory()){
    
    File consignacion =new File("Transaccion/"+c.getId()+".txt");
    if(consignacion.exists()){
        entrada=new Scanner(consignacion);
        while(entrada.hasNextLine()){
        linea=entrada.nextLine();
        lineas.add(linea);
        }
        entrada.close();
    PrintStream salida=new PrintStream(consignacion);
    for(String s:lineas){
    salida.println(s);
    }
    salida.println("ConsignaciondeMonto: "+monto);
    salida.flush();
    salida.close();
    }else{
        try {
            consignacion.createNewFile();
         PrintStream salida=new PrintStream(consignacion);
    salida.println("ConsignaciondeMonto: "+monto);
    salida.flush();
    salida.close();    
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    }
    }
    
    }
    
    }
    
    
    
    
   /* public void consignar( int Idcliente, double monto) throws FileNotFoundException{
    ArrayList<String>lineas=new ArrayList<>();
    Scanner entrada;
String linea;    
    
    
    File Carpeta=new File("Transaccion");
    if(Carpeta.isDirectory()){
    
    File consignacion =new File("Transaccion/"+Idcliente+".txt");
    if(consignacion.exists()){
        entrada=new Scanner(consignacion);
        while(entrada.hasNext()){
        linea=entrada.nextLine();
        lineas.add(linea);
        }
        entrada.close();
    PrintStream salida=new PrintStream(consignacion);
    for(String s:lineas){
    salida.println(s);
    }
    salida.println("ConsignaciondeMonto: "+monto);
    salida.flush();
    salida.close();
    }else{
        try {
            consignacion.createNewFile();
         PrintStream salida=new PrintStream(consignacion);
    salida.println("ConsignaciondeMonto: "+monto);
    salida.flush();
    salida.close();    
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    }
    }
    
    */
    
    
    public boolean  addCuenta(int Idcliente) throws IOException{
    for(Cliente c:this.clients){
    if(c.getId()==Idcliente){
        
    Cuenta cuenta=new Cuenta(c);
    c.addCuenta(cuenta);
    this.accounts.add(cuenta);
    File client=new File("Cuentas/"+cuenta.getId()+".txt");
    if(client.exists()){
    
    
    }else{
    
    client.createNewFile();
    PrintStream salida=new PrintStream(client);
    
    salida.println("Banco: "+this.getName());
    salida.println("IDCuenta: "+cuenta.getId());
    salida.println("Titular: "+cuenta.getOwner().getName());
    salida.println("IdTitular: "+cuenta.getOwner().getId());
    salida.flush();
    salida.close();
    
    }
    return true;
    }
      
     }
    return false;  
    }
    public boolean addCliente(String nombre,int Idmanager,int Idcliente) throws IOException{
    
      
        for(Administrador m:this.managers){
       if(m.getId()==Idmanager){
           
        Cliente cliente=new Cliente(nombre, m,Idcliente);
        
        m.addCliente(cliente);
        File archivo=new File("Clientes/"+nombre+".txt");
        if(archivo.exists()){
       
        }else{
           
        archivo.createNewFile();
        PrintStream salida =new PrintStream(archivo);
        salida.println("Banco: "+this.getName());
        salida.println("NombredelCliente: "+nombre);
        salida.println("Id: "+Idcliente);
        salida.println("Manager: "+m.getName());
        salida.flush();
        salida.close();
        }
                
       return this.clients.add(cliente);
       
       }
       
       
       } 
       return false;
    
    }
    public boolean addManager(String nombre, int Id) throws FileNotFoundException, IOException{
    File manager=new File("Managers/"+nombre+".txt");
    if(manager.exists()){
       
    }else{
        manager.createNewFile();
    PrintStream salida=new PrintStream(manager);
    salida.println("Banco: "+this.getName());
    salida.println("Nombre: "+nombre);
    salida.println("Id: "+Id);
    salida.flush();
    salida.close();
    
    }
        return this.managers.add(new Administrador(nombre,Id));
    
    }

    public String getName() {
        return name;
    }
    public void CargarManagers() throws FileNotFoundException{
    String archivos[];
        File managers=new File("Managers");
        File archivointerno;    
        Scanner entrada;
        String Banco=null,Nombre=null;
        int Id=0;
        if(managers.isDirectory()){
    archivos=managers.list();
    for(String s:archivos){
    archivointerno=new File("Managers/"+s);
    entrada=new Scanner(archivointerno);
    while(entrada.hasNext()){
    if(entrada.next().equalsIgnoreCase("Banco:")){
    Banco=entrada.next();
    }if(entrada.next().equalsIgnoreCase("Nombre:")){
    Nombre=entrada.next();
    }if(entrada.next().equalsIgnoreCase("Id:")){
    Id=entrada.nextInt();
    }
    
    }
    entrada.close();
    if(this.getName().equalsIgnoreCase(Banco)){
    this.managers.add(new Administrador(Nombre,Id));
    }
    
    }
    }
    
    
    }

    public ArrayList<Cuenta> getAccounts() {
        return accounts;
    }

    public ArrayList<Administrador> getManagers() {
        return managers;
    }
   
}
