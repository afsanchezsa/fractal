/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractal;

/**
 *
 * @author USUARIO
 */
public class Fractal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    int [][]m={{1,1},{1,1}};
    int[]u={1,2};
    pt(u);
        System.out.println(u[0]);
        System.out.println(u[1]);
    /* for(int i=0;i<m.length;i++){
           for(int j=0;j<m.length;j++){
               m[i][j]=1;
           }
        }*/
    //Integer a=0;
    // imprimir(m);
     //transformar(m);
    //imprimir(m);
     //prueba(a);
       // System.out.println(a);
      // int a =0;
       //prueba (a);
       // System.out.println(a);
    }
    public static void transformar(int [][]a){
        for(int i=0;i<a.length;i++){
           for(int j=0;j<a.length;j++){
               a[i][j]=0;
           }
        }
    }
    public static void imprimir(int  [][]a){
             for(int i=0;i<a.length;i++){
           for(int j=0;j<a.length;j++){
               System.out.println(a[i][j]); 
           }
        }
    }
    public static void prueba(int a){
        a=3;
    }
    public static void pt(int[]m){
        for(int i=0;i<m.length;i++){
            m[i]=5;
        
    }
    
}
}