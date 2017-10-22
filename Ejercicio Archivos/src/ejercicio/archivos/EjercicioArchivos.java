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
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class EjercicioArchivos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*  try {
            // TODO code application logic here
            Banco bancolombia =new Banco("Bancolombia");
            bancolombia.addManager("ADMIN", 1);
            bancolombia.addCliente("felipe", 1, 1);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
         */
          ArrayList<Banco> bancos = new ArrayList<>();        
        bancos=CargarBancos();
        for(Banco b:bancos){
            System.out.println(b.getName());
        }
        ArrayList<Banco>comodin=CargarManagers(bancos);
        bancos.clear();
        bancos=comodin;
        comodin=CargarCuentas(bancos);
        bancos=comodin;
        /*comodin=cargarTransacciones(bancos);
        bancos=comodin;
        */
        for(Banco b:bancos){
            System.out.println(b.getName());
            
        }
        System.out.println("Bienvenido");
        boolean permanecer = true;
        Scanner entrada = new Scanner(System.in);
        int opcion, id = 0,idmanager=0;
        String nombre, banco;
        Banco bank;
        File bank1;
        do {
            System.out.println("1.crear un nuevo banco");
            System.out.println("2.insertar un manager");
            System.out.println("3. insertar un cliente");
            System.out.println("4.realizar una consignacion");
            System.out.println("5. agregar una cuenta");
            opcion = entrada.nextInt();
            double monto;
            switch (opcion) {
                case 1:
                    System.out.println("inserte el nombre del banco");
                    nombre = entrada.next();
                    bancos.add(new Banco(nombre));
                    bank1 = new File("Bancos/" + nombre + ".txt");
                    if (bank1.exists()) {

                    } else {
                        try {
                            bank1.createNewFile();
                            PrintStream salida = new PrintStream(bank1);
                            salida.println(nombre);
                            salida.flush();
                            salida.close();

                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }

                    break;
                case 2:
                    System.out.println(" ingrese el nombre del banco al que quiere agregar el manager");
                    banco = entrada.next();
                    System.out.println("ingrese la identificacion del manager");
                    try {
                        id = entrada.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("entrada no permitida");
                    }
                    System.out.println("ingrese el nombre del manager");
                    nombre = entrada.next();
                    for (Banco b : bancos) {
                        if (b.getName().equalsIgnoreCase(banco)) {
                            try {
                                b.addManager(nombre, id);
                            } catch (FileNotFoundException ex) {
                                System.out.println(ex.getMessage());
                            } catch (IOException ex) {
                                System.out.println(ex.getMessage());
                            }

                            break;
                        }

                    }
                    break;
                case 3:
                    System.out.println("ingrese el nombre del banco al que quiere agregar el cliente");
                    banco = entrada.next();
                    System.out.println("ingrese el id del cliente");
                    id = entrada.nextInt();
                    System.out.println("ingrese el id del manager");
                    idmanager=entrada.nextInt();
                    System.out.println("ingrese el nombre del cliente");
                    nombre = entrada.next();
                    for (Banco b : bancos) {
                        if (b.getName().equalsIgnoreCase(banco)) {
                            try {
                                b.addCliente(nombre,idmanager, id);
                            } catch (FileNotFoundException ex) {
                                System.out.println(ex.getMessage());
                            } catch (IOException ex) {
                                System.out.println(ex.getMessage());
                            }
                            break;

                        }

                    }
                    break;
                case 4:
                    System.out.println("ingrese el nombre del banco en el que quiere consignar");
                    banco = entrada.next();
                    System.out.println("ingrese el id del cliente");
                    id = entrada.nextInt();
                    System.out.println("ingrese el monto de la consignacion");
                    monto = entrada.nextDouble();
                    for (Banco b : bancos) {
                       if (b.getName().equalsIgnoreCase(banco)) {
                            try {
                                System.out.println("sisiisi");
                                b.consignar(id, monto);
                            } catch (FileNotFoundException ex) {
                                System.out.println(ex.getMessage());
                            }

                        }
                    }
                    break;
                    case 5:
                        System.out.println("ingrese el nombre del banco");
                        banco=entrada.next();
                        System.out.println("ingrese el id del cliente que desea abrir una nueva cuenta");
                        id=entrada.nextInt();
                        for(Banco b:bancos){
                        if(b.getName().equalsIgnoreCase(banco)){
                            try {
                                b.addCuenta(id);
                                
                            } catch (IOException ex) {
                                System.out.println(ex.getMessage());
                            }
                        
                        }
                        
                        }
            break;
                    default:
                        System.out.println("entrada no valida intente de nuevo");
            }
            System.out.println("desea continuar? y/other");
            permanecer = entrada.next().equalsIgnoreCase("y");
            
            
            
        } while (permanecer);

    }

    public static ArrayList<Banco> CargarBancos() {
        File carpeta = new File("Bancos");
        Scanner entrada;
        String nombrebanco;
        ArrayList<Banco> bancos = new ArrayList<>();
        if (carpeta.isDirectory()) {
            String[] archivos = carpeta.list();
            for (String s : archivos) {
                try {
                    entrada = new Scanner(new File("Bancos/"+s));
                    nombrebanco=entrada.next();
                    bancos.add(new Banco(nombrebanco));
                } catch (FileNotFoundException ex) {
                    System.out.println(ex.getMessage());
                }

            }
        }
    return bancos;
    }
    public static ArrayList<Banco> CargarManagers(ArrayList<Banco>bancos){
    ArrayList<Banco> banks=new ArrayList<>();
       for(Banco b:bancos){
        try {
            b.CargarManagers();
            banks.add(b);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    
    }
       return banks;
    }
 public static ArrayList<Banco> CargarCuentas(ArrayList<Banco> bancos) {
    ArrayList<Banco>bank=new ArrayList<>();
        File cuentas=new File("Cuentas");
    File archivointerno;
    Scanner entrada=null;
    String Banco=null,NombrePropietario;
    int idcuenta=0,IdTitular=0;
    String archivos[];
    if(cuentas.isDirectory()){
    archivos=cuentas.list();
    for(String s:archivos){
    archivointerno=new File("Cuentas/"+s);
        try {
            entrada=new Scanner(archivointerno);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
      while(entrada.hasNextInt()){
      if(entrada.next().equalsIgnoreCase("Banco:")){
      Banco=entrada.next();
      
      }if(entrada.next().equalsIgnoreCase("IDCuenta:")){
      idcuenta=entrada.nextInt();
      
      }if(entrada.next().equalsIgnoreCase("Titular:")){
      NombrePropietario=entrada.next();
      
      }
      if(entrada.next().equalsIgnoreCase("IdTitular:")){
      IdTitular=entrada.nextInt();
      
      }
      for(Banco b:bancos){
      if(b.getName().equalsIgnoreCase(Banco)){
          try {
              b.addCuenta(IdTitular);
              bank.add(b);
          } catch (IOException ex) {
              System.out.println(ex.getMessage());
          }
      
      }
      }
      } 
    
    
    }
    
    }
    return bank;
    }
   public static ArrayList<Banco> cargarTransacciones(ArrayList<Banco>bancos){
  double monto=0;
  int Idcuenta=0;
       ArrayList<Banco>bank=new ArrayList<>();
       ArrayList<Cuenta>cuentas=new ArrayList<>();
   File archivointerno;
   Scanner entrada;
   String archivos[];
   File Carpeta=new File("Transaccion");
   if(Carpeta.isDirectory()){
   archivos=Carpeta.list();
   for(String s:archivos){
   archivointerno=new File("Transaccion/"+s);
       try {
           entrada=new Scanner(archivointerno);
            while(entrada.hasNextDouble()){
 entrada.next();
 monto+=entrada.nextDouble();
   
   }
            Idcuenta=Integer.parseInt(s.substring(0, 1));
            for(Banco b:bancos){
            
                for(int i=0;i<b.getAccounts().size();i++){
                if(b.getAccounts().get(i).getId()==Idcuenta){
                b.getAccounts().get(i).Consignar(monto);
                
                break;
                }
                
                }
            
            
            }
       } catch (FileNotFoundException ex) {
           System.out.println(ex.getMessage());
       }
  
   }
   }
   return bancos;
   }
    
}

